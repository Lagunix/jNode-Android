/*
JVM_ARGS
-Djava.net.preferIPv4Stack=false -Djava.net.preferIPv6Addresses=true

sun.net.spi.nameservice.provider.<n>=<default|dns,sun|...>
sun.net.spi.nameservice.nameservers=<server1_ipaddr,server2_ipaddr ...>

import sun.net.util.IPAddressUtil.isIPv6LiteralAddress
public static boolean isIPv6Format(String ip {
ip=ip.trim();
*/

package jnode.protocol.binkp.connector;

import static jnode.protocol.binkp.BinkpProtocolTools.getCommand;
import static jnode.protocol.binkp.BinkpProtocolTools.write;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
 
import java.net.Inet6Address
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.List;

import jnode.logger.Logger;
import jnode.protocol.binkp.exceprion.ConnectionEndException;
import jnode.protocol.binkp.types.BinkpCommand;
import jnode.protocol.binkp.types.BinkpFrame;

/**
 * TCP/IP соединение
 * 
 * @author kreon
 * 
 */
public class BinkpIPv6Connector extends BinkpAbstractConnector {
        static final Logger logger = Logger.getLogger(BinkpIPv6Connector.class);
        private Selector selector;

        /**
         * accept ()
         * 
         * @param socket
         * @throws Exception
         */
        public BinkpIPv6Connector(SocketChannel socket) throws IOException {
                super();
                init(socket);

        }

        public BinkpIPv6Connector(String protocolAddress) throws IOException {
                super(protocolAddress);
                SocketChannel socket = SocketChannel.open();
                try {
                        String[] parts = protocolAddress.split("::");
                        if (parts.length == 1) {
                                socket.connect(new Inet6Address(protocolAddress, 24554));
                        } else if (parts.length == 2) {
                                int port = Integer.valueOf(parts[1]);
                                socket.connect(new Inet6Address(parts[0], port));
                        } else {
                                throw new IOException("Invalid protocolAddress ("
                                                + protocolAddress + ") for this scheme");
                        }
                } catch (NumberFormatException e) {
                        throw new IOException("Invalid protocolAddress (" + protocolAddress
                                        + ") for this scheme");
                }
                init(socket);
        }

        private void init(SocketChannel socket) throws IOException {
                socket.configureBlocking(false);
                selector = Selector.open();
                socket.register(selector, socket.validOps());
        }

        @Override
        public void run() {
                try {
                        greet();
                        while (true) {
                                try {
                                        selector.select(staticMaxTimeout);
                                        for (SelectionKey key : selector.selectedKeys()) {
                                                SocketChannel channel = (SocketChannel) key.channel();
                                                if (key.isValid()) {
                                                        if (key.isConnectable()) {
                                                                if (!channel.finishConnect()) {
                                                                        key.cancel();
                                                                        finish("Connect failed");
                                                                } else {
                                                                        Inet6Address addr = (Inet6Address) channel
                                                                                        .getRemoteAddress();
                                                                        logger.l2(String.format(
                                                                                        "Connected with %s:%d",
                                                                                        addr.getHostString(),
                                                                                        addr.getPort()));
                                                                }
                                                        }
                                                        if (key.isWritable()) {
                                                                checkForMessages();
                                                                if (!frames.isEmpty()) {
                                                                        BinkpFrame frame = frames.removeFirst();
                                                                        logger.l5("Frame sent: " + frame
                                                                                        + ", next " + frames.size()
                                                                                        + " frames, total sent "
                                                                                        + total_sent_bytes);
                                                                        write(frame, channel);
                                                                }
                                                        }
                                                        if (!isConnected()) {
                                                                finish("Connect ended");
                                                        }
                                                        if (key.isReadable()) {
                                                                BinkpFrame frame = null;
                                                                ByteBuffer head = ByteBuffer.allocate(2);
                                                                for (int len = 0; len < 2;) {
                                                                        len += readOrDie(head, channel);
                                                                }
                                                                ((Buffer)head).flip();
                                                                int header = ((int) head.getShort()) & 0xffff;
                                                                int datalen = header & 0x7fff;
                                                                ByteBuffer data = ByteBuffer.allocate(datalen);
                                                                for (int len = 0; len < datalen;) {
                                                                        len += readOrDie(data, channel);
                                                                }
                                                                ((Buffer)data).flip();
                                                                if ((header & 0x8000) >= 0x8000) {
                                                                        // command
                                                                        BinkpCommand cmd = getCommand(data.get());
                                                                        if (datalen > 1) {
                                                                                if (data.get(datalen - 1) == 0) {
                                                                                        datalen--;
                                                                                }
                                                                                byte[] buf = new byte[datalen - 1];
                                                                                data.get(buf);
                                                                                frame = new BinkpFrame(cmd, new String(
                                                                                                buf));
                                                                        } else {
                                                                                frame = new BinkpFrame(cmd);
                                                                        }
                                                                } else {
                                                                        frame = new BinkpFrame(data.array(),
                                                                                        datalen);
                                                                }
                                                                if (frame != null) {
                                                                        logger.l5("Frame received: " + frame);
                                                                        proccessFrame(frame);
                                                                }
                                                        }
                                                } else {
                                                        finish("Key is invalid");
                                                }
                                        }
                                } catch (IOException e) {
                                        error("IOException");

                                }
                        }
                } catch (ConnectionEndException e) {
                        try {
                                for (SelectionKey key : selector.keys()) {
                                        key.channel().close();
                                        key.cancel();
                                }
                                selector.close();
                                if (currentOS != null) {
                                        currentOS.close();
                                }
                                e.printStackTrace();
                        } catch (IOException e2) {
                                logger.l2("Error while closing key", e2);
                        }
                        done();
                }
        }

        private int readOrDie(ByteBuffer buffer, SocketChannel channel)
                        throws IOException {
                int x = channel.read(buffer);
                if (x == -1) {
                        if (flag_leob && flag_reob) {
                                connectionState = STATE_END;
                        }
                        finish("readOrDie failed");
                }
                return x;
        }
}
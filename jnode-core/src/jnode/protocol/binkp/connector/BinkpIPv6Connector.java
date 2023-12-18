/*
JVM_ARGS
-Djava.net.preferIPv4Stack=false -Djava.net.preferIPv6Addresses=true

sun.net.spi.nameservice.provider.<n>=<default|dns,sun|...>
sun.net.spi.nameservice.nameservers=<server1_ipaddr,server2_ipaddr ...>

import sun.net.util.IPAddressUtil.isIPv6LiteralAddress
public static boolean isIPv6Format(String ip {
ip=ip.trim();
*/

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

import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.List;
/*
 * Licensed to the jNode FTN Platform Develpoment Team (jNode Team)
 * under one or more contributor license agreements.
 * See the NOTICE file distributed with this work for 
 * additional information regarding copyright ownership.  
 * The jNode Team licenses this file to you under the 
 * Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
 
package jnode.protocol.binkp;
 
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
 
import jnode.logger.Logger;
import jnode.main.MainHandler;
import jnode.main.threads.ThreadPool;
import jnode.protocol.binkp.connector.BinkpSyncConnector;
 
public class BinkpSyncServer implements Runnable {
	private static final Logger logger = Logger
			.getLogger(BinkpAsyncServer.class);
 
	private static final String BINKD_BIND = "binkp.bind";
	private static final String BINKD_PORT = "binkp.port";
	private static final String BINKD_SERVER = "binkp.server";
 
	@Override
	public void run() {
		if (!MainHandler.getCurrentInstance().getBooleanProperty(BINKD_SERVER,
				true)) {
			return;
		}
		try {
			ServerSocket server = new ServerSocket(MainHandler.getCurrentInstance().getIntegerProperty(BINKD_PORT, 24554));
			while (true) {
				System.out.println("Creating socket and waiting for client connection");
            	Socket socket = server.accept();
				BinkpSyncConnector connector = new BinkpSyncConnector(socket);
				connector.run();
			}			
		} catch (IOException e) {
			e.printStackTrace();
			logger.l1("Server error occured!", e);
		}
	}
}
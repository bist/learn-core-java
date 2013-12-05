/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter08.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.MessageFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version 1.0
 */
public class ServerSockets {
   public static void main(String[] args) {
      int port = 10_000;
      ExecutorService service = Executors.newCachedThreadPool();

      try {
         // let's create a server on port 10000
         ServerSocket server = new ServerSocket(port);
         System.out.println(MessageFormat.format("Listening on port {0}...", port));


         //noinspection InfiniteLoopStatement
         while (true) {
            Socket client = server.accept();
            service.execute(new Handler(client));
         }
      } catch (IOException e) {
         System.out.println(MessageFormat.format("Cannot bind on port {0}", port));
         service.shutdown();
         e.printStackTrace();
      }
   }
}

class Handler implements Runnable {
   private final Socket client;

   Handler(Socket client) {
      this.client = client;
   }

   @Override
   public void run() {
      try (
         PrintWriter out = new PrintWriter(client.getOutputStream(), true);
         BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))
      ) {
         String input;
         while ((input = in.readLine()) != null) {
            out.println(MessageFormat.format("> {0}", input));
            if (input.equals("bye"))
               break;
         }
      } catch (IOException e) {
         System.out.println("Problematic communication!");
      }
   }
}
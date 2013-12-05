/*******************************************************************************
 * This code is developed and owned by Borsa Istanbul A.S.
 * The distribution of this code by any means is prohibited.
 * You cannot copy/share/distribute/deliver/use/modify/move without having
 * a permission to do so. Use it with your own risk.
 *
 * All rights reserved. Copyright (c) 2013.
 ******************************************************************************/

package bist.chapter08.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @version 1.0
 */
public class ClientSockets {
   public static void main(String[] args) {
      try {
         // let's create a client socket for a whois challenge
         Socket whois = new Socket("whois.internic.net", 43);
         OutputStream sender = whois.getOutputStream();
         InputStream receiver = whois.getInputStream();

         // let's query a domain
         String command = "isagoksu.com\n";
         sender.write(command.getBytes());

         // let's print out the response we got from the whois server
         String output = new Scanner(receiver).useDelimiter("\\A").next();
         System.out.println(output);
      } catch (IOException e) {
         System.out.println("Cannot connect to the server!");
         e.printStackTrace();
      }
   }
}

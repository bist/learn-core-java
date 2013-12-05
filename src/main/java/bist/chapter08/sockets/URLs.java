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
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @version 1.0
 */
public class URLs {
   public static void main(String[] args) {
      try {
         String url = "http://isa.io/2009/quotes/occams-razor/?some-sample-key=sample-value";
         URL isa = new URL(url);

         System.out.println(MessageFormat.format("Information on the url: {0}", url));

         // let's print out some meta data about the URL
         System.out.println("isa.getHost() = " + isa.getHost());
         System.out.println("isa.getProtocol() = " + isa.getProtocol());
         System.out.println("isa.getQuery() = " + isa.getQuery());
         System.out.println("isa.getPath() = " + isa.getPath());

         URLConnection connection = isa.openConnection();

         // let's print out some meta data about the connection
         System.out.println("connection.getContentType() = " + connection.getContentType());
         System.out.println("connection.getContentEncoding() = " + connection.getContentEncoding());
         System.out.println("connection.getContentLength() = " + connection.getContentLength());
         Map<String,List<String>> headers = connection.getHeaderFields();

         System.out.println("Printing response headers:");
         for (String key : headers.keySet()) {
            System.out.println("key = " + key);
            List<String> values = headers.get(key);
            System.out.println(Arrays.toString(values.toArray()));
         }

         // let's print out the content
         int length = connection.getContentLength();
         System.out.println("Content Length = " + length);
         if (length != 0) {
            System.out.println("Content:");

            InputStream stream = connection.getInputStream();
            Scanner scanner = new Scanner(stream).useDelimiter("\\A");
            if (scanner.hasNext()) {
               System.out.println(scanner.next());
            }
         }
      } catch (MalformedURLException e) {
         System.out.println("URL format is invalid!");
         e.printStackTrace();
      } catch (IOException e) {
         System.out.println("Cannot open the connection!");
         e.printStackTrace();
      }
   }
}

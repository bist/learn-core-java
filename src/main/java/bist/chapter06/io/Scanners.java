package bist.chapter06.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Scanners {
	public static void main(String[] args) throws IOException {

        Scanner s = null;	// a utility to parse character streams

        try {
            s = new Scanner(new BufferedReader(new FileReader("sample.txt")));

            while (s.hasNext()) {				// by default, uses Character.isWhitespace() to tokenize the input. to override, use useDelimiter() method.
                System.out.println(s.next());
            }
            
            // s.hasNextInt(), s.nextInt() 		scanner can translate individual tokens to primitive types
            
            // regex can also be used during parsing the input.
            
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}
package bist.chapter06.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Unbuffered I/O
// Unbuffered I/O means each read or write request is handled directly by the underlying OS. 
// This can make a program much less efficient, since each such request often triggers a relatively expensive operation (e.g. disk access, network activity)

// Buffered I/O
// Buffered input streams read data from a memory area known as a buffer; the native input API is called only when the buffer is empty. 
// Buffered output streams write data to a buffer, and the native output API is called only when the buffer is full.

// 4 wrappers exist to convert unbuffered streams to buffered streams
// - BufferedInputStream and BufferedOutputStream for byte streams
// - BufferedReader and BufferedWriter for character streams

// Flushing buffers
// Normally, buffer is flushed when it is full. Programmer can manually flush the buffer, if he sees fit.
// auto-flush: some writers support this feature. for example, PrintWriter flushes buffer after println() is called.

public class BufferedStreams {
	
	public static void main(String[] args) throws IOException {

        BufferedReader reader = null;
        PrintWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader("sample.txt")); 				// converts a Reader to a BufferedReader
            writer = new PrintWriter(new FileWriter("destination_buffered.txt"));   // unbuffered writer.
            
            // new BufferedWriter(new FileWriter("destination_buffered.txt"));		// buffered writer.

            String l;
            while ((l = reader.readLine()) != null) { 		// reads a line (i.e. reads until it hits the line terminator)
                writer.println(l); 							// writes a line (adds the line terminator automatically)
            }
        } finally {
            if (reader != null) {							// don't forget to close the resources
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

}

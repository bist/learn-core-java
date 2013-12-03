package bist.chapter06.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// All byte stream classes are descended from InputStream and OutputStream
public class ByteStreams {
	
	public static void main(String[] args) throws IOException {
		
		// copies one file to another
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("sample.txt");
            out = new FileOutputStream("destination_bytes.txt");
            
            int c; 								// why not use byte type? returning int allows read() to use -1 to indicate that it has reached the end of the stream.

            while ((c = in.read()) != -1) { 	// reads a byte
                out.write(c);					// writes a byte
            }
        } finally {
            if (in != null) {
                in.close();						// always close streams. Streams work on resources. 
            }
            if (out != null) {
                out.close();					// both InputStream and OutputStream implement Closeable
            }
        }
    }
}

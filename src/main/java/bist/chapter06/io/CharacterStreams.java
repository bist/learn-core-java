package bist.chapter06.io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Java internally stores characters in Unicode format. 
// Character stream I/O automatically translates this internal format to and from the local character set. 

// i18n

// All character stream classes are descended from Reader and Writer.
public class CharacterStreams {

	public static void main(String[] args) throws IOException {

        FileReader reader = null;
        FileWriter writer = null;

        try {
            reader = new FileReader("sample.txt");
            writer = new FileWriter("destination_character.txt");

            int c; 										// stores character value in its last 16-bits
            
            while ((c = reader.read()) != -1) { 		// reads a character
                writer.write(c);						// writes a character
            }
        } finally {
            if (reader != null) { 						// close the resources
                reader.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }
	
	// Character streams are often "wrappers" for byte streams. 
	// The character stream uses the byte stream to perform the physical I/O, while the character stream handles translation between characters and bytes. 
	// FileReader, for example, uses FileInputStream, while FileWriter uses FileOutputStream.
	
	// Bridge Streams: InputStreamReader and OutputStreamWriter
	// InputStreamReader: reads bytes and decodes them into characters using a specified charset. 
	// OutputStreamWriter: Characters written to it are encoded into bytes using a specified charset. 
}



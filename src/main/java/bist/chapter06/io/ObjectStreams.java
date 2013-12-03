package bist.chapter06.io;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;

// DataStreams are for primitive types, whereas ObjectStreams are for Object types.
// Objects must be marked with Serializable interface
// ObjectInput and ObjectOutput interfaces are used for ObjectStreams. 
// These interfaces extend DataInput and DataOutput, respectively. Therefore, they can serialize both primitive and complex types

public class ObjectStreams {
	public static void main(String[] args) throws ClassNotFoundException {
		
		// writing part
		try {
			ObjectOutputStream dos = new ObjectOutputStream(new FileOutputStream("invoice1.txt"));  // ObjectOutputStream is a wrapper for an existing Byte Stream

			// define a simple order table
			BigDecimal[] prices = { new BigDecimal(19.99), new BigDecimal(9.99), new BigDecimal(15.99), new BigDecimal(3.99), new BigDecimal(4.99) }; // we used BigDecimal instead of double
			int[] units = { 12, 8, 13, 29, 50 };
			String[] descs = { "Java T-shirt", "Java Mug", "Duke Juggling Dolls", "Java Pin", "Java Key Chain" };

			for (int i = 0; i < prices.length; i++) {
				dos.writeObject(prices[i]);
				dos.writeChar('\t');
				dos.writeInt(units[i]);
				dos.writeChar('\t');
				dos.writeChars(descs[i]);
				dos.writeChar('\n');
			}
			dos.close();
		} catch (IOException e) {
			System.out.println("ObjectStreams: " + e);
		}

		// reading part
		try {
			ObjectInputStream dis = new ObjectInputStream(new FileInputStream("invoice1.txt"));

			BigDecimal price;
			int unit;
			String desc;
			BigDecimal total = new BigDecimal(0.0);

			try {
				while (true) {												
					price = (BigDecimal) dis.readObject();			// cast to BigDecimal
					dis.readChar(); // throws out the tab
					unit = dis.readInt();
					dis.readChar(); // throws out the tab
					desc = dis.readLine();
					
					System.out.format("You ordered %d" + " units of %s at $%.2f%n", unit, desc, price);
				        
					total = total.add(new BigDecimal(unit).multiply(price)); 	// calculate total value by using BigDecimal methods
				}
			} catch (EOFException e) {										
			}
			System.out.format("For a TOTAL of: $" + total);
			dis.close();
		} catch (FileNotFoundException e) {
			System.out.println("ObjectStreams: " + e);
		} catch (IOException e) {
			System.out.println("ObjectStreams: " + e);
		}
	}
}

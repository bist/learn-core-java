package bist.chapter06.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// Data streams support binary I/O of primitive data type values (boolean, char, byte, short, int, long, float, and double) as well as String values.
// Since it works only for primitive types, they are not useful for monetary values, i.e. BigDecimal is not a primitive.
// DataInput and DataOutput interfaces are used for DataStreams

public class DataStreams {
	public static void main(String[] args) {
		// writing part
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("invoice1.txt"));  // DataOutputStream is a wrapper for an existing Byte Stream

			// define a simple order table
			double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
			int[] units = { 12, 8, 13, 29, 50 };
			String[] descs = { "Java T-shirt", "Java Mug", "Duke Juggling Dolls", "Java Pin", "Java Key Chain" };

			for (int i = 0; i < prices.length; i++) {
				dos.writeDouble(prices[i]);
				dos.writeChar('\t');
				dos.writeInt(units[i]);
				dos.writeChar('\t');
				dos.writeChars(descs[i]);
				dos.writeChar('\n');
			}
			dos.close();
		} catch (IOException e) {
			System.out.println("DataStreams: " + e);
		}

		// reading part
		try {
			DataInputStream dis = new DataInputStream(new FileInputStream("invoice1.txt"));

			double price;
			int unit;
			String desc;
			double total = 0.0;

			try {
				while (true) {												// while (true), why?
					price = dis.readDouble();
					dis.readChar(); // throws out the tab
					unit = dis.readInt();
					dis.readChar(); // throws out the tab
					desc = dis.readLine();
					
					System.out.format("You ordered %d" + " units of %s at $%.2f%n", unit, desc, price);
				        
					total += unit * price;
				}
			} catch (EOFException e) {										// DataStreams detects an end-of-file condition by catching EOFException
			}
			System.out.format("For a TOTAL of: $" + total);
			dis.close();
		} catch (FileNotFoundException e) {
			System.out.println("DataStreams: " + e);
		} catch (IOException e) {
			System.out.println("DataStreams: " + e);
		}
	}
}

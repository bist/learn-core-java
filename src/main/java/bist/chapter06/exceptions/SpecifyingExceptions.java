package bist.chapter06.exceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class SpecifyingExceptions {
	
	// Note: This class won't compile by design!
//	class UnhandledCheckedExceptions {
//
//	    private List<Integer> list;
//	    private static final int SIZE = 10;
//
//	    public UnhandledCheckedExceptions () {
//	        this.list = new ArrayList<Integer>(SIZE);
//	        for (int i = 0; i < SIZE; i++) {
//	            list.add(new Integer(i));
//	        }
//	    }
//
//	    public void writeList() {
//	        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt")); 	// checked exception: must be handled or declared that it is thrown in the method signature 
//
//	        for (int i = 0; i < SIZE; i++) {
//	            out.println("Value at: " + i + " = " + this.list.get(i));			
//	        }
//	        out.close();
//	    }
//	}

	class SpecifyingCheckedExceptions {

	    private List<Integer> list;
	    private static final int SIZE = 10;

	    public SpecifyingCheckedExceptions () {
	        this.list = new ArrayList<Integer>(SIZE);
	        for (int i = 0; i < SIZE; i++) {
	            list.add(new Integer(i));
	        }
	    }

	    public void writeList() throws IOException {							// exception is specified in the method signature
	        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt")); 	 

	        for (int i = 0; i < SIZE; i++) {
	            out.println("Value at: " + i + " = " + this.list.get(i));			
	        }
	        out.close();
	    }
	    
	    // multiple specifications can be declared. Ex: ... throws IOException, ArrayIndexOutOfBoundsException 
	}
}

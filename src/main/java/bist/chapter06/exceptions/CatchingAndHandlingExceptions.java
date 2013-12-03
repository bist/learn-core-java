package bist.chapter06.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CatchingAndHandlingExceptions {
//	Exception => Event, Exception Handler => Event Handler
//	Exceptions propagate call stack
//	Catch or Specify Requirement (for Checked Exceptions)
//	Exception Types: Checked or Unchecked exceptions (Runtime and Error)
//		Throwable
//			Exception: 
//				Checked Exception: FileNotFoundException
//				Runtime Exception: NullPointerException. is reserved for exceptions that indicate incorrect use of an API.
//			Error: OutOfMemoryError
	
//	Exception softening
//  rethrow, wrap and rethrow
	
// three exception handler components — the try, catch, and finally blocks — to write an exception handler
	
	// Note: This class won't compile by design!
//	class ThrowingCheckedAndUncheckedExceptions {
//
//	    private List<Integer> list;
//	    private static final int SIZE = 10;
//
//	    public ThrowingCheckedAndUncheckedExceptions () {
//	        this.list = createListWithSomeData(SIZE);
//	    }
//
//	    public void writeList() {
//	        PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt")); 		// checked exception
//
//	        for (int i = 0; i < SIZE; i++) {
//	            out.println("Value at: " + i + " = " + this.list.get(i));			// runtime exception IndexOutOfBoundsException
//	        }
//	        out.close();
//	    }
//	}
	
	// let's write the exception handlers for the above exceptions
	class CatchingExceptions {
		
		private List<Integer> list;
		private static final int SIZE = 10;

	    public CatchingExceptions () {
	        this.list = createListWithSomeData(SIZE);
	    }
	    
		public void writeList() {
		    PrintWriter out = null;

		    try { 																	// surround the code that throws exception with try statement
		        out = new PrintWriter(new FileWriter("OutFile.txt"));
		        for (int i = 0; i < SIZE; i++)
		            out.println("Value at: " + i + " = " + list.get(i));
		                  
		    } catch (ArrayIndexOutOfBoundsException e) { 							// catch clause matches exceptions by their types
		    	// Caught ArrayIndexOutOfBoundsException
		    	e.printStackTrace();
		                                 
		    } catch (IOException e) { 												// let's look at highly used exception methods
		        // Caught IOException
		        e.printStackTrace();
		    } finally { 															// explained later.
		        if (out != null) {
		            // Closing PrintWriter
		            out.close();
		        } 
		    }
		}
	}
	
//	class CatchingExceptionsOrderMatters {
//		
//		private List<Integer> list;
//		private static final int SIZE = 10;
//
//	    public CatchingExceptionsOrderMatters () {
//	    	this.list = createListWithSomeData(SIZE);
//	    }
//	    
//		public void writeList() {
//		    PrintWriter out = null;
//
//		    try { 																	// surround the code that throws exception with try statement
//		        out = new PrintWriter(new FileWriter("OutFile.txt"));
//		        for (int i = 0; i < SIZE; i++)
//		            out.println("Value at: " + i + " = " + list.get(i));
//		                  
//		    } catch (Exception e) { 												// catches all exceptions.
//		    	// Caught Exception
//		    	e.printStackTrace();
//		                                 
//		    } catch (IOException e) { 												// unreachable catch block
//		        // Caught IOException
//		        e.printStackTrace();
//		    } finally { 															// explained later.
//		        if (out != null) {
//		            // Closing PrintWriter
//		            out.close();
//		        } 
//		    }
//		}
//	}
	
	class CatchingExceptionsWithMultiCatch {
		
		private List<Integer> list;
		private static final int SIZE = 10;

	    public CatchingExceptionsWithMultiCatch () {
	    	this.list = createListWithSomeData(SIZE);
	    }
	    
		public void writeList() {
		    PrintWriter out = null;

		    try { 																	
		        out = new PrintWriter(new FileWriter("OutFile.txt"));
		        for (int i = 0; i < SIZE; i++)
		            out.println("Value at: " + i + " = " + list.get(i));
		                  
		    } catch (IOException | ArrayIndexOutOfBoundsException e) { 				// multi-catch block
		    	// Caught Either IOException or ArrayIndexOutOfBoundsException
		    	e.printStackTrace();
		                                 
		    } finally {
		        if (out != null) {
		            // Closing PrintWriter
		            out.close();
		        } 
		    }
		}
	}
	
	class CleaningUpResourcesWithoutFinallyBlock {

		private List<Integer> list;
		private static final int SIZE = 10;

	    public CleaningUpResourcesWithoutFinallyBlock () {
	    	this.list = createListWithSomeData(SIZE);
	    }
	    
		public void writeList() {
		    PrintWriter out = null;

		    try { 																	
		        out = new PrintWriter(new FileWriter("OutFile.txt"));
		        for (int i = 0; i < SIZE; i++)
		            out.println("Value at: " + i + " = " + list.get(i));
		        
		        out.close();			// Don't do this - duplicates code
		    } catch (Exception e) { 				
		    	if (out != null) {
					out.close(); 		// Don't do this - duplicates code
				}
		    } 
		}
	}
	
	class CleaningUpResourcesWithFinallyBlock {

		private List<Integer> list;
		private static final int SIZE = 10;

	    public CleaningUpResourcesWithFinallyBlock () {
	    	this.list = createListWithSomeData(SIZE);
	    }
	    
		public void writeList() {
		    PrintWriter out = null;

		    try { 																	
		        out = new PrintWriter(new FileWriter("OutFile.txt"));
		        for (int i = 0; i < SIZE; i++)
		            out.println("Value at: " + i + " = " + list.get(i));
		        
		    } catch (Exception e) { 				
		    	System.err.println("Exception occured!");
		    } 
		    finally {				
		    	// The finally block "always" executes when the try block exits, 
		    	// i.e. at exceptions, return, continue, or break statements
		    	
		    	if (out != null) {
					out.close();
				}			
		    }
		}
	}
	
	class CleaningUpResourcesWithTryWithResources {
		// introduced in Java 7
		// applies to classed implementing AutoCloseable (and Closeable)
		
		public String readFirstLineFromFile(String path) throws IOException {
			
		    try (BufferedReader br = new BufferedReader(new FileReader(path))) { 		// BufferedReader implements the interface java.lang.AutoCloseable
		        return br.readLine();
		    }
		    
		    // Behavior is similar to the below code, but not the same. Differs in "Suppressed Exceptions". 
		    
//		    BufferedReader br = new BufferedReader(new FileReader(path));
//			try {
//				return br.readLine();
//			} finally {						// finally block is used instead of try-with-resources
//				if (br != null)
//					br.close();
//			}
		    
		    // Suppressed Exceptions - What happens if both readLine() and close() throw exceptions
		    // - try-with-resources: readFirstLineFromFile() throws the exception in the try-block. Exception in try-with-resources statement is "suppressed"
		    // - try-finally: 		 readFirstLineFromFileWithFinallyBlock() throws the exception in the finally-block. Exception in the try-block is "suppressed"
		    
		    // multiple resources can be declared in a try-with-resources statement. 
		}
	}
	
	// utility method
	private static List<Integer> createListWithSomeData(int dataSize) {
		List<Integer> list = new ArrayList<Integer>(dataSize);
        for (int i = 0; i < dataSize; i++) {
            list.add(new Integer(i));
        }
        
        return list;
	}
}

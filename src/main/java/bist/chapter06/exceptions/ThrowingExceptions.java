package bist.chapter06.exceptions;

import java.io.IOException;
import java.util.EmptyStackException;

public class ThrowingExceptions {
	// throw statement requires a throwable object
	
	class IncompleteStackImplementation {
		
		private int size;

		public Object pop() {
		    Object obj;

		    if (this.size == 0) {
		        throw new EmptyStackException();	// exception is thrown. call stack is created
		    }

		    obj = objectAt(this.size - 1);
		    setObjectAt(this.size - 1, null);
		    this.size--;
		    
		    return obj;
		}

		private void setObjectAt(int i, Object object) {
			// not implemented
		}

		private Object objectAt(int i) {
			// not implemented
			return null;
		}
	}
	
	class ChainingExceptions {
		public void businessMethod() {
			try {
				infraMethod();
			} catch (IOException e) {
				throw new MyCustomException("Other IOException", e);
			}
		}
		
		public void infraMethod() throws IOException {
			// do some IO stuff
			throw new IOException("Cannot read the specified file");
		}
		
		class MyCustomException extends RuntimeException {

			private static final long serialVersionUID = -7352776100363832420L;

			public MyCustomException(String message, Exception innerException) {
				// not implemented
			}
		}
	}
}

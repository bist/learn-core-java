package bist.chapter06.io;

import java.io.Console;
import java.io.IOException;
import java.util.Arrays;

// By default, StandartStreams read input from the keyboard and write output to the display. 
// Standard streams: System.in, System.out, System.err

// A more advanced alternative to the Standard Streams is the Console.
// - provides most of the Standard Streams' features 
// - useful for secure password entry
// - provides input and output streams as character streams


public class StandartStreams {
	public static void main (String args[]) throws IOException {

        Console c = System.console(); 										// Console object is retrieved
        
        if (c == null) {													// can be null if program is launched in a non-interactive environment
            System.err.println("No console.");
            System.exit(1);
        }

        String login = c.readLine("Enter your login: "); 					// prompt for the username
        char [] oldPassword = c.readPassword("Enter your old password: "); 	// doesn't display characters and returns a char array (not a string) 

        if (verify(login, oldPassword)) {
            boolean noMatch;
            
            do {
                char [] newPassword1 = c.readPassword("Enter your new password: ");
                char [] newPassword2 = c.readPassword("Enter new password again: ");
                
                noMatch = !Arrays.equals(newPassword1, newPassword2);
                
                if (noMatch) {
                    c.format("Passwords don't match. Try again.%n");
                } else {
                    change(login, newPassword1);
                    c.format("Password for %s changed.%n", login);
                }
                
                Arrays.fill(newPassword1, ' ');								// Overwrite both passwords with blanks.
                Arrays.fill(newPassword2, ' ');								// Overwrite both passwords with blanks.
            } while (noMatch);
        }

        Arrays.fill(oldPassword, ' ');										// Overwrite both passwords with blanks.
    }
    
    static boolean verify(String login, char[] password) {
        // not implemented for brevity's sake
        return true;
    }

    static void change(String login, char[] password) {
        // not implemented
    }
}

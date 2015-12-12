package internalTrainingsTask;

import java.io.IOException;
import java.io.PrintWriter;

public class MyLogger {
	
	
	
	public static void log(String message) { 
		
		try{
			
			PrintWriter out = new PrintWriter("output.txt");
			out.println(message);
			out.close();
		}
		catch(IOException iox){
			
			iox.printStackTrace();
		}
	    		
	    }
    
}

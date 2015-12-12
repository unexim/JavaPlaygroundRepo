package internalTrainingsTask;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyLogger {
	
	public static void log(String message) { 
		
	      PrintWriter out = null;
		try {
			
			out = new PrintWriter(new FileWriter("output.txt", true), true);
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally{
			
			out.close();
		}
		
	      out.write(message);
	      out.close();
	      
	    }
    
}

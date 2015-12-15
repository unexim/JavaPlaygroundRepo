package internalTrainingsTask;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyLogger {
	
	
	
	public static void log(String message) { 
		
		File log = new File("output.txt");

				try{
				    if(!log.exists()){
				        System.out.println("We had to make a new file.");
				        log.createNewFile();
				    }

				    FileWriter fileWriter = new FileWriter(log, true);

				    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);				    
				    bufferedWriter.write(message);
				    bufferedWriter.write(System.lineSeparator());
				    bufferedWriter.close();

				    System.out.println("Done");
				} catch(IOException e) {
				    System.out.println("COULD NOT LOG!!");
				}
	    		
	}
	    
}

package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class Log {
	
	public void logMessage(String logText) {
		
		try(PrintWriter pw = new PrintWriter( new FileOutputStream( new File("log.txt"), true ) ) ) {
			
		    pw.println(LocalDateTime.now() + " " + logText);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}

}

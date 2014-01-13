

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class TextFileIO {
	
	public String readText(String fileName){
		String retString = "";
		FileReader file = null;
		
		try{
			file = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(file);
		    String line = "";
		    while((line = reader.readLine()) != null)
		    	retString += line;// + "\n"; //disabled for the use here
		    reader.close();
		}
		catch(FileNotFoundException e){
			throw new RuntimeException("File Not Found");
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		finally{
			if(file != null){
				try{
					file.close();
				}
				catch(IOException e){}
					
			}
		}
	return retString;	
	}		
	
	public void writeText(String fileName, String contents){
		FileWriter file = null;
		try{
			file = new FileWriter(fileName);
			BufferedWriter writer = new BufferedWriter(file);
			writer.write(contents);
			writer.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
			if(file != null){
				try{
					file.close();
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
}

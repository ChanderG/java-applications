import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class BinaryFileIOI {
	
	//reads all objects and calls some function
	public Invoice readFromFile(String fileName) throws Exception{
		FileInputStream fin = new FileInputStream(fileName);
		Invoice obj = new Invoice();
		
		try{
			while(true){
				ObjectInputStream ois = new ObjectInputStream(fin);
				obj = (Invoice)ois.readObject();				
				//add needed code here
				System.out.println(obj.toString());
			}
		}
		catch(EOFException e){}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		finally{
			//if(ois != null)
				//ois.close();
			fin.close();
		}
		return obj;
	}

	//writes a single object to file
	public void writeObjToFile(Invoice obj, String fileName) throws Exception{
		
		File file = new File(fileName);
		FileOutputStream fout;
		boolean append = false;
		if(file.exists()) append = true;
		fout = new FileOutputStream(fileName,append);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		//SimpleClass objcpy = new SimpleClass(obj);
		
		try{
			//obj.printInfo();
			oos.writeObject(obj);
			oos.flush();
			oos.close();
		}
		catch(Exception e){
			throw new RuntimeException(e);
		}
		fout.close();
	}
	
}

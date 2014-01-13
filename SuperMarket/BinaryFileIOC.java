//for the customer class only

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class BinaryFileIOC {
	
	//reads all objects and calls some function
	public Customer readFromFile(String fileName) throws Exception{
		File file = new File(fileName);
		if(!file.exists()){
			return null;
		}
		FileInputStream fin = new FileInputStream(fileName);
		Customer obj = new Customer(false);
		
		try{
			while(true){
				ObjectInputStream ois = new ObjectInputStream(fin);
				obj = (Customer)ois.readObject();				
				//enter required function here - none for the moment
				//System.out.println(obj.toString());
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

	//reads a single req object based on cn
	public Customer readObjFromFile(String fileName, long cn) throws Exception{
		File file = new File(fileName);
		if(!file.exists()){
			return null;
		}
		FileInputStream fin = new FileInputStream(fileName);
		Customer obj = new Customer(false);
		
		try{
			while(true){
				ObjectInputStream ois = new ObjectInputStream(fin);
				obj = (Customer)ois.readObject();	
				if(obj.returnCn() == cn){
					ois.close();
					return obj;
				}
				//enter required function here - none for the moment
				//System.out.println(obj.toString());
			}
		}
		catch(EOFException e){}
		catch(Exception e){
			//throw new RuntimeException(e);
		}
		finally{
			//if(ois != null)
				//ois.close();
			fin.close();
		}
		System.out.println("Customer not found.");
		return obj;
	}
	
	//writes a single object to file
	public void writeObjToFile(Customer obj, String fileName) throws Exception{
		
		File file = new File(fileName);
		FileOutputStream fout;
		boolean append = false;
		if(file.exists()) append = true;
		fout = new FileOutputStream(fileName,append);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		//SimpleClass objcpy = new SimpleClass(obj);
		
		try{
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

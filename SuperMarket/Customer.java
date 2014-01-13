import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.Serializable;


public class Customer implements Serializable{
	private String address; //note:no checking done
	private String phoneNo; //warning:no verification, a pure string
    private String drivNo;  //,,,,,,warning
	
    private long cn;
    
    public long returnCn(){
    	return cn;
    }
   
    public Customer(boolean val) throws Exception{
    	if(val == true){
    	System.out.println("\t\t\t*****Enter Customer Details*****\n\n\n");
    	BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
    	
    	System.out.println("Enter Customer address: ");
    	address = br2.readLine();
    	
    	System.out.println("Enter Customer phone number: ");
    	phoneNo = br2.readLine();
    	
    	System.out.println("Enter Customer Driving License No: ");
    	drivNo = br2.readLine();
        
    	System.out.println("\n\n\nEntered Details:\nAddress: " + address);
    	System.out.println("Phone no: " + phoneNo);
    	System.out.println("Driving license no: " + drivNo);
    	//Create verification system later on
    	
    	System.out.println("Generating unique customer number...");	
        //add customer number- call req function and display here itself
        cn = assignCn();
    	System.out.println("\n\n\nYou have been assigned the CN:\t" + cn);
    	System.out.println("Please remember this for future use.");
    	
    	//br2.close();
    	}
    }
    
    public Customer(Customer obj){
    	this.address = obj.address;
    	this.phoneNo = obj.phoneNo; 
        this.drivNo = obj.drivNo;  
        this.cn = obj.cn;
    }
    
    public String toString(){
    	String totalContents = "";
    	totalContents += "Address: " + address;
    	totalContents += "PhoneNo: " + phoneNo;
    	totalContents += "DrivLicense: " + drivNo;
    	totalContents += "cn: " + cn;
    	return totalContents;
    }
    
    public void printAddress(){
    	System.out.println(address);
    }
    
    public long assignCn(){
    	String fileName = "CnMaster.txt";
    	File cfile = new File(fileName);
    	
    	TextFileIO custEditor = new TextFileIO();
    	
    	long toBeStored = 100; 
    	long genCn = 100;
    	
    	if(cfile.exists()){
    		genCn = Integer.parseInt(custEditor.readText(fileName));
    	}
    	toBeStored = genCn + 1;
    	custEditor.writeText(fileName, String.valueOf(toBeStored));
    	return genCn;
    }
    
}

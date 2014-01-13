import java.io.BufferedReader;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


//delete three files when you need a fresh start

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	*/
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Welcome to SuperMarket");
		int choice;
		
		//unify br if possible
		//prettyfy menu later on
		//include whitespace to clear scrn
		do{
			printMainMenu();
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			choice = Integer.parseInt(br.readLine());
			//for(int i =0;i<25;i++){
			//	System.out.println("\n");
			//}
			//System.out.println(choice);
			switch(choice){
				case 1:registerNewCustomer();break;
				case 2:invoiceTracker();break;
				case 3:managerOptions();break;
				case 4: return;
			}
			//for(int j =0;j<25;j++){
			//	System.out.println("\n");
			//}
		}while(true);
		//return;
	}
	
	
	public static void printMainMenu(){
		System.out.println("\t\t\t*****Main Menu*****\n\n\n");
		System.out.println("1.Register new Customer");
		System.out.println("2.Credit purchase");
		System.out.println("3.Manager Options");
		System.out.println("4.Exit");
	}
 
	
	 // rename at use
	//register new customer menu
	public static void registerNewCustomer() throws Exception{
		//printMainMenu();
		String fileName = "CustMaster.ser";
		Customer newCust = new Customer(true);
		BinaryFileIOC cEditor = new BinaryFileIOC();
		cEditor.writeObjToFile(newCust,fileName);
		//cEditor.readFromFile(fileName);
		return;
	}
	
	
	
	
	// rename at use
	//invoice tracker
	public static void invoiceTracker() throws Exception{
		String fileName = "InvoiceMaster.ser";
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("\t\t\t*****Invoice*****\n\n\n");
		System.out.println("Enter Customer number(CN): ");
		long cn = Integer.parseInt(br1.readLine());
		System.out.println("Enter Purchase amount: ");
		long value = Integer.parseInt(br1.readLine());
		
		Invoice newInvoice = new Invoice(cn, value);
		BinaryFileIOI iEditor = new BinaryFileIOI();
		iEditor.writeObjToFile(newInvoice, fileName);
		//iEditor.readFromFile(fileName);
		return;
	}
	
	
	
	//testcode- rename 
	//manager options
	public static void managerOptions() throws Exception{
		//date format to be specified here
		String dateFormat = "dd-mm-yyyy";
		SimpleDateFormat ft = new SimpleDateFormat(dateFormat);		
		
		Date startDate;
		Date endDate;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String tempTime;
		
		System.out.println("\t\t\t*****Manager Options*****\n\n\n");
		System.out.println("Please input time period to check winners\n");
		
		System.out.println("Use format " + dateFormat);
		System.out.println("Enter the start date: ");
		try{
		    tempTime = br.readLine();
		}
		catch(Exception e){
			throw new RuntimeException("Problem in Buffered Reader.");
		}
		try{
		    startDate = ft.parse(tempTime);
		}
		catch(ParseException e){
			throw new RuntimeException("Problem in parsing time.");
		}
		
		
		System.out.println("Enter the end date: ");
		try{
		    tempTime = br.readLine();
		}
		catch(Exception e){
			throw new RuntimeException("Problem in Buffered Reader.");
		}
		try{
		    endDate = ft.parse(tempTime);
		}
		catch(ParseException e){
			throw new RuntimeException("Problem in parsing time.");
		}
		
		//System.out.println("The start date is: " + startDate);
		//System.out.println("The end date is: " + endDate);
		
		if(startDate.compareTo(endDate) < 0)
		    System.out.println("Estimating winners...");
		else{
			System.out.println("Oops.Looks like the dates are a bit off..");
			System.out.println("Try again.");
			return;
			//handle re-entry of date in a better way
		}
		
		ArrayList <PossibleWinner> pwlist = new ArrayList<PossibleWinner>(); 
	    String fileName = "InvoiceMaster.ser";  //please commonize this later on
	    
		//exp-direct code to got through file
		FileInputStream fin = new FileInputStream(fileName);
		Invoice invobj = new Invoice();
		Date invoiceDate = new Date();
		boolean flag = false;
		boolean inc = false;
		
		try{
			while(true){
				inc = false;
				ObjectInputStream ois = new ObjectInputStream(fin);
				invobj = (Invoice)ois.readObject();				
				//add needed code here
				//System.out.println(invobj.toString());
				invoiceDate = invobj.returnInvoiceDate();
				//System.out.println(invoiceDate);
				if((startDate.compareTo(invoiceDate) < 0) && (invoiceDate.compareTo(endDate) < 0)){
					//implementing a linear search - extend later
					for(int i = 0; i < pwlist.size();i++){
						if(pwlist.get(i).returnCn() == invobj.returnCn()){
							PossibleWinner temp = new PossibleWinner();
							temp = pwlist.get(i);
							temp.incValue(invobj.returnValue());
							pwlist.set(i, temp);
							inc = true;
						}
							
					}
					if (inc == false){
					    PossibleWinner temp = new PossibleWinner();
					    temp.setPossibleWinner(invobj);
					    pwlist.add(temp);
					    flag = true;
					}
				}
			}
		}
		catch(EOFException e){}
		catch(Exception e){
			//throw new RuntimeException("Exception at invoice retrievel");
		}
		finally{
			//if(ois != null)
				//ois.close();
			fin.close();
		}
		
		if(flag == false){
			System.out.println("Oops. It looks like no transactions have been found.");
		    return;
		}//test
		
		
		//System.out.println("\n\n\n" + pwlist.size());
		//System.out.println("\n\n\n");
		//for(int i=0;i<pwlist.size();i++)
		//	System.out.println(pwlist.get(i).toString());
	    
		
		Collections.sort(pwlist, new PWvalueComparator());
		
		
		//System.out.println("\n\n\n");
		//for(int i=0;i<pwlist.size();i++)
		//	System.out.println(pwlist.get(i).toString());
	    
		BinaryFileIOC cEditor = new BinaryFileIOC();
		String cFileName = "CustMaster.ser";
		
		System.out.println("\n\n\n\n");
		System.out.println("Address of surprise gift winner: \n");
		
		long tempCn = pwlist.get(pwlist.size() - 1).returnCn();
		
		System.out.println("Customer no: " + tempCn);
		System.out.print("Customer address: ");
		cEditor.readObjFromFile(cFileName, tempCn).printAddress();
		
		long maxValue = 10000;
		
		System.out.println("\n\n\n\n");
		System.out.println("Address of Gold Coin winner(s): \n");
		
		int i = pwlist.size() - 1;
		while(pwlist.get(i).returnValue() > maxValue){
			tempCn = pwlist.get(i).returnCn();
			System.out.println("\nCustomer no: " + tempCn);
			System.out.print("Customer address: ");
			cEditor.readObjFromFile(cFileName, tempCn).printAddress();
			i--;
		}
		if(i == pwlist.size() - 1)
			System.out.println("No winners of the Gold Coin Scheme.");
		
	}
	
	
}

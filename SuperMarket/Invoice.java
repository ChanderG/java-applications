import java.io.Serializable;
import java.util.Date;

//all important transaction between Invoice and main is in main

public class Invoice implements Serializable{
	private long cn; //no validity checking
	private long value;
	private Date date;

	public Invoice(){
		
	}
	public Invoice(long cn, long value){
		this.cn = cn;
		this.value = value;
		date = new Date();
	}
	
	public Invoice(Invoice in){
		this.cn = in.cn;
		this.value = in.value;
		this.date = in.date;
	}
	
	public String toString(){
		String totalContents = "";
		totalContents += "Cn: " + cn;
		totalContents += "Value: " + value;
		totalContents += "Date: " + date.toString();
		return totalContents;
	}
	
	public long returnCn(){
		return cn;
	}
	
	public long returnValue(){
		return value;
	}
	
	public Date returnInvoiceDate(){
		return date;
	}
	
}

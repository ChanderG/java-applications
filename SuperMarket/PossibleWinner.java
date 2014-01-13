
public class PossibleWinner{
	private long cn;
	private long value;
	
	public PossibleWinner(){
		
	}
	
	public PossibleWinner(PossibleWinner other){
		this.cn = other.returnCn();
		this.value = other.returnValue();
	}
	
	public void  setPossibleWinner(Invoice in){
		this.cn = in.returnCn();
		this.value = in.returnValue();
	}
	
	public void incValue(long inc){
		value += inc;
	}
	
	public long returnCn(){
		return cn;
	}
	
	public long returnValue(){
		return this.value;
	}
	
	public String toString(){
		String totalContents = "";
		totalContents += "Cn: " + cn;
		totalContents += " Value: " + value;
		return totalContents;
	}

}

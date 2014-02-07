package convert;
public class Question {
    int id;
    String q;
    String optA;
    String optB;
    String optC;
    String optD;
    int ans;
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setQ(String q){
        this.q = q;
    }
    
    public void setOptA(String optA){
        this.optA = optA;
    }
    
    public void setOptB(String optB){
        this.optB = optB;
    }
    
    public void setOptC(String optC){
        this.optC = optC;
    }
    
    public void setOptD(String optD){
        this.optD = optD;
    }
    
    public void setAns(int ans){
        this.ans = ans;
    }
    
    public int getId(){
        return id;
    }
    
    public String getQ(){
        return q;
    }
    
    public String getOptA(){
        return optA;
    }
    
    public String getOptB(){
        return optB;
    }
    
    public String getOptC(){
        return optC;
    }
    
    public String getOptD(){
        return optD;
    }
    
    public int getAns(){
        return ans;
    }
}

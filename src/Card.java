public class Card {


    public int value;
    public String name;
    public String suit;
    public Card(String pSuit, int pValue, int pName){
        if(pName==11){

        name="ace";
        value=11;
        } else if(pName==1) {
            name="two";
            value=2;
        }
        suit=pSuit;
        value=pValue;
    }
    public void printInfo(){
        System.out.println("the "+name+" of "+suit+" has a value of "+value);
    }
}

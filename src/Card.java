public class Card {


    public int value;
    public String name;
    public String suit;
    public Card(String pSuit, int pValue, int pName){
        value=pValue;
        if(pName==0){

        name="ace";
        value=11;
        } else if(pName==1) {
            name="two";
            value=2;
        }
        else if(pName==2){
            name="three";
            value=3;
        }
        else if(pName==3){
            name="four";
            value=4;
        }
        else if(pName==4){
            name="five";
            value=5;
        }
        else if(pName==5){
            name="six";
            value=6;
        }
        else if(pName==6){
            name="seven";
            value=7;
        }
        else if(pName==7){
            name="eight";
            value=8;
        }
        else if(pName==8){
            name="nine";
            value=9;
        }
        else if(pName==9){
            name="jack";
            value=10;
        }
        else if(pName==10){
            name="queen";
            value=10;
        }
        else if(pName==11){
            name="king";
            value=10;
        }
        else if(pName==12){
            name="ace";
            value=1;
        }
    suit=pSuit;


    }
    public void printInfo(){
        System.out.println("the "+name+" of "+suit+" has a value of "+value);
    }
}

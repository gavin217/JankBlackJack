public class Player {
    public int CardTotal;
    public boolean isBust;
    public Card[] hand;
    public boolean isHit;
    public boolean isStand;
    public String name;
    public Card[] helper;
    public  int round;
    public Boolean dTurn;



    public Player(){
        CardTotal=0;
        round=2;
        isBust=false;
        helper=new Card[20];
        hand=new Card[round];
        isHit=false;
        isStand=false;
        dTurn=false;
        name="me";
    }
    public void printInfo(){
        System.out.println(name);
        System.out.println(CardTotal);
        System.out.println(isBust);
        System.out.println(isHit);
        for(int x=0;x< hand.length;x++){
            hand[x].printInfo();
        }
    }
    public void calculateTotal(){
        int addValue=0;
        for(int x=0;x< hand.length;x++){
            addValue=addValue+hand[x].value;
        }
       CardTotal=addValue;
        if(CardTotal>21){
            isBust=true;
        }
        if(CardTotal<=21){
            isBust=false;
        }
    }
    public void Hit(){


    if(isHit==true) {
        round = round + 1;
        isHit = false;
    }
    helper = hand;

        hand=new Card[round];
        for(int x=0;x< helper.length;x++){
            hand[x]=helper[x];
        }


    }
    public void stand(){
        if(isStand==true){
            System.out.println("final card total= "+CardTotal);
            isStand=false;
            if(isBust==true){
                System.out.println("you lose");
            }

            }
        if(isBust==false){
            dTurn=true;
        }
    }

}

public class Dealer {
    public boolean isOver16;
    public int cardTotal;
    public boolean isBust;
    public Card[] hand;
    public Card[] dealtHand;

    public Dealer(){
isOver16=false;
cardTotal=0;
isBust=false;
hand=new Card[2];
dealtHand=new Card[2];

    }
    public void printInfo(){
        System.out.println(cardTotal);
        System.out.println(isBust);
        System.out.println(isOver16);
        for(int x=0;x< hand.length;x++){
            hand[x].printInfo();
        }
        for(int a=0;a<dealtHand.length;a++){
            if(isOver16==false) {
                dealtHand[a].printInfo();
            }
        }
    }
    public void calculateTotal(){
        int addValue=0;
        for(int x=0;x< hand.length;x++){
            addValue=addValue+hand[x].value;
            cardTotal=addValue;
            if(cardTotal<17){//fix this so that it stops making cards at 17 but if goes over 21 its a bust
                isOver16=false;
            } else if (cardTotal>17) {
                isOver16=true;

            }
            if(isOver16==false){
                addValue=addValue+dealtHand[x].value;
            }
        }

    }
}

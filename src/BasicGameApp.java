import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BasicGameApp implements Runnable, KeyListener {
    public Card[] deck;
    public int cardAmount;
    public boolean gameOn;
    public Player p1;
    public Dealer d1;
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
    final int WIDTH = 200;
    final int HEIGHT = 200;
    public BufferStrategy bufferStrategy;


    public static void main(String[] args) {
BasicGameApp a= new BasicGameApp();
    }
    public BasicGameApp(){
        setUpGraphics();
        System.out.println("welcome to blackjack");
        p1= new Player();
        d1=new Dealer();
        deck=new Card[52];
        int cardIndex=0;
        for(int x=0;x<4;x++) {


            for (int i=0; i < 13; i++) {
                deck[cardIndex] = new Card(x, 10, i);
                cardIndex++;

            }
        }

        shuffleCards();
        printDeck();

        p1.hand[0]=deck[0];//give the player cards
        p1.hand[1]=deck[1];
        d1.hand[0]=deck[2];
        d1.hand[1]=deck[3];










        Scanner s = new Scanner(System.in);
        p1.calculateTotal();
        p1.printInfo();
        System.out.println("hit or stand");
        String aOption = s.nextLine();
        System.out.println(aOption);
        if(aOption.equals("hit")){
            System.out.println("click white box and hit h");
        }
        if(aOption.equals("stand")){
            System.out.println("click white box and hit s");
        }












    }
    public void run() {

        //for the moment we will loop things forever.

        while (true) {


            render();  // paint the graphics

            // sleep for 10 ms
        }

    }
    public void pause(int time ){
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }
    public void shuffleCards(){
        for(int a=0;a<deck.length;a++){
            int randy= (int)(Math.random()*52);
            Card helper=deck[randy];
            deck[randy]=deck[a];
            deck[a]=helper;
        }
    }
    public void printDeck(){
        for (int x=0;x<deck.length;x++){

            deck[x].printInfo();

        }
    }

public void setUpGraphics(){
    frame = new JFrame("Application Template");   //Create the program window or frame.  Names it.

    panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
    panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
    panel.setLayout(null);   //set the layout

    // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
    // and trap input events (Mouse and Keyboard events)
    canvas = new Canvas();
    canvas.addKeyListener(this);
    canvas.setBounds(0, 0, WIDTH, HEIGHT);
    canvas.setIgnoreRepaint(true);

    panel.add(canvas);  // adds the canvas to the panel.

    // frame operations
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
    frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
    frame.setResizable(false);   //makes it so the frame cannot be resized
    frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

    // sets up things so the screen displays images nicely.
    canvas.createBufferStrategy(2);
    bufferStrategy = canvas.getBufferStrategy();
    canvas.requestFocus();
    System.out.println("DONE graphic setup");
    System.out.println("DONE graphic setup");
}
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //h is 72 s is 83
        if(e.getKeyCode()==72){
            p1.isHit=true;
          p1.Hit();
            p1.hand[p1.round-1]=deck[p1.round+1];
            p1.calculateTotal();
            p1.printInfo();
            cardAmount=p1.round+d1.hand.length;
            if(p1.isBust==true){
                p1.isStand=true;
                p1.stand();
            }

        }
        if(e.getKeyCode()==83){
            p1.isStand=true;
            p1.calculateTotal();
            p1.printInfo();
            p1.stand();
            cardAmount=p1.round+d1.hand.length;
            if(p1.dTurn==true){
                d1.calculateTotal();
                d1.printInfo();
                System.out.println(cardAmount);
                while(d1.isOver16==false){
                    d1.dHit();
                    d1.hand[d1.round-1]=deck[cardAmount+1];
                    d1.calculateTotal();
                    d1.printInfo();
                    pause(1000);
                }
                if(d1.isOver16==true){
                    d1.dStand();
                    if(p1.CardTotal> d1.cardTotal){
                        System.out.println("you win");
                    }
                    if(p1.CardTotal<d1.cardTotal&&d1.isBust==false){
                        System.out.println("you lose");
                    }
                    if(p1.CardTotal== d1.cardTotal){
                        System.out.println("tie");
                    }
                }
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}

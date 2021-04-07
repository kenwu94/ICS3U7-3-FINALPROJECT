/*
Authors: Eric Y, Ken W
Date: April 6 2021
ICS 3U7 Ms S
Class description: Class for the panel where players select their tanks
*/

//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TankSelect extends JPanel implements ActionListener, KeyListener {
    //variables
    private Timer timer;
    private JButton fastTank, heavyTank, armoredTank;
    private JLabel player1picking, player2picking;
    private boolean player1pick;
    private static int[] hp = new int[2];
    private static int[] speed = new int[2];
    private static int[] power = new int[2];
    private int listIndex = 0;
    
    //constructor
    public TankSelect(){
        //initialize variables
        player1pick =true;
        timer = new Timer(5, this);
        timer.start();

        //set up panel
        setBackground(Color.white);
        setFocusable(true);
        this.requestFocusInWindow();


        //initialize and set up buttons
        fastTank = new JButton();
        fastTank.setBounds(250, 240, 140, 60);
        fastTank.setText("Fast Tank");
        fastTank.setBackground(Color.cyan);
        fastTank.addActionListener(this);

        heavyTank = new JButton();
        heavyTank.setBounds(400, 240, 140, 60);
        heavyTank.setText("Heavy Tank");
        heavyTank.setBackground(Color.cyan);
        heavyTank.addActionListener(this);

        armoredTank = new JButton();
        armoredTank.setBounds(550, 240, 140, 60);
        armoredTank.setText("Armored Tank");
        armoredTank.setBackground(Color.cyan);
        armoredTank.addActionListener(this);

        this.setLayout(null);
        this.add(fastTank);
        this.add(heavyTank);
        this.add(armoredTank);


    }

    //method than handles button presses
    public void actionPerformed(ActionEvent e) {
        
        repaint();
        //get the right index
        if(player1pick) listIndex = 0;
        else listIndex = 1;
        
        //check if the light tank button is selected
        if(e.getSource() == fastTank){
            //get the tank values
            hp[listIndex] = 75;
            speed[listIndex] = 8;
            power[listIndex] = 1;
            //check if the players have already picked
            if(!player1pick){
                //initialize a new game panel and display it
                MyFrame.mp = new GamePanel();
                MyFrame.cont.add(MyFrame.mp, "Game Panel");
                MyFrame.lay.show(MyFrame.cont, "Game Panel");
                MyFrame.mp.requestFocusInWindow();
                MyFrame.mp.setFocusable(true);
            }
            //update variable
            player1pick = false;

        }
        //check if the heavy tank button is selected
        if(e.getSource() == heavyTank){
            //get the tank values
            hp[listIndex] = 100;
            speed[listIndex] = 2;
            power[listIndex] = 2;
            //check if the players have already picked
            if(!player1pick){
                //initialize a new game panel and display it
                MyFrame.mp = new GamePanel();
                MyFrame.cont.add(MyFrame.mp, "Game Panel");
                MyFrame.lay.show(MyFrame.cont, "Game Panel");
                MyFrame.mp.requestFocusInWindow();
                MyFrame.mp.setFocusable(true);
            }
            //update variable
            player1pick = false;
        }
        //check if the armored tank button is selected
        if (e.getSource() == armoredTank) {
            //get the tank values
            hp[listIndex] = 150;
            speed[listIndex] = 2;
            power[listIndex] = 1;
            //check if the players have already picked
            if(!player1pick){
                //initialize and display a new game panel
                MyFrame.mp = new GamePanel();
                MyFrame.cont.add(MyFrame.mp, "Game Panel");
                MyFrame.lay.show(MyFrame.cont, "Game Panel");
                MyFrame.mp.requestFocusInWindow();
                MyFrame.mp.setFocusable(true);
            }
            //update variables
            player1pick = false;
        }
    }
    
    //method that displays the proper background image
    public void paintComponent(Graphics g) {
    	g.drawImage(Sprites.tankSelectBG[0],0,0,null);
    	if(!player1pick) {
    		g.drawImage(Sprites.tankSelectBG[1],0,0,null);
    	}
    }
    public void keyTyped(KeyEvent e) {

    }


    public void keyPressed(KeyEvent e) {

    }


    public void keyReleased(KeyEvent e) {

    }

    //getters for the tank values given a specific index
    public static int getHp(int index){
        return hp[index];
    }
    public static int getSpeed(int index){
        return speed[index];
    }
    public static int getPower(int index){
        return power[index];
    }
}

/*
Authors: Eric Y, Ken W
Date: April 6 2021
ICS 3U7 Ms S
Class description: Class for the panel that displays the winner of the game
*/

//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;


public class EndPanel extends JPanel implements ActionListener, KeyListener {
    //variables
    private Timer timer;
    private JButton back, again;
    private JLabel title;
    String winner;

    //constructor
    public EndPanel(String winner) {

        //initialize variables, set up panel
        this.winner = winner;
       
        setBackground(Color.white);

        setFocusable(true);
        this.requestFocusInWindow();

        timer = new Timer(5, this);
        timer.start();
        
        //set up buttons
        back = new JButton();
        back.setBounds(710, 255, 140, 30);
        back.setText("BACK TO MENU");
        back.setBackground(Color.cyan);
        back.addActionListener(this);

        again = new JButton();
        again.setBounds(710, 310, 140, 30);
        again.setText("PLAY AGAIN");
        again.setBackground(Color.YELLOW);
        again.addActionListener(this);
        again.setFocusable(false);

        this.setLayout(null);

        this.add(back);
        this.add(again);
        
        //make a new tankSelect panel
        TankSelect newTs = new TankSelect();
        MyFrame.cont.add(newTs, "New Tank Selection");
    }
    
    //method that handles button presses
    public void actionPerformed(ActionEvent e) {
        //move through panels in CardLayout
        if (e.getSource() == back) {
            MyFrame.lay.show(MyFrame.cont, "Menu Panel");
        }
        if (e.getSource() == again) {
            MyFrame.lay.show(MyFrame.cont, "New Tank Selection");
        }


    }

    //method that handles displaying the winner of the game
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(winner.equals("Player 1")) {
        	g.drawImage(Sprites.winBackG[0],0,0,null);
        }else {
        	g.drawImage(Sprites.winBackG[1],0,0,null);
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }
}

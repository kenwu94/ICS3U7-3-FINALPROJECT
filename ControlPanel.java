/*
Authors: Eric Y, Ken W
Date: April 6 2021
ICS 3U7 Ms S
Class description: Class for the panel that displays the controls
*/

//imports
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel implements ActionListener, KeyListener {
    //variables
    private Timer timer;
    private JButton back, prev;
    private BufferedImage controls;
    
    //constructor
    public ControlPanel(){

        //set up panel
        setBackground(Color.white);
        addKeyListener((KeyListener) this);
        setFocusable(true);
        this.requestFocusInWindow();

        timer = new Timer(5, this);
        timer.start();

        //initialize buttons
        back = new JButton();
        back.setBounds(0, 0, 140, 30);
        back.setText("BACK TO MENU");
        back.setBackground(Color.cyan);
        back.addActionListener(this);

        prev = new JButton();
        prev.setBounds(0, 471, 80, 30);
        prev.setText("PREV");
        prev.setBackground(Color.YELLOW);
        prev.addActionListener(this);

        this.setLayout(null);
        this.add(back);
        this.add(prev);
        
    }

    //method that handles actions once buttons are clicked
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            MyFrame.lay.show(MyFrame.cont, "Menu Panel");
        }
        if(e.getSource() == prev){
            MyFrame.lay.show(MyFrame.cont, "Instructions");
        }


    }

    //method that draws the controls
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Sprites.controls, 200, 0,560,500, null);
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }
    
}

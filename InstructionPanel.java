/*
Authors: Eric Y, Ken W
Date: April 6 2021
ICS 3U7 Ms S
Class description: Class for the panel that displays the instructions
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

public class InstructionPanel extends JPanel implements ActionListener, KeyListener {
    //variables
    private Timer timer;
    private JButton back, next;

    //constructor
    public InstructionPanel(){

        //set up panel
        setBackground(Color.white);
        addKeyListener((KeyListener) this);
        setFocusable(true);
        this.requestFocusInWindow();
        //initialize timer
        timer = new Timer(5, this);
        timer.start();

        //initialize, set up buttons
        back = new JButton();
        back.setBounds(0, 0, 80, 30);
        back.setText("BACK");
        back.setBackground(Color.cyan);
        back.addActionListener(this);

        next = new JButton();
        next.setBounds(864, 471, 80, 30);
        next.setText("NEXT");
        next.setBackground(Color.green);
        next.addActionListener(this);

        this.setLayout(null);
        this.add(back);
        this.add(next);
    }
    //method that handles button presses
    public void actionPerformed(ActionEvent e) {
        //switch panels in cardlayout depending on which button is pressed
        if(e.getSource() == back){
            MyFrame.lay.show(MyFrame.cont, "Menu Panel");
        }
        if(e.getSource() == next){
            MyFrame.lay.show(MyFrame.cont, "Control Panel");
        }

    }
    //method that handles drawing the instructions on the screen
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(Sprites.instructions, 50, 10,700,500, null);
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }


}

  
/*
Authors: Eric Y, Ken W
Date: April 6 2021
ICS 3U7 Ms S
Class description: Class for the menu panel
*/

//imports
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Menu extends JPanel implements ActionListener {
    //variables
    private JButton play, instructions, exit;
    private JLabel menuBackG;
    Sprites sprites;
    public static TankSelect ts;

    public Menu() {
    	//initialize sprites instance
        sprites = new Sprites();
        
        //initialize and set up buttons
        play = new JButton();
        play.setBounds(380, 155, 200, 60);
        play.setText("Play");
        play.setBackground(Color.white);
        play.addActionListener(this);

        instructions = new JButton();
        instructions.setBounds(380, 255, 200, 60);
        instructions.setText("Instructions");
        instructions.setBackground(Color.white);
        instructions.addActionListener(this);


        exit = new JButton();
        exit.setBounds(430, 355, 100, 30);
        exit.setText("Exit");
        exit.setBackground(Color.red);
        exit.addActionListener(this);
        
        //set up panel
        this.add(play);
        this.add(instructions);
        this.add(exit);
        this.setLayout(null);
        this.setVisible(true);
    }

    //method that handles button presses
    public void actionPerformed(ActionEvent e) {
        //check if exit button is pressed
        if (e.getSource() == exit) {
            System.exit(0);
        }
        //check if play button is pressed
        else if(e.getSource() == play) {
            //initialize and set up a new TankSelect panel
            ts = new TankSelect();
            MyFrame.cont.add(ts, "Tank Selection");
            MyFrame.lay.show(MyFrame.cont, "Tank Selection");
            ts.requestFocusInWindow();
            ts.setFocusable(true);
        }
        //check if instruction button is pressed
        else if (e.getSource() == instructions) {
            //show instructions panel
            MyFrame.lay.show(MyFrame.cont, "Instructions");
        }
    }
    //method that draws the background of the menu
    public void paintComponent(Graphics g) {
    	g.drawImage(Sprites.menu,0,0,null);
    }

}

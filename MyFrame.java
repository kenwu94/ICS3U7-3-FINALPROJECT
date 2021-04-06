/*
Authors: Eric Y, Ken W
Date: April 5 2021
ICS 3U7 Ms S
Class description: Class for the Frame
*/
//imports
import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame{
    //variables
    public static CardLayout lay;
    public static Component mp;
    public static Container cont;

    //constructor
    public MyFrame(String title) {
        super(title);
        //set up cardlayout
        cont = this.getContentPane();
        lay = new CardLayout();
        cont.setLayout(lay);
        
        //display program icon
        ImageIcon ii = new ImageIcon("images/icon.png");
        this.setIconImage(ii.getImage());

        //initialize the panels
        Menu m = new Menu();
        InstructionPanel instr = new InstructionPanel();
        ControlPanel contr = new ControlPanel();    
        
        //add panels to layout
        MyFrame.cont.add(m, "Menu Panel");
        MyFrame.cont.add(instr, "Instructions");
        MyFrame.cont.add(contr, "Control Panel");

        //modify frame
        this.setVisible(true);
        this.setSize(960,540);
        setResizable(false);


    }


}

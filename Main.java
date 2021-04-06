/*
Authors: Eric Y, Ken W
Date: April 5 2021
ICS 3U7 Ms S
Class description: Main class that starts the program
*/

import javax.swing.*;

public class Main {
    public static void main(String[] args){
        //create frame instance
        MyFrame frame= new MyFrame("Tanki Offline");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}

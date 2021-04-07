/*
Authors: Eric Y, Ken W
Date: April 6 2021
ICS 3U7 Ms S
Class description: Class for the laser projectile
*/

//imports
import javax.swing.*;
import java.awt.*;

public class Laser extends JComponent {
    //variables
    private int damage = 5;
    private int width;
    private int height;
    public static boolean shootLaser = false;
    private int x, y;
    private boolean turn;

    //constructor
    public Laser(int x, int y, boolean turn) {
        //initialize variables
        this.turn = turn;
        this.width = 50;
        this.height = 6;
        if(turn) {
            this.x = x + 50;
        }
        else{
            this.x = x - 50;
        }
        this.y = y + 30;

    }

    //method that draws the laser
    public void draw(Graphics g) {
        g.drawImage(Sprites.projectiles[2], x,y-15,null);

    }

    //method than handles movement of the laser
    public void shoot(){
        //move the laser depending on which tanks turn it is
        if(turn) x += 20;
        else x -= 20;
        //check if the laser is going outside the screen
        if(x > 1000 || x < -50) {
            //reset variables
            shootLaser = false;
            GamePanel.lselected = false;
            GamePanel.outofbounds = true;
            GamePanel.canHit = false;
            GamePanel.skippable = true;
        }
    }
    
    //getters for the position of the laser
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    //methods that modify the hp of the tank when a tank is hit
    public void hitTarget(Tank x, Tank2 y){

        x.setHp(x.getHp() - damage * y.getPower());
    }
    public void hitTarget(Tank2 x, Tank y){

        x.setHp(x.getHp() - damage * y.getPower());
    }

}

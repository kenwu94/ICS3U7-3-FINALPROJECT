/*
Authors: Eric Y, Ken W
Date: April 5 2021
ICS 3U7 Ms S
Class description: Class for the bomb projectile
*/

//imports
import javax.swing.*;
import java.awt.*;
import java.awt.*;

public class Bomb {
    //variables
    private int damage = 20;
    private int speed = 15;
    private int rad;
    public static boolean shootBomb = false;
    private double x, y;
    private boolean turn;
    private double angle;
    private double xcomponent, ycomponent;

    //constructor
    public Bomb(int x, int y, boolean turn, double angle) {
        //initialize variables
        this.turn = turn;
        this.rad = 15;
        this.angle = angle;
        //adjust the x value depending on which player is shooting
        if(turn) {
            this.x = x + 50;
        }
        else{
            this.x = x - 50;
        }
        this.y = y + 28;

    }
    //method that draws the bomb
    public void myDraw(Graphics g){
        g.setColor(Color.black);
        g.fillOval((int)x, (int)y, rad, rad);
        g.drawImage(Sprites.projectiles[0],(int)x-10,(int)y-10,null);

    }

    //method that calculates the movement of the bomb for tank 1
    public void shootProjectile(Tank tank){
        //physics equations
        double radians = angle*Math.PI/180;
        xcomponent = Math.abs(speed * Math.cos(radians));
        ycomponent = Math.abs(speed * Math.sin(radians));
        double time = (System.currentTimeMillis()-GamePanel.startTime)/20;
        x = tank.getX()+ 50 + xcomponent * time;
        y = tank.getY() + 30 - (ycomponent * time - 0.5 * 0.98 * Math.pow(time, 2));
        //stop the bomb movement once the bomb gets off the screen
        if(y > 600){
            //reset variables
            shootBomb = false;
            GamePanel.bselected = false;
            GamePanel.outofbounds = true;
            GamePanel.canHit = false;
        }
    }

    //method that calculates the movement of the bomb for tank 2
    public void shootProjectile(Tank2 tank){
        //physics equations
        double radians = angle*Math.PI/180;
        xcomponent = Math.abs(speed * Math.cos(radians));
        ycomponent = Math.abs(speed * Math.sin(radians));
        double time = (System.currentTimeMillis()-GamePanel.startTime)/20;
        x = tank.getX() - (xcomponent * time);
        y = tank.getY() + 30 - (ycomponent * (time) - 0.5 * 0.98 * Math.pow(time, 2));
        //stop the bomb movement once the bomb gets off the screen
        if(y > 600){
            //reset variables
            shootBomb = false;
            GamePanel.bselected = false;
            GamePanel.outofbounds = true;
            GamePanel.canHit = false;
        }
    }

    //methods that changes the hp of the tank that is hit
    public void hitTarget(Tank x, Tank2 y){
        x.setHp(x.getHp() - damage * y.getPower());
    }
    public void hitTarget(Tank2 x, Tank y){
        x.setHp(x.getHp() - damage * y.getPower());
    }

    //method that gets the x value of bomb
    public double getX(){
        return x;
    }

    //method that gets y value of bomb
    public double getY(){
        return y;
    }

}

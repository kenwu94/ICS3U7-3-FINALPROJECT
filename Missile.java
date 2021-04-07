  
/*
Authors: Eric Y, Ken W
Date: April 6 2021
ICS 3U7 Ms S
Class description: Class for the missile projectile
*/

//imports
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.*;

public class Missile {
    //variables
    private int damage = 10;
    private double speed;
    private int rad;
    public static boolean shootMissile = false;
    private double x, y;
    private boolean turn;
    private double angle;
    private double xcomponent, ycomponent;
    private BufferedImage img;

    //constructor
    public Missile(int x, int y, boolean turn, double angle) {
        //initialize the variables
        this.speed = 20;
        this.turn = turn;
        this.rad = 10;
        this.angle = angle;
        //get the right missile sprite
        if(turn) {
            this.x = x + 50;
            img = Sprites.projectiles[1];
        }
        else{
            this.x = x - 50;
            img = Sprites.projectiles[3];
        }
        this.y = y + 28;

    }

    //method to draw the missile
    public void myDraw(Graphics g){
        g.setColor(Color.orange);
        g.fillOval((int)x, (int)y, rad, rad);
        g.drawImage(img, (int)x,(int)y-10,null);
        

    }
    
    //method that calculates the movement of the missile for tank 1
    public void shootProjectile(Tank tank){
        //physics equations
        double radians = angle*Math.PI/180;
        xcomponent = Math.abs(speed * Math.cos(radians));
        ycomponent = Math.abs(speed * Math.sin(radians));
        double time = (System.currentTimeMillis()-GamePanel.startTime)/20;
        x = tank.getX()+ 50 + xcomponent * time;
        y = tank.getY() + 30 - (ycomponent * time - 0.5 * 0.98 * Math.pow(time, 2));
        //check if the missile is off the screen
        if(y > 600){
            //reset variables
            shootMissile = false;
            GamePanel.mselected = false;
            GamePanel.outofbounds = true;
            GamePanel.canHit = false;
            GamePanel.skippable = true;
        }
    }
    
    //method that calculates movement of the missile for tank 2
    public void shootProjectile(Tank2 tank){
        //physics equations
        double radians = angle*Math.PI/180;
        xcomponent = Math.abs(speed * Math.cos(radians));
        ycomponent = Math.abs(speed * Math.sin(radians));
        double time = (System.currentTimeMillis()-GamePanel.startTime)/20;
        x = tank.getX() - (xcomponent * time);
        y = tank.getY() + 30 - (ycomponent * (time) - 0.5 * 0.98 * Math.pow(time, 2));
        //check if the missile is off the screen
        if(y > 600){
            //reset variables
            shootMissile = false;
            GamePanel.mselected = false;
            GamePanel.outofbounds = true;
            GamePanel.canHit = false;
            GamePanel.skippable = true;
        }
    }
    
    //methods that modify the hp of the tank if they are hit with the missile
    public void hitTarget(Tank x, Tank2 y){

        x.setHp(x.getHp() - damage * y.getPower());
    }
    public void hitTarget(Tank2 x, Tank y){

        x.setHp(x.getHp() - damage * y.getPower());
    }

    //getters for the position of the missile
    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }



}

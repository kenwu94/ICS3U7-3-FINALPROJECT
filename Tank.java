/*
Authors: Eric Y, Ken W
Date: April 6 2021
ICS 3U7 Ms S
Class description: Class for the tank
*/

//imports
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

//constructor
public class Tank {
    //variables
    int hp, speed, power, x, y;
    double angle;
    int fuel;
    int hpwidth;
    boolean isFacingRight;
    private JLabel hplabel;
    private BufferedImage tankImage;
    private int turretY,turretX;

    //constructor
    public Tank(int hp, int speed, int power, int x, int y,boolean isFacingRight){
        //initialize variables
        this.hp = hp;
        this.speed = speed;
        this.power = power;
        this.x = x;
        this.angle = 0;
        this.y = y;
        this.isFacingRight = isFacingRight;
        fuel = 10;
        hpwidth = hp*2;
    }

    //method that draws the tank
    public void myDraw(Graphics g){
        //get the proper turret sprite to display
        int index = (int) angle;
        index = (index + 10) / 10;
        //draw the tank
        g.drawImage(tankImage, x, y, null);
        g.drawImage(Sprites.tank1[index], turretX, turretY, null);
        
        //check if hp is 0
        if (hp <= 0) {
            //initialize a new EndPanel and display it
            EndPanel end = new EndPanel("Player 2");
            MyFrame.cont.add(end, "End Panel");
            MyFrame.lay.show(MyFrame.cont, "End Panel");
        }
        //check if the players turn is over
        if(fuel == 0 && !GamePanel.canShoot && !GamePanel.canHit && GamePanel.outofbounds){
            //update variables
            GamePanel.player1turn = !GamePanel.player1turn;
            GamePanel.canShoot = true;
            GamePanel.canHit = true;
            GamePanel.outofbounds =false;

        }
    }
    //method that gets the correct tank image based on the terrain
    public void setTankImage(Terrain t) {
        //get direction and slope of the tank
    	boolean direction = t.getDirection(this, t.getSlope());
    	boolean isSlope = t.isSlope();
        //check for slope
    	if(isSlope) {
            //check if the tank is facing up
    		if(direction) {
                //get the tank image facing up,adjust turret values
    			tankImage = Sprites.tank1[11];
    			turretY = y+6;
    			turretX = x+14;
    		}else {
                //get the tank image facing down, adjust turret values
    			tankImage = Sprites.tank1[10];
    			turretY = y+8;
    			turretX = x+26;
    		}
    	}else{
            //get the normal tank image, adjust turret value
    		tankImage = Sprites.tank1[0];
    		turretY = y+18;
    		turretX = x+23;
    	}
    }

    //methods for the tank to move 
    public void moveFlatRight(){
        //check if the tank is in bounds
    	if(x<900) {
        //update values
        x+=speed;
        fuel-=1;
    	}
    }
    public void moveFlatLeft(){
        //check if the tank is in bounds
    	if(x>0) {
        //update values
    	x-=speed;
        fuel-=1;
    	}
    }
    //methods to change the angle of the turret
    public void moveAngleUp() {
        //check if the angle is on bounds
        if(angle<80) {
            angle+=10;
        }
    }
    public void moveAngleDown() {
        //check if the angle is in bounds
        if(angle>0) {
            angle-=10;
        }

    }
    
    //getter for if the tank is facing right
    public boolean getFacingRight() {
        return isFacingRight;
    }

    //method that draws the hp bar for the tank
    public void drawHp(Graphics g, int x, boolean player){
        //check for which player the hp bar is being drawn for
        if(player) {
            g.setColor(Color.black);
            g.drawRect(x - 1, 399, hpwidth + 1, 61);
            g.setColor(Color.RED);
            g.fillRect(x, 400, hpwidth, 60);
            g.setColor(Color.green);
            g.fillRect(x, 400, hp * 2, 60);
        }
        else{
            g.setColor(Color.black);
            g.drawRect(941, 399, -hpwidth -3, 61);
            g.setColor(Color.RED);
            g.fillRect(940 - hpwidth, 400, hpwidth, 60);
            g.setColor(Color.green);
            g.fillRect(940 - hpwidth, 400, hp * 2, 60);
        }
    }

    //method that draws the fuel bar for the tanks
    public void drawFuel(Graphics g, int x, boolean player){
        //check for which player the fuel bar is being drawn for
        if(player) {
            g.setColor(Color.black);
            g.drawRect(x - 1, 464, 101, 16);
            g.setColor(Color.darkGray);
            g.fillRect(x, 465, 100, 15);
            g.setColor(Color.orange);
            g.fillRect(x, 465, fuel * 10, 15);
        }
        else{
            g.setColor(Color.black);
            g.drawRect(941 - 103, 464, 103, 16);
            g.setColor(Color.darkGray);
            g.fillRect(940 - 100, 465, 100, 15);
            g.setColor(Color.orange);
            g.fillRect(940 - fuel * 10, 465, fuel * 10, 15);
        }
    }
    
    //getter for hp
    public int getHp(){
        return hp;
    }

    //setter for hp
    public void setHp(int hp){
        this.hp = hp;
    }

    //getters for the position of the tank
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    
    //method that sets the y value based on a given terrain
    public void setY(Terrain t) {
    	y = t.getY(this)-60;
    }
    //getter for the angle of the turret
    public double getAngle() {
        return angle;
    }
    //setter for the angle of the turret
    public void setAngle(double angle) {
        this.angle = angle;
    }
    //getter for the fuel value
    public int getFuel(){
        return fuel;
    }
    //setter for the fuel value
    public void setFuel(int fuel){
        this.fuel = fuel;
    }
    //getter for the power value
    public int getPower(){
        return power;
    }
}

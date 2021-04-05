import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

//class for the tanks
public class Tank {
    //different tanks will have different hp values
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

    //draws the tank
    public void myDraw(Graphics g){
       // System.out.println(GamePanel.player1turn + " " + (fuel == 0) + " " + GamePanel.canShoot + " " + GamePanel.canHit + " " +GamePanel.outofbounds);
        int index = (int) angle;
        index = (index + 10) / 10;
        g.drawImage(tankImage, x, y, null);
        g.drawImage(Sprites.tank1[index], turretX, turretY, null);
        
        if (hp <= 0) {
            EndPanel end = new EndPanel("Player 2");
            MyFrame.cont.add(end, "End Panel");
            MyFrame.lay.show(MyFrame.cont, "End Panel");
        }
        if(fuel == 0 && !GamePanel.canShoot && !GamePanel.canHit && GamePanel.outofbounds){

            GamePanel.player1turn = !GamePanel.player1turn;
            GamePanel.canShoot = true;
            GamePanel.canHit = true;
            GamePanel.outofbounds =false;

        }
    }
    public void setTankImage(Terrain t) {
    	boolean direction = t.getDirection(this, t.getSlope());
    	boolean isSlope = t.isSlope();
    	if(isSlope) {
    		if(direction) {
    			tankImage = Sprites.tank1[11];
    			turretY = y+6;
    			turretX = x+14;
    		}else {
    			tankImage = Sprites.tank1[10];
    			turretY = y+8;
    			turretX = x+26;
    		}
    	}else{
    		tankImage = Sprites.tank1[0];
    		turretY = y+18;
    		turretX = x+23;
    	}
    }

    //method for the tank to move on flat ground
    public void moveFlatRight(){
        x+=speed;
        fuel-=1;
    }
    public void moveFlatLeft(){
        x-=speed;
        fuel-=1;
    }
    public void moveAngleUp() {
        if(angle<80) {
            angle+=10;
        }
    }
    public void moveAngleDown() {
        if(angle>0) {
            angle-=10;
        }

    }
    public boolean getFacingRight() {
        return isFacingRight;
    }

    public void drawHp(Graphics g, int x, boolean player){
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
            g.fillRect(940, 400, -hpwidth, 60);
            g.setColor(Color.green);
            g.fillRect(940, 400, -hp * 2, 60);
        }
    }

    public void drawFuel(Graphics g, int x, boolean player){
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
            g.drawRect(941, 464, -103, 16);
            g.setColor(Color.darkGray);
            g.fillRect(940, 465, -100, 15);
            g.setColor(Color.orange);
            g.fillRect(940, 465, -fuel * 10, 15);
        }
    }


    //method for the tank to move on non-flat ground
    public void moveTerrain(){}


    //method for the tank to shoot
    public void shoot(int power, int angle, Projectile x){}

    //getter for hp
    public int getHp(){
        return hp;
    }

    //setter for hp
    public void setHp(int hp){
        this.hp = hp;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    public void setY(Terrain t) {
    	y = t.getY(this)-60;
    }
    public double getAngle() {
        return angle;
    }
    public void setAngle(double angle) {
        this.angle = angle;
    }
    public int getFuel(){
        return fuel;
    }
    public void setFuel(int fuel){
        this.fuel = fuel;
    }

    public int getPower(){
        return power;
    }



}
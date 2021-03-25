
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

//class for the tanks
public class Tank2 {
    public static int fuel;
    //different tanks will have different hp values
    private int hp;
    private int power;
    private int x;
    private int y;

    //constructor
    public Tank2(int hp, int power){
        this.hp = hp;
        this.power = power;
        this.x = 500;
        this.y = 300;
        int fuel = 10;

    }

    //draws the tank
    public void myDraw(Graphics g){
        g.drawImage(Sprites.tank1[1], x, y, null);
        g.drawImage(Sprites.tank1[0], x+10, y, null);
    }

    //method for the tank to move on flat ground
    public void moveFlatRight(){
        x+=3;
        fuel-=1;
    }
    public void moveFlatLeft(){
        x-=3;
        fuel-=1;
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

}
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

//class for the tanks
public class Tank {
    //different tanks will have different hp values
    private int hp;
    private int power;
    private int x;
    private int y;
    public static int fuel;

    //constructor
    public Tank(int hp, int power){
        this.hp = hp;
        this.power = power;
        this.x = 100;
        this.y = 300;
        fuel = 10;

    }

    //draws the tank
    public void myDraw(Graphics g){
        g.drawImage(Sprites.tank2[1], x, y, null);
        g.drawImage(Sprites.tank2[0], x, y, null);
        if(hp <= 0){
            EndPanel end = new EndPanel("Player 2");
            Frame.cont.add(end, "End Panel");
            Frame.lay.show(Frame.cont, "End Panel");
        }
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

    public void drawHp(Graphics g){
        g.setColor(Color.black);
        g.drawRect(4, 399, 201, 61);
        g.setColor(Color.RED);
        g.fillRect(5, 400, 200, 60);
        g.setColor(Color.green);
        g.fillRect(5, 400, hp * 2, 60);
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
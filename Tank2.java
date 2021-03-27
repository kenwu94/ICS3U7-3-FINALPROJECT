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
    private double angle;

    //constructor
    public Tank2(int hp, int power){
        this.hp = hp;
        this.power = power;
        this.x = 500;
        this.y = 300;
        this.angle = 0;
        fuel = 10;

    }

    //draws the tank
    public void myDraw(Graphics g){
        int index = (int) angle;
        index = (index + 10)/10;
        g.drawImage(Sprites.tank2[index],x+20,y+19,null);
        g.drawImage(Sprites.tank2[0], x+10, y, null);
        if(hp <= 0){
            EndPanel end = new EndPanel("Player 1");
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

    public void drawHp(Graphics g){
        g.setColor(Color.black);
        g.drawRect(739, 399, 201, 61);
        g.setColor(Color.RED);
        g.fillRect(740, 400, 200, 60);
        g.setColor(Color.green);
        g.fillRect(740, 400, hp * 2, 60);
    }

    public void drawFuel(Graphics g){
        g.setColor(Color.black);
        g.drawRect(839, 464, 101, 16);
        g.setColor(Color.darkGray);
        g.fillRect(840, 465, 100, 15);
        g.setColor(Color.orange);
        g.fillRect(840, 465, fuel*10, 15);
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
    public double getAngle() {
        return angle;
    }
    public void setAngle(double angle) {
        this.angle = angle;
    }
}
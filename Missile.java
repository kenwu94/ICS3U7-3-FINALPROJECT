import javax.swing.*;
import java.awt.*;
import java.awt.*;

public class Missile {
    private int damage = 10;
    private double speed;
    private int rad;
    public static boolean shootMissile = false;
    private double x, y;
    private boolean turn;
    private double angle;
    private double xcomponent, ycomponent;

    public Missile(int x, int y, boolean turn, double angle) {
    	this.speed = 20;
        this.turn = turn;
        this.rad = 10;
        this.angle = angle;
        if(turn) {
            this.x = x + 50;
        }
        else{
            this.x = x - 50;
        }
        this.y = y + 28;

    }

    public void myDraw(Graphics g){
        g.setColor(Color.orange);
        g.fillOval((int)x, (int)y, rad, rad);

    }

    public void shootProjectile(Tank tank){
    	double radians = angle*Math.PI/180;
        xcomponent = Math.abs(speed * Math.cos(radians));
        ycomponent = Math.abs(speed * Math.sin(radians));
//        to find the x position: x component*time
//        to find the y position: y component * time - 1/2*gravity (t)^2
        double time = (System.currentTimeMillis()-GamePanel.startTime)/20;
        x = tank.getX()+ 50 + xcomponent * time;
        y = tank.getY() + 30 - (ycomponent * time - 0.5 * 0.98 * Math.pow(time, 2));
        if(y > 600){
            GamePanel.player1turn = !GamePanel.player1turn;
            GamePanel.canShoot = true;
            shootMissile = false;
            GamePanel.mselected = false;
            GamePanel.canHit = true;
        }
    }

    public void shootProjectile(Tank2 tank){
    	double radians = angle*Math.PI/180;
        xcomponent = Math.abs(speed * Math.cos(radians));
        ycomponent = Math.abs(speed * Math.sin(radians));
//        to find the x position: x component*time
//        to find the y position: y component * time - 1/2*gravity (t)^2
        double time = (System.currentTimeMillis()-GamePanel.startTime)/20;
        x = tank.getX() - (xcomponent * time);
        y = tank.getY() + 30 - (ycomponent * (time) - 0.5 * 0.98 * Math.pow(time, 2));
        if(y > 600){
            GamePanel.player1turn = !GamePanel.player1turn;
            GamePanel.canShoot = true;
            shootMissile = false;
            GamePanel.mselected = false;
            GamePanel.canHit = true;
        }
    }

    public void hitTarget(Tank x){
        x.setHp(x.getHp() - damage);
    }
    public void hitTarget(Tank2 x){
        x.setHp(x.getHp() - damage);
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }



}

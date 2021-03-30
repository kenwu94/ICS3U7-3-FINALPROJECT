import javax.swing.*;
import java.awt.*;
import java.awt.*;

public class Bomb {
    private int damage = 20;
    private int speed = 15;
    private int rad;
    public static boolean shootBomb = false;
    private double x, y;
    private boolean turn;
    private double angle;
    private double xcomponent, ycomponent;

    public Bomb(int x, int y, boolean turn, double angle) {

        this.turn = turn;
        this.rad = 15;
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
        g.setColor(Color.black);
        g.fillOval((int)x, (int)y, rad, rad);
        g.drawImage(Sprites.projectiles[0],(int)x-10,(int)y-10,null);

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
            shootBomb = false;
            GamePanel.bselected = false;
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
            shootBomb = false;
            GamePanel.bselected = false;
            GamePanel.canHit = true;
        }
    }

    public void hitTarget(Tank x, Tank2 y){

        x.setHp(x.getHp() - damage * y.getPower());
    }
    public void hitTarget(Tank2 x, Tank y){
        x.setHp(x.getHp() - damage * y.getPower());
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

}
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

    }

    public void shootProjectile(Tank tank){
        xcomponent = speed * Math.cos(angle);
        ycomponent = speed * Math.sin(angle);
        x = tank.getX() + 50 + xcomponent * ((System.currentTimeMillis() - GamePanel.startTime)/20);
        y = tank.getY() + 30 - (ycomponent * ((System.currentTimeMillis() - GamePanel.startTime)/20) - 0.5 * 0.98 * Math.pow(((System.currentTimeMillis() - GamePanel.startTime)/20), 2));
        if(y > 600){
            GamePanel.player1turn = !GamePanel.player1turn;
            GamePanel.canShoot = true;
            shootBomb = false;
            GamePanel.bselected = false;
            GamePanel.canHit = true;
        }
    }

    public void shootProjectile(Tank2 tank){
        xcomponent = speed * Math.cos(angle);
        ycomponent = speed * Math.sin(angle);
        x = tank.getX() - (xcomponent * ((System.currentTimeMillis() - GamePanel.startTime)/20));
        y = tank.getY() + 30 - (ycomponent * ((System.currentTimeMillis() - GamePanel.startTime)/20) - 0.5 * 0.98 * Math.pow(((System.currentTimeMillis() - GamePanel.startTime)/20), 2));
        if(y > 600){
            GamePanel.player1turn = !GamePanel.player1turn;
            GamePanel.canShoot = true;
            shootBomb = false;
            GamePanel.bselected = false;
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

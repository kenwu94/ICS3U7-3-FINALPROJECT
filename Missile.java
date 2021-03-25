import javax.swing.*;
import java.awt.*;
import java.awt.*;

public class Missile {
    private int damage = 0;
    private int speed = 20;
    private int rad;
    public static boolean shootMissile = false;
    private double x, y;
    private boolean turn;
    private double angle;
    private double xcomponent, ycomponent;

    public Missile(int x, int y, boolean turn, double angle) {

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
        g.setColor(new Color(62, 92, 65));
        g.fillOval((int)x, (int)y, rad, rad);

    }

    public void shootProjectile(Tank tank){
        xcomponent = speed * Math.cos(angle);
        ycomponent = speed * Math.sin(angle);
//        to find the x position: x component*time
//        to find the y position: y component * time - 1/2*gravity (t)^2
        x = tank.getX() + 50 + xcomponent * ((System.currentTimeMillis() - GamePanel.startTime)/20);
        y = tank.getY() + 30 - (ycomponent * ((System.currentTimeMillis() - GamePanel.startTime)/20) - 0.5 * 0.98 * Math.pow(((System.currentTimeMillis() - GamePanel.startTime)/20), 2));
        if(y > 600){
            GamePanel.player1turn = !GamePanel.player1turn;
            shootMissile = false;
        }
    }

    public void shootProjectile(Tank2 tank){
        xcomponent = speed * Math.cos(angle);
        ycomponent = speed * Math.sin(angle);
//        to find the x position: x component*time
//        to find the y position: y component * time - 1/2*gravity (t)^2
        x = tank.getX() - (xcomponent * ((System.currentTimeMillis() - GamePanel.startTime)/20));
        y = tank.getY() + 30 - (ycomponent * ((System.currentTimeMillis() - GamePanel.startTime)/20) - 0.5 * 0.98 * Math.pow(((System.currentTimeMillis() - GamePanel.startTime)/20), 2));
        if(y > 600){
            GamePanel.player1turn = !GamePanel.player1turn;
            shootMissile = false;
        }
    }

    public void hitTarget(Tank x){
        x.setHp(x.getHp() - damage);
    }


}

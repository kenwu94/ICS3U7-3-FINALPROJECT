import javax.swing.*;
import java.awt.*;

public class Laser extends JComponent {
    private int damage = 5;
    private int width;
    private int height;
    public static boolean shootLaser = false;
    private int x, y;
    private boolean turn;

    public Laser(int x, int y, boolean turn) {

        this.turn = turn;
        this.width = 50;
        this.height = 6;
        if(turn) {
            this.x = x + 50;
        }
        else{
            this.x = x - 50;
        }
        this.y = y + 30;

    }

    public void draw(Graphics g) {
        g.drawImage(Sprites.projectiles[2], x,y-15,null);

    }

    public void shoot(){
        if(turn) x += 20;
        else x -= 20;
        if(x > 1000 || x < -50) {
            shootLaser = false;
            GamePanel.player1turn = !GamePanel.player1turn;
            GamePanel.canShoot = true;
            GamePanel.lselected = false;
            GamePanel.canHit = true;
        }
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }


    public void hitTarget(Tank x, Tank2 y){
        x.setHp(x.getHp() - damage * y.getPower());
    }
    public void hitTarget(Tank2 x, Tank y){
        x.setHp(x.getHp() - damage * y.getPower());
    }

}
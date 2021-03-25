import javax.swing.*;
import java.awt.*;

public class Laser extends JComponent {
    private int damage = 0;
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
        g.setColor(Color.cyan);
        g.fillRect(x, y, width, height);
        g.drawRect(x, y, width, height);

    }

    public void shoot(){
        if(turn) x += 20;
        else x -= 20;
        if(x > 1000 || x < 50) {
            shootLaser = false;
            GamePanel.player1turn = !GamePanel.player1turn;
        }
    }


    public void hitTarget(Tank x){
        x.setHp(x.getHp() - damage);
    }

}
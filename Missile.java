import java.awt.*;

public class Missile {
    private int damage = 0;
    private int speed = 10;
    private int rad;
    public static boolean shootMissile = false;
    private int x, y;
    private boolean turn;
    private double angle;

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
        g.fillOval(x, y, rad, rad);

    }

    public void shootProjectile(int angle){

    }

    public void hitTarget(Tank x){
        x.setHp(x.getHp() - damage);
    }


}

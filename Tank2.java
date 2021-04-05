import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

//class for the tanks
public class Tank2 extends Tank{
	private BufferedImage tankImage;
	private int turretY,turretX;
    //constructor
    public Tank2(int hp, int speed, int power, int x, int y, boolean isRight){
        super(hp, speed, power, x, y,isRight);
        this.angle = 0;
        fuel = 10;
    }

    //draws the tank
    public void myDraw(Graphics g){
        int index = (int) angle;
        index = (index + 10)/10;
        g.drawImage(tankImage, turretX, turretY, null);
        g.drawImage(Sprites.tank2[index],x+20,y+19,null);
        
        if(hp <= 0){
            EndPanel end = new EndPanel("Player 1");
            MyFrame.cont.add(end, "End Panel");
            MyFrame.lay.show(MyFrame.cont, "End Panel");
        }
        if(fuel == 0 && !GamePanel.canShoot && !GamePanel.canHit && GamePanel.outofbounds){
            GamePanel.player1turn = !GamePanel.player1turn;
            GamePanel.canShoot = true;
            GamePanel.canHit = true;
            GamePanel.outofbounds = false;
        }
    }
    public void setTankImage(Terrain t) {
    	boolean direction = t.getDirection(this, t.getSlope());
    	boolean isSlope = t.isSlope();
    	if(isSlope) {
    		if(direction) {
    			tankImage = Sprites.tank2[11];
    			turretY = y+13;
        		turretX = x;
    		}else {
    			tankImage = Sprites.tank2[10];
    			turretY = y+10;
        		turretX = x+15;
    		}
    	}else{
    		tankImage = Sprites.tank2[0];
    		turretY = y;
    		turretX = x+10;
    	}
    }

}
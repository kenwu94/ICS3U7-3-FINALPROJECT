/*
Authors: Eric Y, Ken W
Date: April 6 2021
ICS 3U7 Ms S
Class description: Class for the second tank 
*/
//imports
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

//subclass of Tank
public class Tank2 extends Tank{
   //variables
   private BufferedImage tankImage;
   private int turretY,turretX;
   //constructor
   public Tank2(int hp, int speed, int power, int x, int y, boolean isRight){
		//call superclass
     	super(hp, speed, power, x, y,isRight);
	 	//initialize variables	  
  		this.angle = 0;
        fuel = 10;
    }

   	//method that draws the tank
   	public void myDraw(Graphics g){
		//get the proper turret image index
       	int index = (int) angle;
        index = (index + 10)/10;
		//draw the tank
        g.drawImage(tankImage, turretX, turretY, null);
        g.drawImage(Sprites.tank2[index],x+20,y+19,null);
        //check if the hp is 0
       	if(hp <= 0){
		//initialize a new End Panel and display it
           	EndPanel end = new EndPanel("Player 1");
         	MyFrame.cont.add(end, "End Panel");
            MyFrame.lay.show(MyFrame.cont, "End Panel");
        }
		//check if the turn ended
        if(fuel == 0 && !GamePanel.canShoot && !GamePanel.canHit && GamePanel.outofbounds){
		//update variables
            GamePanel.player1turn = !GamePanel.player1turn;
            GamePanel.canShoot = true;
            GamePanel.canHit = true;
            GamePanel.outofbounds = false;
        }
    }
	//method to get the proper tank image given a terrain
    public void setTankImage(Terrain t) {
	//get the direction and if the terrain is on a slope
    	boolean direction = t.getDirection(this, t.getSlope());
    	boolean isSlope = t.isSlope();
		//check if the terrain is on a slope
    	if(isSlope) {
		//check the direction of the tank
    		if(direction) {
				//get the tank image facing upwards
    			tankImage = Sprites.tank2[11];
    			turretY = y+13;
        		turretX = x;
    		}else {
				//get the tank image facing downwards
    			tankImage = Sprites.tank2[10];
    			turretY = y+10;
        		turretX = x+15;
			}
    	}else{
			//get the normal tank image
    		tankImage = Sprites.tank2[0];
    		turretY = y;
    		turretX = x+10;
    	}
 	}
}

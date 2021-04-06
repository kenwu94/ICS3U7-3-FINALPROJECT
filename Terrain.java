/*
Authors: Eric Y, Ken W
Date: April 5 2021
ICS 3U7 Ms S
Class description: Class for the terrain of the gmae
*/
//imports
import java.awt.*;
public class Terrain {
    //variables
    private int x1,x2,y1,y2,slope;
    private boolean isSlope;
    //constructor
    public Terrain(int x1,int x2,int y1,int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        //check if the terrain is on a slope
        if(this.y1 == this.y2) {
            isSlope = false;
        }else {
            isSlope = true;
        }
        //get slope of the terrain
        slope = (y2-y1)/(x2-x1);
        
    }
    //method that draws the terrain
    public void myDraw(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(0, 300, 30, 300);
        g.drawLine(x1+30, y1, x2+30, y2);
    }
    //method that gets the y position of a tank on the terrain
    public int getY(Tank t) {
        //check if the terrain is on a slope
        if(isSlope) {
            //get the y position based on x position
        	if(slope>0) {
        		return y1-(x1-t.getX());
        	}else {
        		return y1+(x1-t.getX());
            }
        }else {
            //get the y position if no slope
        	return y1;
        }
    }
    //method that gets the direction of the tank
    public boolean getDirection(Tank t,int slope) {
    	boolean isRight = t.getFacingRight();
    	boolean positiveSlope = slope<0;
        //get if the tank is facing up or down depending on the slope and tank direction
    	if(!positiveSlope&&!isRight) {
    		return true;
    	}else {
    		return isRight&&positiveSlope;
    	}
    	
    }
    
    
    //method that checks if the tank is inside the given terrain
    public boolean isInTerrain(Tank t) {
    	return t.getX()>=x1 && t.getX()<=x2;
    }
    
    //method that returns if the terrain is on a slope
    public boolean isSlope() {
        return isSlope;
    }
    
    //method that returns the slope
    public int getSlope() {
        return slope;
    }
}

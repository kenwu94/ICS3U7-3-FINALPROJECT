import java.awt.*;
public class Terrain {
    private int x1,x2,y1,y2,slope;
    private boolean isSlope;
    public Terrain(int x1,int x2,int y1,int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        if(this.y1 == this.y2) {
            isSlope = false;
        }else {
            isSlope = true;
        }
        slope = (y2-y1)/(x2-x1);
        
    }
    public void myDraw(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(x1, y1, x2, y2);
    }
    public int getY(Tank t,int x) {
        int y = 0;
        return y;
    }
    public boolean getDirection(Tank t,int slope) {
    	boolean isRight = t.getFacingRight();
    	boolean positiveSlope = slope<0;
    	System.out.println(isRight+" "+positiveSlope);
    	if(!positiveSlope&&!isRight) {
    		return true;
    	}else {
    		return isRight&&positiveSlope;
    	}
    	
    }
    
    
    
    public boolean isInTerrain(Tank t) {
    	return t.getX()>=x1 && t.getX()<=x2;
    }

    public boolean isSlope() {
        return isSlope;
    }
    public int getSlope() {
        return slope;
    }
}

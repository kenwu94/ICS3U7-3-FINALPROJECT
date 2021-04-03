import java.awt.*;
public class Terrain {
    private int x1,x2,y1,y2,slope;
    private boolean isSlope;
    private boolean isDown,isUp;
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
        slope = getSlope();
    }
    public void myDraw(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(x1, y1, x2, y2);
    }
    public int getY(Tank t,int x) {
        int y = 0;
        return y;
    }
    public boolean getIsDown(Tank t) {
        boolean isRight = t.getFacingRight();
        if(isRight||slope<0) {
            isDown = true;
        }else {
            isDown = false;
        }
        return isDown;
    }
    public boolean getIsUp(Tank t) {
        boolean isRight = t.getFacingRight();
        if(isRight||slope>0) {
            isUp = true;
        }else {
            isUp = false;
        }
        return isUp;
    }
    public boolean isInTerrain(Tank t) {
    	return t.getX()>=x1 && t.getX()<=x2;
    }

    public boolean isSlope() {
        return isSlope;
    }
    public int getSlope() {
        int slopeCalc;
        slopeCalc = (y2-y1)/(x2-x1);
        return slopeCalc;
    }
}

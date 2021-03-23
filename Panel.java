import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Panel extends JPanel implements ActionListener, MouseListener, MouseMotionListener{
    int x, mouseX, mouseY;
    Timer timer;
    public Panel() {
        super();
        mouseX=0;
        mouseY=0;
        x=0;
        timer= new Timer(20, this);
        this.addMouseListener(this);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.gray);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==timer) {
            repaint();
        }

    }

    public void mouseClicked(MouseEvent me) {	}
    public void mouseEntered(MouseEvent me) {
        timer.start();
    }
    public void mouseExited(MouseEvent me) {
        timer.stop();
    }
    public void mousePressed(MouseEvent me) {

    }
    public void mouseReleased(MouseEvent me) {}

    public void mouseDragged(MouseEvent e) {

    }

    public void mouseMoved(MouseEvent e) {

    }

}


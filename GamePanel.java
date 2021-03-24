import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private JButton back;
    private Timer timer;
    private Tank player1;
    private Tank2 player2;
    public static boolean player1turn;
    Sprites sprites = new Sprites();

    public GamePanel(){
        setBackground(Color.white);
        this.addKeyListener(this);
        
        timer = new Timer(5, this);
        timer.start();
        back = new JButton();
        back.setBounds(0, 471, 80, 30);
        back.setText("BACK");
        back.setBackground(Color.cyan);
        back.addActionListener(this);

        this.setLayout(null);

        this.add(back);

        player1 = new Tank(100, 10);
        player2 = new Tank2(100,10);
        player1turn = true;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        player1.myDraw(g);
        player2.myDraw(g);

    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            Frame.lay.show(Frame.cont, "Menu Panel");
        }

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
    	if(player1turn) {
    		if(e.getKeyCode()== e.VK_D) {
        		player1.moveFlat();
        	}
    	}else {
    		if(e.getKeyCode()== e.VK_J) {
        		player2.moveFlat();
        	}
    	}
    	repaint();
    }

    public void keyReleased(KeyEvent e) {

    }
}

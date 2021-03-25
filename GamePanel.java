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
    long startTime, endTime;
    Sprites sprites = new Sprites();
    Laser laser;

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
        if(laser.shootLaser) {
            laser.draw(g);
        }

    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            Frame.lay.show(Frame.cont, "Menu Panel");
        }
        if(e.getSource()==timer) {
            //make each ball move towards the mouse when it is clicked
            if(laser.shootLaser) {
                laser.shoot();
                repaint();
            }
        }

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(player1turn) {
            Tank2.fuel = 10;
            if(e.getKeyCode()== e.VK_D) {
                if(Tank.fuel >= 0) player1.moveFlatRight();
            }
            if(e.getKeyCode()== e.VK_A) {
                if(Tank.fuel >= 0) player1.moveFlatLeft();
            }
            if(e.getKeyCode() == e.VK_E){
                laser = new Laser(player1.getX(), player1.getY(), player1turn);
                laser.shootLaser = true;
            }
        }else {
            Tank.fuel = 10;
            if(e.getKeyCode()== e.VK_J) {
                if(Tank2.fuel >= 0) player2.moveFlatLeft();
            }
            if(e.getKeyCode()== e.VK_L) {
                if(Tank2.fuel >= 0) player2.moveFlatRight();
            }
            if(e.getKeyCode() == e.VK_O){
                laser = new Laser(player2.getX(), player2.getY(), player1turn);
                laser.shootLaser = true;
            }
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {

    }
}
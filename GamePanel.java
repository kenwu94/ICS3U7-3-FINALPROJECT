import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    public static long startTime;
    private JButton back, bbutton, lbutton, mbutton, skipTurn;
    private Timer timer;
    private Tank player1;
    private Tank2 player2;
    public static boolean player1turn;
    Sprites sprites = new Sprites();
    Laser laser;
    Missile missile;
    Bomb bomb;
    public static boolean canShoot = true;
    public static boolean lselected, mselected, bselected;
    public static boolean canHit = true;

    public GamePanel(){
        setBackground(Color.white);
        this.addKeyListener(this);

        timer = new Timer(5, this);
        timer.start();

        back = new JButton();
        back.setBounds(0, 0, 80, 30);
        back.setText("BACK");
        back.setBackground(Color.cyan);
        back.addActionListener(this);
        back.setFocusable(false);

        lbutton = new JButton();
        lbutton.setBounds(320, 400, 100, 40);
        lbutton.setText("Laser");
        lbutton.setBackground(Color.cyan);
        lbutton.addActionListener(this);
        lbutton.setFocusable(false);

        mbutton = new JButton();
        mbutton.setBounds(430, 400, 100, 40);
        mbutton.setText("Missile");
        mbutton.setBackground(Color.orange);
        mbutton.addActionListener(this);
        mbutton.setFocusable(false);

        bbutton = new JButton();
        bbutton.setBounds(540, 400, 100, 40);
        bbutton.setText("Bomb");
        bbutton.setBackground(Color.LIGHT_GRAY);
        bbutton.addActionListener(this);
        bbutton.setFocusable(false);

        skipTurn = new JButton();
        skipTurn.setBounds(440, 450, 80, 30);
        skipTurn.setText("SKIP");
        skipTurn.setBackground(Color.yellow);
        skipTurn.addActionListener(this);
        skipTurn.setFocusable(false);



        this.setLayout(null);

        this.add(back);
        this.add(lbutton);
        this.add(mbutton);
        this.add(bbutton);
        this.add(skipTurn);

        player1 = new Tank(100, 10);
        player2 = new Tank2(100,10);
        player1turn = true;

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        player1.myDraw(g);
        player1.drawHp(g);
        player2.myDraw(g);
        player2.drawHp(g);
        if(laser.shootLaser) {
            laser.draw(g);
            if(player1turn) {
                if(laser.getY() < player2.getY() + 64 && laser.getY() > player2.getY() && laser.getX() < player2.getX() + 64 && laser.getX() > player2.getX() && canHit) {
                    laser.hitTarget(player2);
                    canHit = false;
                }
            }
            else{
                if(laser.getY() < player1.getY() + 64 && laser.getY() > player1.getY() && laser.getX() < player1.getX() + 64 && laser.getX() > player1.getX() && canHit) {
                    laser.hitTarget(player1);
                    canHit = false;
                }
            }
        }
        if(missile.shootMissile){
            missile.myDraw(g);
            if(player1turn){
                if(missile.getY() < player2.getY() + 64 && missile.getY() > player2.getY() && missile.getX() < player2.getX() + 64 && missile.getX() > player2.getX() && canHit){
                    missile.hitTarget(player2);
                    canHit = false;
                }
            }
            else{
                System.out.println(missile.getX() + " " + missile.getY() + " / " + player1.getX() + " " + player1.getY());
                if(missile.getY() < player1.getY() + 64 && missile.getY() > player1.getY() && missile.getX() < player1.getX() + 64 && missile.getX() > player1.getX() && canHit) {
                    missile.hitTarget(player1);
                    canHit = false;
                }
            }
        }
        if(bomb.shootBomb){
            bomb.myDraw(g);
            if(player1turn){
                if(bomb.getY() < player2.getY() + 64 && bomb.getY() > player2.getY() && bomb.getX() < player2.getX() + 64 && bomb.getX() > player2.getX() && canHit){
                    bomb.hitTarget(player2);
                    canHit = false;
                }
            }
            else{
                if(bomb.getY() < player1.getY() + 64 && bomb.getY() > player1.getY() && bomb.getX() < player1.getX() + 64 && bomb.getX() > player1.getX() && canHit) {
                    bomb.hitTarget(player1);
                    canHit = false;
                }
            }
        }

    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            Frame.lay.show(Frame.cont, "Menu Panel");
        }
        if(e.getSource() == skipTurn){
            if(player1turn) Tank2.fuel = 10;
            else Tank.fuel = 10;
            player1turn = !player1turn;
        }
        if(e.getSource() == lbutton && canShoot){
            lselected = true;
        }

        if(e.getSource() == mbutton && canShoot){
            mselected = true;
        }

        if(e.getSource() == bbutton && canShoot){
            bselected = true;
        }

        if(e.getSource()==timer) {
            //make each ball move towards the mouse when it is clicked
            if(laser.shootLaser) {
                laser.shoot();
                repaint();
            }
            if(missile.shootMissile){
                if(player1turn) missile.shootProjectile(player1);
                else missile.shootProjectile(player2);
                repaint();
            }
            if(bomb.shootBomb){
                if(player1turn) bomb.shootProjectile(player1);
                else bomb.shootProjectile(player2);
                repaint();
            }
        }

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(player1turn) {
            Tank2.fuel = 10;
            if(e.getKeyCode()== e.VK_A) {
                if(Tank.fuel >= 0) player1.moveFlatLeft();
            }
            if(e.getKeyCode()== e.VK_D) {
                if(Tank.fuel >= 0) player1.moveFlatRight();
            }

            if(e.getKeyCode() == e.VK_E){
                if(lselected){
                    laser = new Laser(player1.getX(), player1.getY(), player1turn);
                    laser.shootLaser = true;
                    canShoot = false;
                }
                else
                    if(mselected){
                    missile = new Missile(player1.getX(), player1.getY(), player1turn, 45);
                    if(!missile.shootMissile) {
                        startTime = System.currentTimeMillis();
                    }
                    missile.shootMissile = true;
                    canShoot = false;
                }

                else if(bselected){
                    bomb = new Bomb(player1.getX(), player1.getY(), player1turn, 45);
                    if(!bomb.shootBomb){
                        startTime = System.currentTimeMillis();
                    }
                    bomb.shootBomb = true;
                    canShoot = false;
                }
            }
        }
        else {
            Tank.fuel = 10;
            if(e.getKeyCode()== e.VK_J) {
                if(Tank2.fuel >= 0) player2.moveFlatLeft();
            }
            if(e.getKeyCode()== e.VK_L) {
                if(Tank2.fuel >= 0) player2.moveFlatRight();
            }
            if(e.getKeyCode() == e.VK_O){
                if(lselected){
                    laser = new Laser(player2.getX(), player2.getY(), player1turn);
                    laser.shootLaser = true;
                    canShoot = false;
                }
                else
                if(mselected){
                    missile = new Missile(player2.getX(), player2.getY(), player1turn, 45);
                    if(!missile.shootMissile) {
                        startTime = System.currentTimeMillis();
                    }
                    missile.shootMissile = true;
                    canShoot = false;
                }

                else if(bselected){
                    bomb = new Bomb(player2.getX(), player2.getY(), player1turn, 45);
                    if(!bomb.shootBomb){
                        startTime = System.currentTimeMillis();
                    }
                    bomb.shootBomb = true;
                    canShoot = false;
                    }
                }
            }
        repaint();
    }

    public void keyReleased(KeyEvent e) {

    }
}
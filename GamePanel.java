/*
Authors: Eric Y, Ken W
Date: April 6 2021
ICS 3U7 Ms S
Class description: Class for the panel that controls how the game runs
*/

//imports
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    //variables
    public static long startTime;
    private JButton back, bbutton, lbutton, mbutton, skipTurn;
    private Timer timer;
    private Tank player1;
    private Tank2 player2;
    public static boolean player1turn;
    Terrain[] terrain;
    Laser laser;
    Missile missile;
    Bomb bomb;
    public static boolean canShoot;
    public static boolean lselected, mselected, bselected;
    public static boolean canHit;
    public static boolean outofbounds;
    private int drawn = 0;
    
    
    //constructor
    public GamePanel(){
        //set up panel
        setBackground(Color.white);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();

        //initialize variables
        canShoot = true;
        canHit = true;
        outofbounds = false;

        timer = new Timer(5, this);
        timer.start();

        //set up buttons
        back = new JButton();
        back.setBounds(0, 0, 80, 30);
        back.setText("BACK");
        back.setBackground(Color.cyan);
        back.addActionListener(this);
        back.setFocusable(false);

        ImageIcon laser = new ImageIcon("buttons/button2.png");
        lbutton = new JButton(laser);
        lbutton.setBounds(320, 400, 100, 40);
        lbutton.setBackground(Color.cyan);
        lbutton.addActionListener(this);
        lbutton.setFocusable(false);

        ImageIcon missile = new ImageIcon("buttons/button1.png");
        mbutton = new JButton(missile);
        mbutton.setBounds(430, 400, 100, 40);
        mbutton.setBackground(Color.orange);
        mbutton.addActionListener(this);
        mbutton.setFocusable(false);

        ImageIcon bomb = new ImageIcon("buttons/button0.png");
        bbutton = new JButton(bomb);
        bbutton.setBounds(540, 400, 100, 40);
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
        
        //initialize terrain
        terrain = new Terrain[9];
        terrain[0] = new Terrain(0,80,300,300);
        terrain[1] = new Terrain(81,151,300,370);
        terrain[2] = new Terrain(152,302,370,370);
        terrain[3] = new Terrain(303,403,370,270);
        terrain[4] = new Terrain(404,537,270,270);
        terrain[5] = new Terrain(538,638,270,370);
        terrain[6] = new Terrain(639,788,370,370);
        terrain[7] = new Terrain(789,859,370,300);
        terrain[8] = new Terrain(860,960,300,300);

        //initialize tanks
        player1 = new Tank(Menu.ts.getHp(0), Menu.ts.getSpeed(0), Menu.ts.getPower(0), 50, 310,true);
        player2 = new Tank2(Menu.ts.getHp(1), Menu.ts.getSpeed(1), Menu.ts.getPower(1), 860, 310,false);
        player1turn = true;

    }
    
    //method for displaying the sprites
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //get the terrain that the tank is currently in
        int indexTerrain1 = 0;
        int indexTerrain2 = 0;
    	for(int i = 0;i<9;i++) {
    		if(terrain[i].isInTerrain(player1)) {
    			indexTerrain1 = i;
    		}
    		if(terrain[i].isInTerrain(player2)) {
    			indexTerrain2 = i;
    		}
    	}
    	//draw the background and terrain of the game
    	g.drawImage(Sprites.gameBackG, 0, 0, null);
    	g.drawImage(Sprites.terrain,0,0,null);
        //display which players turn it is
    	Font font = new Font("Courier",Font.BOLD,15);
    	g.setFont(font);
    	g.setColor(Color.WHITE);
    	if(player1turn) {
    		g.drawString("Player 1 turn",430 , 360);
    	}else {
    		g.drawString("Player 2 turn",430 , 360);
    	}
        
        //set the y position and direction of the tank
    	player1.setY(terrain[indexTerrain1]);
    	player1.setTankImage(terrain[indexTerrain1]);
    	player2.setY(terrain[indexTerrain2]);
    	player2.setTankImage(terrain[indexTerrain2]);
    	
        //draw the tanks with corresponding fuel and hp bars
        player1.myDraw(g);
        player1.drawHp(g, 5, true);
        player1.drawFuel(g, 5, true);
        player2.myDraw(g);
        player2.drawHp(g, 740, false);
        player2.drawFuel(g, 840, false);

        //check if the laser being shot
        if(laser.shootLaser) {
            //draw the laser
            laser.draw(g);
            if(player1turn) {
                //detect player 2 tank collision with the laser
                if(laser.getY() < player2.getY() + 64 && laser.getY() > player2.getY() && laser.getX() < player2.getX() + 64 && laser.getX() > player2.getX() && canHit) {
                    laser.hitTarget(player2, player1);
                    canHit = false;
                }
            }
            else{
                //detect player 1 tank collision with the laser
                if(laser.getY() < player1.getY() + 64 && laser.getY() > player1.getY() && laser.getX() < player1.getX() + 64 && laser.getX() > player1.getX() && canHit) {
                    laser.hitTarget(player1, player2);
                    canHit = false;
                }
            }
        }
        //check if the missile is being shot
        if(missile.shootMissile){
            //draw the laser
            missile.myDraw(g);
            if(player1turn){
                //detect player 2 tank collision with the missile
                if(missile.getY() < player2.getY() + 64 && missile.getY() > player2.getY() && missile.getX() < player2.getX() + 64 && missile.getX() > player2.getX() && canHit){
                    missile.hitTarget(player2, player1);
                    canHit = false;
                }
            }
            else{
                //detect player 1 tank collision with the missile
                if(missile.getY() < player1.getY() + 64 && missile.getY() > player1.getY() && missile.getX() < player1.getX() + 64 && missile.getX() > player1.getX() && canHit) {
                    missile.hitTarget(player1, player2);
                    canHit = false;
                }
            }
        }
        //check if the bomb is being shot
        if(bomb.shootBomb){
            //draw the bomb
            bomb.myDraw(g);
            if(player1turn){
                //detect player 2 tank collision with bomb
                if(bomb.getY() < player2.getY() + 64 && bomb.getY() > player2.getY() && bomb.getX() < player2.getX() + 64 && bomb.getX() > player2.getX() && canHit){
                    bomb.hitTarget(player2, player1);
                    canHit = false;
                }
            }
            else{
                //detect player 1 tank collision with bomb
                if(bomb.getY() < player1.getY() + 64 && bomb.getY() > player1.getY() && bomb.getX() < player1.getX() + 64 && bomb.getX() > player1.getX() && canHit) {
                    bomb.hitTarget(player1, player2);
                    canHit = false;
                }
            }
        }

        repaint();
    }

    //method that handles button presses
    public void actionPerformed(ActionEvent e) {
        //check if the back button is pressed
        if(e.getSource() == back){
            //show the menu banel
            MyFrame.lay.show(MyFrame.cont, "Menu Panel");
        }
        //check if the skip button
        if(e.getSource() == skipTurn){
            //switch player turn
            player1turn = !player1turn
            //reset variables
            player2.setFuel(10);
            player1.setFuel(10);
            canShoot = true;
            canHit = true;
            outofbounds = false;
            repaint();
        }
        //check if the laser button is pressed
        if(e.getSource() == lbutton && canShoot){
            //select the laser 
            lselected = true;
            //reset the turret angle to 0
            if(player1turn) player1.setAngle(0);
            else player2.setAngle(0);
            repaint();
        }
        //reset the turret angle
        if(lselected){
            if(player1turn) player1.setAngle(0);
            else player2.setAngle(0);
        }
        //check if the missile button is pressed
        if(e.getSource() == mbutton && canShoot){
            //select the missile, unselect the laser
            mselected = true;
            lselected = false;
        }
        //check if the bomb button is pressed
        if(e.getSource() == bbutton && canShoot){
            //select the bomb, unselect the laser
            bselected = true;
            lselected = false;
        }

        //runs each time the timer ticks
        if(e.getSource()==timer) {
            try {
                //check if the projectiles are supposed to be shot
                //if they are, shoot the projectile
                if (laser.shootLaser) {
                    laser.shoot();
                    repaint();
                }
                if (missile.shootMissile) {
                    if (player1turn) missile.shootProjectile(player1);
                    else missile.shootProjectile(player2);
                    repaint();
                }
                if (bomb.shootBomb) {
                    if (player1turn) bomb.shootProjectile(player1);
                    else bomb.shootProjectile(player2);
                    repaint();
                }
            }
            catch(Exception ee){
            }
        }

    }

    public void keyTyped(KeyEvent e) {

    }
    //method that runs each time a key is pressed
    public void keyPressed(KeyEvent e) {
        //check if its the first players turn
        if(player1turn) {
            //reset the fuel
            player2.setFuel(10);
            //tank movement buttons
            if(e.getKeyCode()== e.VK_A) {
                if(player1.getFuel() > 0) player1.moveFlatLeft();
            }
            if(e.getKeyCode()== e.VK_D) {
                if(player1.getFuel() > 0) player1.moveFlatRight();
            }
            //turret movement buttons
            if(e.getKeyCode()== e.VK_W) {
                if(!lselected) player1.moveAngleUp();
            }
            if(e.getKeyCode()== e.VK_S) {
                if(!lselected) player1.moveAngleDown();
            }
            //shooting button
            if(e.getKeyCode() == e.VK_E){
                //check if the laser is selected
                if(lselected && canShoot){
                    //create a new laser
                    laser = new Laser(player1.getX(), player1.getY(), player1turn);
                    //update variables
                    laser.shootLaser = true;
                    canShoot = false;
                }
                else
                //check if the missile is selected
                if(mselected){
                    //create a new missile
                    missile = new Missile(player1.getX(), player1.getY(), player1turn, player1.getAngle());
                    //update time variable
                    if(!missile.shootMissile) {
                        startTime = System.currentTimeMillis();
                    }
                    //update variables
                    missile.shootMissile = true;
                    canShoot = false;
                }
                //check if bomb is selected
                else if(bselected){
                    //create a new bomb
                    bomb = new Bomb(player1.getX(), player1.getY(), player1turn, player1.getAngle());
                    //update time variable
                    if(!bomb.shootBomb){
                        startTime = System.currentTimeMillis();
                    }
                    //update variables
                    bomb.shootBomb = true;
                    canShoot = false;
                }
            }
        }
        //second players turn 
        else {
            //update player1 fuel value
            player1.setFuel(10);
            //tank movement buttons
            if(e.getKeyCode()== e.VK_J) {
                if(player2.getFuel() > 0) player2.moveFlatLeft();
            }
            if(e.getKeyCode()== e.VK_L) {
                if(player2.getFuel() > 0) player2.moveFlatRight();
            }
            //turret movement buttons
            if(e.getKeyCode()== e.VK_I) {
                if(!lselected) player2.moveAngleUp();
            }
            if(e.getKeyCode()== e.VK_K) {
                if(!lselected) player2.moveAngleDown();
            }
            //button to shoot
            if(e.getKeyCode() == e.VK_O){
                //check if laser is selected
                if(lselected && canShoot){
                    //create a new laser
                    laser = new Laser(player2.getX(), player2.getY(), player1turn);
                    //update variables
                    laser.shootLaser = true;
                    canShoot = false;
                }
                //check if missile is selected
                else if(mselected){
                    //create a new missile
                    missile = new Missile(player2.getX(), player2.getY(), player1turn, player2.getAngle());
                    //update the time variable
                    if(!missile.shootMissile) {
                        startTime = System.currentTimeMillis();
                    }
                    //update variables
                    missile.shootMissile = true;
                    canShoot = false;
                }
                //check if bomb is selected
                else if(bselected){
                    //create a new bomb
                    bomb = new Bomb(player2.getX(), player2.getY(), player1turn, player2.getAngle());
                    //update the time variable
                    if(!bomb.shootBomb){
                        startTime = System.currentTimeMillis();
                    }
                    //update variables
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

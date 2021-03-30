import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TankSelect extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private JButton fastTank, heavyTank, armoredTank;
    private JLabel player1picking, player2picking;
    private boolean player1pick = true;
    private static int[] hp = new int[2];
    private static int[] speed = new int[2];
    private static int[] power = new int[2];
    private int listIndex = 0;

    public TankSelect(){
        timer = new Timer(5, this);
        timer.start();

        setBackground(Color.white);

        setFocusable(true);
        this.requestFocusInWindow();

        player1picking = new JLabel();
        player1picking.setText("Player 1 is Picking...");
        player1picking.setLocation(50, 50);
        player1picking.setSize(400, 100);

        player2picking = new JLabel();
        player2picking.setText("Player 2 is Picking...");
        player2picking.setLocation(50, 50);
        player2picking.setSize(400, 100);

        fastTank = new JButton();
        fastTank.setBounds(180, 240, 140, 60);
        fastTank.setText("Fast Tank");
        fastTank.setBackground(Color.cyan);
        fastTank.addActionListener(this);

        heavyTank = new JButton();
        heavyTank.setBounds(330, 240, 140, 60);
        heavyTank.setText("Heavy Tank");
        heavyTank.setBackground(Color.cyan);
        heavyTank.addActionListener(this);

        armoredTank = new JButton();
        armoredTank.setBounds(480, 240, 140, 60);
        armoredTank.setText("Armored Tank");
        armoredTank.setBackground(Color.cyan);
        armoredTank.addActionListener(this);

        this.setLayout(null);

        this.add(fastTank);
        this.add(heavyTank);
        this.add(armoredTank);


    }


    public void actionPerformed(ActionEvent e) {
        if(player1pick) this.add(player1picking);
        else{
            this.add(player2picking);

        }
        repaint();
        if(player1pick) listIndex = 0;
        else listIndex = 1;
        if(e.getSource() == fastTank){
            hp[listIndex] = 75;
            speed[listIndex] = 8;
            power[listIndex] = 1;
            if(!player1pick){
                MyFrame.mp = new GamePanel();
                MyFrame.cont.add(MyFrame.mp, "Game Panel");
                MyFrame.lay.show(MyFrame.cont, "Game Panel");
                MyFrame.mp.requestFocusInWindow();
                MyFrame.mp.setFocusable(true);
            }
            player1pick = false;

        }

        if(e.getSource() == heavyTank){
            hp[listIndex] = 100;
            speed[listIndex] = 2;
            power[listIndex] = 2;
            if(!player1pick){
                MyFrame.mp = new GamePanel();
                MyFrame.cont.add(MyFrame.mp, "Game Panel");
                MyFrame.lay.show(MyFrame.cont, "Game Panel");
                MyFrame.mp.requestFocusInWindow();
                MyFrame.mp.setFocusable(true);
            }
            player1pick = false;
        }

        if (e.getSource() == armoredTank) {
            hp[listIndex] = 150;
            speed[listIndex] = 2;
            power[listIndex] = 1;
            if(!player1pick){
                MyFrame.mp = new GamePanel();
                MyFrame.cont.add(MyFrame.mp, "Game Panel");
                MyFrame.lay.show(MyFrame.cont, "Game Panel");
                MyFrame.mp.requestFocusInWindow();
                MyFrame.mp.setFocusable(true);
            }
            player1pick = false;
        }
    }


    public void keyTyped(KeyEvent e) {

    }


    public void keyPressed(KeyEvent e) {

    }


    public void keyReleased(KeyEvent e) {

    }

    public static int getHp(int index){
        return hp[index];
    }

    public static int getSpeed(int index){
        return speed[index];
    }

    public static int getPower(int index){
        return power[index];
    }
}

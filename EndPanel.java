
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;


public class EndPanel extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private JButton back, again;
    private JLabel title;
    String winner;

    public EndPanel(String winner) {

        this.winner = winner;

        setBackground(Color.white);

        setFocusable(true);
        this.requestFocusInWindow();

        timer = new Timer(5, this);
        timer.start();
        

        back = new JButton();
        back.setBounds(710, 255, 140, 30);
        back.setText("BACK TO MENU");
        back.setBackground(Color.cyan);
        back.addActionListener(this);

        again = new JButton();
        again.setBounds(710, 310, 140, 30);
        again.setText("PLAY AGAIN");
        again.setBackground(Color.YELLOW);
        again.addActionListener(this);
        again.setFocusable(false);

        this.setLayout(null);

        this.add(back);
        this.add(again);

        TankSelect newTs = new TankSelect();

        MyFrame.cont.add(newTs, "New Tank Selection");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            MyFrame.lay.show(MyFrame.cont, "Menu Panel");
        }
        if (e.getSource() == again) {
            MyFrame.lay.show(MyFrame.cont, "New Tank Selection");
        }


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(winner.equals("Player 1")) {
        	g.drawImage(Sprites.winBackG[0],0,0,null);
        }else {
        	g.drawImage(Sprites.winBackG[1],0,0,null);
        }
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }
}
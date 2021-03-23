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
    private Tank player1, player2;

    public GamePanel(){
        setBackground(Color.white);

        addKeyListener((KeyListener) this);
        setFocusable(true);
        this.requestFocusInWindow();

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
        player2 = new Tank(50, 20);

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

    }

    public void keyReleased(KeyEvent e) {

    }
}

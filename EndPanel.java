
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

        addKeyListener((KeyListener) this);
        setFocusable(true);
        this.requestFocusInWindow();

        timer = new Timer(5, this);
        timer.start();

        title = new JLabel();
        title.setText(winner + " wins!");
        title.setLocation(50, 50);
        title.setSize(400, 100);

        back = new JButton();
        back.setBounds(410, 255, 140, 30);
        back.setText("BACK TO MENU");
        back.setBackground(Color.cyan);
        back.addActionListener(this);

        again = new JButton();
        again.setBounds(410, 310, 140, 30);
        again.setText("PLAY AGAIN");
        again.setBackground(Color.YELLOW);
        again.addActionListener(this);
        again.setFocusable(false);

        this.setLayout(null);

        this.add(back);
        this.add(again);
        this.add(title);

        GamePanel newGame = new GamePanel();
        Frame.cont.add(newGame, "Game Panel");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            Frame.lay.show(Frame.cont, "Menu Panel");
        }
        if (e.getSource() == again) {
            Frame.lay.show(Frame.cont, "Game Panel");
        }


    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }
}
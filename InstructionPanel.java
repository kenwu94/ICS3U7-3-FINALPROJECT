import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InstructionPanel extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private JLabel title;
    private JButton back;

    public InstructionPanel(){
        setBackground(Color.black);

        title = new JLabel();

        title.setText("INSTRUCTIONS");
        title.setLocation(100, 20);
        title.setSize(400, 100);

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

        this.add(title);
        this.add(back);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            Frame.lay.show(Frame.cont, "Menu Panel");
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

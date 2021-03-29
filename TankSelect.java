import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TankSelect extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private JButton fastTank, heavyTank, armoredTank;

    public TankSelect(){
        timer = new Timer(5, this);
        timer.start();

        setBackground(Color.white);

        setFocusable(true);
        this.requestFocusInWindow();

        fastTank = new JButton();
        fastTank.setBounds(180, 240, 140, 60);
        fastTank.setText("Fast Tank");
        fastTank.setBackground(Color.cyan);
        fastTank.addActionListener(this);

        heavyTank = new JButton();
        heavyTank.setBounds(180, 240, 140, 60);
        heavyTank.setText("Fast Tank");
        heavyTank.setBackground(Color.cyan);
        heavyTank.addActionListener(this);

        armoredTank = new JButton();
        armoredTank.setBounds(180, 240, 140, 60);
        armoredTank.setText("Fast Tank");
        armoredTank.setBackground(Color.cyan);
        armoredTank.addActionListener(this);

        this.setLayout(null);

        this.add(fastTank);
        this.add(heavyTank);
        this.add(armoredTank);
    }


    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == fastTank){

        }

    }


    public void keyTyped(KeyEvent e) {

    }


    public void keyPressed(KeyEvent e) {

    }


    public void keyReleased(KeyEvent e) {

    }
}

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Menu extends JPanel implements ActionListener {
    private JButton play, instructions, exit;
    private JLabel title;
    Sprites sprites;
    public static TankSelect ts;

    public Menu() {

        sprites = new Sprites();
        this.setBackground(new Color(75, 87, 72));

        //title
        title = new JLabel();
        title.setText("final project title");
        title.setLocation(50, 50);
        title.setSize(400, 100);

        //play button
        play = new JButton();
        play.setBounds(380, 155, 200, 60);
        play.setText("Play");
        play.setBackground(Color.white);
        play.addActionListener(this);

        //button for instructions
        instructions = new JButton();
        instructions.setBounds(380, 255, 200, 60);
        instructions.setText("Instructions");
        instructions.setBackground(Color.white);
        instructions.addActionListener(this);

        //button to exit
        exit = new JButton();
        exit.setBounds(430, 355, 100, 30);
        exit.setText("Exit");
        exit.setBackground(Color.red);
        exit.addActionListener(this);

        this.add(title);
        this.add(play);
        this.add(instructions);
        this.add(exit);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
        }
        else if(e.getSource() == play) {
            ts = new TankSelect();
            MyFrame.cont.add(ts, "Tank Selection");
            MyFrame.lay.show(MyFrame.cont, "Tank Selection");
            ts.requestFocusInWindow();
            ts.setFocusable(true);
        }

        else if (e.getSource() == instructions) {
            MyFrame.lay.show(MyFrame.cont, "Instructions");
        }
    }

}
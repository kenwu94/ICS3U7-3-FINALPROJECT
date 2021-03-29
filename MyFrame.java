
import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame{
    public static CardLayout lay;
    public static Component mp;
    public static Container cont;
    //creates the frame
    public MyFrame(String title) {
        super(title);
        cont = this.getContentPane();
        lay = new CardLayout();
        cont.setLayout(lay);

        Menu m = new Menu();
        InstructionPanel instr = new InstructionPanel();
        ControlPanel contr = new ControlPanel();
        mp = new GamePanel();


        MyFrame.cont.add(m, "Menu Panel");
        MyFrame.cont.add(mp, "Game Panel");
        MyFrame.cont.add(instr, "Instructions");
        MyFrame.cont.add(contr, "Control Panel");


        this.setVisible(true);
        this.setSize(960,540);
        setResizable(false);


    }


}
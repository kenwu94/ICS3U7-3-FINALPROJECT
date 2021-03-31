
import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame{
    public static CardLayout lay;
    public static Component mp;
    public static Container cont;
    //creates the frame
    public Frame(String title) {
        super(title);
        cont = this.getContentPane();
        lay = new CardLayout();
        cont.setLayout(lay);

        Menu m = new Menu();
        InstructionPanel instr = new InstructionPanel();
        ControlPanel contr = new ControlPanel();
        mp = new GamePanel();
        TankSelect ts = new TankSelect();

        Frame.cont.add(m, "Menu Panel");
        Frame.cont.add(mp, "Game Panel");
        Frame.cont.add(instr, "Instructions");
        Frame.cont.add(contr, "Control Panel");


        this.setVisible(true);
        this.setSize(960,540);
        setResizable(false);


    }


}
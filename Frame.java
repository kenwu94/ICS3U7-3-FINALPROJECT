
import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame{
    public static GamePanel mp;
    public static CardLayout lay;
    public static Container cont;
    //creates the frame
    public Frame(String title) {
        super(title);
        cont = this.getContentPane();
        lay = new CardLayout();
        cont.setLayout(lay);

        Menu m = new Menu();
        InstructionPanel instr = new InstructionPanel();
        mp = new GamePanel();

        Frame.cont.add(m, "Menu Panel");
        Frame.cont.add(mp, "Game Panel");
        Frame.cont.add(instr, "Instructions");

        this.setVisible(true);
        this.setSize(960,540);
        setResizable(false);


    }


}
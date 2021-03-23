import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame{
    private Panel mp;
    public static CardLayout lay;
    public static Container cont;
    //creates the frame
    public Frame(String title) {
        super(title);
//        mp= new Panel();
        cont = this.getContentPane();
        lay = new CardLayout();
        cont.setLayout(lay);
//        cont.add(mp, BorderLayout.CENTER);

        this.setVisible(true);
        this.setSize(960,540);
        setResizable(false);


    }


}

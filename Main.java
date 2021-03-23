import javax.swing.*;

public class Main {
    public static void main(String[] args){
        //creates frame instance
        Frame frame= new Frame("final project title");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Menu m = new Menu();
        InstructionPanel instr = new InstructionPanel();

        GamePanel game = new GamePanel();

        Frame.cont.add(m, "Menu Panel");
        Frame.cont.add(game, "Game Panel");
        Frame.cont.add(instr, "Instructions");
        frame.setVisible(true);

    }
}

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprites {
    public static BufferedImage[] tank1, tank2;
    private String path;

    public Sprites() {
        tank1 = new BufferedImage[10];
        tank1[0] = getImage("images/tank2.png");
        tank2 = new BufferedImage[10];
        tank2[0] = getImage("images/tank0.png");
        for(int i = 1;i<10;i++) {
            int index = 10*(i-1);
            tank1[i] = getImage("turret1/"+"degree"+index+".png");
        }
        for(int i = 1;i<10;i++) {
            int index = 10*(i-1);
            tank2[i] = getImage("turret2/"+"degree"+index+".png");
        }

    }

    private BufferedImage getImage(String path){
        BufferedImage img;
        try{
            img = ImageIO.read(new File(path));
            return img;
        }
        catch(IOException e){
            System.out.println("Something is wrong with file reading" + e);
            System.out.println(path);
        }
        catch(Exception ee){
            System.out.println(ee);
        }
        return null;
    }
}
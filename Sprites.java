import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprites {
    public static BufferedImage[] tank1, tank2;
    private String path;

    public Sprites() {
        tank1 = new BufferedImage[2];
        tank1[0] = getImage("images/tank0.png");
        tank1[1] = getImage("images/tank1.png");
        tank2 = new BufferedImage[2];
        tank2[0] = getImage("images/tank2.png");
        tank2[1] = getImage("images/tank3.png");

    }

    private BufferedImage getImage(String path){
        BufferedImage img;
        try{
            img = ImageIO.read(new File(path));
            return img;
        }
        catch(IOException e){
            System.out.println("Something is wrong with file reading" + e);
        }
        catch(Exception ee){
            System.out.println(ee);
        }
        return null;
    }
}

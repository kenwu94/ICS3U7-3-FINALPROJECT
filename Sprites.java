/*
Authors: Eric Y, Ken W
Date: April 6 2021
ICS 3U7 Ms S
Class description: Class for the initialization and loading of sprites
*/

//imports
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sprites {
    //variables
    public static BufferedImage[] tank1, tank2,projectiles,tankSelectBG,winBackG;
    public static BufferedImage instructions,controls,menu,gameBackG,terrain;

    public Sprites() {
        //initialize tank sprites
        tank1 = new BufferedImage[12];
        tank1[0] = getImage("images/tank2.png");
        tank1[10] = getImage("images/tilted_tank1.png");
        tank1[11] = getImage("images/tilted_tank3.png");
        tank2 = new BufferedImage[12];
        tank2[10] = getImage("images/tilted_tank0.png");
        tank2[11] = getImage("images/tilted_tank2.png");
        tank2[0] = getImage("images/tank0.png");
        //get background images
        instructions = getImage("images/instructions.png");
        controls = getImage("images/controls.png");
        menu = getImage("images/menuBackG.png");
        gameBackG = getImage("images/gameBackG.png");
        projectiles = new BufferedImage[4];
        tankSelectBG = new BufferedImage[2];
        tankSelectBG[0] = getImage("images/player1pick.png");
        tankSelectBG[1] = getImage("images/player2pick.png");
        winBackG = new BufferedImage[2];
        winBackG[0]= getImage("images/player1win.png");
        winBackG[1]= getImage("images/player2win.png");
        //get background for terrain
        terrain =  getImage("images/terrain.png");
        //get turret position sprites
        for(int i = 1;i<10;i++) {
            int index = 10*(i-1);
            tank1[i] = getImage("turret1/"+"degree"+index+".png");
        }
        for(int i = 1;i<10;i++) {
            int index = 10*(i-1);
            tank2[i] = getImage("turret2/"+"degree"+index+".png");
        }
        //get projectile sprites
        for(int i = 0; i<4 ;i++) {
            projectiles[i] = getImage("projectiles/projectile"+i+".png");
        }

    }

    //method that returns an image given a file path
    private BufferedImage getImage(String path){
        BufferedImage img;
        //get the image with the given path
        try{
            img = ImageIO.read(new File(path));
            return img;
        }
        //error handling
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

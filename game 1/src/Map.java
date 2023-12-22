import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class Map {
    BufferedImage image1, image2;
    GamePanel gp;
   
    public Map(GamePanel gp) {
        this.gp = gp;
        getMap(gp);
    }

    public void getMap(GamePanel gp) {
        try {
            image1 = ImageIO.read(getClass().getResourceAsStream("./6.png"));        
            image2 = ImageIO.read(getClass().getResourceAsStream("./6.png"));        
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(image1, 0, 0, 1280, 1200, null);
    }
}

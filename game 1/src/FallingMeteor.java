import java.awt.*; 
import javax.imageio.ImageIO; 
import java.io.IOException;

public class FallingMeteor {
    private int x, y; 
    private int speed; 
    private Image image1;
    public FallingMeteor(int x, int y, int speed, String imagePath) { 
        this.x = x; 
        this.y = y; 
        this.speed = speed;
        try { 
            this.image1 = ImageIO.read(getClass().getResourceAsStream("./Explosion_5.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {
        y += speed;
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(image1, x, y,155, 155, null); 
    }

    public int getY() {
        return y;
    }
}

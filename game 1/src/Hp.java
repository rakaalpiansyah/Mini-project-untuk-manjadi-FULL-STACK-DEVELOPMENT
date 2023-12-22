import java.awt.Color;
import java.awt.Graphics;

public class Hp {
    private int maxHp; 
    private int currentHp; 

    public Hp(int maxHp) {
        this.maxHp = maxHp;
        this.currentHp = maxHp;
    }

    public void decreaseHp(int amount) {
        currentHp -= amount;
        if (currentHp < 0) {
            currentHp = 0;
        }
    }

    public void increaseHp(int amount) {
        currentHp += amount;
        if (currentHp > maxHp) {
            currentHp = maxHp;
        }
    }

    public void draw(Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.RED);
        int healthWidth = (int) ((currentHp / (double) maxHp) * width);
        g.fillRect(x, y, healthWidth, height);
    }
}

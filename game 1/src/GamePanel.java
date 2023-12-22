/*
 * Nama : Raka Alpiansyah
 * NIM : 1237050112
 */

import java.awt.*; 
import java.time.LocalDateTime; 
import java.util.ArrayList; 
import java.util.Iterator; 

import javax.swing.*;

public class GamePanel extends JPanel implements Runnable  { 
    
    int FPS = 60; 
    int CharSize = 25 * 3; 
    int screenWidth = 40 * 25;
    int screenHeight = 40 *25; 
    Tombol tombolY = new Tombol();
    Thread gameThread; 
    
    Map map = new Map(this);
    Player player = new Player(this,tombolY, CharSize, null); 
    FallingMeteor fallingBox; 
    ArrayList<FallingMeteor> boxes = new ArrayList<>();
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.gray); 
        this.setDoubleBuffered(true); 
        this.addKeyListener(tombolY); 
        this.setFocusable(true); 
    }

   public void startGameThread(){ 
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void run() { 
        double GambarFPS = 1000/FPS; 
        long WaktuTrakhir= System.currentTimeMillis(); 
        long Waktuskrg;
        long timer = 0;
        int drawCount = 0;
        double delta = 0;
        while(gameThread != null) {
            Waktuskrg = System.currentTimeMillis(); 
            delta += (Waktuskrg - WaktuTrakhir) / GambarFPS;
            timer += (Waktuskrg- WaktuTrakhir); 
            WaktuTrakhir = Waktuskrg;

          if(delta >= 1) {
              delta--; 
              drawCount++;
              update(); 
              repaint();
             if(timer >= 1000) { 
                System.out.println("FPS: " + drawCount); 
                drawCount = 0;
                timer = 0;
                LocalDateTime waktu = LocalDateTime.now(); 
                System.out.println(waktu);
                boxes.add(new FallingMeteor((int)(Math.random() * screenWidth), 0, 13, "./Explosion_5.png")); // Membuat objek baru dari kelas FallingBox dan menambahkannya ke ArrayList boxes
                }
            }
        }
   }
    
    public void update(){
        player.update();
        Iterator<FallingMeteor> it = boxes.iterator(); 
        while (it.hasNext()) {
            FallingMeteor box = it.next(); 
            box.update(); 
            if (box.getY() > screenHeight) { 
                it.remove();
            }
        }
    }

    public void paintComponent(Graphics g) { 
        super.paintComponent(g); 
        Graphics2D g2 = (Graphics2D)g; 
        map.draw(g2);
        player.draw(g2); 
        for (FallingMeteor box : boxes) { 
            box.draw(g2); 
        }   
        g2.dispose(); 
    }

    public static void main(String[] args) { 
        // tampilan window
        JFrame window = new JFrame(null, null);
        GamePanel gamePanel = new GamePanel(); 
        window.setResizable(false);
        window.setTitle("GAME RAKA?"); 
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        window.add(gamePanel);
        window.pack(); 
        window.setLocationRelativeTo(null); 
        gamePanel.startGameThread(); 
        window.setVisible(true); 
    }
}

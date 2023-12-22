import java.awt.event.*;

public class Tombol implements KeyListener {
    public boolean TekanLoncat, TekanBawah, TekanKanan, TekanKiri;

    @Override
    public void keyTyped(KeyEvent e) { 
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_UP) {
            TekanLoncat = true;
        }
        if(code == KeyEvent.VK_DOWN) {
            TekanBawah = true;
        }
        if(code == KeyEvent.VK_RIGHT) {
            TekanKanan = true;
        }
        if(code == KeyEvent.VK_LEFT) {
            TekanKiri = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_UP) {
            TekanLoncat = false;
        }
        if(code == KeyEvent.VK_DOWN) {
            TekanBawah = false;
        }
        if(code == KeyEvent.VK_RIGHT) {
            TekanKanan = false;
        }
        if(code == KeyEvent.VK_LEFT) {
            TekanKiri = false;
        }
    }
}


package davemon;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Sprite {

    private int dx;
    private int dy;
    private int x = 40;
    private int y = 60;
    private int w;
    private int h;
    private Image image;

    public Sprite() {
        loadImage();
    }

    private void loadImage() {
        
        //ImageIcon ii = new ImageIcon("assets/images/avatar-remodeled.png");
        image = Constant.STILL_AVATAR.getImage();

        w = image.getWidth(null);
        h = image.getHeight(null);
    }

    public void move() {
        
        x += dx;
        y += dy;
    }

    public int getX() {
        
        return x;
    }

    public int getY() {
        
        return y;
    }
    
    public int getWidth() {
        
        return w;
    }
    
    public int getHeight() {
        
        return h;
    }    

    public Image getImage() {
        
        return image;
    }

    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = -2;
            image = Constant.WALKING_LEFT_AVATAR.getImage();
        }

        if (key == KeyEvent.VK_RIGHT) {
            // dx = 2;
            dx = 2;
            image = Constant.WALKING_RIGHT_AVATAR.getImage();
        }

        if (key == KeyEvent.VK_UP) {
            dy = -2;
            image = Constant.WALKING_UP_AVATAR.getImage();
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 2;
            image = Constant.WALKING_DOWN_AVATAR.getImage();
        }
    }

    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
            image = Constant.STILL_AVATAR.getImage();
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
            image = Constant.STILL_AVATAR.getImage();
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
            image = Constant.STILL_AVATAR.getImage();
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
            image = Constant.STILL_AVATAR.getImage();
        }
    }
}
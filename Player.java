import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends GameObject implements KeyListener, Sprite {
    boolean alive = true;
    int hp;
    double speed = 0.02;
    KeyListener keyin;
    int headType = 0;
    int bodyType = 0;
    int legsType = 0;

    public void spawn(int i, int j) {
        this.setLocation(i, j);
    }

    Player(int x, int y) throws IOException {
        super(x, y);
        }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            this.direction = 0;
                xinertia = -speed;
                break;
            case KeyEvent.VK_RIGHT:
            this.direction = 5;

                xinertia = speed;
                break;
            case KeyEvent.VK_UP:
            this.direction = 1;

                yinertia = -speed;
                break;
            case KeyEvent.VK_DOWN:
            this.direction = 2;

                yinertia = speed;
                break;
            default:
                break;
        }
        // TODO Auto-generated method stub
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                xinertia = 0;
                System.out.println("lef");
                break;
            case KeyEvent.VK_RIGHT:
                xinertia = 0;
                System.out.println("rig");
                break;
            case KeyEvent.VK_UP:
                yinertia = 0;
                System.out.println("up");
                break;
            case KeyEvent.VK_DOWN:
                yinertia = 0;
                System.out.println("dow");
                break;
            default:
                break;
        }
    }
    @Override
    public int compare(Point2D o1, Point2D o2) {
        // TODO Auto-generated method stub
        if (this.distance(o1) < this.distance(o2)) {
            return 1;
        }
        if (this.distance(o1) == this.distance(o2)) {
            return 0;
        }
        if (this.distance(o1) > this.distance(o2)) {
            return -1;
        }
        return 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

}
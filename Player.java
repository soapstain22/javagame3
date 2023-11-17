import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends GameObject implements KeyListener {
    boolean alive = true;
    int hp;
    double speed = 0.02;
    KeyListener keyin;
    int headType = 0;
    int bodyType = 0;
    int legsType = 0;
    int px;
    int py;

    public void spawn(int i, int j) {
        this.setLocation(i, j);
    }

    Player(int x, int y) throws IOException {
        super(x, y);
    }

    @Override
    public void keyPressed(KeyEvent e) { // move this to a 2d array using Direction.toInt. eventually do this because we
        // can get 8 direction positions so quick

        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                px = 1;
                xinertia = -speed;
                break;
            case KeyEvent.VK_RIGHT:
                px = -1;
                xinertia = speed;
                break;
            case KeyEvent.VK_UP:
                py = 1;
                yinertia = -speed;
                break;
            case KeyEvent.VK_DOWN:
                py = -1;
                yinertia = speed;
                break;
            default:
                break;
        }
                this.direction = Direction.spriteMatrix[1+px][1+py];

        // TODO Auto-generated method stub
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                xinertia = 0;
                px = 0;
                break;
            case KeyEvent.VK_RIGHT:
                xinertia = 0;
                px = 0;
                break;
            case KeyEvent.VK_UP:
                yinertia = 0;
                py = 0;
                break;
            case KeyEvent.VK_DOWN:
                yinertia = 0;
                py = 0;
                break;
            default:
                break;
        }
        this.spriteIndex = 0;
        System.out.println(1 + px);
        System.out.println(1 + py);
        this.direction = Direction.spriteMatrix[1+px][1+py];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }
}
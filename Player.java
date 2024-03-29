import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Player extends GameObject implements KeyListener {
    boolean alive = true;
    int hp;
    double speed = 0.02;
    KeyListener keyin;
    int headType = 0;
    int bodyType = 0;
    int legsType = 0;
    int px = 0;
    int py = 0;
    int inhand = 0;
    String msg;
    Item[] inventory = new Item[9];
    private int cooldown = 0;

    Player(int x, int y) throws IOException {
        super(x, y);
    }

    @Override
    public void keyPressed(KeyEvent e) { // move this to a 2d array using Direction.toInt. eventually do this because we
        // can get 8 direction positions so quick

        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            px = -1;
                break;
            case KeyEvent.VK_RIGHT:
            px = 1;
                break;
            case KeyEvent.VK_UP:
            py = 1;
                break;
            case KeyEvent.VK_DOWN:
            py = -1;
                break;
            case KeyEvent.VK_E:
                pickup();
                break;
            case KeyEvent.VK_X:
                attack();
                break;
            case KeyEvent.VK_Q:
                drop();
                break;
            case KeyEvent.VK_Z:
                use();
                break;
            default:
                break;
        }
        this.direction = Direction.spriteMatrix[1 + px][1 + py];

        // TODO Auto-generated method stub
    }

    private void drop() {
    }

    private void use() {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                px = 0;
                break;
            case KeyEvent.VK_RIGHT:
                px = 0;
                break;
            case KeyEvent.VK_UP:
                py = 0;
                break;
            case KeyEvent.VK_DOWN:
                py = 0;
                break;
            case KeyEvent.VK_E:
                inhand = (inhand + 1) % 9;
                break;
            case KeyEvent.VK_Q:
                inhand = (inhand - 1) % 9;
                if (inhand < 0) {
                    inhand = 8;
                }
            case KeyEvent.VK_G:
                // new GamePanel();
            default:
                break;
        }
        this.spriteIndex = 0;
        System.out.println(1 + px);
        System.out.println(1 + py);
        this.direction = Direction.spriteMatrix[1 + px][1 + py];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    boolean pickup(Item i) {
        for (int j = 0; j < inventory.length; j++) {
            if (inventory[j] == null) {
                inventory[j] = i;
                break;
            } else if (inventory[j].type == i.type) {
                if (i.count + inventory[j].count < inventory[j].maxStack) {
                    inventory[j].count += i.count;
                }
                break;
            }
        }
        return true;
    }

    boolean pickup() {
        Item i = Game.gameMap.getTile(x, y).onTile.peek();
        if (i != null) {
            pickup(Game.gameMap.getTile(x, y).onTile.pop());
        }
        return alive;
    }

    void Speak(String s) {
        NetCon.sendMsg(this, s);
    }

    public boolean canSee(GameTile ref) {

        return false;
    }

    public boolean canSee(GameTile ref, int viewdist) {

        return false;
    }

    boolean attack() {
        int a = (int) (this.x + px);
        int b = (int) (this.y + py);
        GameTile t = Game.gameMap.getTile(a, b);
        boolean rt = false;
        if (!t.objs.empty()) {
            rt = t.objs.peek().attacked(1);
            this.cooldown = 10;
        }
        return alive;
    }
}
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class GameCamera extends Panel {
    Point2D tracking;
    int fc;
    Graphics lastFrame;
    BufferedImage lastImg;
    boolean inv;

    @Override
    public void paint(Graphics g) {

    }

    public void paintComponent(Graphics g) {
        boolean[][] vismap = new boolean[15][15];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                // set color of background item
                int offsetx = (((int) i * 32));
                int offsety = (((int) j * 32));
                int c = (int) (offsetx - (tracking.getX() * 32) % 32);
                int d = (int) (offsety - (tracking.getY() * 32) % 32);
                GameTile ref = Game.gameMap.getTile(tracking.getX() - 8 + i, tracking.getY() - 8 + j);
                vismap[i][j] = ref.t.getDense();
                g.drawImage(GameCache.tiles[ref.t.getSprite()], c, d, this);
                if (!ref.onTile.empty()) {
                    for (int k = 0; k < ref.onTile.size(); k++) {
                        g.drawImage(GameCache.items[ref.onTile.get(k).sprite], c, d, this);
                    }
                }
                if (!ref.objs.empty()) {
                    for (int k = 0; k < ref.objs.size(); k++) {
                        GameObject gb =ref.objs.get(k);
                        g.drawImage(gb.getImage(), c+gb.subx, d+gb.suby, this);
                    }
                }
            }
            vismap = GameCamera.shittyView(vismap);
        }
        if (inv) {
            for (int i = 0; i < 9; i++) {
                Item work = Game.player.inventory[i];
                for (int j = 0; j < 3; j++) {
                    g.drawImage(GameCache.ui[0], 128 + i * 32, 438, this); // bg
                    int ass = Game.player.inhand * 32;
                    g.drawRect(128 + ass, 438, 32, 32);
                }
                if (work != null) {
                    g.drawImage(GameCache.items[Game.player.inventory[i].sprite], 128 + i * 32, 438, this);
                    g.drawString(work.count + "\n" + work.name, 128 + i * 32, 408);
                    g.drawString(work.desc, 128 + i * 32, 390);
                }
            }

        } else {
            for (int i = 0; i < 9; i++) {
                Item work = Game.player.inventory[i];
                g.drawImage(GameCache.ui[0], 128 + i * 32, 438, this); // bg
                int ass = Game.player.inhand * 32;
                g.drawRect(128 + ass, 438, 32, 32);
                if (work != null) {
                    g.drawImage(GameCache.items[Game.player.inventory[i].sprite], 128 + i * 32, 438, this);
                    g.drawString(work.count + "\n" + work.name, 128 + i * 32, 408);
                    g.drawString(work.desc, 128 + i * 32, 390);
                }
            }
        }
    }

    private static boolean[][] shittyView(boolean[][] vismap) {
        int ct = vismap.length / 2;
        boolean n = false;
        boolean s = false;
        boolean e = false;
        boolean w = false;
        for (int i = ct; i < ct; i++) {
            for (int j = ct; j < ct; j++) {
                vismap[i][j] = n;
                vismap[i][-j] = s;
                vismap[-i][j] = e;
                vismap[-i][-j] = w;
                if (vismap[i][j] = true) {
                    System.out.print(0);
                } else
                    System.out.print(1);
                if (!vismap[i][j]) {
                    n = true;
                }
                if (!vismap[i][-j]) {
                    s = true;
                }
                if (!vismap[-i][j]) {
                    e = true;
                }
                if (!vismap[-i][-j]) {
                    w = true;
                }
                System.out.println(n + "" + s + "" + e + "" + w);
            }
            System.out.println();

        }
        return vismap;
    }

    public void update() {
        repaint();
    }

    @Override
    public void update(Graphics g) {
        lastImg = (BufferedImage) createImage(getWidth(), getHeight());
        lastFrame = lastImg.getGraphics();
        paintComponent(lastFrame);
        g.drawImage(lastImg, 0, 0, this);
    }

    GameCamera(Player p) {
        GamePanel gp = new GamePanel();
        tracking = p;
        this.addKeyListener(p);
        setVisible(true);
        setBounds(200, 200, 480, 480);

    }
}

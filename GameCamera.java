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

    @Override
    public void paint(Graphics g) {

    }

    public void paintComponent(Graphics g) {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                // set color of background item
                int offsetx = (((int) i * 32));
                int offsety = (((int) j * 32));
                int c = (int) (offsetx - (Game.player.x * 32) % 32);
                int d = (int) (offsety - (Game.player.y * 32) % 32);
                GameTile ref = Game.gameMap.getTile(Game.player.x - 8 + i, Game.player.y - 8 + j);
                g.drawImage(GameCache.tiles[ref.t.getSprite()], c, d, this);
                if (!ref.onTile.empty()) {
                    for (int k = 0; k < ref.onTile.size(); k++) {
                        int x = ref.onTile.get(k).yoffset;
                        int y = ref.onTile.get(k).xoffset;
                        g.drawImage(GameCache.items[ref.onTile.get(k).sprite], c + x, d + y, this);
                    }
                }
            }
        }
        g.setColor(Color.green);
        g.setColor(Color.CYAN);
        g.drawImage(GameCache.bodies[0][Game.player.direction][Game.player.spriteIndex % 3], 224, 238, this);
        g.drawImage(GameCache.pants[0][Game.player.direction][Game.player.spriteIndex % 3], 224, 244, this);
        g.drawImage(GameCache.heads[0][Game.player.direction][0], 224, 226, this);
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

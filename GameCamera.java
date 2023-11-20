import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.geom.Point2D;

public class GameCamera extends Panel {
    Point2D tracking;
    int fc;
    GameTile[][] loaded;
    public void paint(Graphics g) {
        // gameplan
        /*
         *
         */
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                // set color of background item
                g.setColor(Color.orange);
                int offsetx = (((int) i * 32));
                int offsety = (((int) j * 32));
                int c = (int) (offsetx - (Game.player.x * 32) % 32);
                int d = (int) (offsety - (Game.player.y * 32) % 32);
                g.fillRect(c, d, 32, 32);
                g.setColor(Color.black);
                g.drawRect(c + 1, d + 1, 30, 30);
                /*
                 * visible = wrangleNear(tracking, d, i);
                 * for (int k = 0; k < visible.length; k++) {
                 * //g.drawImage(visible[k].getGameSprite(), offsetx, offsety, Game.gameCamera);
                 * }
                 */
            }
        }
            g.setColor(Color.green);
            g.drawString("Game.Player", 5, 40);
            g.setColor(Color.CYAN);
            g.drawString(Game.player.direction + "d " + Game.player.headType + "h " + Game.player.bodyType + "b "+ Game.player.legsType + "l ", 120, 40);
            g.drawImage(GameCache.bodies[0][Game.player.direction][Game.player.spriteIndex%3], 224, 238, this);
            g.drawImage(GameCache.pants[0][Game.player.direction][Game.player.spriteIndex%3], 224, 244, this);
            g.drawImage(GameCache.heads[0][Game.player.direction][0], 224, 226, this);
            /*for (int i = 0; i < Game.gameMap.objex.length; i++) {
                BufferedImage[] go = Game.gameMap.objex[i].face;
                for (int j = 0; j < go.length; j++) {
                    g.drawImage(go[j],(int)Game.gameMap.objex[i].x,(int)Game.gameMap.objex[i].y,this);
                }   
            }*/
            fc +=1;
        setVisible(true);

    }

    public void update() {
        repaint();
    }

    GameCamera(Player p) {
        tracking = p;
        this.addKeyListener(p);
        setVisible(true);
        setBounds(200, 200, 480, 480);
    }
}

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.geom.Point2D;

public class GameCamera extends Frame {
    Point2D tracking;
    @Override
    public void paint(Graphics g) {
        // gameplan
        /*
         *
         */
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                GameTile t = Game.gameMap.getTile(Game.player.x+i, Game.player.y+j);
                //set color of background item
                g.setColor(Color.BLUE);
                int offsetx = (((int)i*32));
                int offsety = (((int)j*32));
                int c = (int) (offsetx-(Game.player.x*32)%32);
                int d = (int) (offsety-(Game.player.y*32)%32);
                g.fillRect(c, d, 32, 32);
                g.setColor(Color.RED);
                g.drawRect(c+1, d+1, 30, 30);
                /*visible = wrangleNear(tracking, d, i);
                for (int k = 0; k < visible.length; k++) {
                    //g.drawImage(visible[k].getGameSprite(), offsetx, offsety, Game.gameCamera);
                }
                */
            }
            for (int j = 0; j < Game.player.getDisplaying().length; j++) {
                g.drawImage(Game.player.getDisplaying()[j],224,224,this);
            }

            }
            setVisible(true);
        
    }
    public void update(){
        repaint();
    }
    GameCamera(Player p){
        tracking = p;
        this.addKeyListener(p);
        setVisible(true);
        setBounds(200, 200, 480, 480);
    
    
    }
}

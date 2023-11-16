import java.awt.Color;
import java.awt.image.BufferedImage;

public class GameTile {
    GameTile(){
        type = 2;
    }
    boolean open;
    short temperature = 293; //Boiling point of water is 373.15 K
    byte brightness;
    byte height;
    int type;
    public Color color = new Color(200,255,200);
    public BufferedImage getIcon() {
        return GameCache.blocks[type];
    }
    
}
import java.awt.Color;
import java.awt.image.BufferedImage;

public class GameTile {
    GameTile(int i){
        switch (i % 6) {
            case 0:
                color = water;
                outline = waterOutline;
                break; 
            case 4:
                color = grass;
                outline = grassOutline;
                break;
            case 3:
                color = dirt;
                outline = dirtOutline;
                break;
            case 2:
                color = mud;
                outline = mudOutline;
                break;
            case 1:
                color = sand;
                outline = sandOutline;
                break;
            case 5:
                color = gravel;
                outline = gravelOutline;
                break;
            default:
                break;
        }
    }
    GameTile(int x, int y){
        this(GameMap.nz.generateNoise(x, y));
    }
    boolean open;
    short temperature = 293; //Boiling point of water is 373.15 K
    byte brightness;
    byte height;
    int type;
    Color color;
    Color outline;

    public static final Color water = new Color(72, 113, 172);
    public static final Color waterOutline = new Color(83, 130, 185);
    public static final Color grass = new Color(145, 188, 27);
    public static final Color grassOutline = new Color(167, 176, 27);
    public static final Color dirt = new Color(214, 116, 27);
    public static final Color dirtOutline = new Color(187, 108, 73);
    public static final Color mud = new Color(72, 113, 172);
    public static final Color mudOutline = new Color(83, 130, 185);
    public static final Color sand = new Color(72, 113, 172);
    public static final Color sandOutline = new Color(83, 130, 185);
    public static final Color gravel = new Color(46, 101, 125);
    public static final Color gravelOutline = new Color(83, 130, 185);
    
    
    
        public BufferedImage getIcon() {
        return GameCache.blocks[type];
    }
    
}
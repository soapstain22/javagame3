import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class GameTile {
    Stack<Item> onTile = new Stack<>();
    GameTile(int i){
        type = i;
        switch (Math.abs(type)%4) {
            case 0:
                this.color = water;
                this.outline = waterOutline;
                break; 
            case 1:
                this.color = sand;
                this.outline = sandOutline;
                break;
            case 2:
                this.color = gravel;
                this.outline = gravelOutline;
                break;
            case 3:
                this.color = dirt;
                this.outline = dirtOutline;
                break;
            case 4:
                this.color = grass;
                this.outline = grassOutline;
                break;
            default:
            System.out.println(type);
                break;
        }
    }
    GameTile(int x, int y){
        this(GameMap.nz.noise[x][y]);
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
    public static final Color mud = new Color(100, 60, 30);
    public static final Color mudOutline = new Color(90, 50, 20);
    public static final Color sand = new Color(221, 226, 153);
    public static final Color sandOutline = new Color(221, 204, 153);
    public static final Color gravel = new Color(46, 101, 125);
    public static final Color gravelOutline = new Color(83, 130, 185);
    
    
    
        public BufferedImage getIcon() {
        return GameCache.blocks[type];
    }
    
}
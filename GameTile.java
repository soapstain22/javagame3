import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class GameTile {
    Stack<Item> onTile = new Stack<>();
    TileType t = TileType.water;
    GameTile(TileType type){
        this.t = type;
        
    }
    short temperature = 293; //Boiling point of water is 373.15 K
    byte brightness;
    byte height;

    
}

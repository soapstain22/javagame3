import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class GameTile {
    Stack<Item> onTile = new Stack<>();
    Stack<GameObject> objs = new Stack<>();
    TileType t = TileType.water;
    GameTile(TileType type){
        this.t = type;
    }
}

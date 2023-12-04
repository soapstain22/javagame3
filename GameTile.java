import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Stack;

public class GameTile {
    Stack<Item> onTile = new Stack<>();
    TileType t = TileType.water;
    GameTile(int i){
        switch (Math.abs(i)%12) {
            case 0:
                t = TileType.water; 
                break;
            case 1:
                t = TileType.sand; 
                break;
            case 2:
                t = TileType.dirt; 
                if (Math.random() > 0.5){
                    this.onTile.push(new Item(ItemType.dirt));
                }
                break;
            case 3:
                t = TileType.silt; 
                break;
            case 4:
                t = TileType.grass; 
                if (Math.random() > 0.5){
                    this.onTile.push(new Item(ItemType.stick));
                }
                break;
            case 5:
                t = TileType.longgrass; 
                break;
            case 6:
                t = TileType.clay; 
                break;
            case 7:
                t = TileType.asphalt; 
                break;
            case 8:
                t = TileType.wood; 
                break;
            case 9:
                t = TileType.pavement; 
                break;
            case 10:
                t = TileType.chess; 
                break;
            case 11:
                t = TileType.log; 
                break;
            default:
                break;
        }
    }
    short temperature = 293; //Boiling point of water is 373.15 K
    byte brightness;
    byte height;

    
}

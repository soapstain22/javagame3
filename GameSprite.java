import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class GameSprite {
    private int max = 0;
    private int cur = 0;
    protected int maxHeight = 32;
    protected int maxWidth = 32;
    protected int maxDirections = 8; //must be 1, 4, 8
    protected int maxFrames = 8; //must be 1, 4, 8
    GameObject owner;
    BufferedImage source;
    BufferedImage[][] sprites;
    public int cell;
    BufferedImage getCurrentSprite(int direction){
        return sprites[direction][cur];
    }
    GameSprite(String file, int maxDirections, int maxFrames) throws IOException{
        
        //can only have 1,4,8 directions
        source = ImageIO.read(new File(file));
        sprites = new BufferedImage[maxDirections][maxFrames];
        for (int i = 0; i < maxDirections; i++) {
            for (int j = 0; j < maxFrames; j++) {
                sprites[i][j] = source.getSubimage((i*maxWidth),(j*maxHeight), maxWidth, maxHeight);
            }
        }
    }
}

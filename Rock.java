import java.awt.image.BufferedImage;
import java.io.IOException;

public class Rock extends GameObject {

    Rock(int x, int y) {
        super(x, y);
        face = new BufferedImage[1];
        face[0] = GameCache.blocks[0];
    }
}

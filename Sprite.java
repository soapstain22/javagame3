import java.awt.image.BufferedImage;
import java.io.File;

public interface Sprite {
    BufferedImage getSprite(Direction d, int f);
}

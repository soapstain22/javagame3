import java.awt.image.BufferedImage;

public class InnerGameCache {
    int frames;
    int dirs;
        public InnerGameCache(BufferedImage[][] poop) {
        frames = poop[0].length;
        dirs = poop[1].length;
        }
    }

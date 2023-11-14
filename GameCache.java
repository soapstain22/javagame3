import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import javax.imageio.ImageIO;

public class GameCache {
    public static BufferedImage bodies[][][]; // [type][frame][direction] DONT FUCK IT UP
    public static BufferedImage shirt[][][]; // [type][frame][direction]
    public static BufferedImage pants[][][]; // [type][frame][direction]
    public static BufferedImage heads[][][]; // [type][frame][direction]
    public static BufferedImage items[][][]; // [type][frame][direction]
    Map<String, Integer> ImageTracker;

    static void init() throws IOException {
        heads = fillBuffer("Resources/img/player/heads");
        bodies = fillBuffer("Resources/img/player/body");
        pants = fillBuffer("Resources/img/player/pants");
        shirt = fillBuffer("Resources/img/player/shirt");
    }
    static BufferedImage[][][] fillBuffer(String directory) throws IOException {
        File root = new File(directory);
        System.out.println("dir:" + root.isDirectory());
        System.out.println("file:" + root.isFile());
        System.out.println("abs:" + root.isAbsolute());
        File[] collection = root.listFiles();
        ArrayList<BufferedImage[][]> pile = new ArrayList<>();
        for (int i = 0; i < collection.length; i++) {
            pile.add(generateSprite(collection[i]));
        }
        BufferedImage[][][] fuck = new BufferedImage[pile.size()][][];
        for (int i = 0; i < fuck.length; i++) {
            fuck[i] = pile.get(i);
        }
        return fuck;
    }
    static BufferedImage[][] generateSprite(File f) throws IOException {
        BufferedImage i = ImageIO.read(f);
        int directions = i.getWidth()/32;
        int frames = i.getHeight()/32;
        BufferedImage[][] pool = new BufferedImage[directions][frames];
        for (int j2 = 0; j2< directions; j2++) {
            for (int j = 0; j < frames; j++) {
                pool[j2][j] = i.getSubimage(j2, j, directions, frames);
            }
        }
        return null;
    }
}
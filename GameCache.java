import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
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
    public static BufferedImage blocks[]; // [type][frame][direction]

    Map<String, Integer> ImageTracker;

    static void init() throws IOException {
        heads = fillBuffer("Resources/img/player/head");
        bodies = fillBuffer("Resources/img/player/body");
        pants = fillBuffer("Resources/img/player/pants");
        shirt = fillBuffer("Resources/img/player/shirt");
    }
    private static BufferedImage[] gimmieBlocks() throws IOException {
        File f = new File("Resources/img/blockz.png");
        BufferedImage b = ImageIO.read(f);
        int totalx = b.getWidth()/32;
        int totaly = b.getHeight()/32;
        ArrayList<BufferedImage> fuak = new ArrayList<>();
        for (int i = 0; i < totalx; i++) {
            for (int j = 0; j < totaly; j++) {
                fuak.add(b.getSubimage(i*32, j*32, 32, 32));
            }
        }
        BufferedImage[] b2 = new BufferedImage[fuak.size()];
        fuak.toArray(b2);
        return b2;
    }
    static BufferedImage[][][] fillBuffer(String directory) throws IOException {
        File root = new File(directory);
        System.out.println("dir:" + root.isDirectory()+"|file:" + root.isFile()+"|abs:" + root.isAbsolute());
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
                pool[j2][j] = i.getSubimage(j2, j, 32, 32);
            }
        }
        return pool;
    }
}

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Dictionary;
import javax.imageio.ImageIO;

public class GameMap {
    public static Noize nz;
    private static GameTile[][] map;
    public GameObject[] objex;
    final int size;
    public static Dictionary<String, GameObject> g;
    final public static long seed = 451679238;
    private int rgb;

    public GameMap(int size, int seed) {
        nz = new Noize(size);
        this.size = size;
        map = new GameTile[size][size];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = new GameTile((int) ImprovedNoise.noise(i, j, 0)/4);
            }
        }
    }
    public GameMap(String s) throws IOException{
        File f = new File(s);
        BufferedImage read = ImageIO.read(f);
        if (read.getWidth() != read.getHeight()) {
            System.out.println("not square image KILL YOURSELF!!!!!!");
        }
        size = read.getWidth();
        map = new GameTile[read.getWidth()][read.getHeight()];
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map.length; x++) {
                rgb = read.getRGB(x, y);
                Color c = new Color(rgb);
                map[y][x] = new GameTile(c.getRed()%9);
            }
        }
    }

    GameTile getTile(double d, double e) {
        int truex = (int) (d % size);
        int truey = (int) (e % size);
        return map[truex][truey];
    }

    public static boolean isTilePassable(double d, double e) {
        return GameMap.map[(int) d][(int) e].t.isSolid();
    }

    public void update() {

        Game.player.update();
    }

    /*
     * void mapRewrite(File f) throws IOException{
     * BufferedImage b = ImageIO.read(f);
     * for (int c = 0; c < map.length; c++) {
     * for (int j = 0; j < map.length; j++) {
     * //map[c][j] = new GameTile(b.getRGB(c, j));
     * }
     * }
     * }
     */
    public int mapSize() {
        return this.size;
    }

    public void addObject(GameObject gameObject) {

    }
    public void spawn(ItemType item) {
        spawn(item, Game.player.x, Game.player.y);
    }
    public void spawn(ItemType item, double x, double y) {
        Game.gameMap.getTile(x, y).onTile.push(new Item(item));
    }
    public void generateRoads(int recursivetype, int fuel){
        GameTile[][] rds;
        boolean vert;
        int curx = 30;
        int cury = 30;
        for (int i = 0; i < fuel; i++) {
            rds = new GameTile[size][size];
            rds[]
        }
    }
    public GameTile[][] roadSeg(int type){
        GameTile[][] rs = new GameTile[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                rs[i][j] = new GameTile(7);
            }
        }
        switch (type) {
            case 0:
                for (int i = 0; i < 5; i++) {
                    rs[0][i] = new GameTile(9);
                    rs[4][i] = new GameTile(9);
                }
                break;
                case 1:
                for (int i = 0; i < 5; i++) {
                    rs[i][0] = new GameTile(9);
                    rs[i][4] = new GameTile(9);
                }
            default:
                break;
        }
        return rs;
        
    }
}


import java.util.Dictionary;

public class GameMap {
    public static Noize nz;
    private static GameTile[][] map;
    public GameObject[] objex;
    final int size;
    public static Dictionary<String, GameObject> g;
    final public static long seed = 451679238;

    public GameMap(int size, int seed) {
        nz = new Noize(size);
        this.size = size;
        map = new GameTile[size][size];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = new GameTile(nz.noise[i][j]);
            }
        }
        objex = new GameObject[3];
        objex[1] = new Rock(2, 4);
    }

    GameTile getTile(double d, double e) {
        int truex = (int) (d % size);
        int truey = (int) (e % size);
        return map[truex][truey];
    }

    public static boolean isTilePassable(double d, double e) {
        return GameMap.map[(int) d][(int) e].open;
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
}

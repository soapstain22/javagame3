
import java.util.Dictionary;

public class GameMap {
    ObjectTree mapper;
    private static GameTile[][] map;
    final int size;
    public static Dictionary<String, GameObject> g;
    final public static long seed = 451679238;

    public GameMap(int size, int seed) {
        this.size = size;
        map = new GameTile[size][size];    }

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

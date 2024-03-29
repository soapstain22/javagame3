
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class GameMap {
    private static GameTile[][] map;
    static HashMap<Integer, HashMap<Integer, ArrayList<GameObject>>> valids;
    final int size;
    final public static long seed = 451679238;
    private int rgb;

    public GameMap(int size, int seed) {
        GameObject.objects = new HashMap<Long,GameObject>();
        this.size = size;
        map = new GameTile[size][size];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = new GameTile(TileType.sand);
            }
        }
    }

    public GameMap(String s) throws IOException {
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
                TileType gt;
                switch (c.getRGB()) {
                    case -15937984:
                        gt = TileType.sand;
                        break;
                    case -5203273:
                        gt = TileType.silt;
                        break;
                    case -16146383:
                        gt = TileType.grass;
                        break;
                    case -4758733:
                        gt = TileType.longgrass;
                        break;
                    case -8955787:
                        gt = TileType.dirt;
                        break;
                    case -11913:
                        gt = TileType.stone;
                        break;
                    case -8934913:
                        gt = TileType.wood;
                        break;
                    case -8355693:
                        gt = TileType.log;
                        break;
                    case -2035969:
                        gt = TileType.glass;
                        break;
                    default:
                        System.out.println(c.getRGB());
                        gt = TileType.dirt;
                        break;
                }
                map[y][x] = new GameTile(gt);
            }
        }
    }

    GameTile getTile(int d, int e) {
        return map[d][e];
    }

    public static boolean isTilePassable(int x, int y) {
        return GameMap.map[x][y].t.isSolid();
    }

    public void update() {

    }

    public int mapSize() {
        return this.size;
    }

    public void spawn(ItemType item) {
        spawn(item, Game.player.x, Game.player.y);
    }

    public void spawn(ItemType item, int x, int y) {
        Game.gameMap.getTile(x, y).onTile.push(new Item(item));
    }

}

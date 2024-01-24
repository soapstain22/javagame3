import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;

public abstract class GameObject {
    static HashMap<Integer, HashMap<Integer, ArrayList<GameObject>>> okay;
    static HashMap<Long, GameObject> objects;
    int x;
    int y;
    final long uuid;
    static private long totalUUID;
    int spriteIndex;

    private static ArrayList<GameObject> getOnPoint(int x, int y) {
        if (okay.containsKey(x)) {
            if (okay.get(x).containsKey(y)) {
                return okay.get(x).get(y);
            } else {
                ArrayList<GameObject> g = new ArrayList<GameObject>();
                okay.get(x).put(y, g);
            }
        } else {
            HashMap<Integer, ArrayList<GameObject>> g = new HashMap<>();
            ArrayList<GameObject> objects = new ArrayList<GameObject>();
            g.put(y, objects);
            okay.put(x, g);
        }
        return null;
    }
    public static GameObject[] onPoint(int x, int y) {
        GameObject[] g;
        g = (GameObject[]) getOnPoint(x, y).toArray();
        return g;
    }

    GameObject(int x, int y) {
        this.x = x;
        this.y = y;
        uuid = totalUUID + 1;
        totalUUID += 1;
        objects.put(uuid, this);
        new PacketEvent(this, PacketEvent.UPDATE_GAME_OBJ.INIT);
    }

    void Delete() {

        new PacketEvent(this, PacketEvent.UPDATE_GAME_OBJ.DELETE);
    }

    public boolean push(int x, int y) {
        if (GameMap.isTilePassable(this.x + x, this.y + y)) {
            getOnPoint(this.x, this.y).remove(this);
            getOnPoint(this.x + x, this.y + y).add(this);
            this.x = this.x + x;
            this.y = this.y + y;
            new PacketEvent(this, PacketEvent.UPDATE_GAME_OBJ.LOCATION);
            return true;
        }
        return false;
    }

    public static void init() {
        // TODO Auto-generated method stub
        objects = new HashMap<>();
    }
}

import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.Queue;

public class PacketEvent {
    static Queue<PacketEvent> jobs;
    byte[] job = new byte[16];

    // 0 = [4][4] > [4] get tile at location
    // 1 = [4][4][2] > [4] get object at location at index
    // 2 = [4][4][2] > [2] get object count location
    // 3 = [4][4][2] set tile type at x,y
    // 4 = [4][2][2] uuid moves to x,y
    // 5 = [4] uuid deleted
    // 6 = [4] > [2] return uuid sprite index
    // 7 = [4] > [2] return uuid hp
    // 8 = [4] > [2] return uuid maxhp
    // 9 = [4] > [8] return uuid name
    // 10 = [4][2][2] initialize uuid at [][]
    public enum UPDATE_GAME_OBJ {
        LOCATION, DELETE, INIT, SPRITE,
    };

    public enum UPDATE_GAME_TILE {
        LOCATION, DELETE, INIT, SPRITE,
    };

    PacketEvent(GameTile g, UPDATE_GAME_TILE a) {
        ByteBuffer event = ByteBuffer.allocate(16);
        switch (a) {
            case LOCATION:
            job[0] = 1;

                break;
            case DELETE:
            job[0] = 2;

                break;
            case INIT:
            job[0] = 3;

                break;
            case SPRITE:
            job[0] = 4;

                break;
            default:
                break;
        }
        ByteBuffer cBuffer = ByteBuffer.allocate(16);
        byte b = 0;
    }

    PacketEvent(GameObject g, UPDATE_GAME_OBJ a) {
        // update position
        ByteBuffer cBuffer = ByteBuffer.allocate(16);
        byte b = 0;

        switch (a) {
            case LOCATION:
                b = 1;
                cBuffer.put(b);
                cBuffer.putLong(g.uuid);
                cBuffer.putInt(g.x);
                cBuffer.putInt(g.y);
                this.job = cBuffer.array();
                break;
            case DELETE:
                b = 2;
                cBuffer.put(b);
                cBuffer.putLong(g.uuid);
                GameObject.objects.get(cBuffer);
                getOnPoint(x, y).remove(this);
            case INIT:
                b = 3;
                cBuffer.put(b);
                cBuffer.putLong(g.uuid);
            case INIT:
                b = 4;
                cBuffer.put(b);
                cBuffer.putLong(g.uuid);
            default:
                break;
        }
        push(this);
    }

    static PacketEvent decrypt(byte[] job) {
        switch (job[0]) {
            case 0: // get a tile at a location
                ByteBuffer x = ByteBuffer.allocate(4);
                ByteBuffer y = ByteBuffer.allocate(4);
                x.put(job[1]);
                x.put(job[2]);
                x.put(job[3]);
                x.put(job[4]);
                y.put(job[5]);
                y.put(job[6]);
                y.put(job[7]);
                y.put(job[8]);
                byte b = job[9];
                Game.gameMap.getTile(x.getInt(), y.getInt());

                break;
            case 5:
                ByteBuffer uuid = ByteBuffer.allocate(4);
                uuid.put(job[1]);
                uuid.put(job[2]);
                uuid.put(job[3]);
                uuid.put(job[4]);
                break;
            case 10:
                ByteBuffer uuid2 = ByteBuffer.allocate(4);
                uuid2.put(job[1]);
                uuid2.put(job[2]);
                uuid2.put(job[3]);
                uuid2.put(job[4]);

                break;
            default:
                break;
        }
        return false;

    }

    public static void push(PacketEvent packetEvent) {
        // TODO Auto-generated method stub
        if (jobs == null) {
            jobs = new LinkedList<>();
        }
        jobs.add(packetEvent);
    }
}


import java.awt.List;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Game
 */
public class Game {
    public static int TickCount = 0;
    public static GameMap gameMap;
    public static Chatblob chatblob;
    public static GameCache gameCache;
    public static Player player;
    public static GameCamera gameCamera;
    public static KeyListener k;
    public static List items;
    public static GameWindow gw;
    public static Client cli;
    boolean debug;

    public static void main(String[] args) throws IOException {
        cli = new Client();
        GameCache.init();
        Game.gameMap = new GameMap("world.png");
        Game.player = new Player(10, 10);
        Game.chatblob = new Chatblob();
        Game.gameCamera = new GameCamera(player);
        gw = new GameWindow(true);
        gw.setVisible(true);
        Game.Load(null);
        Game.gameMap.spawn(ItemType.dollar);
        MapPrefab p = new MapPrefab();
        Runnable tick = new Runnable() {
            public void run() {
                Game.gameMap.update();
                Game.player.update();
                Game.gameCamera.update();
            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(tick, 0, 10, TimeUnit.MILLISECONDS);
    }

    private static void Load(String string) {
        System.out.println("Game.Load()");

    }

    public Thread ticks = new Thread(() -> extracted());

    private void extracted() {
        try {
            Thread.sleep(15);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Thread.currentThread().run();
    }
}
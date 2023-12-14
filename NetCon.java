import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;

public class NetCon {
    static Socket socket;
    static InputStream inputStream;
    static OutputStream outputStream;
    static boolean TryConnect(SocketAddress socketAddress) throws IOException{
        try {
            socket.connect(socketAddress);
        } catch (IOException e) {
            System.out.println("NO!");
            e.printStackTrace();
        }
        inputStream = socket.getInputStream();
        outputStream = socket.getOutputStream();
        return false;

    }
    static boolean trysomething(){
        return false;

    }
    public static void sendMsg(Player player, String s) {
    }
    public static void updatePos(GameObject obj) throws IOException{
        byte[] x = ByteBuffer.allocate(4).putDouble(obj.x).array();
        byte[] y = ByteBuffer.allocate(4).putDouble(obj.y).array();
        byte[] id = ByteBuffer.allocate(3).putDouble(obj.uuid).array();
        byte[] dir = ByteBuffer.allocate(1).putDouble(obj.direction).array();

        inputStream.read(null);
    }
    private static byte[] byteSize(double d){
        Double.doubleToLongBits(obj.x);

    }
    public static void getServers() {
    }
}

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.util.Queue;

public class NetCon {
    static Socket socket;
    static Socket Master;

    static InputStream inputStream;
    static OutputStream outputStream;
        Queue<Byte[]> packets = new Queue<Byte[]>() {
            
        };

    static boolean TryConnect(SocketAddress socketAddress) throws IOException{
        socket.connect(socketAddress);
        socket.getOutputStream();
        return false;

    }
    static boolean trysomething(){
        return false;

    }
    public static void sendMsg(Player player, String s) {
    }
    public static void updatePos(GameObject obj) throws IOException{
        byte opcode = 1;
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

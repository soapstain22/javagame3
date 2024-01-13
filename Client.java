
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Client implements Runnable {

    // run() method for the thread
    @Override
    public void run() {

        // Initially assign null to our socket to be
        // used
        Socket socket = null;

        // Try block to e=check for exceptions
        try {

            socket = new Socket("localhost", 3333);

            // Creating an object of PrintWriter class
            PrintWriter outWriter = new PrintWriter(
                    socket.getOutputStream(), true);

            // Display message
            Chat.recieve("wait");

            // making thread to sleep for 1500
            // nanoseconds
            Thread.sleep(15000);

            // Display message
            outWriter.println("Hello Mr. Server!");
        }
        // Catch block to handle the exceptions

        // Catch block 1
        catch (SocketException e) {

            // Display the line number where exception
            // occurred using printStackTrace() method
            e.printStackTrace();
        }

        // Catch block 2
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Catch block 3
        catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // Catch block 4
        catch (IOException e) {
            e.printStackTrace();
        }

        finally {

            try {

                // If socket goes NULL
                if (socket != null)

                    // Close the socket
                    socket.close();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
    }
}

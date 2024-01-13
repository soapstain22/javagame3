

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import javax.net.SocketFactory;

public class Server {
   // Main driver method
    public static void main(String[] args)
        throws InterruptedException
    {
 
        new Thread(new SimpleServer()).start();
    }
 
    static class SimpleServer implements Runnable {
 
        // run() method for thread
        @Override public void run()
        {
 
            ServerSocket serverSocket = null;
 
            // Try block to check for exceptions
            try {
 
                serverSocket = new ServerSocket(3333);
                serverSocket.setSoTimeout(0);
 
                // Till condition holds true
                while (true) {
 
                    try {
                        Socket clientSocket
                            = serverSocket.accept();
 
                        // Creating an object of
                        // BufferedReader class
                        BufferedReader inputReader
                            = new BufferedReader(
                                new InputStreamReader(
                                    clientSocket
                                        .getInputStream()));

                        System.out.println(
                            "Client said :"
                            + inputReader.readLine());
                    }
 
                    // Handling the exception
                    catch (SocketTimeoutException e) {
 
                        // Print the exception along with
                        // line number
                        e.printStackTrace();
                    }
                }
            }
 
            // Catch block to handle the exceptions
            catch (IOException e1) {
 
                // Display the line where exception occurs
                e1.printStackTrace();
            }
 
            finally {
 
                try {
                    if (serverSocket != null) {
                        serverSocket.close();
                    }
                }
                catch (IOException e) {
 
                    e.printStackTrace();
                }
            }
        }
    }
}
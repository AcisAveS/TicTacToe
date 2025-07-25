package src.Controllers;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server extends ServerSocket implements Runnable {
    private final Socket[] user = new Socket[2];
    private final Thread serverThread;
    private volatile boolean serverRunning = true;

    public Server(short port, String players) throws IOException {
        super(port, 2);
        Arrays.fill(user, null);
        serverThread = new Thread(this);
    }

    @Override
    public void run() {
        try {
            int i = 0;
            while (serverRunning) {
                user[i] = this.accept();
                System.out.println(i);
                i++;
                System.out.println("Waiting....");
            }
        } catch (IOException e) {
        }

    }

    public void startServer() {
        serverThread.start();
    }

    @Override
    public void close() throws IOException {
        super.close();
        serverRunning = false;
        serverThread.interrupt();
    }

}

class ServerThread implements Runnable {
    private final DataOutputStream dataOutput;
    private final DataInputStream dataInput;

    public ServerThread(Socket client, DataOutputStream dataOutput, DataInputStream dataInput) {
        this.dataInput = dataInput;
        this.dataOutput = dataOutput;
    }

    @Override
    public void run() {

    }

}
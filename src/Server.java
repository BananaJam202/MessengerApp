import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) {
        int portNumber = Integer.parseInt(args[0]);
        int maxClients = 5;
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(portNumber);

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            return;
        }

        Thread [] t = new Thread[maxClients];
        Thread t2 = new Thread(new ServerBroadcaster());

        while (true) {
            try {
                Socket client = serverSocket.accept();

                for (int i = 0; i < maxClients; i++) {
                    if ((t[i] == null) || (t[i] != null && !t[i].isAlive())) {
                        t[i] = new Thread(new ServerListener(client));
                        t[i].start();
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

}

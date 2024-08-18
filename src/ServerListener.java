import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerListener implements Runnable{

    private Socket socket;

    public ServerListener(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String input;
            while ((input = in.readLine()) != null) {
                System.out.println(input);
            }
        }
        catch (Exception e) {
            return;
        }
    }
}

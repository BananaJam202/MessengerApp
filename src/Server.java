import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args){
        int portNumber = Integer.parseInt(args[0]);
        try (ServerSocket serverSocket =
                     new ServerSocket(portNumber);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out =
                     new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(clientSocket.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.println(inputLine);
            }

        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

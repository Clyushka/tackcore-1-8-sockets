import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private BufferedReader in;
    private PrintWriter out;

    public Server() throws IOException {
        serverSocket = new ServerSocket(80);
    }

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public int start() throws IOException {
        Socket clientSocket = serverSocket.accept();
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        return clientSocket.getPort();
    }

    public String recieve() throws IOException {
        return in.readLine();
    }

    public void send(String message){
        out.println(message);
    }

    public void close() throws IOException {
        serverSocket.close();
    }
}

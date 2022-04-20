import java.io.IOException;

public class ClientMain {
    public static void main (String[] args) {
        int serverPort = 65000;
        String ipAddress = "netology.homework";

        try {
            Client client = new Client(ipAddress, serverPort);
            System.out.println(client.recieve());
            client.send("Clyushka");
            System.out.println(client.recieve());
            //client.send("yes");
            //client.send("no");
            client.send("abra-kadabra");
            System.out.println(client.recieve());
            client.close();
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }

    }
}

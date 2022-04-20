import java.io.IOException;

public class Main {
    //Server main
    public static void main (String[] args) {
        int serverPort = 65000;
        String ipAddress = "netology.homework";

        try {
            while (true) {
                Server server = new Server(serverPort);
                int clientPort = server.start();
                System.out.println("New connection has started on port: " + clientPort);
                server.send("Write your name");
                String name = server.recieve();
                server.send("Are you child? (yes/no)");
                String answer = server.recieve();
                if (answer.equals("yes")) {//kid
                    server.send(String.format("Welcome to the kids area, %s! Let's play!", name));
                } else if (answer.equals("no")) {//adult
                    server.send(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
                } else {//incorrect
                    server.send(String.format("Not funny, %s! Next time just answer \"yes\" or \"no\"!", name));;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}

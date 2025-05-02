import java.io.*;
import java.net.*;

// Client class to connect to server and send/receive messages
class ChatClient{
    public static void main(String[] args) {
        final String SERVER_IP = "localhost"; // or use your server IP
        final int SERVER_PORT = 12345;

        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Connected to chat server");

            System.out.print("Enter your name : ");
            String name=userInput.readLine();
            System.out.println("Welcome,"+name+"! Start chatting...");


            // Thread to listen for messages from the server
            Thread receiveThread = new Thread(() -> {
                String msgFromServer;
                try {
                    while ((msgFromServer = in.readLine()) != null) {
                        System.out.println("Server: " + msgFromServer);
                    }
                } catch (IOException e) {
                    System.out.println("Disconnected from server.");
                }
            });
            receiveThread.start();

            // Main thread to send user input to server
            String message;
            while ((message = userInput.readLine()) != null) {
                out.println(name+": "+message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
 * How to Run:
 * 1. Run ChatServer.java first to start the server.
 * 2. Then run ChatClient.java for each user.
 *    - Each client will be prompted to enter their name.
 *    - Type messages to chat in real-time.
 * 3. Run multiple clients (ChatClient) to simulate multiple users.
 */

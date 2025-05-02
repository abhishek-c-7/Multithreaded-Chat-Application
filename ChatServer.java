import java.io.*;
import java.net.*;
import java.util.*;

/*
 * Internship Task 3: Multithreaded Chat Application
 * Student Name: Abhishek Choudhary
 *
 * Description:
 * This project is a multithreaded client-server chat application built using Java sockets.
 * The server handles multiple clients concurrently using threads.
 * Each client can send and receive messages in real-time.
 */

// Server class to accept client connections and broadcast messages
class ChatServer {

    // Store all connected clients
    private static final Set<ClientHandler> clientHandlers = new HashSet<>();

    public static void main(String[] args) {
        final int PORT = 12345; // Port number for the server

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);

            // Keep accepting new clients
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                // Create a new handler for each client
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                clientHandlers.add(clientHandler);

                // Start the thread
                new Thread(clientHandler).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Broadcast a message to all connected clients
    public static void broadcastMessage(String message, ClientHandler sender) {
        for (ClientHandler client : clientHandlers) {
            if (client != sender) {
                client.sendMessage(message);
            }
        }
    }

    // Remove a client from the list when they disconnect
    public static void removeClient(ClientHandler clientHandler) {
        clientHandlers.remove(clientHandler);
    }
}

// Handler class to manage individual client in its own thread
class ClientHandler implements Runnable {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        try {
            // Create input and output streams
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Thread's run method
    public void run() {
        try {
            out.println("Welcome to the chat!");
            String message;

            // Read messages from the client and broadcast them
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                ChatServer.broadcastMessage(message, this);
            }
        } catch (IOException e) {
            System.out.println("Client disconnected.");
        } finally {
            // Remove this client from server list and close connection
            ChatServer.removeClient(this);
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Method to send message to this client
    public void sendMessage(String message) {
        out.println(message);
    }
}

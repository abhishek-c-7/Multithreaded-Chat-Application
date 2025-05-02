# Multithreaded-Chat-Application
Company Name : CODTECH IT SOLUTIONS PVT. LTD

Student Name : Abhishek Choudhary

Intern ID : CT06DK611

Domain Name : JAVA PROGRAMMING

Batch Duration : April 30th,2025 to June 15th,2025

Mentor Name : Neela Santhosh Kumar

Internship Task 3 : Multithreaded Chat Application

About the task : 

This project is developed as part of my Internship Task 3, which involved building a Multithreaded Client-Server Chat Application using Java Sockets and Multithreading. The objective was to demonstrate a practical understanding of Java networking concepts and thread handling by allowing multiple clients to connect to a single server and chat in real-time.

The core functionality of this application revolves around establishing a communication bridge between a server and multiple clients, where each client can send and receive messages in a real-time group chat environment. The server continuously listens for incoming client connections and spawns a new thread for each client to handle messaging concurrently. This allows multiple clients to interact simultaneously without interrupting each other's communication flows.

Tools and Technologies Used

To successfully complete this project, I leveraged various online tools and resources that played a crucial role in building, debugging, and enhancing my understanding:

Java: The primary programming language used to develop the chat server and client using Socket, ServerSocket, BufferedReader, and PrintWriter classes for input/output and networking.

IntelliJ IDEA: This was the primary IDE (Integrated Development Environment) used for writing, running, and testing the Java code. IntelliJ offers powerful debugging tools and code suggestions, making it ideal for Java development.

ChatGPT: I used OpenAI’s ChatGPT as a coding assistant to clarify doubts related to socket programming, multithreading, and Java I/O streams. It was also helpful in troubleshooting issues and getting guidance on best practices.

YouTube: Served as a visual learning platform where I watched tutorials on Java networking and socket programming. This helped me understand the concepts through real-world implementations.

Google: An essential tool for looking up Java documentation, Stack Overflow discussions, and examples of similar client-server applications to understand common pitfalls and solutions.


How It Works

1. The ChatServer starts and listens on a specific port (e.g., 12345).


2. When a ChatClient connects, the server accepts the connection and starts a new thread to handle that client.


3. Each client is prompted to enter their name, and they can start sending messages.


4. The server broadcasts any message received from a client to all other connected clients using the shared output streams.


5. Messages are displayed in real time, tagged with the sender's name for easy identification.



This application simulates a group chat where all participants see messages from others live, just like WhatsApp or Messenger group chats — but in a simple terminal-based format.

Applications and Use Cases

This kind of application has several real-world applications, such as:

Real-Time Messaging Systems: Can be used as the base for more advanced chat applications like Slack, Discord, or Microsoft Teams.

Customer Support Chatbots: Backend communication for live support systems.

Collaborative Tools: Integration into collaborative coding environments or project management systems.

Network Programming Practice: An excellent foundation for students and developers looking to understand multi-user systems and socket communication.


It also acts as a stepping stone for learning about asynchronous I/O, event-driven programming, and more advanced frameworks like Netty, Spring Boot WebSockets, or Socket.IO (in JavaScript/Node.js).

Conclusion

Internship Task 3 was both a challenging and rewarding experience. It helped me solidify my understanding of networking fundamentals, multithreading, and real-time system design. With the help of tools like IntelliJ, ChatGPT, YouTube, and Google, I was able to overcome challenges, debug effectively, and complete the task successfully. This project not only boosted my Java programming skills but also gave me confidence in working on real-world backend communication systems.

OUTPUT : 

![Image](https://github.com/user-attachments/assets/7ccbff73-35db-4a7b-bca4-2eae478b5122)

![Image](https://github.com/user-attachments/assets/cb1e1a33-a694-4f42-9f13-bcb785a20f5e)

![Image](https://github.com/user-attachments/assets/448899d7-07d0-4c77-82a5-96b3bbc82779)

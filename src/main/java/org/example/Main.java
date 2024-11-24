package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChatLogger logger = new ChatLogger("chat.ser");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Loading chat history...");
        List<ChatMessage> chatHistory = logger.loadChatHistory();
        if (chatHistory.isEmpty()) {
            System.out.println("No previous chat history found");
        } else {
            chatHistory.forEach(System.out::println);
        }

        System.out.println("\nChat Application Started. Type 'exit' to quit.");

        while (true) {
            System.out.println("Enter your username: ");
            String username = scanner.nextLine();

            System.out.println("Enter the message you want to send: ");
            String message = scanner.nextLine();

            if (message.equalsIgnoreCase("exit")) {
                System.out.println("Exiting chat...");
                break;
            }

            ChatMessage chatMessage = new ChatMessage(username, message);
            logger.logMessage(chatMessage);

            System.out.println("Message logged: " + chatMessage);
        }
        scanner.close();
    }
}
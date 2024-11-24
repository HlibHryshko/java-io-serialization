package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChatLogger {
    private final String fileName;

    public ChatLogger(String fileName) {
        this.fileName = fileName;
    }

    public void logMessage (ChatMessage message) {
        try (FileOutputStream fos = new FileOutputStream(fileName, true);
        ObjectOutputStream oos = new AppendableObjectOutputStream(fos)) {
            oos.writeObject(message);
        } catch (IOException e) {
            System.err.println("Error saving chat message: " + e.getMessage());
        }
    }

    public List<ChatMessage> loadChatHistory() {
        List<ChatMessage> chatHistory = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
            while (true) {
                try {
                    ChatMessage message = (ChatMessage) ois.readObject();
                    chatHistory.add(message);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Previous chat history is not found ");
        }
        catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading chat history: " + e.getMessage());
        }
        return chatHistory;
    }
}

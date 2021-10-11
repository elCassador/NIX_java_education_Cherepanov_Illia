package nix.education.java.chatbot;
import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        System.out.println("Hello! My name is TEST.\nI was created in 2021.");
        System.out.println("Please, remind me your name.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("What a great name you have, " + scanner.nextLine() + "!");
    }
}

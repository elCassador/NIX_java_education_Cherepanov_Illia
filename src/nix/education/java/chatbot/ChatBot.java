package nix.education.java.chatbot;
import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        System.out.println("Hello! My name is TEST.\nI was created in 2021.");
        System.out.println("Please, remind me your name.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("What a great name you have, " + scanner.nextLine() + "!");
        System.out.println("Let me guess your age.\nEnter remainders of dividing your age by 3, 5 and 7.");
        System.out.println("Your age is " + (scanner.nextInt() * 70 + scanner.nextInt() * 21 + scanner.nextInt() * 15) % 105 + "; that's a good time to start programming!");
    }
}

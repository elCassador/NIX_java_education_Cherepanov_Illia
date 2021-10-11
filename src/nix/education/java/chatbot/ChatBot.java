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
        System.out.println("Now I will prove t you that I can count to any numer you want.");
        int number = scanner.nextInt();
        for (int i = 0; i < number + 1; i++) {
            System.out.println(i + " !");
        }
        System.out.println("Let's test your programming knowledge.\nWhy do we use methods?");
        System.out.println("1. Wrong answer.\n2. Correct answer.\n3. Wrong answer\n4. Wrong answer.");
        while (true) {
            switch (scanner.nextInt()) {
                case 2:
                    System.out.println("Great, you right!");
                    System.out.println("Goodbye, have a nice day!");
                    System.exit(0);
                default:
                    System.out.println("Please, try again.");
            }
        }
    }
}

package nix.education.java.coffeemachine;
import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyClass coffeeMachine = new MyClass();

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            coffeeMachine.input(scanner.nextLine());
        }
    }

}

class MyClass {

    Scanner scanner = new Scanner(System.in);
    private int availableCoffeeWater = 400;
    private int availableCoffeeMilk = 540;
    private int availableCoffeeBeans = 120;
    private int availableCoffeeCups = 9;
    private int availableMoney = 550;


    private void supplies() {
        System.out.println("The coffee machine has:\n" +
                availableCoffeeWater + " of water\n" +
                availableCoffeeMilk + " of milk\n" +
                availableCoffeeBeans + " of coffee beans\n" +
                availableCoffeeCups + " of disposable cups\n" +
                availableMoney + " of money\n");
    }

    public void input(String option) {

        switch (option) {
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                coffeeTypes(scanner.nextInt());
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                supplies();
                break;
            case "exit":
                System.exit(0);
        }
    }

    private void coffeeTypes(int option) {
        switch (option) {
            case 1:
                availableMoney += 4;
                if (availableCoffeeWater - 250 < 0) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else {
                    availableCoffeeWater -= 250;
                }

                if (availableCoffeeBeans - 16 < 0) {
                    System.out.println("Sorry, not enough beans!");
                    break;
                } else {
                    availableCoffeeBeans -= 16;
                }

                if (availableCoffeeCups - 1 < 0) {
                    System.out.println("Sorry, not enough cups!");
                    break;
                } else {
                    availableCoffeeCups -= 1;
                }
                System.out.println("I have enough resources, making you a coffee!");
                break;
            case 2:
                availableMoney += 7;
                if (availableCoffeeWater - 350 < 0) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else {
                    availableCoffeeWater -= 350;
                }
                if (availableCoffeeMilk - 75 < 0) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                } else {
                    availableCoffeeMilk -= 75;
                }

                if (availableCoffeeBeans - 20 < 0) {
                    System.out.println("Sorry, not enough beans!");
                    break;
                } else {
                    availableCoffeeBeans -= 20;
                }

                if (availableCoffeeCups - 1 < 0) {
                    System.out.println("Sorry, not enough cups!");
                    break;
                } else {
                    availableCoffeeCups -= 1;
                }
                System.out.println("I have enough resources, making you a coffee!");
                break;
            case 3:
                availableMoney += 6;
                if (availableCoffeeWater - 200 < 0) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else {
                    availableCoffeeWater -= 200;
                }
                if (availableCoffeeMilk - 100 < 0) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                } else {
                    availableCoffeeMilk -= 100;
                }

                if (availableCoffeeBeans - 12 < 0) {
                    System.out.println("Sorry, not enough beans!");
                    break;
                } else {
                    availableCoffeeBeans -= 12;
                }

                if (availableCoffeeCups - 1 < 0) {
                    System.out.println("Sorry, not enough cups!");
                    break;
                } else {
                    availableCoffeeCups -= 1;
                }
                System.out.println("I have enough resources, making you a coffee!");
                break;
        }
    }

    private void fill() {
        System.out.println("Write how many ml of water you want to add: ");
        availableCoffeeWater += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        availableCoffeeMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        availableCoffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable coffee cups you want to add: ");
        availableCoffeeCups += scanner.nextInt();
    }

    private void take() {
        System.out.println("I gave you " + availableMoney);
        availableMoney = 0;
    }
}
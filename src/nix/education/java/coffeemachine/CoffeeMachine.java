package nix.education.java.coffeemachine;
import java.util.Scanner;

public class CoffeeMachine {

    Scanner scanner = new Scanner(System.in);
//    private int oneEspressoWater = 250;
//    private int oneEspressoMilk = 0;
//    private int oneEspressoBeans = 16;
//    private int oneEspressoCost = 4;
//    private int oneLatteWater = 350;
//    private int oneLatteMilk = 75;
//    private int oneLatteBeans = 20;
//    private int oneLatteCost = 7;
//    private int oneCappuccinoWater = 200;
//    private int oneCappuccinoMilk = 100;
//    private int oneCappuccinoBeans = 12;
//    private int oneCappuccinoCost = 6;

    private int availableCoffeeWater = 400;
    private int availableCoffeeMilk = 540;
    private int availableCoffeeBeans = 120;
    private int availableCoffeeCups = 9;
    private int availableMoney = 550;

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
//        coffeeMachine.makeCoffee();
//        coffeeMachine.howManyCups();
//        coffeeMachine.makeCoffeeCups();
        coffeeMachine.supplies();
        while (true) {
            coffeeMachine.input();
        }
    }

    public void makeCoffee() {
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup Coffee is ready!");
    }

//    public void howManyCups() {
//        System.out.println("Write how many cups of coffee you will need: ");
//        int coffeeCups = scanner.nextInt();
//        System.out.println("For " + coffeeCups + " cups of coffee you will need:\n" +
//                coffeeCups * oneCoffeeWater + " ml of water\n" +
//                coffeeCups * oneCoffeeMilk + " ml of milk\n" +
//                coffeeCups * oneCoffeeBeans + " g of coffee beans");
//    }
//
//    public void makeCoffeeCups() {
//        System.out.println("Write how many ml of water the coffee machine has: ");
//        availableCoffeeWater = scanner.nextInt();
//        System.out.println("Write how many ml of milk the coffee machine has: ");
//        availableCoffeeMilk = scanner.nextInt();
//        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
//        availableCoffeeBeans = scanner.nextInt();
//        System.out.println("Write how many cups of coffee you will need: ");
//        int coffeeCups = scanner.nextInt();
//        int canMakeCups = Math.min(availableCoffeeWater/oneCoffeeWater, Math.min(availableCoffeeMilk/oneCoffeeMilk, availableCoffeeBeans/oneCoffeeBeans));
//
//        if (coffeeCups == canMakeCups) {
//            System.out.println("Yes, I can make that amount of coffee");
//        } else if (coffeeCups < canMakeCups) {
//            System.out.println("Yes, I can make that amount of coffee (and even "
//            + (canMakeCups - coffeeCups) + " more than that)");
//        } else {
//            System.out.println("No, I can make only " + canMakeCups + " cups of coffee");
//        }
//    }

    private void supplies() {
        System.out.println("The coffee machine has:\n" +
                availableCoffeeWater + " of water\n" +
                availableCoffeeMilk + " of milk\n" +
                availableCoffeeBeans + " of coffee beans\n" +
                availableCoffeeCups + " of disposable cups\n" +
                availableMoney + " of money\n");
    }

    public void input() {
        System.out.println("(buy, fill, take, remaining, exit):");
        String option = scanner.nextLine();

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

    public void coffeeTypes(int option) {
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

    public void fill() {
        System.out.println("Write how many ml of water you want to add: ");
        availableCoffeeWater += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        availableCoffeeMilk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add: ");
        availableCoffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable coffee cups you want to add: ");
        availableCoffeeCups += scanner.nextInt();
    }

    public void take() {
        System.out.println("I gave you " + availableMoney);
        availableMoney = 0;
    }
}

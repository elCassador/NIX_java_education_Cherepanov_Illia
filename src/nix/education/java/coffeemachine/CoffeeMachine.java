package nix.education.java.coffeemachine;
import java.util.Scanner;

public class CoffeeMachine {

    Scanner scanner = new Scanner(System.in);
    private int oneCoffeeWater = 200;
    private int oneCoffeeMilk = 50;
    private int oneCoffeeBeans = 15;

    private int availableCoffeeWater;
    private int availableCoffeeMilk;
    private int availableCoffeeBeans;

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
//        coffeeMachine.makeCoffee();
//        coffeeMachine.howManyCups();
        coffeeMachine.makeCoffeeCups();
    }

    public void makeCoffee() {
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup Coffee is ready!");
    }

    public void howManyCups() {
        System.out.println("Write how many cups of coffee you will need: ");
        int coffeeCups = scanner.nextInt();
        System.out.println("For " + coffeeCups + " cups of coffee you will need:\n" +
                coffeeCups * oneCoffeeWater + " ml of water\n" +
                coffeeCups * oneCoffeeMilk + " ml of milk\n" +
                coffeeCups * oneCoffeeBeans + " g of coffee beans");
    }

    public void makeCoffeeCups() {
        System.out.println("Write how many ml of water the coffee machine has: ");
        availableCoffeeWater = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        availableCoffeeMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        availableCoffeeBeans = scanner.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int coffeeCups = scanner.nextInt();
        int canMakeCups = Math.min(availableCoffeeWater/oneCoffeeWater, Math.min(availableCoffeeMilk/oneCoffeeMilk, availableCoffeeBeans/oneCoffeeBeans));

        if (coffeeCups == canMakeCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (coffeeCups < canMakeCups) {
            System.out.println("Yes, I can make that amount of coffee (and even "
            + (canMakeCups - coffeeCups) + " more than that)");
        } else {
            System.out.println("No, I can make only " + canMakeCups + " cups of coffee");
        }
    }
}

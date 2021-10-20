package nix.education.java.coffeemachine;
import java.util.Scanner;

public class CoffeeMachine {

    Scanner scanner = new Scanner(System.in);
    int oneCoffeeWater = 200;
    int oneCoffeeMilk = 50;
    int oneCoffeeBeans = 15;

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        coffeeMachine.makeCoffee();
        coffeeMachine.howManyCups();
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
}

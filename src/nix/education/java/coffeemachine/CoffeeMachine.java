package nix.education.java.coffeemachine;
import java.util.Scanner;



class CoffeeMachine {

    enum Coffee {
        ESPRESSO   (1, 4, 250, 0, 16),
        LATTE       (1, 7, 350, 75, 20),
        CAPPUCCINO  (1, 6, 200, 100, 12);

        private final int Cups;
        private final int Cost;
        private final int Water;
        private final int Milk;
        private final int Beans;

        Coffee(int Cups, int Cost, int Water, int Milk, int Beans) {
            this.Cups = Cups;
            this.Cost = Cost;
            this.Water = Water;
            this.Milk = Milk;
            this.Beans = Beans;
        }
    }


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
                coffeeChoose(scanner.nextInt());
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

    private void coffeeTypes(int COST, int WATER, int MILK, int BEANS, int CUPS) {
        availableMoney += COST;
        if (availableCoffeeWater - WATER < 0) {
            System.out.println("Sorry, not enough water!");
        }
        else {
            availableCoffeeWater -= WATER;
        }

        if (availableCoffeeMilk - MILK < 0) {
            System.out.println("Sorry, not enough milk!");
        }
        else {
            availableCoffeeMilk -= MILK ;
        }

        if (availableCoffeeBeans - BEANS < 0) {
            System.out.println("Sorry, not enough beans!");
        }
        else {
            availableCoffeeBeans -= BEANS;
        }

        if (availableCoffeeCups - CUPS < 0) {
            System.out.println("Sorry, not enough cups!");
        }
        else {
            availableCoffeeCups -= CUPS;
        }
        System.out.println("I have enough resources, making you a coffee!");
    }

    private void coffeeChoose(int type) {
        if (type == 1) {
            coffeeTypes(Coffee.ESPRESSO.Cost, Coffee.ESPRESSO.Water, Coffee.ESPRESSO.Milk, Coffee.ESPRESSO.Beans, Coffee.ESPRESSO.Cups);
        }
        else if (type == 2) {
            coffeeTypes(Coffee.LATTE.Cost, Coffee.LATTE.Water, Coffee.LATTE.Milk, Coffee.LATTE.Beans, Coffee.LATTE.Cups);
        }
        else if (type == 3) {
            coffeeTypes(Coffee.CAPPUCCINO.Cost, Coffee.CAPPUCCINO.Water, Coffee.CAPPUCCINO.Milk, Coffee.CAPPUCCINO.Beans, Coffee.CAPPUCCINO.Cups);
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
package nix.education.java.coffeemachine;
import java.util.Scanner;



class CoffeeMachine {

    enum coffeeReq {
        reqCups(1),
        espressoCost(4),
        espressoWater(250),
        espressoMilk(0),
        espressoBeans(16),
        latteCost(7),
        latteWater(350),
        latteMilk(75),
        latteBeans(20),
        cappuccinoCost(6),
        cappuccinoWater(200),
        cappuccinoMilk(100),
        cappuccinoBeans(12);

        private int req;
        coffeeReq(int req) {
            this.req = req;
        }
        public int getReq() {
            return req;
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
                availableMoney += coffeeReq.espressoCost.getReq();
                if (availableCoffeeWater - coffeeReq.espressoWater.getReq() < 0) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else {
                    availableCoffeeWater -= coffeeReq.espressoWater.getReq();
                }

                if (availableCoffeeBeans - coffeeReq.espressoBeans.getReq() < 0) {
                    System.out.println("Sorry, not enough beans!");
                    break;
                } else {
                    availableCoffeeBeans -= coffeeReq.espressoBeans.getReq();
                }

                if (availableCoffeeCups - coffeeReq.reqCups.getReq() < 0) {
                    System.out.println("Sorry, not enough cups!");
                    break;
                } else {
                    availableCoffeeCups -= coffeeReq.reqCups.getReq();
                }
                System.out.println("I have enough resources, making you a coffee!");
                break;
            case 2:
                availableMoney += coffeeReq.latteCost.getReq();
                if (availableCoffeeWater - coffeeReq.latteWater.getReq() < 0) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else {
                    availableCoffeeWater -= coffeeReq.latteWater.getReq();
                }
                if (availableCoffeeMilk - coffeeReq.latteMilk.getReq() < 0) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                } else {
                    availableCoffeeMilk -= coffeeReq.latteMilk.getReq();
                }

                if (availableCoffeeBeans - coffeeReq.latteBeans.getReq() < 0) {
                    System.out.println("Sorry, not enough beans!");
                    break;
                } else {
                    availableCoffeeBeans -= coffeeReq.latteBeans.getReq();
                }

                if (availableCoffeeCups - coffeeReq.reqCups.getReq() < 0) {
                    System.out.println("Sorry, not enough cups!");
                    break;
                } else {
                    availableCoffeeCups -= coffeeReq.reqCups.getReq();
                }
                System.out.println("I have enough resources, making you a coffee!");
                break;
            case 3:
                availableMoney += coffeeReq.cappuccinoCost.getReq();
                if (availableCoffeeWater - coffeeReq.cappuccinoWater.getReq() < 0) {
                    System.out.println("Sorry, not enough water!");
                    break;
                } else {
                    availableCoffeeWater -= coffeeReq.cappuccinoWater.getReq();
                }
                if (availableCoffeeMilk - coffeeReq.cappuccinoMilk.getReq() < 0) {
                    System.out.println("Sorry, not enough milk!");
                    break;
                } else {
                    availableCoffeeMilk -= coffeeReq.cappuccinoMilk.getReq();
                }

                if (availableCoffeeBeans - coffeeReq.cappuccinoBeans.getReq() < 0) {
                    System.out.println("Sorry, not enough beans!");
                    break;
                } else {
                    availableCoffeeBeans -= coffeeReq.cappuccinoBeans.getReq();
                }

                if (availableCoffeeCups - coffeeReq.reqCups.getReq() < 0) {
                    System.out.println("Sorry, not enough cups!");
                    break;
                } else {
                    availableCoffeeCups -= coffeeReq.reqCups.getReq();
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
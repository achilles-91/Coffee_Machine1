package machine;
import java.util.Scanner;
import static machine.Drink.*;

enum Drink {

    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    private final int water;
    private final int milk;
    private final int coffeeBeans;
    private final int money;

    Drink(int water, int milk, int coffeeBeans, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.money = money;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffeeBeans() {
        return coffeeBeans;
    }

    public int getMoney() {
        return money;
    }
}


public class CoffeeMachine {
    enum MachineState {
        OFF, MAIN, BUYING, FILL_WATER, FILL_MILK,
        FILL_COFFEE_BEANS, FILL_DISPOSABLE_CUPS,
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);

        while (machine.isWorking()) {
            machine.execute(scanner.next());
        }
    }


    private MachineState state;
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;

    public CoffeeMachine(int water, int milk, int coffeeBeans, int disposableCups, int money) {
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.disposableCups = disposableCups;
        this.money = money;
        setMainState();
    }

    public boolean isWorking() {
        return state != MachineState.OFF;
    }

    public void execute(String input) {
        switch (state) {
            case MAIN:
                setState(input);
                break;
            case BUYING:
                handleBuying(input);
                setMainState();
                break;
            case FILL_WATER:
                this.water += Integer.parseInt(input);
                System.out.println("Write how many ml of milk do you want to add:");
                state = MachineState.FILL_MILK;
                break;
            case FILL_MILK:
                this.milk += Integer.parseInt(input);
                System.out.println("Write how many grams of coffee beans do you want to add:");
                state = MachineState.FILL_COFFEE_BEANS;
                break;
            case FILL_COFFEE_BEANS:
                this.coffeeBeans += Integer.parseInt(input);
                System.out.println("Write how many disposable cups of coffee do you want to add:");
                state = MachineState.FILL_DISPOSABLE_CUPS;
                break;
            case FILL_DISPOSABLE_CUPS:
                this.disposableCups += Integer.parseInt(input);
                setMainState();
                break;
            default:
                break;
        }
    }


    private void setState(String command) {
        switch (command) {
            case "remaining":
                printState();
                setMainState();
                break;
            case "buy":
                System.out.println("What do you want to buy? 1 - espresso, " +
                        "2 - latte, 3 - cappuccino, back - to main menu:");
                state = MachineState.BUYING;
                break;
            case "fill":
                System.out.println("Write how many ml of water do you want to add:");
                state = MachineState.FILL_WATER;
                break;
            case "take":
                giveMoney();
                setMainState();
                break;
            case "exit":
                state = MachineState.OFF;
                break;
            default:
                System.out.println("Unexpected action.");
                setMainState();
        }
    }

    public void handleBuying(String input) {
        Drink recipe;

        switch (input) {
            case "back":
                state = MachineState.MAIN;
                return;
            case "1":
                recipe = ESPRESSO;
                break;
            case "2":
                recipe = LATTE;
                break;
            case "3":
                recipe = CAPPUCCINO;
                break;
            default:
                System.out.println("Unexpected option.");
                return;
        }
        makeCoffee(recipe);
        acceptPayment(recipe.getMoney());
    }


    public void makeCoffee(Drink recipe) {
        if (this.water < recipe.getWater()) {
            System.out.println("Sorry, not enough water!");
            return;
        }

        if (this.milk < recipe.getMilk()) {
            System.out.println("Sorry, not enough milk!");
            return;
        }

        if (this.coffeeBeans < recipe.getCoffeeBeans()) {
            System.out.println("Sorry, not enough coffee beans");
            return;
        }

        if (this.disposableCups < 1) {
            System.out.println("Sorry, not enough disposable cups");
            return;
        }

        this.water -= recipe.getWater();
        this.milk -= recipe.getMilk();
        this.coffeeBeans -= recipe.getCoffeeBeans();
        this.disposableCups--;
        System.out.println("I have enough resources, making you a coffee!");
    }


    private void acceptPayment(int price) {
        this.money += price;
    }


    private void printState() {
        String amount = "\nThe coffee machine has:\n" + this.water + " of water\n" +
                this.milk + " of milk\n" + this.coffeeBeans + " of coffee beans\n" + this.disposableCups +
                " of disposable cups\n$" + this.money + " of money";
        System.out.println(amount);
    }


    private void setMainState() {
        state = MachineState.MAIN;
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
    }


    private void giveMoney() {
        System.out.println("I gave you $" + money);
        this.money = 0;
    }
}
//    private void setWater(int water) {
//        this.water = water;
//    }
//
//    private void setMilk(int milk) {
//        this.milk = milk;
//    }
//
//    private void setCoffeeBeans(int coffeeBeans) {
//        this.coffeeBeans = coffeeBeans;
//    }
//
//    private void setDisposableCups(int disposableCups) {
//        this.disposableCups = disposableCups;
//    }
//
//    private void setMoney(int money) {
//        this.money = money;
//    }






//    private void printAmount() {
//        String amount = "\nThe coffee machine has:\n" + this.water + " of water\n" +
//                this.milk + " of milk\n" + this.coffeeBeans + " of coffee beans\n" + this.disposableCups +
//                " of disposable cups\n$" + this.money + " of money";
//        System.out.println(amount);
//    }


//    public static void main(String[] args) {
//        CoffeeMachine coffeeMachine = new CoffeeMachine();
//
//        boolean loopOn = true;
//        while (loopOn) {
//            System.out.println("Write action (buy, fill, take, remaining, exit):");
//            String option = scanner.next();
//
//            switch (option) {
//                case "buy":
//                    coffeeMachine.buy();
//                    break;
//
//                case "fill":
//                    coffeeMachine.toFill();
//                    break;
//
//                case "take":
//                    coffeeMachine.takeMoney();
//                    break;
//
//                case "remaining":
//                    coffeeMachine.printAmount();
//                    break;
//
//                case "exit":
//                    loopOn = false;
//                    break;
//            }
//            System.out.println();
//        }
//
//    }


//    private void toFill() {
//        System.out.println("Write how many ml of water do you want to add:");
//        this.water += scanner.nextInt();
//        System.out.println("Write how many ml of milk do you want to add:");
//        this.milk += scanner.nextInt();
//        System.out.println("Write how many grams of coffee beans do you want to add:");
//        this.coffeeBeans += scanner.nextInt();
//        System.out.println("Write how many disposable cups of coffee do you want to add:");
//        this.disposableCups += scanner.nextInt();
//    }


//    private void buy() {
//        System.out.println();
//        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
//        String buyChoice = scanner.next();
//
//        if (!isOutOfResources(buyChoice)) {
//            switch (buyChoice) {
//                case "1":
//                    setWater(this.water - 250);
//                    setCoffeeBeans(this.coffeeBeans - 16);
//                    setDisposableCups(this.disposableCups - 1);
//                    setMoney(this.money + 4);
//                    break;
//
//                case "2":
//                    setWater(this.water - 350);
//                    setCoffeeBeans(this.coffeeBeans - 20);
//                    setMilk(this.milk - 75);
//                    setDisposableCups(this.disposableCups - 1);
//                    setMoney(this.money + 7);
//                    break;
//
//                case "3":
//                    setMoney(this.money + 6);
//                    setWater(this.water - 200);
//                    setMilk(this.milk - 100);
//                    setCoffeeBeans(this.coffeeBeans - 12);
//                    setDisposableCups(this.disposableCups - 1);
//                    break;
//
//                case "back":
//                    break;
//            }
//        } else {
//            return;
//        }
//    }



//    private boolean isOutOfResources(String coffee) {
//        String noWater = "Sorry, not enough water!";
//        String noMilk = "Sorry, not enough milk!";
//        String noCoffeeBeans = "Sorry, not enough coffee beans!";
//        String noDisposableCups = "Sorry, not enough disposable cups!";
//        String enoughResources = "I have enough resources, making you a coffee!";
//
//        switch (coffee) {
//            case "1":
//                if (this.water - 250 < 0) {
//                    System.out.println(noWater);
//                    return true;
//                } else if (this.coffeeBeans - 16 < 0) {
//                    System.out.println(noCoffeeBeans);
//                    return true;
//                } else if (this.disposableCups - 1 < 0) {
//                    System.out.println(noDisposableCups);
//                    return true;
//                }
//                System.out.println(enoughResources);
//                return false;
//
//            case "2":
//                if (this.water - 350 < 0) {
//                    System.out.println(noWater);
//                    return true;
//                } else if (this.milk - 75 < 0) {
//                    System.out.println(noMilk);
//                    return true;
//                } else if (this.coffeeBeans - 20 < 0) {
//                    System.out.println(noCoffeeBeans);
//                    return true;
//                } else if (this.disposableCups - 1 < 0) {
//                    System.out.println(noDisposableCups);
//                    return true;
//                }
//                System.out.println(enoughResources);
//                return false;
//
//            case "3":
//                if (this.water - 200 < 0) {
//                    System.out.println(noWater);
//                    return true;
//                } else if (this.milk - 100 < 0) {
//                    System.out.println(noMilk);
//                    return true;
//                } else if (this.coffeeBeans - 12 < 0) {
//                    System.out.println(noCoffeeBeans);
//                    return true;
//                } else if (this.disposableCups - 1 < 0) {
//                    System.out.println(noDisposableCups);
//                    return true;
//                }
//                System.out.println(enoughResources);
//                return false;
//
//            default:
//                return false;
//        }
//    }






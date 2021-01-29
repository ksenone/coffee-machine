package com.machine;

import java.util.Scanner;

public class CoffeeMachineFunctionality {
    static int money = 550;
    static int mlOfWater = 400;
    static int mlOfMilk = 540;
    static int grOfCoffee = 120;
    static int amountOfCups = 9;

    static void printMachinesState() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d of water\n", mlOfWater);
        System.out.printf("%d of milk\n", mlOfMilk);
        System.out.printf("%d of coffee beans\n", grOfCoffee);
        System.out.printf("%d of disposable cups\n", amountOfCups);
        System.out.printf("$%d of money\n\n", money);
    }

    public static void printTheActions() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }

    public static StatesOfTheMachine chooseTheAction(String input) {
        return switch (input) {
            case "buy" -> StatesOfTheMachine.BUYING_COFFEE;
            case "fill" -> StatesOfTheMachine.FILLING;
            case "take" -> StatesOfTheMachine.TAKING_MONEY;
            case "remaining" -> StatesOfTheMachine.REMAINING;
            default -> StatesOfTheMachine.EXIT;
        };

    }

    public static void printCoffeeVariants() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino," +
                           " back - to main menu:");
    }

    public static void chooseTheCoffee(String input) {
        switch (input) {
            case "1" -> makeEspresso();
            case "2" -> makeLatte();
            case "3" -> makeCappuccino();
            case "back" -> System.out.println();
        }
    }

    static void makeEspresso() {
        if (mlOfWater < 250) {
            System.out.println("Sorry, not enough water!\n");
        } else if (grOfCoffee < 16) {
            System.out.println("Sorry, not enough coffee beans!\n");
        } else if (amountOfCups < 1) {
                System.out.println("Sorry, not enough cups!\n");
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            amountOfCups -= 1;
            mlOfWater -= 250;
            grOfCoffee -= 16;
            money += 4;
        }
    }

    static void makeLatte() {
        if (mlOfWater < 350) {
            System.out.println("Sorry, not enough water!\n");
        } else if (mlOfMilk < 75) {
            System.out.println("Sorry, not enough milk!\n");
        } else if (grOfCoffee < 20) {
            System.out.println("Sorry, not enough coffee beans!\n");
        } else if (amountOfCups < 1) {
            System.out.println("Sorry, not enough cups!\n");
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            amountOfCups -= 1;
            mlOfWater -= 350;
            mlOfMilk -= 75;
            grOfCoffee -= 20;
            money += 7;
        }
    }

    static void makeCappuccino() {
        if (mlOfWater < 200) {
            System.out.println("Sorry, not enough water!\n");
        } else if (mlOfMilk < 100) {
            System.out.println("Sorry, not enough milk!\n");
        } else if (grOfCoffee < 12) {
            System.out.println("Sorry, not enough coffee beans!\n");
        } else if (amountOfCups < 1) {
            System.out.println("Sorry, not enough cups!\n");
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            amountOfCups -= 1;
            mlOfWater -= 200;
            mlOfMilk -= 100;
            grOfCoffee -= 12;
            money += 6;
        }
    }

    public static void printFillingWater() {
        System.out.println("\nWrite how many ml of water do you want to add:");
    }

    public static void printFillingMilk() {
        System.out.println("Write how many ml of milk do you want to add:");
    }

    public static void printFillingBeans() {
        System.out.println("Write how many grams of coffee beans do you want to add:");
    }

    public static void printFillingCups() {
        System.out.println("Write how many disposable cups of coffee do you want to add:");
    }

    public static void takeMoney() {
        System.out.println("\nI gave you $" + money + "\n");
        money = 0;
    }
}

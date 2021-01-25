package com.machine;

import java.util.Scanner;

public class CoffeeMachine {
    static int money = 550;
    static int mlOfWater = 400;
    static int mlOfMilk = 540;
    static int grOfCoffee = 120;
    static int amountOfCups = 9;

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            switch (chooseTheAction()) {
                case "buy":
                    buyCoffee();
                    break;
                case "fill":
                    fillTheMachine();
                    break;
                case "take":
                    takeMoney();
                    break;
                case "remaining":
                    printMachinesState();
                    break;
                case "exit":
                    exit = true;
                    break;
            }
        }
    }

    static void printMachinesState() {
        System.out.println("\nThe coffee machine has:");
        System.out.printf("%d of water\n", mlOfWater);
        System.out.printf("%d of milk\n", mlOfMilk);
        System.out.printf("%d of coffee beans\n", grOfCoffee);
        System.out.printf("%d of disposable cups\n", amountOfCups);
        System.out.printf("$%d of money\n\n", money);
    }

    static String chooseTheAction() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        return sc.next();
    }

    static void buyCoffee() {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        Scanner sc = new Scanner(System.in);
        switch (sc.next()) {
            case "1":
                makeEspresso();
                break;
            case "2":
                makeLatte();
                break;
            case "3":
                makeCappuccino();
                break;
            case "back":
                break;
        }
    }

    static void makeEspresso() {
        if (mlOfWater < 250) {
            System.out.println("Sorry, not enough water!\n");
        } else if (grOfCoffee < 16) {
            System.out.println("Sorry, not enough coffee beans!\n");
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
        } else {
            System.out.println("I have enough resources, making you a coffee!\n");
            amountOfCups -= 1;
            mlOfWater -= 200;
            mlOfMilk -= 100;
            grOfCoffee -= 12;
            money += 6;
        }
    }

    static void fillTheMachine() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nWrite how many ml of water do you want to add:");
        mlOfWater += sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        mlOfMilk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        grOfCoffee += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        amountOfCups += sc.nextInt();
        System.out.println();
    }

    static void takeMoney() {
        System.out.println("\nI gave you $" + money + "\n");
        money = 0;
    }
}

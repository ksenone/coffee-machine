package com.machine;

import java.util.Scanner;

import static com.machine.CoffeeMachineFunctionality.*;

public class CoffeeMachine {
    static StatesOfTheMachine state = StatesOfTheMachine.CHOOSING_THE_ACTION;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (state != StatesOfTheMachine.EXIT) {
            switch (state) {
                case CHOOSING_THE_ACTION -> {
                    printTheActions();
                    processUserInput(sc.next());
                }
                case BUYING_COFFEE -> {
                    printCoffeeVariants();
                    processUserInput(sc.next());
                }
                case REMAINING -> {
                    printMachinesState();
                    state = StatesOfTheMachine.CHOOSING_THE_ACTION;
                }
                case TAKING_MONEY -> {
                    takeMoney();
                    state = StatesOfTheMachine.CHOOSING_THE_ACTION;
                }
                case FILLING -> state = StatesOfTheMachine.FILLING_WATER;
                case FILLING_WATER -> {
                    printFillingWater();
                    processUserInput(sc.next());
                }
                case FILLING_MILK -> {
                    printFillingMilk();
                    processUserInput(sc.next());
                }
                case FILLING_BEANS -> {
                    printFillingBeans();
                    processUserInput(sc.next());
                }
                case FILLING_CUPS -> {
                    printFillingCups();
                    processUserInput(sc.next());
                }
            }
        }
    }

    static void processUserInput(String input) {
        switch (state) {
            case CHOOSING_THE_ACTION -> state = chooseTheAction(input);
            case BUYING_COFFEE -> {
                chooseTheCoffee(input);
                state = StatesOfTheMachine.CHOOSING_THE_ACTION;
            }
            case FILLING_WATER -> {
                mlOfWater += Integer.parseInt(input);
                state = StatesOfTheMachine.FILLING_MILK;
            }
            case FILLING_MILK -> {
                mlOfMilk += Integer.parseInt(input);
                state = StatesOfTheMachine.FILLING_BEANS;
            }
            case FILLING_BEANS -> {
                grOfCoffee += Integer.parseInt(input);
                state = StatesOfTheMachine.FILLING_CUPS;
            }
            case FILLING_CUPS -> {
                amountOfCups += Integer.parseInt(input);
                System.out.println();
                state = StatesOfTheMachine.CHOOSING_THE_ACTION;
            }
        }
    }
}

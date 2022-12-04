package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import static model.entities.PrimeNumbers.*;

public class UI {

    private static final Scanner scanner = new Scanner(System.in);

    public static void execute() {

        System.out.printf("Find prime numbers (from), (to), (one), (next) specific number? or (exit)?%n");

        while (true) {
            try {
                String line = scanner.nextLine().toLowerCase();

                switch (line) {
                    case "from" -> {
                        System.out.print("Start number: ");
                        int startNumber = scanStartNumber();

                        System.out.print("End number: ");
                        int endNumber = scanEndNumber();
                        findFrom(startNumber, endNumber);
                    }
                    case "to" -> {
                        System.out.print("End number: ");
                        int endNumber = scanEndNumber();
                        findTo(endNumber);
                    }
                    case "one" -> {
                        System.out.print("Number: ");
                        int number = scanNumber();
                        findOne(number);
                    }
                    case "next" -> {
                        System.out.print("Start number: ");
                        int startNumber = scanStartNumber();

                        System.out.print("Next prime numbers: ");
                        int nextPrimeNumbers = scanNextPrimeNumbers();
                        findNext(startNumber, nextPrimeNumbers);
                    }
                    case "exit" -> System.exit(0);
                    default -> throw new InputMismatchException();
                }
            } catch (InputMismatchException ime) {
                System.out.println("Invalid command! Available commands are (from), (to), (one), (next) or (exit)");
                continue;
            }
            break;
        }
    }

    private static int scanStartNumber() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid value!");
            System.out.print("Start number: ");
            scanner.nextLine();
        }
        return Integer.parseInt(scanner.nextLine());
    }
    private static int scanEndNumber() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid value!");
            System.out.print("End number: ");
            scanner.nextLine();
        }
        return Integer.parseInt(scanner.nextLine());
    }
    private static int scanNumber() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid value!");
            System.out.print("Number: ");
            scanner.nextLine();
        }
        return Integer.parseInt(scanner.nextLine());
    }
    private static int scanNextPrimeNumbers() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid value!");
            System.out.print("Next prime numbers: ");
            scanner.nextLine();
        }
        return Integer.parseInt(scanner.nextLine());
    }
}

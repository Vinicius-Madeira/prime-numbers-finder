package application;

import java.util.Scanner;

import static model.entities.PrimeNumbers.*;

public class UI {

    public static void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Find prime numbers (from), (to), (one), (next) specific number? or (quit)?%n");
        String line = scanner.nextLine().toLowerCase();
        while (!line.equals("from") && !line.equals("to") && !line.equals("quit") && !line.equals("one") && !line.equals("next")) {
            System.out.println("Invalid command! Available commands are (from), (to), (one), (next) or (quit)");
            line = scanner.nextLine();
        }
        switch (line) {
            case "from" -> {
                System.out.print("Start number: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid value!");
                    System.out.print("Start number: ");
                    scanner.nextLine();
                }
                int startNumber = scanner.nextInt();
                scanner.nextLine();

                System.out.print("End number: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid value!");
                    System.out.print("End number: ");
                    scanner.nextLine();
                }
                int endNumber = scanner.nextInt();
                findFrom(startNumber, endNumber);
            }
            case "to" -> {
                System.out.print("End number: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid value!");
                    System.out.print("End number: ");
                    scanner.nextLine();
                }
                int endNumber = scanner.nextInt();
                findTo(endNumber);
            }
            case "one" -> {
                System.out.print("Number: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid value!");
                    System.out.print("Number: ");
                    scanner.nextLine();
                }
                int number = scanner.nextInt();
                findOne(number);
            }
            case "next" -> {
                System.out.print("Start number: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid value!");
                    System.out.print("Start number: ");
                    scanner.nextLine();
                }
                int startNumber = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Next prime numbers: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid value!");
                    System.out.print("Next prime numbers: ");
                    scanner.nextLine();
                }
                int nextPrimeNumbers = scanner.nextInt();
                findNext(startNumber, nextPrimeNumbers);
            }
            case "quit" -> System.exit(0);
            default -> throw new RuntimeException("An unknown error has occurred.");
        }
        scanner.close();
    }
}

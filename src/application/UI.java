package application;

import java.util.Scanner;

import static model.entities.PrimeNumbers.*;


public class UI {

    public static void execute(Scanner scanner) {
        System.out.printf("Find prime numbers (from), (to), (one), (next) specific number? or (quit)?%n");
        String line = scanner.nextLine().toLowerCase();
        while (!line.equals("from") && !line.equals("to") && !line.equals("quit") && !line.equals("one") && !line.equals("next")) {
            System.out.println("Invalid command! Available commands are (from), (to), (one), (next) or (quit)");
            line = scanner.nextLine();
        }
        switch (line) {
            case "from" -> {
                System.out.print("From number: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid value!");
                    System.out.print("From number: ");
                    scanner.nextLine();
                }
                int fromNumber = scanner.nextInt();
                scanner.nextLine();

                System.out.print("To number: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid value!");
                    System.out.print("To number: ");
                    scanner.nextLine();
                }
                int toNumber = scanner.nextInt();
                from(fromNumber, toNumber);
            }
            case "to" -> {
                System.out.print("To number: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid value!");
                    System.out.print("To number: ");
                    scanner.nextLine();
                }
                int toNumber = scanner.nextInt();
                to(toNumber);
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
                System.out.print("From number: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid value!");
                    System.out.print("From number: ");
                    scanner.nextLine();
                }
                int fromNumber = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Next prime numbers: ");
                while (!scanner.hasNextInt()) {
                    System.out.println("Invalid value!");
                    System.out.print("Next prime numbers: ");
                    scanner.nextLine();
                }
                int nextPrimeNumbers = scanner.nextInt();
                findNext(fromNumber, nextPrimeNumbers);
            }
            case "quit" -> System.exit(0);
            default -> throw new RuntimeException("An unknown error has occurred.");
        }
    }
}

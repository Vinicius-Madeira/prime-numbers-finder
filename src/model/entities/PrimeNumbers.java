package model.entities;

import java.util.*;
import java.util.stream.Collectors;

public class PrimeNumbers {

    public static final Integer[] initialPN = {2, 3};

    private static Set<Integer> set = new LinkedHashSet<>(Arrays.asList(initialPN));

    public static void execute(Scanner scanner) {
        System.out.printf("Find prime numbers (from) a specific number?%nFind prime numbers (to) a specific number? or (quit)?%n");
        String line = scanner.nextLine().toLowerCase();
        while (!line.equals("from") && !line.equals("to") && !line.equals("quit")) {
            System.out.println("Invalid command! Available commands are (from), (to) or (quit)");
            line = scanner.nextLine();
        }
        switch (line) {
            case "from" -> {
                System.out.print("From number: ");
                int fromNumber = scanner.nextInt();
                System.out.print("To number: ");
                int toNumber = scanner.nextInt();
                toNumber += fromNumber;
                from(fromNumber, toNumber);
            }
            case "to" -> {
                System.out.print("To number: ");
                int toNumber = scanner.nextInt();
                to(toNumber);
            }
            case "quit" -> System.exit(0);
            default -> throw new RuntimeException("An unknown error has occurred");
        }
    }

    private static void to(int toNumber) {
        if (toNumber <= 1) {
            throw new IllegalArgumentException("Can't find prime numbers prior to one");
        }
        findAll(toNumber);
        printList(set.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new)));
    }

    private static void from(int fromNumber, int toNumber) {
        if (fromNumber <= 0) {
            throw new IllegalArgumentException("Can't find prime numbers from a negative number or zero");
        }
        findAll(toNumber);
        printList(set.stream().filter(x -> x > fromNumber).sorted().collect(Collectors.toCollection(LinkedHashSet::new)));
    }

    private static void findAll(int toNumber) {

        for (int i=1; i<toNumber; i++) {
            for (int j=1; j<3; j++) {
                int n = j == 1 ? 6*i-1 : 6*i+1;

                if (n > toNumber) {
                    break;
                }
                if (PrimeNumbers.validation(n, set)) {
                    set.add(n);
                }
            }
        }
    }

    public static boolean validation(int number, Set<Integer> list) {
        if (list.isEmpty()) {
            throw new IllegalStateException();
        }
        for (Integer primeNumber : list) {
            if (number % primeNumber == 0) {
                return false;
            }
        }
        return true;
    }

    public static void printList(Set<Integer> list) {
        for (Integer number : list) {
            System.out.printf("Prime Number: %d%n", number);
        }
    }
}
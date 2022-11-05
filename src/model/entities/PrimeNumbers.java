package model.entities;

import java.util.*;
import java.util.stream.Collectors;

public class PrimeNumbers {

    private static final Integer[] initialPN = {2, 3};

    private static final Set<Integer> set = new LinkedHashSet<>(Arrays.asList(initialPN));



    public static void to(int toNumber) {
        if (toNumber <= 1) {
            throw new IllegalArgumentException("Cannot find prime numbers prior to one.");
        }
        findAll(toNumber);
        printList(set.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new)));
    }

    public static void from(int fromNumber, int toNumber) {
        if (fromNumber <= 0) {
            throw new IllegalArgumentException("Cannot find prime numbers from negative numbers or zero.");
        }
        if (toNumber < fromNumber) {
            throw new IllegalArgumentException("Prime numbers out of reach. Cannot traverse to an endpoint lower than the starting point.");
        }
        findAll(toNumber);
        set.removeIf(x -> x < fromNumber);
        printList(set.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new)));
        count();
    }

    public static void findOne(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("There are no prime number below or equal to zero.");
        }
        findAll(number);
        if (set.stream().anyMatch(x -> x == number)) {
            System.out.println(number + " is a prime number!");
        }
        else {
            System.out.println(number + " is NOT a prime number!");
        }
    }

    public static void findNext(int fromNumber, int nextPrimeNumbers) {
        if (fromNumber <= 0) {
            throw new IllegalArgumentException("Cannot find prime numbers from negative numbers or zero.");
        }
        if (nextPrimeNumbers <= 0) {
            throw new IllegalArgumentException("Only positive numbers are allowed.");
        }
        int count;
        // if from number = 1/2/3, the numbers already contained in the Set are not going to be counted, resulting in inconsistent 1 or 2 extra Prime numbers to be printed.

        switch (fromNumber) {
            case 1, 2 -> count = 2;
            case 3 -> count = 1;
            default -> count = 0;
        }

        for (int i = 1; i < 10000; i++) {
            for (int j = 1; j <= 2; j++) {
                int n = j == 1 ? 6 * i - 1 : 6 * i + 1;

                if (count == nextPrimeNumbers) {
                    break;
                }
                else if (count > nextPrimeNumbers) {
                    set.remove(3);
                    break;
                }

                if (n >= fromNumber) {
                    if (PrimeNumbers.validate(n)) {
                        set.add(n);
                        count++;
                    }
                }
            }
        }
        set.removeIf(x -> x < fromNumber);
        printList(set.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new)));
        count();
    }

    private static void findAll(int toNumber) {

        for (int i=1; i<toNumber; i++) {
            for (int j=1; j<3; j++) {
                int n = j == 1 ? 6*i-1 : 6*i+1;

                if (n > toNumber) {
                    break;
                }
                if (PrimeNumbers.validate(n)) {
                    set.add(n);
                }
            }
        }
    }

    private static void count() {
        System.out.println("Total of " + set.size() + " prime numbers.");
    }

    private static boolean validate(int number) {
        if (set.isEmpty()) {
            throw new IllegalStateException("Cannot iterate an empty list.");
        }
        for (Integer primeNumber : set) {
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
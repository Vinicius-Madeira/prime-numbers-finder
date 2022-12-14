package model.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumbers {

    private static final Integer[] initialPrimeNumbers = {2, 3};

    private static final List<Integer> listOfPrimeNumbers = new ArrayList<>(Arrays.asList(initialPrimeNumbers));
    private static final List<Integer> listOfAllPrimeNumbers = new ArrayList<>(Arrays.asList(initialPrimeNumbers));

    public static void findTo(int endNumber) {
        if (endNumber < 1) {
            throw new IllegalArgumentException("Cannot find prime numbers prior to one.");
        }
        switch (endNumber) {
            case 1 -> listOfAllPrimeNumbers.clear();
            case 2 -> listOfAllPrimeNumbers.remove(3);
            default -> {
                findAll(endNumber);
                printList(listOfAllPrimeNumbers);
            }
        }
    }

    public static void findFrom(int startNumber, int endNumber) {
        if (startNumber <= 0) {
            throw new IllegalArgumentException("Cannot find prime numbers from negative numbers or zero.");
        }
        if (endNumber < startNumber) {
            throw new IllegalArgumentException("Prime numbers out of reach. Cannot traverse to an endpoint lower than the starting point.");
        }
        if (startNumber == 1 && endNumber == 2 || startNumber == 2 && endNumber == 2) {
            listOfAllPrimeNumbers.remove(3);
        }
        findAll(endNumber);
        listOfAllPrimeNumbers.removeIf(x -> x < startNumber);
        printList(listOfAllPrimeNumbers);
    }

    public static void findOne(int number) {
        if (number <= 0) throw new IllegalArgumentException("There are no prime number below or equal to zero.");

        findAll(number);
        if (listOfAllPrimeNumbers.stream().anyMatch(x -> x == number)) {
            System.out.println(number + " is a prime number!");
        }
        else {
            System.out.println(number + " is NOT a prime number!");
        }
    }

    public static void findNext(int startNumber, int nextPrimeNumbers) {
        if (startNumber <= 0) {
            throw new IllegalArgumentException("Cannot find prime numbers from negative numbers or zero.");
        }
        if (nextPrimeNumbers <= 0) {
            throw new IllegalArgumentException("Only positive numbers are allowed.");
        }
        int count;
        // if 'start number' = 1/2, the numbers already contained in the List are not going to be counted, resulting in an inconsistent extra Prime number to be printed.

        switch (startNumber) {
            case 1 -> count = 2;
            case 2 -> count = 1;
            default -> count = 0;
        }

        findAllNext(startNumber, nextPrimeNumbers, count);
        listOfAllPrimeNumbers.removeIf(x -> x <= startNumber);
        printList(listOfAllPrimeNumbers);
    }

    private static void findAllNext(int startNumber, int nextPrimeNumbers, int count) {

        for (int i=2, index=1; ; i++) {
            int n = i / 2;
            int probeNumber = (i % 2 == 0) ? (6 * n - 1) : (6 * n + 1);

            if (count == nextPrimeNumbers) return;
            else if (count > nextPrimeNumbers) {
                listOfAllPrimeNumbers.remove(3);
                return;
            }
            if (probeNumber == listOfAllPrimeNumbers.get(index) * listOfAllPrimeNumbers.get(index)) {
                index++;
                listOfPrimeNumbers.add(listOfAllPrimeNumbers.get(index));
            }
            if (validate(probeNumber)) {
                listOfAllPrimeNumbers.add(probeNumber);
                if (index == 1) {
                    index = listOfAllPrimeNumbers.indexOf(probeNumber);
                    listOfPrimeNumbers.add(probeNumber);
                }
                if (probeNumber > startNumber) {
                    count++;
                }
            }
        }
    }

    private static void findAll(int endNumber) {

        for (int i=2, index=1; ; i++) {
            int n = i / 2;
            int probeNumber = (i % 2 == 0) ? (6 * n - 1) : (6 * n + 1);

            if (probeNumber > endNumber) return;
            if (probeNumber == listOfAllPrimeNumbers.get(index) * listOfAllPrimeNumbers.get(index)) {
                index++;
                listOfPrimeNumbers.add(listOfAllPrimeNumbers.get(index));
            }
            if (validate(probeNumber)) {
                listOfAllPrimeNumbers.add(probeNumber);
                if (index == 1) {
                    index = listOfAllPrimeNumbers.indexOf(probeNumber);
                    listOfPrimeNumbers.add(probeNumber);
                }

            }
        }
    }

    private static boolean validate(int probeNumber) {

        for (int i=1; i < listOfPrimeNumbers.size(); i++) {
            if (probeNumber % listOfPrimeNumbers.get(i) == 0) {
                return false;
            }
        }
        return true;
    }

    private static void count() {
        System.out.println("Total of " + listOfAllPrimeNumbers.size() + " prime numbers.");
    }

    public static void printList(List<Integer> list) {
        for (Integer number : list) {
            System.out.printf("Prime Number: %d%n", number);
        }
        count();
    }
}
/*
    private static boolean validateOld(int probeNumber) {
        if (listOfPrimeNumbers.isEmpty()) {
            throw new IllegalStateException("Cannot iterate an empty list.");
        }
        for (Integer primeNumber : listOfPrimeNumbers) {
            if (probeNumber % primeNumber == 0) {
                return false;
            }
        }
        return true;
    }*/
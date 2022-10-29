package model.entities;

import java.util.List;

public class PrimeNumbers {

    public static final Integer[] initialPN = {2, 3};

    public static boolean validation(int number, List<Integer> list) {
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

    public static void printList(List<Integer> list) {
        for (Integer number : list) {
            System.out.printf("Prime Number: %d%n", number);
        }
    }

    public static void printNumber(int number) {
        System.out.printf("Prime number: %d%n", number);
    }

}
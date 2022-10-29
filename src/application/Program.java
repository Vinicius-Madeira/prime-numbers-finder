package application;

import model.entities.PrimeNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>(Arrays.asList(PrimeNumbers.initialPN));

        System.out.print("Enter a limit number: ");
        int limit = sc.nextInt();

        PrimeNumbers.printList(list);

        for (int i=1; i<100; i++) {

            int number = 6 * i - 1;

            if (number < limit  && PrimeNumbers.validation(number, list)) {
                    list.add(number);
                    PrimeNumbers.printNumber(number);
                }

            number = 6 * i + 1;
            if (number < limit && PrimeNumbers.validation(number, list)) {
                list.add(number);
                PrimeNumbers.printNumber(number);
            }
        }
        sc.close();
    }
}

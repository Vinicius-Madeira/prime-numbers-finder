package application;

import model.entities.PrimeNumbers;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UI.execute(sc);

        sc.close();
    }
}

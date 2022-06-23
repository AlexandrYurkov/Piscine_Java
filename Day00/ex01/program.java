package ex01;

import java.util.Scanner;

public class program {
    private static int var = 2;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n <= 1) {
            System.out.println("Illegal Argument");
            System.exit(-1);
        } else {
            checkIsItANaturalNumber(n);
        }
    }
    private static void checkIsItANaturalNumber(int n) {
            if (n % var != 0) {
                var++;
                checkIsItANaturalNumber(n);
            } else if (n % var == 0) {
                printIsItNaturalNumber(var, n);
            }
    }
    private static void printIsItNaturalNumber(int var, int n) {
        if (var == n) {
            System.out.println("True " + var);
        } else {
            System.out.println("False " + var);
        }
    }
}

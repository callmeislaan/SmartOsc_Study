package com.fitech;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

public class Main {
    // get first char of "Hello world"
    public static char getFirstChar(String string) {
        return string.charAt(0);
    }

    // get last char of "Hello world"
    public static char getLastChar(String string) {
        return string.charAt(string.length() - 1);
    }

    // compute large number
    public static BigInteger powLargeNumber(int x, int n) {
        BigInteger bigX = new BigInteger(String.valueOf(x));
        return bigX.pow(n);
    }

    // print the numbers from n to 0
    public static void countDown(int n) {
        for (int i = n; i >= 0; i--) {
            System.out.print(i + " ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // computing the product of the Unicode codes of all letters
    public static long convertingLettersToUnicode(String string) {
        long result = 1;
        for (char c :
                string.toCharArray()) {
            result *= c;
        }
        return result;
    }


    public static long convertingLettersToUnicodeByRecursive(String string) {
        System.out.println(string);
        if (string.length() == 1) {
            return (long) string.charAt(0);
        } else {
            return  convertingLettersToUnicodeByRecursive(string)
                    * convertingLettersToUnicodeByRecursive(string.substring(0, string.length()-1));
        }
    }

    // Selects first n elements
    public static String take(String string, int n) {
        return string.substring(0, n);
    }

    // Selects last n elements
    public static String takeRight(String string, int n) {
        int len = string.length();
        return string.substring(len - n, len);
    }

    // Selects all elements except first n ones
    public static String drop(String string, int n) {
        return string.substring(n);
    }

    // Selects all elements except last n ones
    public static String dropRight(String string, int n) {
        return string.substring(0, string.length() - n);
    }

    public static void main(String[] args) {
        int choose;
        String string;
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("------Menu------");
        System.out.println("0. get first character");
        System.out.println("1. get last character");
        System.out.println("2. pow a big number");
        System.out.println("3. count down");
        System.out.println("4. convert letters to unicode");
        System.out.println("5. convert letters to unicode by recursive");
        System.out.println("6. take string");
        System.out.println("7. take right string");
        System.out.println("8. drop string");
        System.out.println("9. drop right string");
        System.out.println("10. exit");
        do {
            System.out.println("enter your choose: ");
            choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 0:
                    System.out.println("enter string: ");
                    System.out.println(getFirstChar(sc.nextLine()));
                    break;
                case 1:
                    System.out.println("enter string: ");
                    System.out.println(getLastChar(sc.nextLine()));
                    break;
                case 2:
                    System.out.println("enter x: ");
                    int x = sc.nextInt();
                    System.out.println("enter n: ");
                    int n = sc.nextInt();
                    System.out.println("result: " + powLargeNumber(x, n));
                    break;
                case 3:
                    System.out.println("enter number: ");
                    countDown(sc.nextInt());
                    break;
                case 4:
                    System.out.println("enter string: ");
                    System.out.println(convertingLettersToUnicode((sc.nextLine())));
                    break;
                case 5:
                    System.out.println("enter string: ");
                    System.out.println(convertingLettersToUnicodeByRecursive((sc.nextLine())));
                    break;
                case 6:
                    System.out.println("enter string: ");
                    string = sc.nextLine();
                    System.out.println("enter number: ");
                    num = sc.nextInt();
                    System.out.println(take(string, num));
                    break;
                case 7:
                    System.out.println("enter string: ");
                    string = sc.nextLine();
                    System.out.println("enter number: ");
                    num = sc.nextInt();
                    System.out.println(takeRight(string, num));
                    break;
                case 8:
                    System.out.println("enter string: ");
                    string = sc.nextLine();
                    System.out.println("enter number: ");
                    num = sc.nextInt();
                    System.out.println(drop(string, num));
                    break;
                case 9:
                    System.out.println("enter string: ");
                    string = sc.nextLine();
                    System.out.println("enter number: ");
                    num = sc.nextInt();
                    System.out.println(dropRight(string, num));
                    break;
                case 10:
                    break;
                default:
                    break;
            }
        } while (choose != 10);
    }
}

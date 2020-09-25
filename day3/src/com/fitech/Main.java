package com.fitech;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int choose;
        double inches;
        double miles;
        double gallons;
        do {
            System.out.println("---Menu---");
            System.out.println("0. Exit");
            System.out.println("1. Bai 1");
            System.out.println("2. Bai 2");
            System.out.println("3. Bai 3");
            System.out.println("4. Bai 4");
            System.out.println("5. Bai 5");
            System.out.println("6. Bai 6");
            System.out.println("your choose: ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("enter amount of inches: ");
                    inches = sc.nextDouble();
                    System.out.println(inches + " inches = " + Conversions.inchesToCentimeters(inches) + " centimeters");
                    System.out.println("enter amount of gallons: : ");
                    gallons = sc.nextDouble();
                    System.out.println(gallons + " gallons = " + Conversions.gallonsToLiters(gallons) + " liters");
                    System.out.println("enter amount of miles: ");
                    miles = sc.nextDouble();
                    System.out.println(miles + " miles = " + Conversions.milesToKilometers(miles) + " kilometers");
                    break;
                case 2:
                    System.out.println("enter amount of inches: ");
                    inches = sc.nextDouble();
                    System.out.println(inches + " inches = " + new InchesToCentimeters().conversion(inches) + " centimeters");
                    System.out.println("enter amount of gallons: : ");
                    gallons = sc.nextDouble();
                    System.out.println(gallons + " gallons = " + new GallonsToLiters().conversion(gallons) + " liters");
                    System.out.println("enter amount of miles: ");
                    miles = sc.nextDouble();
                    System.out.println(miles + " miles = " + new MilesToKilometers().conversion(miles) + " kilometers");
                    break;
                case 3:
                    int c;
                    BankAccount checkingAccount = new CheckingAccount();
                    accountAction(sc, checkingAccount);
                    break;
                case 4:
                    BankAccount savingAccount = new SavingAccount();
                    accountAction(sc, savingAccount);
                    break;
                case 5:
                    sc.nextLine();
                    System.out.println("Enter name of point: ");
                    String name = sc.nextLine();
                    System.out.println("Enter x: ");
                    double x = sc.nextDouble();
                    System.out.println("Enter y: ");
                    double y = sc.nextDouble();
                    Point labeledPoint = new LabeledPoint(name, x, y);
                    System.out.println(labeledPoint.toString());
                    break;
                case 6:
                    Shape rectangle = new Rectangle();
                    Shape circle = new Circle();
                    System.out.println("Enter x: ");
                    x = sc.nextDouble();
                    System.out.println("Enter y: ");
                    y = sc.nextDouble();
                    System.out.println("center point of rectangle: "
                            + rectangle.centerPoint(new Point(x, y)));
                    System.out.println("center point of circle: "
                            + circle.centerPoint(new Point(x, y)));
                    break;
                default:break;
            }
        } while (choose != 0);
    }

    private static void accountAction(Scanner sc, BankAccount savingAccount) {
        int c;
        do {
            System.out.println("Enter 0 to exit");
            System.out.println("Enter 1 to deposit");
            System.out.println("Enter 2 to withdrawal");
            System.out.println("Enter 3 to watch your balance");
            System.out.println("Please enter a number: ");
            c = sc.nextInt();
            switch (c) {
                case 0: break;
                case 1:
                    System.out.println("enter amount: ");
                    savingAccount.deposit(sc.nextDouble());
                    System.out.println(savingAccount.toString());
                    break;
                case 2:
                    System.out.println("enter amount: ");
                    savingAccount.withdrawal(sc.nextDouble());
                    System.out.println(savingAccount.toString());
                    break;
                case 3:
                    System.out.println(savingAccount.toString());
                    break;
            }
        } while (c != 0);
    }
}

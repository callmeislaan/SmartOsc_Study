package com.fitech;

import java.util.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static int[] getRandomArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Random().nextInt(n + 1);
        }
        return a;
    }

    public static void swapTwoNumber(int[] a, int index1, int index2) {
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    // swaps adjacent elements of an array of integers
    public static void swapAdjacentElements(int[] a) {
        int i = 0;
        int n = a.length;
        while (i < n - 1) {
            swapTwoNumber(a, i, i + 1);
            i += 2;
        }
    }

    // produce a new array that contains all positive
    // values of the original array, in their original order, followed by all values that
    // are zero or negative, in their original order
    public static int[] separatePositiveAndNegative(int[] a) {
        int j = 0;
        for (int i = j + 1; i < a.length; i++) {
            if (a[i] > 0) {
                swapTwoNumber(a, i, j);
                j++;
            }
        }
        return a;
    }

    // compute the average of a array
    public static double computeAverage(double[] a) {
        double sum = 0;
        for (double element :
                a) {
            sum += element;
        }
        return sum / a.length;
    }

    // rearrange elements of a array
    public static void reverseSort(Integer[] a) {
        Arrays.sort(a, Collections.reverseOrder());
    }

    // produces all values from an array with duplicates removed
    public static Integer[] copyDuplicatesRemoved(Integer[] a) {
        HashSet<Integer> integerHashSet = new HashSet<>(Arrays.asList(a));
        return integerHashSet.toArray(new Integer[]{});
    }

    // collection of all time zones in America
    public static String[] getAllTimeZonesInAmerica() {
        List<String> result = new ArrayList<>();
        for (String timezone :
                TimeZone.getAvailableIDs()) {
            if (timezone.startsWith("America")) {
                result.add(timezone.split("/")[1]);
            }
        }
        return result.toArray(new String[]{});
    }

    public static int[] inputInt() {
        System.out.println("enter length of array: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("enter element : ");
            a[i] = sc.nextInt();
        }
        return a;
    }

    public static Integer[] inputInteger() {
        System.out.println("enter length of array: ");
        int n = sc.nextInt();
        Integer[] ar = new Integer[n];
        for (int i = 0; i < n; i++) {
            System.out.println("enter element : ");
            ar[i] = sc.nextInt();
        }
        return ar;
    }

    public static void main(String[] args) {
        int choose = 0;
        int n = 0;
        int[] a;
        Integer[] ar;
        Time time;
        do {
            System.out.println("------Menu------");
            System.out.println("1. create a random array");
            System.out.println("2. swaps adjacent elements of an array");
            System.out.println("3. separate positive and negative");
            System.out.println("4. compute average of array");
            System.out.println("5. reverse sorted order");
            System.out.println("6. copy with duplicates removed");
            System.out.println("7. collection of all time zones in America");
            System.out.println("8. bank account");
            System.out.println("9. time");
            System.out.println("10. compute minutes");
            System.out.println("11. Person name");
            System.out.println("0. exit");
            System.out.println("enter your choose: ");
            choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("enter n: ");
                    System.out.println(Arrays.toString(getRandomArray(sc.nextInt())));
                    break;
                case 2:
                    System.out.println("enter n: ");
                    a = getRandomArray(sc.nextInt());
                    System.out.println("Original array: " + Arrays.toString(a));
                    swapAdjacentElements(a);
                    System.out.println("after array: " + Arrays.toString(a));
                    break;
                case 3:
                    a = inputInt();
                    System.out.println("Original array: " + Arrays.toString(a));
                    System.out.println("after array: " + Arrays.toString(separatePositiveAndNegative(a)));
                    break;
                case 4:
                    System.out.println("enter length of array: ");
                    n = sc.nextInt();
                    double[] d = new double[n];
                    for (int i = 0; i < n; i++) {
                        System.out.println("enter element : ");
                        d[i] = sc.nextInt();
                    }
                    System.out.println("Original array: " + Arrays.toString(d));
                    System.out.println("average of array: " + computeAverage(d));
                    break;
                case 5:
                    ar = inputInteger();
                    System.out.println("Original array: " + Arrays.toString(ar));
                    reverseSort(ar);
                    System.out.println("average of array: " + Arrays.toString(ar));
                    break;
                case 6:
                    ar = inputInteger();
                    System.out.println("Original array: " + Arrays.toString(ar));
                    ar = copyDuplicatesRemoved(ar);
                    System.out.println("average of array: " + Arrays.toString(ar));
                    break;
                case 7:
                    System.out.println("All of timezones in America: " + Arrays.toString(getAllTimeZonesInAmerica()));
                    break;
                case 8:
                    BankAccount bankAccount = new BankAccount();
                    System.out.println(bankAccount.toString());
                    break;
                case 9:
                     time = new Time();
                     int fh, fm, sh, sm;
                    do {
                        System.out.println("enter hour: ");
                        fh = sc.nextInt();
                        System.out.println("enter minute: ");
                        fm = sc.nextInt();
                    } while (!Time.check(fh, fm));
                    do {
                        System.out.println("enter hour: ");
                        sh = sc.nextInt();
                        System.out.println("enter minute: ");
                        sm = sc.nextInt();
                    } while (!Time.check(sh, sm));
                    time.setHours(fh);
                    time.setMinutes(fm);
                    System.out.println("second time before first time: " + time.before(new Time(sh, sm)));
                    break;
                case 10:
                    time = new Time();
                    int h, m;
                    do {
                    System.out.println("enter hour: ");
                    h = sc.nextInt();
                    System.out.println("enter minute: ");
                    m = sc.nextInt();
                    } while (!Time.check(h, m));
                    time.setHours(h);
                    time.setMinutes(m);
                    System.out.println("total minutes from 0:0 to " + time.getHours() + ":"
                            + time.getMinutes() + " is : " + time.computeTotalMinutes());
                    break;
                case 11:
                    sc.nextLine();
                    System.out.println("enter full name: ");
                    String name = sc.nextLine();
                    Person person = new Person(name);
                    System.out.println(person.toString());
                    break;
                case 0:
                    break;
                default:
                    break;
            }
        } while(choose != 0);
    }
}

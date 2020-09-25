import java.util.Scanner;

public class OverTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your choose: ");
        String choose = sc.nextLine();
        sc.close();
        switch (choose) {
            case "1":
                break;
            case "2":
            case "3":
                System.out.println(3);
                break;
            case "4":
            default:
                System.out.println("default");
        }
    }
}
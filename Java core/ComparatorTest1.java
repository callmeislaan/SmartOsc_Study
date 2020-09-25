import java.util.*;

public class ComparatorTest1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();

        int n = sc.nextInt();
        int m = sc.nextInt();
        int max = 0;

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            deque.add(num);
            set.add(num);
            if (deque.size() == m) {
                if (set.size() > max) {
                    max = set.size();
                }
                int first = deque.remove();
                if (!set.contains(first))
                    set.remove(first);
            }
        }
        System.out.println(max);
    }
}

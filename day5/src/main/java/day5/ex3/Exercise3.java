package day5.ex3;

import java.util.List;

public class Exercise3<T extends Comparable<T>> {
    public T findMax(List<T> t, int begin, int end) {
        T max = t.get(begin);
        for (int i = begin+1; i < end; i++) {
            if (t.get(i).compareTo(max) > 0)
                max = t.get(i);
        }
        return max;
    }
}

package Lab12.prob2;

import java.util.List;

public class Small {
    public static <T extends Comparable<? super T>> T secondSmallest(List<T> list) {
        if (list.size() < 2) throw new IllegalArgumentException("Need at least 2 elements");

        T first = null, second = null;

        for (T elem : list) {
            if (first == null || elem.compareTo(first) < 0) {
                second = first;
                first = elem;
            } else if (second == null || elem.compareTo(second) < 0) {
                second = elem;
            }
        }
        return second;
    }
}

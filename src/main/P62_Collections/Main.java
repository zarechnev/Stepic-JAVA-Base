package P62_Collections;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>();
        a.add(1);
        a.add(2);
        a.add(3);

        Set<Integer> b = new HashSet<>();
        b.add(0);
        b.add(1);
        b.add(2);

        System.out.println(
                symmetricDifference(a, b)
        );
    }

    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        Set<T> summ = new HashSet<>(set1);
        summ.addAll(set2);

        Set<T> dub = new HashSet<>(summ);
        dub.retainAll(set1);
        dub.retainAll(set2);

        summ.removeAll(dub);

        return summ;
    }
}

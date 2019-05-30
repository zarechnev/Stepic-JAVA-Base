package P64_Stream_API;

import java.util.*;


public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "UTF-8")
                .useDelimiter("[^\\p{L}\\p{Digit}]+");

        Map<String, Long> mapFromIn = new HashMap<>();

        scanner.forEachRemaining(s -> mapFromIn.merge(s.toLowerCase(), 1L, Long::sum));

        mapFromIn.entrySet()
                .stream()
                .sorted(myComparator())
                .limit(10)
                .map(Map.Entry::getKey)
                .forEach(System.out::println);
    }

    private static Comparator<Map.Entry<String, Long>> myComparator(){
        return Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue)
                .reversed()
                .thenComparing(Map.Entry::getKey);
    }
}

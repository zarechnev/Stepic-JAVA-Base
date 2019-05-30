package temp;

import java.util.Arrays;
import java.util.stream.IntStream;


public class Main1 {
    public static void main(String[] args) {
        IntStream ans = pseudoRandomStream(13);

        Arrays.stream(ans.getClass().getMethods())
                .filter(x -> x.toString().endsWith("Stream()"))
                .forEach(System.out::println);
    }

    public static IntStream pseudoRandomStream(int initialVal) {
        IntStream ans = IntStream.iterate(initialVal, x -> (x*x / 10) % 1000);
        return ans;
    }

}

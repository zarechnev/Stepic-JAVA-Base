package P64_Stream_API;

import java.util.stream.IntStream;


public class Main1 {
    public static void main(String[] args) {
        IntStream ans = pseudoRandomStream(13);
        ans.limit(10).forEach(System.out::println);
    }

    public static IntStream pseudoRandomStream(int initialVal) {
        IntStream ans = IntStream.iterate(initialVal, x -> (x*x / 10) % 1000);
        return ans;
    }

}

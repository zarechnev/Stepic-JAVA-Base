package P62_Collections2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        while (in.hasNext())
                integerList.add(in.nextInt());

        for (int i = integerList.size() - 1; i > 0; i--){
            if (i % 2 == 1)
                System.out.print(integerList.get(i) + " ");
        }
    }
}

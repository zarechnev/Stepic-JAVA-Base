package P53_Stream1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Double realList = new Double(0);
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            try {
                realList += (Double.parseDouble(in.next()));
            } catch (Exception e) {
                continue;
            }
        }

        System.out.print(String.format("%.6f",realList));
    }
}

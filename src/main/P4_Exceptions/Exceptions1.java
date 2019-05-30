package P4_Exceptions;

public class Exceptions1 {
    public static void main(String[] args) {

        class A{
        }

        A a;

        Object b;

        b = new Integer(2);

        // a = (A) b; - тест на выбрасывание исключения

        System.out.println(sqrt(3.3));
        System.out.println(sqrt(-43.3));

    }

    public static double sqrt(double x) {
        if (x < 0) {
            throw new IllegalArgumentException("Expected non-negative number, got " + x);
        } else {
            return Math.sqrt(x);
        }
    }
}

import java.util.function.DoubleUnaryOperator;

public class AbstractLeftRectangle {
    public static void main(String[] args) {
        System.out.println(integrate(y -> y*2+5.5/y, 2, 10));
        System.out.println(integrate(x -> 1, 0, 10));
    }

    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        double step = (b - a) / 10000000;
        double ans = 0;
        double x = a;

        while (x < b) {
            ans += f.applyAsDouble(x) * step;
            x += step;
        }
        return ans;
    }
}

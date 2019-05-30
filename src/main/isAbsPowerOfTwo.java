
public class isAbsPowerOfTwo {
    public static void main(String[] args) {
        isPowerOfTwo(-2);
    }

    /**
     * Checks if given <code>value</code> is a power of two.
     *
     * @param value any number
     * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
     */
    public static boolean isPowerOfTwo(int value) {
        if (Integer.bitCount(Math.abs(value)) == 1) return true;

        return false; // you implementation here
    }
}

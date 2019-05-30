public class Polindrom {
    public static void main(String[] args) {
        System.out.println(Polindrom.isPalindrome("Madam, I'm Adam!"));
    }

    /**
     * Checks if given <code>text</code> is a palindrome.
     *
     * @param text any string
     * @return <code>true</code> when <code>text</code> is a palindrome, <code>false</code> otherwise
     */
    public static boolean isPalindrome(String text) {
        text = text.replaceAll("[^a-zA-Zа-яА-Я0-9]", "").toLowerCase();

        String a = new StringBuilder(text).reverse().toString();

        if (text.equals(a)){
            return true; // your implementation here
        } else {
            return false; // your implementation here
        }
    }
}

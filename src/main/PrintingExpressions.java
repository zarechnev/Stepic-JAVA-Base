public class PrintingExpressions {
    public static void main(String[] args) {
        System.out.println("A" + ('\t' + '\u0003'));
        System.out.println('A' + "12");
        System.out.println("A" + 12);
        System.out.println('A' + '1' + "2");
    }
}

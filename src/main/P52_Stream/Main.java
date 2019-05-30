package P52_Stream;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        convert(System.in, System.out);
    }

    public static void convert(InputStream in, OutputStream out) throws IOException {
        int a = in.read();
        int b;
        while (a != -1) {
            b = in.read();
            if (!(b == 10 && a == 13)) { out.write(a); }
            a = b;
        }
        out.flush();
    }
}

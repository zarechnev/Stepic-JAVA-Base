package P53_Stream;

import java.nio.charset.Charset;

public class Temp {

    public static void main(String[] args)  {
        for (byte iByte: "Ы".getBytes(Charset.forName("UTF8"))) {
            System.out.println(Byte.toUnsignedInt(iByte));
        }
    }
}

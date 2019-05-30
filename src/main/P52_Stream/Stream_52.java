package P52_Stream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Stream_52 {
    public static void main(String[] args) throws IOException {
        System.out.println(checkSumOfStream(new ByteArrayInputStream(new byte[] {})));
        System.out.println(checkSumOfStream(new ByteArrayInputStream(new byte[] {0x33, 0x45, 0x01})));
    }

    public static int checkSumOfStream(InputStream inputStream) throws IOException {
        int a = inputStream.read();
        int ans = 0;
        while (a != -1) {
            int unSigByte = (byte) a & 0xFF;
            ans = Integer.rotateLeft(ans, 1) ^ unSigByte;
            a =  inputStream.read();
        }
        return ans;
    }
}

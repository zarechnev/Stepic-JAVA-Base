package P53_Stream;

import java.io.*;
import java.nio.charset.Charset;

public class First {

    public static void main(String[] args) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[]{48, 49, 50, 51});
        String ans = readAsString(byteArrayInputStream, Charset.forName("ASCII"));
        System.out.println(ans);
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        String ans;

        Writer writer = new StringWriter();
        Reader reader = new InputStreamReader(inputStream, charset);

        int var;

        while ((var = reader.read()) != -1){
            writer.write(var);
        }

        ans = writer.toString();

        return ans;
    }
}

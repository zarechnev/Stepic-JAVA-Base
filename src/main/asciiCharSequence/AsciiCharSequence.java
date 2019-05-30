package asciiCharSequence;

public class AsciiCharSequence implements CharSequence {

    private byte[] bytes;

    public AsciiCharSequence(byte[] inByte){
        this.bytes = inByte.clone();
    }

    @Override
    public int length() {
        return this.bytes.length;
    }

    @Override
    public char charAt(int index) {
        return (char) this.bytes[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(java.util.Arrays.copyOfRange(this.bytes, start, end));
    }

    @Override
    public String toString(){
        return new String(this.bytes);
    }
}
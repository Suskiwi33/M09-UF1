package iticbcn.xifratge;
import java.util.Arrays;
public class TextXifrat {
    
    private byte[] data;

    public TextXifrat(byte[] data) {
        this.data = data;
    }

    public byte[] getBytes() {
        return data;
    }

    @Override
    public String toString() {
        return "TextXifrat: " + Arrays.toString(data);
    }
}

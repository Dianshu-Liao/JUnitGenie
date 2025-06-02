package org.apache.commons.codec.binary;
import org.apache.commons.codec.binary.BinaryCodec;
import org.apache.commons.codec.DecoderException;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class binary_BinaryCodec_decode_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testDecode_withCharArray() {
        BinaryCodec binaryCodec = new BinaryCodec();
        char[] input = new char[] {'A', 'B', 'C'};
        try {
            Object result = binaryCodec.decode(input);
            byte[] expected = {65, 66, 67}; // Corresponding byte values for 'A', 'B', 'C'
            assertArrayEquals(expected, (byte[]) result);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }
    
    @Test(timeout = 4000)
    public void testDecode_withEmptyCharArray() {
        BinaryCodec binaryCodec = new BinaryCodec();
        char[] input = new char[] {};
        try {
            binaryCodec.decode(input);
        } catch (DecoderException e) {
            // Expected exception for empty char array
            assert "argument not a byte array".equals(e.getMessage());
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
        }
    }   
    
    @Test(timeout = 4000)
    public void testDecode_withNull() {
        BinaryCodec binaryCodec = new BinaryCodec();
        Object result = binaryCodec.decode(null);
        assertArrayEquals(new byte[0], (byte[]) result);
    }

}
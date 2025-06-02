package org.apache.commons.codec.net;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.QCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class net_QCodec_doDecoding_byte_____cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testDoDecodingWithUnderscores() {
        QCodec codec = new QCodec();
        byte[] input = new byte[] { 'H', 'e', 'l', 'l', '_', 'W', 'o', 'r', 'l', 'd' };
        byte[] expectedOutput = new byte[] { 'H', 'e', 'l', 'l', ' ', 'W', 'o', 'r', 'l', 'd' };
        
        try {
            byte[] result = (byte[]) QCodec.class.getDeclaredMethod("doDecoding", byte[].class)
                    .invoke(codec, input);
            assertArrayEquals(expectedOutput, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDoDecodingWithoutUnderscores() {
        QCodec codec = new QCodec();
        byte[] input = new byte[] { 'H', 'e', 'l', 'l', ' ', 'W', 'o', 'r', 'l', 'd' };
        byte[] expectedOutput = new byte[] { 'H', 'e', 'l', 'l', ' ', 'W', 'o', 'r', 'l', 'd' };
        
        try {
            byte[] result = (byte[]) QCodec.class.getDeclaredMethod("doDecoding", byte[].class)
                    .invoke(codec, input);
            assertArrayEquals(expectedOutput, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDoDecodingWithNullInput() {
        QCodec codec = new QCodec();
        
        try {
            byte[] result = (byte[]) QCodec.class.getDeclaredMethod("doDecoding", byte[].class)
                    .invoke(codec, null);
            assertArrayEquals(null, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
package org.apache.commons.codec.net;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.QCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class net_QCodec_doDecoding_byte_____cfg_path_15_Test {

    @Test(timeout = 4000)
    public void testDoDecodingWithUnderscores() {
        QCodec codec = new QCodec();
        byte[] input = new byte[] { 72, 101, 95, 108, 111, 95, 87, 111, 114, 108, 100 }; // "He_lo_World" with underscores
        byte[] expectedOutput = new byte[] { 72, 101, 32, 108, 111, 32, 87, 111, 114, 108, 100 }; // "He lo World" with spaces

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
        byte[] input = new byte[] { 72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100 }; // "Hello World"
        byte[] expectedOutput = new byte[] { 72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100 }; // "Hello World"

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
        byte[] input = null;

        try {
            byte[] result = (byte[]) QCodec.class.getDeclaredMethod("doDecoding", byte[].class)
                    .invoke(codec, input);
            assertArrayEquals(null, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
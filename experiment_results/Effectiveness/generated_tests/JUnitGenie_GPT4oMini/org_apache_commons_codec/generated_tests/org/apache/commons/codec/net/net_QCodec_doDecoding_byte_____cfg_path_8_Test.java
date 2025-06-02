package org.apache.commons.codec.net;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.QCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import java.lang.reflect.Method;

public class net_QCodec_doDecoding_byte_____cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testDoDecodingWithUnderscores() {
        QCodec codec = new QCodec();
        byte[] input = new byte[] { 65, 66, 95, 67 }; // Contains underscore
        byte[] expectedOutput = new byte[] { 65, 66, 32, 67 }; // Expected output after replacing underscore with space

        try {
            Method method = QCodec.class.getDeclaredMethod("doDecoding", byte[].class);
            method.setAccessible(true);
            byte[] actualOutput = (byte[]) method.invoke(codec, input);
            assertArrayEquals(expectedOutput, actualOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDoDecodingWithoutUnderscores() {
        QCodec codec = new QCodec();
        byte[] input = new byte[] { 65, 66, 67 }; // No underscores
        byte[] expectedOutput = new byte[] { 65, 66, 67 }; // Expected output should be the same

        try {
            Method method = QCodec.class.getDeclaredMethod("doDecoding", byte[].class);
            method.setAccessible(true);
            byte[] actualOutput = (byte[]) method.invoke(codec, input);
            assertArrayEquals(expectedOutput, actualOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDoDecodingWithNullInput() {
        QCodec codec = new QCodec();
        byte[] input = null; // Null input
        byte[] expectedOutput = null; // Expected output should be null

        try {
            Method method = QCodec.class.getDeclaredMethod("doDecoding", byte[].class);
            method.setAccessible(true);
            byte[] actualOutput = (byte[]) method.invoke(codec, input);
            assertArrayEquals(expectedOutput, actualOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
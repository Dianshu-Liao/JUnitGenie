package org.apache.commons.codec.net;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.QCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import java.lang.reflect.Method;

public class net_QCodec_doDecoding_byte_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testDoDecodingWithUnderscores() {
        QCodec codec = new QCodec();
        byte[] input = new byte[] { 65, 95, 66 }; // A_B
        byte[] expectedOutput = new byte[] { 65, 32, 66 }; // A B

        try {
            Method method = QCodec.class.getDeclaredMethod("doDecoding", byte[].class);
            method.setAccessible(true);
            byte[] result = (byte[]) method.invoke(codec, input);
            assertArrayEquals(expectedOutput, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDoDecodingWithoutUnderscores() {
        QCodec codec = new QCodec();
        byte[] input = new byte[] { 65, 66 }; // AB
        byte[] expectedOutput = new byte[] { 65, 66 }; // AB

        try {
            Method method = QCodec.class.getDeclaredMethod("doDecoding", byte[].class);
            method.setAccessible(true);
            byte[] result = (byte[]) method.invoke(codec, input);
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
            Method method = QCodec.class.getDeclaredMethod("doDecoding", byte[].class);
            method.setAccessible(true);
            byte[] result = (byte[]) method.invoke(codec, input);
            assertArrayEquals(null, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
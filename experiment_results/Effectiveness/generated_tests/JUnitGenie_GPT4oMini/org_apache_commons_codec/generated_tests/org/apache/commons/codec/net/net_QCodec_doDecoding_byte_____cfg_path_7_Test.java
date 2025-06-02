package org.apache.commons.codec.net;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.QCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class net_QCodec_doDecoding_byte_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testDoDecodingWithUnderscores() {
        QCodec codec = new QCodec();
        byte[] input = new byte[] { 65, 95, 66 }; // A_B
        byte[] expectedOutput = new byte[] { 65, 32, 66 }; // A B
        try {
            byte[] result = invokeDoDecoding(codec, input);
            assertArrayEquals(expectedOutput, result);
        } catch (DecoderException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDoDecodingWithoutUnderscores() {
        QCodec codec = new QCodec();
        byte[] input = new byte[] { 65, 66 }; // AB
        byte[] expectedOutput = new byte[] { 65, 66 }; // AB
        try {
            byte[] result = invokeDoDecoding(codec, input);
            assertArrayEquals(expectedOutput, result);
        } catch (DecoderException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDoDecodingWithNullInput() {
        QCodec codec = new QCodec();
        byte[] input = null;
        try {
            byte[] result = invokeDoDecoding(codec, input);
            assertArrayEquals(null, result);
        } catch (DecoderException e) {
            e.printStackTrace();
        }
    }

    private byte[] invokeDoDecoding(QCodec codec, byte[] input) throws DecoderException {
        try {
            java.lang.reflect.Method method = QCodec.class.getDeclaredMethod("doDecoding", byte[].class);
            method.setAccessible(true);
            return (byte[]) method.invoke(codec, (Object) input);
        } catch (Exception e) {
            throw new DecoderException("Error invoking doDecoding", e);
        }
    }

}
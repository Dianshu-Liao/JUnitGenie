package org.apache.commons.codec.net;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.net.QCodec;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class net_QCodec_doDecoding_byte_____cfg_path_16_Test {

    @Test(timeout = 4000)
    public void testDoDecodingWithUnderscores() {
        QCodec codec = new QCodec();
        byte[] input = "Hello_World".getBytes(); // Example input with underscore
        byte[] expectedOutput = "Hello World".getBytes(); // Expected output after decoding

        try {
            // Accessing the protected method using reflection
            byte[] result = (byte[]) QCodec.class.getDeclaredMethod("doDecoding", byte[].class)
                    .invoke(codec, input);
            assertArrayEquals(expectedOutput, result);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception
        }
    }

    @Test(timeout = 4000)
    public void testDoDecodingWithoutUnderscores() {
        QCodec codec = new QCodec();
        byte[] input = "HelloWorld".getBytes(); // Example input without underscore
        byte[] expectedOutput = "HelloWorld".getBytes(); // Expected output after decoding

        try {
            // Accessing the protected method using reflection
            byte[] result = (byte[]) QCodec.class.getDeclaredMethod("doDecoding", byte[].class)
                    .invoke(codec, input);
            assertArrayEquals(expectedOutput, result);
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception
        }
    }

    @Test(timeout = 4000)
    public void testDoDecodingWithNullInput() {
        QCodec codec = new QCodec();
        byte[] input = null; // Null input

        try {
            // Accessing the protected method using reflection
            byte[] result = (byte[]) QCodec.class.getDeclaredMethod("doDecoding", byte[].class)
                    .invoke(codec, input);
            assertArrayEquals(null, result); // Expecting null output
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception
        }
    }

}
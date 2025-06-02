package org.apache.commons.codec.net;
import org.apache.commons.codec.net.BCodec;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class net_BCodec_doEncoding_byte_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testDoEncoding() {
        BCodec bCodec = new BCodec();
        byte[] input = "test".getBytes(); // Non-null byte array
        byte[] expectedOutput = Base64.encodeBase64(input); // Expected output from Base64 encoding

        try {
            Method method = BCodec.class.getDeclaredMethod("doEncoding", byte[].class);
            method.setAccessible(true); // Make the protected method accessible
            byte[] actualOutput = (byte[]) method.invoke(bCodec, input); // Invoke the method

            assertArrayEquals(expectedOutput, actualOutput); // Assert that the output is as expected
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception
        }
    }

    @Test(timeout = 4000)
    public void testDoEncodingWithNull() {
        BCodec bCodec = new BCodec();
        byte[] input = null; // Null input

        try {
            Method method = BCodec.class.getDeclaredMethod("doEncoding", byte[].class);
            method.setAccessible(true); // Make the protected method accessible
            byte[] actualOutput = (byte[]) method.invoke(bCodec, input); // Invoke the method

            assertArrayEquals(null, actualOutput); // Assert that the output is null
        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception
        }
    }

}
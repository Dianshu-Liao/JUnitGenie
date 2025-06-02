package org.apache.commons.codec.net;
import org.apache.commons.codec.net.BCodec;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.CodecPolicy;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class net_BCodec_doDecoding_byte_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testDoDecoding() {
        try {
            // Instantiate BCodec using the default constructor
            BCodec bCodec = new BCodec();

            // Prepare the input byte array for testing
            byte[] inputBytes = Base64.encodeBase64("test".getBytes());

            // Access the protected method doDecoding using reflection
            Method method = BCodec.class.getDeclaredMethod("doDecoding", byte[].class);
            method.setAccessible(true);

            // Invoke the method and get the result
            byte[] result = (byte[]) method.invoke(bCodec, inputBytes);

            // Assert that the result matches the expected output
            assertArrayEquals("Decoded bytes should match the original input", "test".getBytes(), result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testDoDecodingWithNullInput() {
        try {
            // Instantiate BCodec using the default constructor
            BCodec bCodec = new BCodec();

            // Access the protected method doDecoding using reflection
            Method method = BCodec.class.getDeclaredMethod("doDecoding", byte[].class);
            method.setAccessible(true);

            // Invoke the method with null input
            byte[] result = (byte[]) method.invoke(bCodec, (byte[]) null);

            // Assert that the result is null
            assertArrayEquals("Decoded bytes should be null for null input", null, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
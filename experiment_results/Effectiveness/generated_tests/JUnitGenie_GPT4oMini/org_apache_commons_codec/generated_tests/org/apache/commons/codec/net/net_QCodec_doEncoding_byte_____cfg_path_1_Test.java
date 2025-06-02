package org.apache.commons.codec.net;
import org.apache.commons.codec.net.QCodec;
import org.junit.Test;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import static org.junit.Assert.assertArrayEquals;

public class net_QCodec_doEncoding_byte_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testDoEncoding() {
        try {
            // Instantiate the QCodec class
            QCodec codec = new QCodec();

            // Prepare the input byte array
            byte[] input = "Hello World".getBytes();

            // Access the protected method doEncoding using reflection
            Method method = QCodec.class.getDeclaredMethod("doEncoding", byte[].class);
            method.setAccessible(true);

            // Invoke the method
            byte[] expectedOutput = new byte[] { 72, 101, 108, 108, 111, 95, 87, 111, 114, 108, 100 }; // Expected output after encoding
            byte[] actualOutput = (byte[]) method.invoke(codec, input);

            // Assert the output
            assertArrayEquals(expectedOutput, actualOutput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
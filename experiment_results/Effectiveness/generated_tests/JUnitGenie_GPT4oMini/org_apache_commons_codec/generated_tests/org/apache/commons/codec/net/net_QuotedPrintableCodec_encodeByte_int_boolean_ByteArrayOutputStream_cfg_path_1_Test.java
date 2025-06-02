package org.apache.commons.codec.net;
import org.apache.commons.codec.net.QuotedPrintableCodec;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class net_QuotedPrintableCodec_encodeByte_int_boolean_ByteArrayOutputStream_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEncodeByteWithEncoding() {
        try {
            // Prepare the parameters
            int b = 65; // ASCII for 'A'
            boolean encode = true;
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            // Access the private static method using reflection
            Method method = QuotedPrintableCodec.class.getDeclaredMethod("encodeByte", int.class, boolean.class, ByteArrayOutputStream.class);
            method.setAccessible(true);

            // Invoke the method
            int result = (int) method.invoke(null, b, encode, buffer);

            // Verify the result
            assertEquals(1, result);
            // Additional verification can be done on the buffer content if needed

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEncodeByteWithoutEncoding() {
        try {
            // Prepare the parameters
            int b = 65; // ASCII for 'A'
            boolean encode = false;
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            // Access the private static method using reflection
            Method method = QuotedPrintableCodec.class.getDeclaredMethod("encodeByte", int.class, boolean.class, ByteArrayOutputStream.class);
            method.setAccessible(true);

            // Invoke the method
            int result = (int) method.invoke(null, b, encode, buffer);

            // Verify the result
            assertEquals(1, result);
            // Verify that the buffer contains the byte
            assertEquals(1, buffer.size());
            assertEquals(b, buffer.toByteArray()[0]);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
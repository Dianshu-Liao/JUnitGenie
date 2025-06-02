package org.apache.commons.codec.net;
import org.apache.commons.codec.net.QCodec;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class net_QCodec_doEncoding_byte_____cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testDoEncodingWithNullInput() {
        QCodec codec = new QCodec(); // Using the default constructor
        byte[] result = null;

        try {
            // Accessing the protected method using reflection
            java.lang.reflect.Method method = QCodec.class.getDeclaredMethod("doEncoding", byte[].class);
            method.setAccessible(true);
            result = (byte[]) method.invoke(codec, (Object) null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertNull(result);
    }

}
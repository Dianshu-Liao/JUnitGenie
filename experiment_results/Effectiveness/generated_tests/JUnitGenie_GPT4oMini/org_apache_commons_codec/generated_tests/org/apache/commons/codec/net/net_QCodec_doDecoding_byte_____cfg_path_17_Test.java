package org.apache.commons.codec.net;
import org.apache.commons.codec.net.QCodec;
import org.apache.commons.codec.DecoderException;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class net_QCodec_doDecoding_byte_____cfg_path_17_Test {

    @Test(timeout = 4000)
    public void testDoDecoding_NullInput() {
        QCodec codec = new QCodec();
        byte[] result = null;
        try {
            // Accessing the protected method using reflection
            java.lang.reflect.Method method = QCodec.class.getDeclaredMethod("doDecoding", byte[].class);
            method.setAccessible(true);
            result = (byte[]) method.invoke(codec, (byte[]) null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertNull(result);
    }

}
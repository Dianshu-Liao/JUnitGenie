package org.apache.commons.codec.net;
import org.apache.commons.codec.net.BCodec;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNull;

public class net_BCodec_doEncoding_byte_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testDoEncoding_NullInput() {
        // Arrange
        BCodec bCodec = new BCodec();
        byte[] input = null;

        // Act
        byte[] result = null;
        try {
            Method method = BCodec.class.getDeclaredMethod("doEncoding", byte[].class);
            method.setAccessible(true);
            result = (byte[]) method.invoke(bCodec, input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Assert
        assertNull(result);
    }

}
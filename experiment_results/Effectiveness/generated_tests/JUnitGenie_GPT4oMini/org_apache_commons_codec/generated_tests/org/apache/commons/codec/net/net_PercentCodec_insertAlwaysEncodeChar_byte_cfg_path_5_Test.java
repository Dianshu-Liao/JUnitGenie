package org.apache.commons.codec.net;
import org.apache.commons.codec.net.PercentCodec;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class net_PercentCodec_insertAlwaysEncodeChar_byte_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testInsertAlwaysEncodeChar_ThrowsIllegalArgumentException() {
        PercentCodec percentCodec = new PercentCodec();
        byte testByte = -1; // This should trigger the exception

        try {
            // Accessing the private method using reflection
            Method method = PercentCodec.class.getDeclaredMethod("insertAlwaysEncodeChar", byte.class);
            method.setAccessible(true);
            method.invoke(percentCodec, testByte);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

}
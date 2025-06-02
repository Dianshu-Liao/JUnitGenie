package org.apache.commons.codec.net;
import org.apache.commons.codec.net.PercentCodec;
import org.junit.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class net_PercentCodec_insertAlwaysEncodeChar_byte_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testInsertAlwaysEncodeChar() {
        try {
            PercentCodec codec = new PercentCodec();
            Method method = PercentCodec.class.getDeclaredMethod("insertAlwaysEncodeChar", byte.class);
            method.setAccessible(true);

            // Test with a valid byte value
            byte validByte = 5;
            method.invoke(codec, validByte);
            // Verify the state of alwaysEncodeCharsMin and alwaysEncodeCharsMax
            // Assuming these methods are not available, we will use reflection to access the fields directly
            Field minField = PercentCodec.class.getDeclaredField("alwaysEncodeCharsMin");
            Field maxField = PercentCodec.class.getDeclaredField("alwaysEncodeCharsMax");
            minField.setAccessible(true);
            maxField.setAccessible(true);

            assertEquals(5, minField.get(codec));
            assertEquals(5, maxField.get(codec));

            // Test with another valid byte value
            byte anotherValidByte = 10;
            method.invoke(codec, anotherValidByte);
            assertEquals(5, minField.get(codec));
            assertEquals(10, maxField.get(codec));

        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInsertAlwaysEncodeCharThrowsException() {
        try {
            PercentCodec codec = new PercentCodec();
            Method method = PercentCodec.class.getDeclaredMethod("insertAlwaysEncodeChar", byte.class);
            method.setAccessible(true);

            // Test with an invalid byte value
            byte invalidByte = -1;
            method.invoke(codec, invalidByte);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

}
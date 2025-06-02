package org.apache.commons.codec.net;
import org.apache.commons.codec.net.PercentCodec;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.AccessibleObject;

public class net_PercentCodec_insertAlwaysEncodeChar_byte_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testInsertAlwaysEncodeChar_ValidInput() {
        PercentCodec percentCodec = new PercentCodec();
        byte input = 5;  // Valid byte input

        try {
            // Access the private method using reflection
            Method method = PercentCodec.class.getDeclaredMethod("insertAlwaysEncodeChar", byte.class);
            AccessibleObject.setAccessible(new AccessibleObject[] {method}, true);
            method.invoke(percentCodec, input);

            // Assert that alwaysEncodeCharsMin and alwaysEncodeCharsMax are updated correctly
            // We need to access these private variables via reflection as well
            int alwaysEncodeCharsMin = (Integer) PercentCodec.class.getDeclaredField("alwaysEncodeCharsMin").get(percentCodec);
            int alwaysEncodeCharsMax = (Integer) PercentCodec.class.getDeclaredField("alwaysEncodeCharsMax").get(percentCodec);
            
            assertEquals(5, alwaysEncodeCharsMin);
            assertEquals(5, alwaysEncodeCharsMax);

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | NoSuchFieldException e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInsertAlwaysEncodeChar_IllegalArgument() {
        PercentCodec percentCodec = new PercentCodec();
        byte input = -1;  // Invalid byte input to trigger exception

        try {
            // Access the private method using reflection
            Method method = PercentCodec.class.getDeclaredMethod("insertAlwaysEncodeChar", byte.class);
            AccessibleObject.setAccessible(new AccessibleObject[] {method}, true);
            method.invoke(percentCodec, input);
            fail("Expected IllegalArgumentException not thrown.");
        } catch (InvocationTargetException e) {
            assertTrue(e.getCause() instanceof IllegalArgumentException);
            assertEquals("byte must be >= 0", e.getCause().getMessage());
        } catch (NoSuchMethodException | IllegalAccessException e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

}
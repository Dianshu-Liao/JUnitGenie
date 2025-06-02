package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class ObjectUtils_mode_Object_____cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testModeWithEmptyArray() {
        // Given an empty array
        Object[] items = new Object[0];

        // When calling the mode method
        Object result = null;
        try {
            result = ObjectUtils.mode(items);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        // Then the result should be null
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testModeWithNullArray() {
        // Given a null array
        Object[] items = null;

        // When calling the mode method
        Object result = null;
        try {
            result = ObjectUtils.mode(items);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }

        // Then the result should be null
        assertNull(result);
    }

}
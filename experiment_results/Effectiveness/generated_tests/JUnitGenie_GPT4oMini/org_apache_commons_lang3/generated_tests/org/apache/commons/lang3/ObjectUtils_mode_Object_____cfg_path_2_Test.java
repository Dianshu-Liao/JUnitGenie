package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.mutable.MutableInt;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ObjectUtils_mode_Object_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testModeWithMultipleOccurrences() {
        Object[] items = {1, 2, 2, 3, 3, 3};
        Object result = ObjectUtils.mode(items);
        assertEquals(3, result);
    }

    @Test(timeout = 4000)
    public void testModeWithSingleOccurrence() {
        Object[] items = {1, 2, 3, 4};
        Object result = ObjectUtils.mode(items);
        assertEquals(1, result);
    }

    @Test(timeout = 4000)
    public void testModeWithNoItems() {
        Object[] items = {};
        Object result = ObjectUtils.mode(items);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testModeWithNullItems() {
        Object[] items = null;
        Object result = ObjectUtils.mode(items);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testModeWithEqualMaxOccurrences() {
        Object[] items = {1, 1, 2, 2};
        Object result = ObjectUtils.mode(items);
        assertEquals(null, result);
    }

    @Test(timeout = 4000)
    public void testModeWithMutableInt() {
        try {
            MutableInt mutableInt = new MutableInt(1);
            Object[] items = {mutableInt, mutableInt, new MutableInt(2)};
            Object result = ObjectUtils.mode(items);
            assertEquals(mutableInt, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}
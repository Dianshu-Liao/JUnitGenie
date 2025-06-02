package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.apache.commons.jxpath.Container;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class util_ValueUtils_setValue_Object_int_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSetValueWithArray() {
        Object array = new Integer[5];
        int index = 2;
        Object value = 10;

        try {
            ValueUtils.setValue(array, index, value);
            assertEquals(10, Array.get(array, index));
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetValueWithList() {
        List<Object> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int index = 1;
        Object value = 20;

        try {
            ValueUtils.setValue(list, index, value);
            assertEquals(20, list.get(index));
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSetValueWithCollection() {
        Collection<Object> collection = new HashSet<>(Arrays.asList(1, 2, 3));
        int index = 0;
        Object value = 30;

        try {
            ValueUtils.setValue(collection, index, value);
        } catch (UnsupportedOperationException e) {
            // Expected exception
            throw e;
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetValueWithNullCollection() {
        Object collection = null;
        int index = 0;
        Object value = 40;

        try {
            ValueUtils.setValue(collection, index, value);
            // No assertion needed, as the method should handle null gracefully
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }


}
package org.apache.commons.collections4;
import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.collections4.CollectionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class CollectionUtils_size_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testSize_withIterable() {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        
        int result = 0;
        try {
            result = CollectionUtils.size(list);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }

        assertEquals(3, result);
    }

    @Test(timeout = 4000)
    public void testSize_withNull() {
        int result = 0;
        try {
            result = CollectionUtils.size(null);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }

        assertEquals(0, result);
    }

    @Test(timeout = 4000)
    public void testSize_withEmptyIterable() {
        List<String> list = new ArrayList<>();
        
        int result = 0;
        try {
            result = CollectionUtils.size(list);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }

        assertEquals(0, result);
    }

    @Test(timeout = 4000)
    public void testSize_withSingleElement() {
        List<String> list = new ArrayList<>();
        list.add("one");
        
        int result = 0;
        try {
            result = CollectionUtils.size(list);
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }

        assertEquals(1, result);
    }

    @Test(timeout = 4000)
    public void testSize_withNonIterable() {
        Object nonIterableObject = new Object();
        
        int result = 0;
        try {
            result = CollectionUtils.size(nonIterableObject);
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Unsupported object type"));
            return; // Success, exception was thrown as expected
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
        
        fail("Expected IllegalArgumentException to be thrown");
    }

}
package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;

public class ObjectUtils_isEmpty_Object_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testIsEmptyWithNonEmptyMap() {
        try {
            // Create a non-empty map
            Map<String, String> nonEmptyMap = new HashMap<>();
            nonEmptyMap.put("key", "value");
            // Assert that isEmpty returns false
            assertFalse(ObjectUtils.isEmpty(nonEmptyMap));
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithEmptyMap() {
        try {
            // Create an empty map
            Map<String, String> emptyMap = new HashMap<>();
            // Assert that isEmpty returns true
            assertTrue(ObjectUtils.isEmpty(emptyMap));
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNull() {
        try {
            // Assert that isEmpty returns true for null
            assertTrue(ObjectUtils.isEmpty(null));
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithEmptyCollection() {
        try {
            // Create an empty collection
            Collection<String> emptyCollection = new ArrayList<>();
            // Assert that isEmpty returns true
            assertTrue(ObjectUtils.isEmpty(emptyCollection));
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsEmptyWithNonEmptyCollection() {
        try {
            // Create a non-empty collection
            Collection<String> nonEmptyCollection = new ArrayList<>();
            nonEmptyCollection.add("element");
            // Assert that isEmpty returns false
            assertFalse(ObjectUtils.isEmpty(nonEmptyCollection));
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        }
    }


}
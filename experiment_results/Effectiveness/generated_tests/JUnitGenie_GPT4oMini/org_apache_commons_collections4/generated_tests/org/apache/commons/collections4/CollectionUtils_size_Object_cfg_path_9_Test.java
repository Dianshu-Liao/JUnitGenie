package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class CollectionUtils_size_Object_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testSizeWithUnsupportedObjectType() {
        Object unsupportedObject = new Object(); // An unsupported type for testing
        try {
            CollectionUtils.size(unsupportedObject);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException ex) {
            assertEquals("Unsupported object type: java.lang.Object", ex.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSizeWithNull() {
        int result = CollectionUtils.size(null);
        assertEquals(0, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithMap() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        int result = CollectionUtils.size(map);
        assertEquals(2, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithCollection() {
        Collection<String> collection = new ArrayList<>();
        collection.add("element1");
        collection.add("element2");
        int result = CollectionUtils.size(collection);
        assertEquals(2, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithArray() {
        Object[] array = new Object[5];
        int result = CollectionUtils.size(array);
        assertEquals(5, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithIterator() {
        Iterator<String> iterator = Arrays.asList("a", "b", "c").iterator();
        int result = CollectionUtils.size(iterator);
        assertEquals(3, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithEnumeration() {
        Enumeration<String> enumeration = Collections.enumeration(Arrays.asList("x", "y", "z"));
        int result = CollectionUtils.size(enumeration);
        assertEquals(3, result);
    }


}
package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CollectionUtils_size_Object_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testSizeWithMap() {
        Map<String, String> map = Collections.singletonMap("key", "value");
        int result = CollectionUtils.size(map);
        assertEquals(1, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithCollection() {
        List<String> list = Collections.singletonList("element");
        int result = CollectionUtils.size(list);
        assertEquals(1, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithIterable() {
        Iterable<String> iterable = Collections.singleton("element")::iterator;
        int result = CollectionUtils.size(iterable);
        assertEquals(1, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithArray() {
        Object[] array = new Object[3];
        int result = CollectionUtils.size(array);
        assertEquals(3, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithIterator() {
        Iterator<String> iterator = Collections.singleton("element").iterator();
        int result = CollectionUtils.size(iterator);
        assertEquals(1, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithEnumeration() {
        Enumeration<String> enumeration = Collections.enumeration(Collections.singletonList("element"));
        int result = CollectionUtils.size(enumeration);
        assertEquals(1, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithUnsupportedObject() {
        Object unsupportedObject = new Object();
        try {
            CollectionUtils.size(unsupportedObject);
        } catch (IllegalArgumentException ex) {
            // Expected exception
            assertEquals("Unsupported object type: java.lang.Object", ex.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSizeWithNullObject() {
        int result = CollectionUtils.size(null);
        assertEquals(0, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithEmptyIterator() {
        Iterator<String> emptyIterator = Collections.emptyIterator();
        int result = CollectionUtils.size(emptyIterator);
        assertEquals(0, result);
    }

}
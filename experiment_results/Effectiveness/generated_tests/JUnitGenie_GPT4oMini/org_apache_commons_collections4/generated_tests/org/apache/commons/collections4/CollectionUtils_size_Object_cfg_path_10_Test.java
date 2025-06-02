package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.*;
import java.util.stream.Collectors;

public class CollectionUtils_size_Object_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testSizeWithMap() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        assertEquals(1, CollectionUtils.size(map));
    }

    @Test(timeout = 4000)
    public void testSizeWithCollection() {
        Collection<String> collection = new ArrayList<>();
        collection.add("element1");
        assertEquals(1, CollectionUtils.size(collection));
    }

    @Test(timeout = 4000)
    public void testSizeWithIterable() {
        Iterable<String> iterable = Arrays.asList("element1", "element2");
        assertEquals(2, CollectionUtils.size(iterable));
    }

    @Test(timeout = 4000)
    public void testSizeWithArray() {
        Object[] array = new Object[5];
        assertEquals(5, CollectionUtils.size(array));
    }

    @Test(timeout = 4000)
    public void testSizeWithIterator() {
        Iterator<String> iterator = Arrays.asList("element1", "element2").iterator();
        assertEquals(2, CollectionUtils.size(iterator));
    }

    @Test(timeout = 4000)
    public void testSizeWithEnumeration() {
        Enumeration<String> enumeration = new Vector<>(Arrays.asList("element1", "element2")).elements();
        assertEquals(2, CollectionUtils.size(enumeration));
    }

    @Test(timeout = 4000)
    public void testSizeWithUnsupportedObject() {
        try {
            CollectionUtils.size(new Object());
        } catch (IllegalArgumentException ex) {
            assertEquals("Unsupported object type: java.lang.Object", ex.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSizeWithNull() {
        assertEquals(0, CollectionUtils.size(null));
    }


}
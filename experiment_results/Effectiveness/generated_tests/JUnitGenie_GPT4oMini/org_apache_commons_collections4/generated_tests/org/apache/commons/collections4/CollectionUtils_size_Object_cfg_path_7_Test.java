package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.Enumeration;

public class CollectionUtils_size_Object_cfg_path_7_Test {
    
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
        Iterable<String> iterable = Arrays.asList("elem1", "elem2");
        assertEquals(2, CollectionUtils.size(iterable));
    }

    @Test(timeout = 4000)
    public void testSizeWithArray() {
        Object[] array = new Object[5];
        assertEquals(5, CollectionUtils.size(array));
    }

    @Test(timeout = 4000)
    public void testSizeWithIterator() {
        Iterator<String> iterator = Arrays.asList("item1", "item2").iterator();
        assertEquals(2, CollectionUtils.size(iterator));
    }

    @Test(timeout = 4000)
    public void testSizeWithEnumeration() {
        Vector<String> vector = new Vector<>();
        vector.add("item1");
        vector.add("item2");
        Enumeration<String> enumeration = vector.elements();
        assertEquals(2, CollectionUtils.size(enumeration));
    }

    @Test(timeout = 4000)
    public void testSizeWithUnsupportedType() {
        try {
            CollectionUtils.size(new Object()); // Unsupported type
        } catch (IllegalArgumentException ex) {
            assertEquals("Unsupported object type: java.lang.Object", ex.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSizeWithNull() {
        assertEquals(0, CollectionUtils.size(null));
    }


}
package org.apache.commons.collections4.bag;
import org.apache.commons.collections4.bag.AbstractMapBag;
import org.apache.commons.collections4.bag.AbstractMapBag.MutableInteger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class bag_AbstractMapBag_remove_Object_cfg_path_1_Test {

    private AbstractMapBag<Object> bag;

    // Concrete implementation of AbstractMapBag for testing
    private class TestMapBag extends AbstractMapBag<Object> {
        protected TestMapBag(Map<Object, MutableInteger> map) {
            super(map);
        }
    }

    @Before
    public void setUp() throws Exception {
        // Using reflection to access the protected constructor
        Constructor<TestMapBag> constructor = TestMapBag.class.getDeclaredConstructor(Map.class);
        constructor.setAccessible(true);
        Map<Object, MutableInteger> map = new HashMap<>();
        map.put("testObject", new MutableInteger(1));
        bag = constructor.newInstance(map);
    }

    @Test(timeout = 4000)
    public void testRemoveObjectExists() {
        boolean result = bag.remove("testObject");
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testRemoveObjectDoesNotExist() {
        boolean result = bag.remove("nonExistentObject");
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testRemoveUpdatesSizeAndModCount() {
        bag.remove("testObject");
        // Accessing private fields using reflection
        try {
            java.lang.reflect.Field sizeField = AbstractMapBag.class.getDeclaredField("size");
            sizeField.setAccessible(true);
            int size = (int) sizeField.get(bag);
            assertEquals(0, size);

            java.lang.reflect.Field modCountField = AbstractMapBag.class.getDeclaredField("modCount");
            modCountField.setAccessible(true);
            int modCount = (int) modCountField.get(bag);
            assertEquals(1, modCount);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
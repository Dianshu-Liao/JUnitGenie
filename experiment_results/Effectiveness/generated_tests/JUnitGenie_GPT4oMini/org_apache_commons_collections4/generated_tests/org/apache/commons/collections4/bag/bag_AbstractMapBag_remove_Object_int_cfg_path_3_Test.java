package org.apache.commons.collections4.bag;
import org.apache.commons.collections4.bag.AbstractMapBag;
import org.apache.commons.collections4.bag.AbstractMapBag.MutableInteger;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class bag_AbstractMapBag_remove_Object_int_cfg_path_3_Test {

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
        map.put("item1", new MutableInteger(5));
        bag = constructor.newInstance(map);
    }

    @Test(timeout = 4000)
    public void testRemoveWithValidObjectAndPositiveCopies() {
        boolean result = bag.remove("item1", 3);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testRemoveWithValidObjectAndZeroCopies() {
        boolean result = bag.remove("item1", 0);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testRemoveWithValidObjectAndNegativeCopies() {
        boolean result = bag.remove("item1", -1);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testRemoveWithNonExistentObject() {
        boolean result = bag.remove("item2", 1);
        assertFalse(result);
    }

}
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

public class bag_AbstractMapBag_remove_Object_cfg_path_2_Test {

    private AbstractMapBag<Object> bag;

    @Before
    public void setUp() throws Exception {
        // Using reflection to access the protected constructor
        Constructor<AbstractMapBag> constructor = AbstractMapBag.class.getDeclaredConstructor(Map.class);
        constructor.setAccessible(true);
        Map<Object, MutableInteger> map = new HashMap<>();
        bag = constructor.newInstance(map);
    }

    @Test(timeout = 4000)
    public void testRemoveObjectNotPresent() {
        // Test removing an object that is not present in the bag
        Object object = new Object();
        boolean result = bag.remove(object);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testRemoveObjectPresent() {
        // Prepare the bag with an object
        Object object = new Object();
        MutableInteger mut = new MutableInteger(1);
        
        // Use reflection to access the private map for testing
        try {
            java.lang.reflect.Field mapField = AbstractMapBag.class.getDeclaredField("map");
            mapField.setAccessible(true);
            Map<Object, MutableInteger> map = (Map<Object, MutableInteger>) mapField.get(bag);
            map.put(object, mut); // Manipulating the private map for testing
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Test removing an object that is present in the bag
        boolean result = bag.remove(object);
        assertTrue(result);
    }


}
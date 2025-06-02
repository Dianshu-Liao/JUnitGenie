package org.apache.commons.collections4.bag;
import org.apache.commons.collections4.bag.AbstractMapBag;
import org.apache.commons.collections4.bag.AbstractMapBag.MutableInteger;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class bag_AbstractMapBag_getCount_Object_cfg_path_1_Test {

    private class ConcreteMapBag extends AbstractMapBag<Object> {
        // Constructor to initialize the map
        public ConcreteMapBag() {
            super(new java.util.HashMap<>());
        }
        
        // Implementing the abstract methods if any (not shown in the provided context)
    }

    @Test(timeout = 4000)
    public void testGetCountWhenCountIsNotNull() {
        ConcreteMapBag bag = new ConcreteMapBag();
        Object testObject = new Object();
        MutableInteger mutableInteger = new MutableInteger(5);
        
        // Using reflection to access the private map field
        try {
            java.lang.reflect.Field mapField = AbstractMapBag.class.getDeclaredField("map");
            mapField.setAccessible(true);
            java.util.Map<Object, MutableInteger> map = (java.util.Map<Object, MutableInteger>) mapField.get(bag);
            map.put(testObject, mutableInteger);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Test the getCount method
        int count = bag.getCount(testObject);
        assertEquals(5, count);
    }

    @Test(timeout = 4000)
    public void testGetCountWhenCountIsNull() {
        ConcreteMapBag bag = new ConcreteMapBag();
        Object testObject = new Object();

        // Test the getCount method
        int count = bag.getCount(testObject);
        assertEquals(0, count);
    }

}
package org.apache.commons.collections4.bag;
import org.apache.commons.collections4.bag.AbstractMapBag;
import org.apache.commons.collections4.bag.AbstractMapBag.MutableInteger;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class bag_AbstractMapBag_getCount_Object_cfg_path_2_Test {

    private class ConcreteMapBag extends AbstractMapBag<Object> {
        // Implementing the abstract methods is necessary for instantiation
        public ConcreteMapBag() {
            super();
        }

        public ConcreteMapBag(java.util.Map<Object, MutableInteger> map) {
            super(map);
        }

        public ConcreteMapBag(java.util.Map<Object, MutableInteger> map, java.lang.Iterable<Object> iterable) {
            super(map, iterable);
        }
    }

    @Test(timeout = 4000)
    public void testGetCountReturnsZeroWhenObjectNotInMap() {
        ConcreteMapBag bag = new ConcreteMapBag();
        Object testObject = new Object();
        
        // Testing the case where the object is not in the map
        int count = bag.getCount(testObject);
        assertEquals(0, count);
    }

    @Test(timeout = 4000)
    public void testGetCountReturnsCountWhenObjectInMap() {
        ConcreteMapBag bag = new ConcreteMapBag();
        Object testObject = new Object();
        MutableInteger mutableInteger = new MutableInteger(5);
        
        // Using reflection to access the private map field
        try {
            java.lang.reflect.Field field = AbstractMapBag.class.getDeclaredField("map");
            field.setAccessible(true);
            java.util.Map<Object, MutableInteger> map = (java.util.Map<Object, MutableInteger>) field.get(bag);
            map.put(testObject, mutableInteger);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Testing the case where the object is in the map
        int count = bag.getCount(testObject);
        assertEquals(5, count);
    }

}
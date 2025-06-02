package org.apache.commons.collections4.bag;
import org.apache.commons.collections4.bag.AbstractMapBag;
import org.apache.commons.collections4.bag.AbstractMapBag.MutableInteger;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;

public class bag_AbstractMapBag_add_Object_int_cfg_path_1_Test {

    private class ConcreteMapBag<E> extends AbstractMapBag<E> {
        protected ConcreteMapBag() {
            super(new HashMap<E, MutableInteger>());
        }
        
        protected ConcreteMapBag(java.util.Map<E, MutableInteger> map) {
            super(map);
        }
        
        protected ConcreteMapBag(java.util.Map<E, MutableInteger> map, java.lang.Iterable<E> iterable) {
            super(map, iterable);
        }
    }

    @Test(timeout = 4000)
    public void testAddWithPositiveCopies() {
        ConcreteMapBag<String> bag = new ConcreteMapBag<>();
        assertTrue(bag.add("item1", 5));
    }

    @Test(timeout = 4000)
    public void testAddWithExistingItem() {
        ConcreteMapBag<String> bag = new ConcreteMapBag<>();
        bag.add("item1", 5);
        assertTrue(bag.add("item1", 3)); // Should add to existing item
    }

    @Test(timeout = 4000)
    public void testAddWithZeroCopies() {
        ConcreteMapBag<String> bag = new ConcreteMapBag<>();
        assertFalse(bag.add("item1", 0)); // Should not add with 0 copies
    }

    @Test(timeout = 4000)
    public void testAddWithNegativeCopies() {
        ConcreteMapBag<String> bag = new ConcreteMapBag<>();
        assertFalse(bag.add("item1", -3)); // Should not add with negative copies
    }


}
package org.apache.commons.collections4.multiset;
import org.apache.commons.collections4.multiset.AbstractMapMultiSet;
import org.apache.commons.collections4.multiset.AbstractMapMultiSet.MutableInteger;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertArrayEquals;

public class multiset_AbstractMapMultiSet_toArray__cfg_path_2_Test {

    private class ConcreteMapMultiSet<E> extends AbstractMapMultiSet<E> {
        public ConcreteMapMultiSet(Map<E, MutableInteger> map) {
            super(map);
        }

        @Override
        public boolean containsAll(java.util.Collection<?> collection) {
            return false; // Implement as needed for testing
        }

        @Override
        public boolean retainAll(java.util.Collection<?> collection) {
            return false; // Implement as needed for testing
        }
    }

    @Test(timeout = 4000)
    public void testToArray_EmptyMap() {
        try {
            // Create an empty map
            Map<Object, MutableInteger> emptyMap = new HashMap<>();
            
            // Use reflection to access the protected constructor
            Constructor<ConcreteMapMultiSet> constructor = ConcreteMapMultiSet.class.getDeclaredConstructor(Map.class);
            constructor.setAccessible(true);
            ConcreteMapMultiSet<Object> multiSet = constructor.newInstance(emptyMap);
            
            // Call the toArray method
            Object[] result = multiSet.toArray();
            
            // Verify that the result is an empty array
            assertArrayEquals(new Object[0], result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
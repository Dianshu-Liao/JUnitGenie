package org.apache.commons.collections4.map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections4.map.AbstractSortedMapDecorator;
import org.junit.Test;

public class map_AbstractSortedMapDecorator_previousKey_Object_cfg_path_2_Test {

    // Concrete implementation of the AbstractSortedMapDecorator for testing purposes
    private class TestSortedMapDecorator<K, V> extends AbstractSortedMapDecorator<K, V> {
        protected TestSortedMapDecorator(SortedMap<K, V> sortedMap) {
            super(sortedMap);
        }
    }

    @Test(timeout = 4000)
    public void testPreviousKey_EmptyHeadMap() {
        SortedMap<Integer, String> sortedMap = new TreeMap<>();
        TestSortedMapDecorator<Integer, String> decorator = new TestSortedMapDecorator<>(sortedMap);
        
        Integer key = 5;
        try {
            // Call the focal method
            Object result = decorator.previousKey(key);
            // Verify that the result is null as the headMap is empty
            assertNull(result);
        } catch (Exception e) {
            e.printStackTrace(); // Handle any unexpected exceptions
        }
    }

}
// Test method
package org.apache.commons.collections4.map;

import java.util.SortedMap;
import java.util.TreeMap;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.IterableSortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.iterators.ListIteratorWrapper;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractSortedMapDecorator_previousKey_7_0_Test {

    private AbstractSortedMapDecorator<Integer, String> decorator;

    private SortedMap<Integer, String> sortedMap;

    @BeforeEach
    public void setUp() {
        sortedMap = new TreeMap<>();
        decorator = new AbstractSortedMapDecorator<Integer, String>(sortedMap) {
        };
    }

    @Test
    public void testPreviousKey_WhenHeadMapIsEmpty_ReturnsNull() {
        Integer key = 5;
        Integer result = decorator.previousKey(key);
        assertNull(result);
    }

    @Test
    public void testPreviousKey_WhenHeadMapIsNotEmpty_ReturnsLastKey() {
        sortedMap.put(1, "One");
        sortedMap.put(2, "Two");
        sortedMap.put(3, "Three");
        Integer key = 4;
        Integer result = decorator.previousKey(key);
        assertEquals(3, result);
    }

    @Test
    public void testPreviousKey_WhenKeyIsLessThanAllKeys_ReturnsLastKey() {
        sortedMap.put(2, "Two");
        sortedMap.put(3, "Three");
        Integer key = 1;
        Integer result = decorator.previousKey(key);
        assertEquals(3, result);
    }

    @Test
    public void testPreviousKey_WhenKeyIsEqualToLastKey_ReturnsLastKey() {
        sortedMap.put(1, "One");
        sortedMap.put(2, "Two");
        sortedMap.put(3, "Three");
        Integer key = 3;
        Integer result = decorator.previousKey(key);
        assertEquals(2, result);
    }

    @Test
    public void testPreviousKey_WhenKeyIsLessThanLastKey_ReturnsCorrectLastKey() {
        sortedMap.put(1, "One");
        sortedMap.put(2, "Two");
        sortedMap.put(4, "Four");
        Integer key = 3;
        Integer result = decorator.previousKey(key);
        assertEquals(2, result);
    }

    @Test
    public void testPreviousKey_WhenMapHasOneElement_ReturnsNullForGreaterKey() {
        sortedMap.put(1, "One");
        Integer key = 2;
        Integer result = decorator.previousKey(key);
        assertNull(result);
    }

    @Test
    public void testPreviousKey_WhenMapHasOneElement_ReturnsNullForEqualKey() {
        sortedMap.put(1, "One");
        Integer key = 1;
        Integer result = decorator.previousKey(key);
        assertNull(result);
    }
}

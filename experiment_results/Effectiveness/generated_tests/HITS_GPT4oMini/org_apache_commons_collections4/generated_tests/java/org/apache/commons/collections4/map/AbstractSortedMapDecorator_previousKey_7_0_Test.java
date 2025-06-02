package org.apache.commons.collections4.map;

import java.util.SortedMap;
import java.util.TreeMap;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

class AbstractSortedMapDecorator_previousKey_7_0_Test extends AbstractSortedMapDecorator<Integer, String> {

    private SortedMap<Integer, String> sortedMap;

    public AbstractSortedMapDecorator_previousKey_7_0_Test() {
        super(new TreeMap<>());
    }

    @BeforeEach
    void setUp() {
        sortedMap = new TreeMap<>();
        sortedMap.put(1, "One");
        sortedMap.put(2, "Two");
        sortedMap.put(3, "Three");
        sortedMap.put(4, "Four");
        sortedMap.put(5, "Five");
    }

    @Override
    public SortedMap<Integer, String> decorated() {
        return sortedMap;
    }

    @Test
    void testPreviousKey_ReturnsPreviousKey_WhenKeyExists() {
        Integer key = 3;
        Integer expected = 2;
        Integer actual = previousKey(key);
        assertEquals(expected, actual);
    }

    @Test
    void testPreviousKey_ReturnsNull_WhenKeyIsTheFirst() {
        Integer key = 1;
        Integer actual = previousKey(key);
        assertNull(actual);
    }

    @Test
    void testPreviousKey_ReturnsNull_WhenKeyDoesNotExist() {
        // Key greater than the highest key
        Integer key = 6;
        Integer actual = previousKey(key);
        assertNull(actual);
    }

    @Test
    void testPreviousKey_ReturnsNull_WhenHeadMapIsEmpty() {
        // Clear the map to make it empty
        sortedMap.clear();
        Integer key = 1;
        Integer actual = previousKey(key);
        assertNull(actual);
    }

    @Test
    void testPreviousKey_ReturnsCorrectPreviousKey_ForMultipleCalls() {
        Integer key1 = 4;
        Integer expected1 = 3;
        Integer actual1 = previousKey(key1);
        assertEquals(expected1, actual1);
        Integer key2 = 5;
        Integer expected2 = 4;
        Integer actual2 = previousKey(key2);
        assertEquals(expected2, actual2);
    }
}

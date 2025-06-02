package org.apache.commons.collections4.map;

import java.util.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.collections4.IterableSortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.iterators.ListIteratorWrapper;

class AbstractSortedMapDecorator_previousKey_7_0_Test {

    private AbstractSortedMapDecorator<Integer, String> abstractSortedMapDecorator;

    private SortedMap<Integer, String> sortedMap;

    @BeforeEach
    void setUp() {
        sortedMap = new TreeMap<>();
        abstractSortedMapDecorator = new AbstractSortedMapDecorator<Integer, String>(sortedMap) {
        };
    }

    @Test
    void testPreviousKey_WhenHeadMapIsEmpty() {
        Integer key = 10;
        Integer result = invokePreviousKey(key);
        assertNull(result, "Expected null when headMap is empty");
    }

    @Test
    void testPreviousKey_WhenHeadMapHasElements() {
        sortedMap.put(5, "five");
        sortedMap.put(10, "ten");
        sortedMap.put(15, "fifteen");
        Integer key = 15;
        Integer result = invokePreviousKey(key);
        assertEquals(10, result, "Expected previous key to be 10");
    }

    @Test
    void testPreviousKey_WhenKeyIsTheFirstElement() {
        sortedMap.put(5, "five");
        sortedMap.put(10, "ten");
        Integer key = 5;
        Integer result = invokePreviousKey(key);
        assertNull(result, "Expected null when there is no previous key");
    }

    @Test
    void testPreviousKey_WhenKeyIsNotPresentInMap() {
        sortedMap.put(5, "five");
        sortedMap.put(10, "ten");
        // Key not in the map
        Integer key = 20;
        Integer result = invokePreviousKey(key);
        assertEquals(10, result, "Expected previous key to be 10 for a non-existent key");
    }

    @Test
    void testPreviousKey_WhenMapIsNull() {
        abstractSortedMapDecorator = new AbstractSortedMapDecorator<Integer, String>(null) {
        };
        Integer key = 10;
        Integer result = invokePreviousKey(key);
        assertNull(result, "Expected null when map is null");
    }

    private Integer invokePreviousKey(Integer key) {
        try {
            return (Integer) AbstractSortedMapDecorator.class.getDeclaredMethod("previousKey", Object.class).invoke(abstractSortedMapDecorator, key);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

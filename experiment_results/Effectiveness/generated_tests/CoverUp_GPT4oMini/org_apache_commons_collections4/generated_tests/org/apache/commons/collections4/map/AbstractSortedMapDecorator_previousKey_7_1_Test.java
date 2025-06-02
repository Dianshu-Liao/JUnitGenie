package org.apache.commons.collections4.map;

import java.util.SortedMap;
import java.util.TreeMap;
import java.lang.reflect.Method;
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

class AbstractSortedMapDecorator_previousKey_7_1_Test {

    private AbstractSortedMapDecorator<Integer, String> sortedMapDecorator;

    private SortedMap<Integer, String> sortedMap;

    @BeforeEach
    void setUp() {
        sortedMap = new TreeMap<>();
        sortedMapDecorator = new AbstractSortedMapDecorator<Integer, String>(sortedMap) {

            @Override
            public SortedMap<Integer, String> headMap(Integer toKey) {
                return sortedMap.headMap(toKey);
            }
        };
    }

    @Test
    void testPreviousKey_WithNonEmptyHeadMap() throws Exception {
        sortedMap.put(1, "One");
        sortedMap.put(2, "Two");
        sortedMap.put(3, "Three");
        Integer result = invokePreviousKey(3);
        assertEquals(2, result);
    }

    @Test
    void testPreviousKey_WithEmptyHeadMap() throws Exception {
        sortedMap.put(1, "One");
        Integer result = invokePreviousKey(1);
        assertNull(result);
    }

    @Test
    void testPreviousKey_WithKeyNotInMap() throws Exception {
        sortedMap.put(1, "One");
        sortedMap.put(2, "Two");
        Integer result = invokePreviousKey(4);
        assertEquals(2, result);
    }

    @Test
    void testPreviousKey_WithHeadMapEmpty() throws Exception {
        Integer result = invokePreviousKey(0);
        assertNull(result);
    }

    @SuppressWarnings("unchecked")
    private Integer invokePreviousKey(Integer key) throws Exception {
        Method method = AbstractSortedMapDecorator.class.getDeclaredMethod("previousKey", Object.class);
        method.setAccessible(true);
        return (Integer) method.invoke(sortedMapDecorator, key);
    }
}

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

public class AbstractSortedMapDecorator_previousKey_7_4_Test {

    private AbstractSortedMapDecorator<String, Integer> decorator;

    private SortedMap<String, Integer> map;

    @BeforeEach
    public void setUp() {
        map = new TreeMap<>();
        decorator = new AbstractSortedMapDecorator<String, Integer>(map) {

            @Override
            public SortedMap<String, Integer> headMap(final String toKey) {
                return super.headMap(toKey);
            }
        };
    }

    @Test
    public void testPreviousKey_WhenMapIsEmpty() throws Exception {
        assertNull(invokePreviousKey("key"));
    }

    @Test
    public void testPreviousKey_WhenKeyIsNotPresent() throws Exception {
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        assertEquals("b", invokePreviousKey("d"));
    }

    @Test
    public void testPreviousKey_WhenKeyIsFirst() throws Exception {
        map.put("a", 1);
        assertNull(invokePreviousKey("a"));
    }

    @Test
    public void testPreviousKey_WhenKeyIsLast() throws Exception {
        map.put("a", 1);
        map.put("b", 2);
        assertEquals("a", invokePreviousKey("b"));
    }

    @Test
    public void testPreviousKey_WhenKeyIsInMiddle() throws Exception {
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        assertEquals("b", invokePreviousKey("c"));
    }

    private String invokePreviousKey(String key) throws Exception {
        Method method = AbstractSortedMapDecorator.class.getDeclaredMethod("previousKey", Object.class);
        method.setAccessible(true);
        return (String) method.invoke(decorator, key);
    }
}

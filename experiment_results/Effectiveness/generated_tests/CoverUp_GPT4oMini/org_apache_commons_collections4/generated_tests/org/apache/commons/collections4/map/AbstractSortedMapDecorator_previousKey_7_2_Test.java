package org.apache.commons.collections4.map;

import java.lang.reflect.Method;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Comparator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import org.apache.commons.collections4.IterableSortedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.iterators.ListIteratorWrapper;

public class AbstractSortedMapDecorator_previousKey_7_2_Test {

    private AbstractSortedMapDecorator<String, Integer> mapDecorator;

    private SortedMap<String, Integer> sortedMap;

    @BeforeEach
    public void setUp() {
        sortedMap = new TreeMap<>();
        sortedMap.put("a", 1);
        sortedMap.put("b", 2);
        sortedMap.put("c", 3);
        mapDecorator = new AbstractSortedMapDecorator<String, Integer>(sortedMap) {

            @Override
            public SortedMap<String, Integer> headMap(String key) {
                return sortedMap.headMap(key);
            }
        };
    }

    @Test
    public void testPreviousKey_ExistingKey() throws Exception {
        String result = invokePreviousKey("b");
        assertEquals("a", result);
    }

    @Test
    public void testPreviousKey_FirstKey() throws Exception {
        String result = invokePreviousKey("a");
        assertNull(result);
    }

    @Test
    public void testPreviousKey_NonExistentKey() throws Exception {
        String result = invokePreviousKey("d");
        assertEquals("c", result);
    }

    @Test
    public void testPreviousKey_EmptyHeadMap() throws Exception {
        sortedMap.clear();
        String result = invokePreviousKey("a");
        assertNull(result);
    }

    private String invokePreviousKey(String key) throws Exception {
        Method method = AbstractSortedMapDecorator.class.getDeclaredMethod("previousKey", Object.class);
        method.setAccessible(true);
        return (String) method.invoke(mapDecorator, key);
    }
}

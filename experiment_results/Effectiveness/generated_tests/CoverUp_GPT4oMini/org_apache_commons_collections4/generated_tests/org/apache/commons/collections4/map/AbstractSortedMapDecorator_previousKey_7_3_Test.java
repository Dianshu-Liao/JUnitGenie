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

public class AbstractSortedMapDecorator_previousKey_7_3_Test {

    private AbstractSortedMapDecorator<String, Integer> sortedMapDecorator;

    private SortedMap<String, Integer> mockSortedMap;

    @BeforeEach
    public void setUp() {
        // Create a mock of SortedMap
        mockSortedMap = mock(SortedMap.class);
        // Create an anonymous subclass to instantiate AbstractSortedMapDecorator
        sortedMapDecorator = new AbstractSortedMapDecorator<String, Integer>(mockSortedMap) {
        };
    }

    @Test
    public void testPreviousKey_whenHeadMapIsEmpty() {
        // Arrange
        String key = "key";
        when(mockSortedMap.headMap(key)).thenReturn(new TreeMap<String, Integer>());
        // Act
        String result = sortedMapDecorator.previousKey(key);
        // Assert
        assertNull(result);
    }

    @Test
    public void testPreviousKey_whenHeadMapHasElements() {
        // Arrange
        String key = "key";
        TreeMap<String, Integer> headMap = new TreeMap<>();
        headMap.put("previousKey", 1);
        when(mockSortedMap.headMap(key)).thenReturn(headMap);
        when(headMap.lastKey()).thenReturn("previousKey");
        // Act
        String result = sortedMapDecorator.previousKey(key);
        // Assert
        assertEquals("previousKey", result);
    }

    @Test
    public void testPreviousKey_whenHeadMapHasOneElement() {
        // Arrange
        String key = "key";
        TreeMap<String, Integer> headMap = new TreeMap<>();
        headMap.put("onlyKey", 1);
        when(mockSortedMap.headMap(key)).thenReturn(headMap);
        when(headMap.lastKey()).thenReturn("onlyKey");
        // Act
        String result = sortedMapDecorator.previousKey(key);
        // Assert
        assertEquals("onlyKey", result);
    }
}

package org.apache.commons.collections4.map;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections4.Transformer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Map;

class TransformedSortedMap_transformedSortedMap_0_0_Test {

    private SortedMap<String, Integer> sortedMap;

    private Transformer<String, String> keyTransformer;

    private Transformer<Integer, Integer> valueTransformer;

    @BeforeEach
    void setUp() {
        sortedMap = new TreeMap<>();
        keyTransformer = mock(Transformer.class);
        valueTransformer = mock(Transformer.class);
    }

    @Test
    void testTransformedSortedMap_EmptyMap() {
        TransformedSortedMap<String, Integer> transformedMap = TransformedSortedMap.transformedSortedMap(sortedMap, keyTransformer, valueTransformer);
        assertNotNull(transformedMap);
        assertTrue(transformedMap.getSortedMap().isEmpty());
    }

    @Test
    void testTransformedSortedMap_NonEmptyMap() {
        sortedMap.put("key1", 1);
        sortedMap.put("key2", 2);
        when(keyTransformer.transform("key1")).thenReturn("transformedKey1");
        when(keyTransformer.transform("key2")).thenReturn("transformedKey2");
        when(valueTransformer.transform(1)).thenReturn(100);
        when(valueTransformer.transform(2)).thenReturn(200);
        TransformedSortedMap<String, Integer> transformedMap = TransformedSortedMap.transformedSortedMap(sortedMap, keyTransformer, valueTransformer);
        assertNotNull(transformedMap);
        assertEquals(2, transformedMap.getSortedMap().size());
        assertTrue(transformedMap.getSortedMap().containsKey("transformedKey1"));
        assertTrue(transformedMap.getSortedMap().containsKey("transformedKey2"));
        assertEquals(100, transformedMap.getSortedMap().get("transformedKey1"));
        assertEquals(200, transformedMap.getSortedMap().get("transformedKey2"));
    }

    @Test
    void testTransformedSortedMap_NullMap() {
        assertThrows(NullPointerException.class, () -> {
            TransformedSortedMap.transformedSortedMap(null, keyTransformer, valueTransformer);
        });
    }

    @Test
    void testTransformedSortedMap_NullKeyTransformer() {
        assertThrows(NullPointerException.class, () -> {
            TransformedSortedMap.transformedSortedMap(sortedMap, null, valueTransformer);
        });
    }

    @Test
    void testTransformedSortedMap_NullValueTransformer() {
        assertThrows(NullPointerException.class, () -> {
            TransformedSortedMap.transformedSortedMap(sortedMap, keyTransformer, null);
        });
    }
}

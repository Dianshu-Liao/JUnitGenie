package org.apache.commons.collections4.map;

import org.apache.commons.collections4.Transformer;
import java.util.SortedMap;
import java.util.TreeMap;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Comparator;
import java.util.Map;

public class TransformedSortedMap_transformedSortedMap_0_0_Test {

    private SortedMap<Integer, String> originalMap;

    private Transformer<Integer, Integer> keyTransformer;

    private Transformer<String, String> valueTransformer;

    @BeforeEach
    public void setUp() {
        originalMap = new TreeMap<>();
        originalMap.put(1, "one");
        originalMap.put(2, "two");
        originalMap.put(3, "three");
        keyTransformer = new Transformer<Integer, Integer>() {

            @Override
            public Integer transform(Integer input) {
                // No transformation for keys
                return input;
            }
        };
        valueTransformer = new Transformer<String, String>() {

            @Override
            public String transform(String input) {
                return "Value_" + input;
            }
        };
    }

    @Test
    public void testTransformedSortedMap_nonEmptyMap() {
        TransformedSortedMap<Integer, String> transformedMap = TransformedSortedMap.transformedSortedMap(originalMap, keyTransformer, valueTransformer);
        assertEquals(3, transformedMap.size());
        assertEquals("Value_one", transformedMap.get(1));
        assertEquals("Value_two", transformedMap.get(2));
        assertEquals("Value_three", transformedMap.get(3));
    }

    @Test
    public void testTransformedSortedMap_emptyMap() {
        SortedMap<Integer, String> emptyMap = new TreeMap<>();
        TransformedSortedMap<Integer, String> transformedMap = TransformedSortedMap.transformedSortedMap(emptyMap, keyTransformer, valueTransformer);
        assertTrue(transformedMap.isEmpty());
    }

    @Test
    public void testTransformedSortedMap_singleEntry() {
        SortedMap<Integer, String> singleEntryMap = new TreeMap<>();
        singleEntryMap.put(1, "one");
        TransformedSortedMap<Integer, String> transformedMap = TransformedSortedMap.transformedSortedMap(singleEntryMap, keyTransformer, valueTransformer);
        assertEquals(1, transformedMap.size());
        assertEquals("Value_one", transformedMap.get(1));
    }

    @Test
    public void testTransformedSortedMap_withNullValues() {
        SortedMap<Integer, String> mapWithNull = new TreeMap<>();
        mapWithNull.put(1, null);
        mapWithNull.put(2, "two");
        TransformedSortedMap<Integer, String> transformedMap = TransformedSortedMap.transformedSortedMap(mapWithNull, keyTransformer, valueTransformer);
        assertEquals(2, transformedMap.size());
        assertNull(transformedMap.get(1));
        assertEquals("Value_two", transformedMap.get(2));
    }
}

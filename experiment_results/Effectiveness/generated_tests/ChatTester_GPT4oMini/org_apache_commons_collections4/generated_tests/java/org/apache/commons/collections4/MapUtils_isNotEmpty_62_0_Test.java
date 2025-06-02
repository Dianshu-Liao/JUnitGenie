package org.apache.commons.collections4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.function.BiFunction;
import java.util.function.Function;
import org.apache.commons.collections4.map.AbstractMapDecorator;
import org.apache.commons.collections4.map.AbstractSortedMapDecorator;
import org.apache.commons.collections4.map.FixedSizeMap;
import org.apache.commons.collections4.map.FixedSizeSortedMap;
import org.apache.commons.collections4.map.LazyMap;
import org.apache.commons.collections4.map.LazySortedMap;
import org.apache.commons.collections4.map.ListOrderedMap;
import org.apache.commons.collections4.map.MultiValueMap;
import org.apache.commons.collections4.map.PredicatedMap;
import org.apache.commons.collections4.map.PredicatedSortedMap;
import org.apache.commons.collections4.map.TransformedMap;
import org.apache.commons.collections4.map.TransformedSortedMap;
import org.apache.commons.collections4.map.UnmodifiableMap;
import org.apache.commons.collections4.map.UnmodifiableSortedMap;

public class MapUtils_isNotEmpty_62_0_Test {

    @Test
    public void testIsNotEmpty_withNonEmptyMap() {
        Map<String, String> nonEmptyMap = new HashMap<>();
        nonEmptyMap.put("key", "value");
        assertTrue(MapUtils.isNotEmpty(nonEmptyMap), "Expected map to be not empty");
    }

    @Test
    public void testIsNotEmpty_withEmptyMap() {
        Map<String, String> emptyMap = Collections.emptyMap();
        assertFalse(MapUtils.isNotEmpty(emptyMap), "Expected map to be empty");
    }

    @Test
    public void testIsNotEmpty_withNullMap() {
        Map<String, String> nullMap = null;
        assertFalse(MapUtils.isNotEmpty(nullMap), "Expected null map to be treated as empty");
    }

    @Test
    public void testIsNotEmpty_withEmptySortedMap() {
        SortedMap<String, String> emptySortedMap = new TreeMap<>();
        assertFalse(MapUtils.isNotEmpty(emptySortedMap), "Expected empty sorted map to be empty");
    }

    @Test
    public void testIsNotEmpty_withNonEmptySortedMap() {
        SortedMap<String, String> nonEmptySortedMap = new TreeMap<>();
        nonEmptySortedMap.put("key", "value");
        assertTrue(MapUtils.isNotEmpty(nonEmptySortedMap), "Expected sorted map to be not empty");
    }
}

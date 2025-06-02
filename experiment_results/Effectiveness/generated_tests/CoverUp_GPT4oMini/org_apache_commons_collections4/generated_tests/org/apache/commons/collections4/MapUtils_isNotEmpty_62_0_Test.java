package org.apache.commons.collections4;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
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
import java.util.Collections;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.SortedMap;
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
        Map<String, String> map = new HashMap<>();
        map.put("key", "value");
        assertTrue(MapUtils.isNotEmpty(map), "The map should not be empty");
    }

    @Test
    public void testIsNotEmpty_withEmptyMap() {
        Map<String, String> map = new HashMap<>();
        assertFalse(MapUtils.isNotEmpty(map), "The map should be empty");
    }

    @Test
    public void testIsNotEmpty_withNullMap() {
        Map<String, String> map = null;
        assertFalse(MapUtils.isNotEmpty(map), "The map should be considered empty");
    }

    @Test
    public void testIsNotEmpty_withEmptyProperties() {
        Map<Object, Object> map = new Properties();
        assertFalse(MapUtils.isNotEmpty(map), "The properties map should be empty");
    }

    @Test
    public void testIsNotEmpty_withSingleElementMap() {
        Map<String, String> map = new HashMap<>();
        map.put("singleKey", "singleValue");
        assertTrue(MapUtils.isNotEmpty(map), "The map should not be empty");
    }

    @Test
    public void testIsNotEmpty_withMultipleElementsMap() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        assertTrue(MapUtils.isNotEmpty(map), "The map should not be empty");
    }

    @Test
    public void testIsNotEmpty_withEmptySortedMap() {
        Map<String, String> map = new TreeMap<>();
        assertFalse(MapUtils.isNotEmpty(map), "The sorted map should be empty");
    }
}

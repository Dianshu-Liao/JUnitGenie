package org.apache.commons.collections4.map;

import org.apache.commons.collections4.map.Flat3Map;
import java.util.HashMap;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

class Flat3Map_isEmpty_10_0_Test {

    private Flat3Map<String, String> flat3Map;

    @BeforeEach
    void setUp() {
        flat3Map = new Flat3Map<>();
    }

    @Test
    void testIsEmpty_WhenMapIsEmpty() {
        // Given the map is initialized and empty
        // When checking if the map is empty
        boolean result = flat3Map.isEmpty();
        // Then it should return true
        assertTrue(result, "Expected the map to be empty");
    }

    @Test
    void testIsEmpty_WhenMapHasElements() {
        // Given the map is initialized and has elements
        flat3Map.put("key1", "value1");
        // When checking if the map is empty
        boolean result = flat3Map.isEmpty();
        // Then it should return false
        assertFalse(result, "Expected the map to not be empty");
    }

    @Test
    void testIsEmpty_WhenMapHasMultipleElements() {
        // Given the map is initialized and has multiple elements
        flat3Map.put("key1", "value1");
        flat3Map.put("key2", "value2");
        // When checking if the map is empty
        boolean result = flat3Map.isEmpty();
        // Then it should return false
        assertFalse(result, "Expected the map to not be empty");
    }
}

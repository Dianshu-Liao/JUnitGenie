package org.apache.commons.collections4.map;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
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
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.EmptyIterator;
import org.apache.commons.collections4.iterators.EmptyMapIterator;

public class Flat3Map_values_19_0_Test {

    private Flat3Map<String, String> flat3Map;

    @BeforeEach
    public void setUp() {
        flat3Map = new Flat3Map<>();
    }

    @Test
    public void testValuesEmpty() {
        Collection<String> values = flat3Map.values();
        assertNotNull(values);
        assertTrue(values.isEmpty(), "Values collection should be empty");
    }

    @Test
    public void testValuesWithDelegateMap() {
        Map<String, String> delegate = new HashMap<>();
        delegate.put("key1", "value1");
        delegate.put("key2", "value2");
        delegate.put("key3", "value3");
        flat3Map = new Flat3Map<>(delegate);
        Collection<String> values = flat3Map.values();
        assertNotNull(values);
        assertEquals(3, values.size(), "Values collection should contain 3 items");
        assertTrue(values.containsAll(Arrays.asList("value1", "value2", "value3")), "Values collection should contain all values from delegate map");
    }

    @Test
    public void testValuesWithNullDelegateMap() {
        flat3Map = new Flat3Map<>();
        Collection<String> values = flat3Map.values();
        assertNotNull(values);
        assertTrue(values.isEmpty(), "Values collection should be empty when delegateMap is null");
    }

    @Test
    public void testValuesAfterAddingEntries() {
        flat3Map.put("key1", "value1");
        flat3Map.put("key2", "value2");
        flat3Map.put("key3", "value3");
        Collection<String> values = flat3Map.values();
        assertNotNull(values);
        assertEquals(3, values.size(), "Values collection should contain 3 items");
        assertTrue(values.containsAll(Arrays.asList("value1", "value2", "value3")), "Values collection should contain all added values");
    }
}

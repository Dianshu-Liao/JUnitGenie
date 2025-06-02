package org.apache.commons.collections4.map;

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

public class Flat3Map_isEmpty_10_0_Test {

    private Flat3Map<String, String> flat3Map;

    @BeforeEach
    public void setUp() {
        flat3Map = new Flat3Map<>();
    }

    @Test
    public void testIsEmpty_WhenMapIsEmpty_ShouldReturnTrue() {
        assertTrue(flat3Map.isEmpty(), "Expected isEmpty() to return true for an empty map.");
    }

    @Test
    public void testIsEmpty_WhenMapHasElements_ShouldReturnFalse() {
        flat3Map.put("key1", "value1");
        assertFalse(flat3Map.isEmpty(), "Expected isEmpty() to return false for a map with elements.");
    }

    @Test
    public void testIsEmpty_AfterRemovingAllElements_ShouldReturnTrue() {
        flat3Map.put("key1", "value1");
        flat3Map.put("key2", "value2");
        flat3Map.remove("key1");
        flat3Map.remove("key2");
        assertTrue(flat3Map.isEmpty(), "Expected isEmpty() to return true after removing all elements.");
    }
}

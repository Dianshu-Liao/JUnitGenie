package org.apache.commons.collections4.map;

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
import java.util.Collection;
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

public class Flat3Map_size_17_0_Test {

    @Test
    public void testSizeWhenEmpty() {
        Flat3Map<String, String> flatMap = new Flat3Map<>();
        assertEquals(0, flatMap.size(), "Size should be 0 for an empty Flat3Map");
    }

    @Test
    public void testSizeWhenNotEmpty() {
        Map<String, String> initialMap = new HashMap<>();
        initialMap.put("key1", "value1");
        initialMap.put("key2", "value2");
        Flat3Map<String, String> flatMap = new Flat3Map<>(initialMap);
        assertEquals(2, flatMap.size(), "Size should reflect the number of entries in the map");
    }

    @Test
    public void testSizeWithDelegateMap() {
        Map<String, String> initialMap = new HashMap<>();
        initialMap.put("key1", "value1");
        Flat3Map<String, String> flatMap = new Flat3Map<>(initialMap);
        assertEquals(1, flatMap.size(), "Size should be 1 after adding one entry");
        flatMap.put("key2", "value2");
        assertEquals(2, flatMap.size(), "Size should be 2 after adding another entry");
    }
}

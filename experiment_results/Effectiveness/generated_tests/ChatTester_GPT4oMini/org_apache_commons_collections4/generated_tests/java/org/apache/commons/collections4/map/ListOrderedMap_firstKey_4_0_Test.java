package org.apache.commons.collections4.map;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
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
import java.util.AbstractList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.ResettableIterator;
import org.apache.commons.collections4.iterators.AbstractUntypedIteratorDecorator;
import org.apache.commons.collections4.keyvalue.AbstractMapEntry;
import org.apache.commons.collections4.list.UnmodifiableList;

public class ListOrderedMap_firstKey_4_0_Test {

    private ListOrderedMap<String, Integer> listOrderedMap;

    @BeforeEach
    public void setUp() {
        listOrderedMap = new ListOrderedMap<>();
    }

    @Test
    public void testFirstKeyThrowsExceptionWhenEmpty() {
        // Act & Assert
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, () -> {
            listOrderedMap.firstKey();
        });
        assertEquals("Map is empty", exception.getMessage());
    }

    @Test
    public void testFirstKeyReturnsFirstKeyWhenNotEmpty() {
        // Arrange
        Map<String, Integer> initialMap = new HashMap<>();
        initialMap.put("first", 1);
        initialMap.put("second", 2);
        // Assuming there's a method to add entries to the ListOrderedMap
        // Add first key-value pair
        listOrderedMap.put("first", 1);
        // Add second key-value pair
        listOrderedMap.put("second", 2);
        // Act
        String firstKey = listOrderedMap.firstKey();
        // Assert
        assertEquals("first", firstKey);
    }
}

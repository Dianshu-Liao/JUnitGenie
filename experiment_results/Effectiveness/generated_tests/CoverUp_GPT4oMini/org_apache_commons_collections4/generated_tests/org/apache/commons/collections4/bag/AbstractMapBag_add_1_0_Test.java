package org.apache.commons.collections4.bag;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.set.UnmodifiableSet;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AbstractMapBag_add_1_0_Test {

    private AbstractMapBag<String> abstractMapBag;

    private Map<String, AbstractMapBag.MutableInteger> map;

    @BeforeEach
    void setUp() {
        map = new HashMap<>();
        abstractMapBag = new AbstractMapBag<String>(map) {
        };
    }

    @Test
    void testAddNewElement() throws Exception {
        // Given
        String element = "apple";
        int copies = 3;
        // When
        boolean result = abstractMapBag.add(element, copies);
        // Then
        assertTrue(result);
        assertEquals(3, getSize());
        assertEquals(3, map.get(element).value);
    }

    @Test
    void testAddExistingElement() throws Exception {
        // Given
        String element = "banana";
        map.put(element, new AbstractMapBag.MutableInteger(2));
        int copies = 5;
        // When
        boolean result = abstractMapBag.add(element, copies);
        // Then
        assertFalse(result);
        assertEquals(2 + 5, map.get(element).value);
        assertEquals(7, getSize());
    }

    @Test
    void testAddZeroCopies() throws Exception {
        // Given
        String element = "orange";
        int copies = 0;
        // When
        boolean result = abstractMapBag.add(element, copies);
        // Then
        assertFalse(result);
        assertEquals(0, getSize());
        assertNull(map.get(element));
    }

    @Test
    void testAddNegativeCopies() throws Exception {
        // Given
        String element = "grape";
        int copies = -1;
        // When
        boolean result = abstractMapBag.add(element, copies);
        // Then
        assertFalse(result);
        assertEquals(0, getSize());
        assertNull(map.get(element));
    }

    private int getSize() throws Exception {
        Field sizeField = AbstractMapBag.class.getDeclaredField("size");
        sizeField.setAccessible(true);
        return (int) sizeField.get(abstractMapBag);
    }

    // MutableInteger class definition
    static class MutableInteger {

        int value;

        MutableInteger(int value) {
            this.value = value;
        }
    }
}

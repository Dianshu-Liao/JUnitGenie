package org.apache.commons.collections4.bag;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.AbstractMapBag;
import org.apache.commons.collections4.set.UnmodifiableSet;
import java.lang.reflect.Field;
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
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.CollectionUtils;

class AbstractMapBag_add_1_1_Test extends AbstractMapBag<String> {

    private Map<String, MutableInteger> testMap;

    protected AbstractMapBag_add_1_1_Test() {
        super(new HashMap<>());
    }

    @BeforeEach
    void setUp() {
        testMap = getMap();
    }

    @Test
    void testAddNewElement() {
        assertTrue(add("apple", 5));
        assertEquals(5, testMap.get("apple").value);
        assertEquals(5, getSize());
    }

    @Test
    void testAddExistingElement() {
        add("banana", 3);
        assertFalse(add("banana", 2));
        assertEquals(5, testMap.get("banana").value);
        assertEquals(5, getSize());
    }

    @Test
    void testAddZeroCopies() {
        assertFalse(add("orange", 0));
        assertNull(testMap.get("orange"));
        assertEquals(0, getSize());
    }

    @Test
    void testAddNegativeCopies() {
        assertFalse(add("grape", -2));
        assertNull(testMap.get("grape"));
        assertEquals(0, getSize());
    }

    private int getSize() {
        try {
            Field sizeField = AbstractMapBag.class.getDeclaredField("size");
            sizeField.setAccessible(true);
            return (int) sizeField.get(this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

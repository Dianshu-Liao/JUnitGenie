package org.apache.commons.collections4.bag;

import org.apache.commons.collections4.Bag;
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

class AbstractMapBag_getCount_10_1_Test {

    private TestMapBag bag;

    @BeforeEach
    void setUp() {
        bag = new TestMapBag();
    }

    @Test
    void testGetCount_WithExistingElement() {
        bag.add("apple", 3);
        assertEquals(3, bag.getCount("apple"));
    }

    @Test
    void testGetCount_WithNonExistingElement() {
        assertEquals(0, bag.getCount("banana"));
    }

    @Test
    void testGetCount_WithNull() {
        assertEquals(0, bag.getCount(null));
    }

    private class TestMapBag extends AbstractMapBag<String> {

        public TestMapBag() {
            super(new HashMap<>());
        }

        public boolean add(String object, int count) {
            MutableInteger mutableInteger = new MutableInteger(count);
            getMap().put(object, mutableInteger);
            // Return true to match the Bag interface
            return true;
        }
    }

    private class MutableInteger {

        int value;

        MutableInteger(int value) {
            this.value = value;
        }
    }
}

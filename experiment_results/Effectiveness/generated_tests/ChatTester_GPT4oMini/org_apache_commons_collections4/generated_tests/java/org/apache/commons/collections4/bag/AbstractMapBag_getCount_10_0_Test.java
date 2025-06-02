package org.apache.commons.collections4.bag;

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
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.set.UnmodifiableSet;

class AbstractMapBag_getCount_10_0_Test {

    private AbstractMapBag bag;

    @BeforeEach
    void setUp() {
        Map<Object, MutableInteger> map = new HashMap<>();
        map.put("apple", new MutableInteger(3));
        map.put("banana", new MutableInteger(5));
        bag = new AbstractMapBag(map) {
        };
    }

    @Test
    void testGetCount_existingObject() {
        assertEquals(3, bag.getCount("apple"), "Count for 'apple' should be 3");
        assertEquals(5, bag.getCount("banana"), "Count for 'banana' should be 5");
    }

    @Test
    void testGetCount_nonExistingObject() {
        assertEquals(0, bag.getCount("orange"), "Count for 'orange' should be 0");
    }

    @Test
    void testGetCount_nullObject() {
        assertEquals(0, bag.getCount(null), "Count for null should be 0");
    }

    // MutableInteger class for testing purposes
    static class MutableInteger {

        int value;

        MutableInteger(int value) {
            this.value = value;
        }
    }
}

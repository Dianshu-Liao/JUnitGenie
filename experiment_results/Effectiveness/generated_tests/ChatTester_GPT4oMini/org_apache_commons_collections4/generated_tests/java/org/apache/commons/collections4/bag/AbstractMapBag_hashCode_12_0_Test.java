package org.apache.commons.collections4.bag;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

class AbstractMapBag_hashCode_12_0_Test {

    private AbstractMapBag<String> mapBag;

    @BeforeEach
    void setUp() {
        // Mocking the AbstractMapBag class since it's abstract
        mapBag = mock(AbstractMapBag.class, withSettings().useConstructor().defaultAnswer(CALLS_REAL_METHODS));
    }

    @Test
    void testHashCodeWithNonNullElements() {
        Map<String, MutableInteger> map = new HashMap<>();
        map.put("A", new MutableInteger(1));
        map.put("B", new MutableInteger(2));
        map.put("C", new MutableInteger(3));
        // Use reflection to set the private 'map' field
        setPrivateField(mapBag, "map", map);
        int expectedHashCode = "A".hashCode() ^ 1 + "B".hashCode() ^ 2 + "C".hashCode() ^ 3;
        assertEquals(expectedHashCode, mapBag.hashCode());
    }

    @Test
    void testHashCodeWithNullElement() {
        Map<String, MutableInteger> map = new HashMap<>();
        map.put(null, new MutableInteger(1));
        map.put("B", new MutableInteger(2));
        // Use reflection to set the private 'map' field
        setPrivateField(mapBag, "map", map);
        int expectedHashCode = 0 ^ 1 + "B".hashCode() ^ 2;
        assertEquals(expectedHashCode, mapBag.hashCode());
    }

    @Test
    void testHashCodeWithEmptyMap() {
        Map<String, MutableInteger> map = new HashMap<>();
        // Use reflection to set the private 'map' field
        setPrivateField(mapBag, "map", map);
        assertEquals(0, mapBag.hashCode());
    }

    // Helper method to set private fields using reflection
    private void setPrivateField(Object target, String fieldName, Object value) {
        try {
            // Fixed line
            Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    // MutableInteger class for testing purposes
    static class MutableInteger {

        int value;

        MutableInteger(int value) {
            this.value = value;
        }
    }
}

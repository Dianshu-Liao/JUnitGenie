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
        assertTrue(flat3Map.isEmpty(), "Flat3Map should be empty");
    }

    @Test
    public void testIsEmpty_WhenMapIsNotEmpty_ShouldReturnFalse() {
        // Using reflection to set the private size field directly for testing
        try {
            java.lang.reflect.Field sizeField = Flat3Map.class.getDeclaredField("size");
            sizeField.setAccessible(true);
            // Simulating a non-empty map
            sizeField.set(flat3Map, 1);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection failed to access size field");
        }
        assertFalse(flat3Map.isEmpty(), "Flat3Map should not be empty");
    }
}

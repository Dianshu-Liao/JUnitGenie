package org.apache.commons.collections4.iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

class PermutationIterator_PermutationIterator_3_0_Test {

    private PermutationIterator<String> permutationIterator;

    @BeforeEach
    void setUp() {
        // Setting up a sample collection for testing
        Collection<String> collection = Arrays.asList("A", "B", "C");
        permutationIterator = new PermutationIterator<>(collection);
    }

    @Test
    void testConstructorWithNullCollection() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new PermutationIterator<>(null);
        });
        assertEquals("collection", exception.getMessage());
    }

    @Test
    void testConstructorWithEmptyCollection() {
        Collection<String> emptyCollection = Collections.emptyList();
        PermutationIterator<String> emptyIterator = new PermutationIterator<>(emptyCollection);
        // Validate that the internal state is correctly initialized
        assertNotNull(emptyIterator);
    }

    @Test
    void testConstructorWithNonEmptyCollection() throws NoSuchFieldException, IllegalAccessException {
        Collection<String> collection = Arrays.asList("A", "B", "C");
        PermutationIterator<String> iterator = new PermutationIterator<>(collection);
        // Validate the internal state
        assertNotNull(iterator);
        Field keysField = PermutationIterator.class.getDeclaredField("keys");
        keysField.setAccessible(true);
        int[] keys = (int[]) keysField.get(iterator);
        assertEquals(3, keys.length);
        Field objectMapField = PermutationIterator.class.getDeclaredField("objectMap");
        objectMapField.setAccessible(true);
        Map<Integer, String> objectMap = (Map<Integer, String>) objectMapField.get(iterator);
        assertEquals(3, objectMap.size());
        Field nextPermutationField = PermutationIterator.class.getDeclaredField("nextPermutation");
        nextPermutationField.setAccessible(true);
        List<String> nextPermutation = (List<String>) nextPermutationField.get(iterator);
        assertEquals(Arrays.asList("A", "B", "C"), nextPermutation);
    }

    @Test
    void testConstructorWithSingleElementCollection() throws NoSuchFieldException, IllegalAccessException {
        Collection<String> singleElementCollection = Collections.singletonList("A");
        PermutationIterator<String> singleElementIterator = new PermutationIterator<>(singleElementCollection);
        // Validate the internal state
        assertNotNull(singleElementIterator);
        Field keysField = PermutationIterator.class.getDeclaredField("keys");
        keysField.setAccessible(true);
        int[] keys = (int[]) keysField.get(singleElementIterator);
        assertEquals(1, keys.length);
        Field objectMapField = PermutationIterator.class.getDeclaredField("objectMap");
        objectMapField.setAccessible(true);
        Map<Integer, String> objectMap = (Map<Integer, String>) objectMapField.get(singleElementIterator);
        assertEquals(1, objectMap.size());
        Field nextPermutationField = PermutationIterator.class.getDeclaredField("nextPermutation");
        nextPermutationField.setAccessible(true);
        List<String> nextPermutation = (List<String>) nextPermutationField.get(singleElementIterator);
        assertEquals(Collections.singletonList("A"), nextPermutation);
    }
}

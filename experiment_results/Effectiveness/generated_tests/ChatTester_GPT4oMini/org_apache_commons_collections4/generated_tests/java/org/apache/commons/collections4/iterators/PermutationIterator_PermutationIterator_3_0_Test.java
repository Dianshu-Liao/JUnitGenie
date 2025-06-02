package org.apache.commons.collections4.iterators;

import java.lang.reflect.Field;
import java.util.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class PermutationIterator_PermutationIterator_3_0_Test {

    private PermutationIterator<Integer> iterator;

    @BeforeEach
    public void setUp() {
        // No setup needed for this test class as each test initializes its own instance
    }

    @Test
    public void testConstructorWithNullCollection() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new PermutationIterator<>(null);
        });
        assertEquals("collection", exception.getMessage());
    }

    @Test
    public void testConstructorWithEmptyCollection() {
        Collection<Integer> emptyCollection = Collections.emptyList();
        iterator = new PermutationIterator<>(emptyCollection);
        // Validate internal state for empty collection
        assertNotNull(iterator);
        // Validate private fields
        assertPrivateFieldsState(iterator, new int[0], new boolean[0], new HashMap<>(), new ArrayList<>());
    }

    @Test
    public void testConstructorWithNonEmptyCollection() {
        Collection<Integer> collection = Arrays.asList(1, 2, 3);
        iterator = new PermutationIterator<>(collection);
        // Validate internal state
        assertNotNull(iterator);
        // Validate private fields
        int[] expectedKeys = { 1, 2, 3 };
        boolean[] expectedDirection = { false, false, false };
        Map<Integer, Integer> expectedObjectMap = new HashMap<>();
        expectedObjectMap.put(1, 1);
        expectedObjectMap.put(2, 2);
        expectedObjectMap.put(3, 3);
        List<Integer> expectedNextPermutation = Arrays.asList(1, 2, 3);
        assertPrivateFieldsState(iterator, expectedKeys, expectedDirection, expectedObjectMap, expectedNextPermutation);
    }

    private void assertPrivateFieldsState(PermutationIterator<Integer> iterator, int[] expectedKeys, boolean[] expectedDirection, Map<Integer, Integer> expectedObjectMap, List<Integer> expectedNextPermutation) {
        try {
            Field keysField = PermutationIterator.class.getDeclaredField("keys");
            keysField.setAccessible(true);
            int[] keys = (int[]) keysField.get(iterator);
            assertArrayEquals(expectedKeys, keys);
            Field directionField = PermutationIterator.class.getDeclaredField("direction");
            directionField.setAccessible(true);
            boolean[] direction = (boolean[]) directionField.get(iterator);
            assertArrayEquals(expectedDirection, direction);
            Field objectMapField = PermutationIterator.class.getDeclaredField("objectMap");
            objectMapField.setAccessible(true);
            Map<Integer, Integer> objectMap = (Map<Integer, Integer>) objectMapField.get(iterator);
            assertEquals(expectedObjectMap.size(), objectMap.size());
            for (Map.Entry<Integer, Integer> entry : expectedObjectMap.entrySet()) {
                assertEquals(entry.getValue(), objectMap.get(entry.getKey()));
            }
            Field nextPermutationField = PermutationIterator.class.getDeclaredField("nextPermutation");
            nextPermutationField.setAccessible(true);
            List<Integer> nextPermutation = (List<Integer>) nextPermutationField.get(iterator);
            assertEquals(expectedNextPermutation, nextPermutation);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection access failed: " + e.getMessage());
        }
    }
}

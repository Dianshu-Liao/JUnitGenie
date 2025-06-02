package org.apache.commons.collections4.iterators;

import java.util.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.list.UnmodifiableList;

public class // Additional tests can be added here to cover more scenarios
CollatingIterator_CollatingIterator_17_0_Test {

    private CollatingIterator<String> collatingIterator;

    private Comparator<String> comparator;

    @BeforeEach
    public void setUp() {
        // Simple comparator for strings
        comparator = String::compareTo;
        collatingIterator = new CollatingIterator<>(comparator);
    }

    @Test
    public void testCollatingIteratorWithComparator() {
        // Verify that the instance is created correctly
        assertNotNull(collatingIterator);
    }

    @Test
    public void testCollatingIteratorWithDefaultCapacity() {
        // Create a new CollatingIterator with a custom comparator
        CollatingIterator<String> customIterator = new CollatingIterator<>(comparator);
        assertNotNull(customIterator);
    }

    @Test
    public void testCollatingIteratorWithNullComparator() {
        assertThrows(NullPointerException.class, () -> {
            new CollatingIterator<>(null);
        });
    }

    @Test
    public void testCollatingIteratorWithCustomCapacity() {
        CollatingIterator<String> customCapacityIterator = new CollatingIterator<>(comparator, 5);
        assertNotNull(customCapacityIterator);
    }

    @Test
    public void testCollatingIteratorWithEmptyIterators() {
        CollatingIterator<String> emptyIterator = new CollatingIterator<>(comparator, Collections.emptyList());
        assertNotNull(emptyIterator);
        assertFalse(emptyIterator.hasNext());
    }
}

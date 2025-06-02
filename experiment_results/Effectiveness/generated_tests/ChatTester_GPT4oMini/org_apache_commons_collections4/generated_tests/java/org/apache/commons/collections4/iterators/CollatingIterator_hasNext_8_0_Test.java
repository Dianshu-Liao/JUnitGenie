// Test method
package org.apache.commons.collections4.iterators;

import java.util.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.collections4.list.UnmodifiableList;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CollatingIterator_hasNext_8_0_Test {

    private CollatingIterator<String> collatingIterator;

    @BeforeEach
    void setUp() {
        collatingIterator = new CollatingIterator<>(String::compareTo);
    }

    @Test
    void testHasNextWithValuesSet() throws Exception {
        // Setup
        List<Iterator<String>> iterators = new ArrayList<>();
        iterators.add(Arrays.asList("apple", "banana").iterator());
        iterators.add(Arrays.asList("cherry", "date").iterator());
        // Using reflection to set the private field 'iterators'
        setPrivateField(collatingIterator, "iterators", iterators);
        setPrivateField(collatingIterator, "valueSet", new BitSet());
        // Act
        boolean result = collatingIterator.hasNext();
        // Assert
        assertTrue(result);
    }

    @Test
    void testHasNextWithNoValuesSet() throws Exception {
        // Setup
        List<Iterator<String>> iterators = new ArrayList<>();
        iterators.add(Collections.emptyIterator());
        iterators.add(Collections.emptyIterator());
        // Using reflection to set the private field 'iterators'
        setPrivateField(collatingIterator, "iterators", iterators);
        setPrivateField(collatingIterator, "valueSet", new BitSet());
        // Act
        boolean result = collatingIterator.hasNext();
        // Assert
        assertFalse(result);
    }

    @Test
    void testHasNextWithSomeIteratorsHasNext() throws Exception {
        // Setup
        List<Iterator<String>> iterators = new ArrayList<>();
        iterators.add(Arrays.asList("apple").iterator());
        iterators.add(Collections.emptyIterator());
        // Using reflection to set the private field 'iterators'
        setPrivateField(collatingIterator, "iterators", iterators);
        setPrivateField(collatingIterator, "valueSet", new BitSet());
        // Act
        boolean result = collatingIterator.hasNext();
        // Assert
        assertTrue(result);
    }

    @Test
    void testHasNextWithValuesSetAndEmptyIterators() throws Exception {
        // Setup
        List<Iterator<String>> iterators = new ArrayList<>();
        iterators.add(Collections.emptyIterator());
        iterators.add(Arrays.asList("banana").iterator());
        // Using reflection to set the private field 'iterators'
        setPrivateField(collatingIterator, "iterators", iterators);
        BitSet valueSet = new BitSet();
        // Simulate that the second iterator has a value set
        valueSet.set(1);
        setPrivateField(collatingIterator, "valueSet", valueSet);
        // Act
        boolean result = collatingIterator.hasNext();
        // Assert
        assertTrue(result);
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        // Fixed the buggy line here
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}

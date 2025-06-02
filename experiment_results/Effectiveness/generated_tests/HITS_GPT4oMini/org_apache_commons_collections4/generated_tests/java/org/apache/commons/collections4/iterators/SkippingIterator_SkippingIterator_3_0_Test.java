// Replace with the actual package name
package org.apache.commons.collections4.iterators;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class SkippingIterator_SkippingIterator_3_0_Test {

    @Test
    public void testConstructor_WithNegativeOffset_ShouldThrowIllegalArgumentException() {
        // Arrange
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        long negativeOffset = -1;
        // Act & Assert
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SkippingIterator<>(iterator, negativeOffset);
        });
        Assertions.assertEquals("Offset parameter must not be negative.", exception.getMessage());
    }

    @Test
    public void testConstructor_WithZeroOffset_ShouldNotThrowException() {
        // Arrange
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        long zeroOffset = 0;
        // Act
        SkippingIterator<Integer> skippingIterator = new SkippingIterator<>(iterator, zeroOffset);
        // Assert
        Assertions.assertNotNull(skippingIterator);
    }

    @Test
    public void testConstructor_WithPositiveOffset_ShouldNotThrowException() {
        // Arrange
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        long positiveOffset = 1;
        // Act
        SkippingIterator<Integer> skippingIterator = new SkippingIterator<>(iterator, positiveOffset);
        // Assert
        Assertions.assertNotNull(skippingIterator);
    }

    @Test
    public void testInit_WithOffsetGreaterThanIteratorSize_ShouldSkipAllElements() {
        // Arrange
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        // Greater than the size of the iterator
        long offset = 5;
        // Act
        SkippingIterator<Integer> skippingIterator = new SkippingIterator<>(iterator, offset);
        // Assert
        Assertions.assertFalse(skippingIterator.hasNext());
    }

    @Test
    public void testInit_WithOffsetLessThanIteratorSize_ShouldSkipElements() {
        // Arrange
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        // Should skip the first element
        long offset = 1;
        // Act
        SkippingIterator<Integer> skippingIterator = new SkippingIterator<>(iterator, offset);
        // Assert
        Assertions.assertTrue(skippingIterator.hasNext());
        Assertions.assertEquals(2, skippingIterator.next());
    }

    @Test
    public void testInit_WithOffsetEqualToIteratorSize_ShouldNotReturnAnyElements() {
        // Arrange
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        // Equal to the size of the iterator
        long offset = 3;
        // Act
        SkippingIterator<Integer> skippingIterator = new SkippingIterator<>(iterator, offset);
        // Assert
        Assertions.assertFalse(skippingIterator.hasNext());
    }
}

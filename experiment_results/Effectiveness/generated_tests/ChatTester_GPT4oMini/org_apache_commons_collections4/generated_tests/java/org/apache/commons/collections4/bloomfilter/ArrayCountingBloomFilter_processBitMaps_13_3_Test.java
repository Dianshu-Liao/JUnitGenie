package org.apache.commons.collections4.bloomfilter;

import java.util.Objects;
import java.util.function.LongPredicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class ArrayCountingBloomFilter_processBitMaps_13_3_Test {

    private ArrayCountingBloomFilter bloomFilter;

    private Shape shape;

    @BeforeEach
    public void setUp() {
        // Assuming Shape is a class that can be mocked
        shape = mock(Shape.class);
        bloomFilter = new ArrayCountingBloomFilter(shape);
    }

    @Test
    public void testProcessBitMaps_WithNonEmptyCells_ReturnsTrue() {
        // Arrange
        // Example cell values
        int[] cells = { 1, 0, 1, 1 };
        setCells(bloomFilter, cells);
        // Consumer that returns true for non-zero values
        LongPredicate consumer = value -> value != 0;
        // Act
        boolean result = bloomFilter.processBitMaps(consumer);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testProcessBitMaps_WithEmptyCells_ReturnsFalse() {
        // Arrange
        // All cells are zero
        int[] cells = { 0, 0, 0, 0 };
        setCells(bloomFilter, cells);
        // Consumer that returns true for non-zero values
        LongPredicate consumer = value -> value != 0;
        // Act
        boolean result = bloomFilter.processBitMaps(consumer);
        // Assert
        assertFalse(result);
    }

    @Test
    public void testProcessBitMaps_WithConsumerReturningFalse() {
        // Arrange
        // Example cell values
        int[] cells = { 1, 1, 1, 1 };
        setCells(bloomFilter, cells);
        // Consumer that always returns false
        LongPredicate consumer = value -> false;
        // Act
        boolean result = bloomFilter.processBitMaps(consumer);
        // Assert
        assertFalse(result);
    }

    @Test
    public void testProcessBitMaps_WithNullConsumer_ThrowsException() {
        // Arrange
        // Example cell values
        int[] cells = { 1, 0, 1, 1 };
        setCells(bloomFilter, cells);
        // Act & Assert
        assertThrows(NullPointerException.class, () -> bloomFilter.processBitMaps(null));
    }

    @Test
    public void testProcessBitMaps_WithAllCellsSet_ReturnsTrue() {
        // Arrange
        // All cells are non-zero
        int[] cells = { 1, 1, 1, 1, 1 };
        setCells(bloomFilter, cells);
        // 31 is the expected value for the given cells
        LongPredicate consumer = value -> value == 31;
        // Act
        boolean result = bloomFilter.processBitMaps(consumer);
        // Assert
        assertTrue(result);
    }

    private void setCells(ArrayCountingBloomFilter bloomFilter, int[] cells) {
        try {
            java.lang.reflect.Field field = ArrayCountingBloomFilter.class.getDeclaredField("cells");
            field.setAccessible(true);
            field.set(bloomFilter, cells);
        } catch (Exception e) {
            fail("Failed to set cells: " + e.getMessage());
        }
    }
}

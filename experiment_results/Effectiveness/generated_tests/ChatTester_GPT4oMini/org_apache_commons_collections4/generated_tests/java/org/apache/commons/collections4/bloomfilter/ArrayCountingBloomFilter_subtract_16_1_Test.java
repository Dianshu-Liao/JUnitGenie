package org.apache.commons.collections4.bloomfilter;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import java.util.stream.IntStream;

class ArrayCountingBloomFilter_subtract_16_1_Test {

    private ArrayCountingBloomFilter bloomFilter;

    private Shape shape;

    private CellExtractor cellExtractor;

    @BeforeEach
    void setUp() {
        shape = Mockito.mock(Shape.class);
        bloomFilter = new ArrayCountingBloomFilter(shape);
        cellExtractor = Mockito.mock(CellExtractor.class);
    }

    @Test
    void testSubtract_NonNullCellExtractor() {
        // Arrange
        Mockito.doAnswer(invocation -> {
            // Simulate processing of cells by invoking the subtract method on the bloom filter
            return null;
        }).when(cellExtractor).processCells(Mockito.any());
        // Act
        boolean result = bloomFilter.subtract(cellExtractor);
        // Assert
        assertTrue(result);
        // Verify that isValid() was called
        assertTrue(bloomFilter.isValid());
    }

    @Test
    void testSubtract_NullCellExtractor() {
        // Act & Assert
        Exception exception = assertThrows(NullPointerException.class, () -> {
            bloomFilter.subtract(null);
        });
        assertEquals("other", exception.getMessage());
    }

    @Test
    void testSubtract_WithValidCells() {
        // Arrange
        Mockito.doAnswer(invocation -> {
            // Simulate processing of cells
            return null;
        }).when(cellExtractor).processCells(Mockito.any());
        // Assuming isValid() returns true after valid operations
        Mockito.when(bloomFilter.isValid()).thenReturn(true);
        // Act
        boolean result = bloomFilter.subtract(cellExtractor);
        // Assert
        assertTrue(result);
    }

    @Test
    void testSubtract_WithInvalidCells() {
        // Arrange
        Mockito.doAnswer(invocation -> {
            // Simulate processing of cells
            return null;
        }).when(cellExtractor).processCells(Mockito.any());
        // Assuming isValid() returns false after invalid operations
        Mockito.when(bloomFilter.isValid()).thenReturn(false);
        // Act
        boolean result = bloomFilter.subtract(cellExtractor);
        // Assert
        assertFalse(result);
    }
}

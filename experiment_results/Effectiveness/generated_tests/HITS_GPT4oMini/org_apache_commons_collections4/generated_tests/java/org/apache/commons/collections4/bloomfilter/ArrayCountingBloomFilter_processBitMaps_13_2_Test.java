package org.apache.commons.collections4.bloomfilter;

import java.lang.reflect.Field;
import java.util.function.LongPredicate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

@ExtendWith(MockitoExtension.class)
public class ArrayCountingBloomFilter_processBitMaps_13_2_Test {

    private ArrayCountingBloomFilter bloomFilter;

    private Shape shape;

    @BeforeEach
    public void setUp() {
        shape = mock(Shape.class);
        when(shape.getNumberOfBits()).thenReturn(64);
        when(shape.getNumberOfHashFunctions()).thenReturn(3);
        bloomFilter = new ArrayCountingBloomFilter(shape);
    }

    private void setCells(int[] values) {
        try {
            Field cellsField = ArrayCountingBloomFilter.class.getDeclaredField("cells");
            cellsField.setAccessible(true);
            int[] cells = (int[]) cellsField.get(bloomFilter);
            for (int i = 0; i < values.length && i < cells.length; i++) {
                cells[i] = values[i];
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Failed to set cells", e);
        }
    }

    @Test
    public void testProcessBitMaps_WithNonEmptyCells() {
        setCells(new int[] { 1, 2 });
        LongPredicate consumer = value -> true;
        boolean result = bloomFilter.processBitMaps(consumer);
        assertTrue(result, "Expected processBitMaps to return true when consumer always returns true.");
    }

    @Test
    public void testProcessBitMaps_WithEmptyCells() {
        LongPredicate consumer = value -> true;
        boolean result = bloomFilter.processBitMaps(consumer);
        assertTrue(result, "Expected processBitMaps to return true when all cells are empty.");
    }

    @Test
    public void testProcessBitMaps_WithConsumerReturningFalse() {
        setCells(new int[] { 1, 2 });
        LongPredicate consumer = value -> false;
        boolean result = bloomFilter.processBitMaps(consumer);
        assertFalse(result, "Expected processBitMaps to return false when consumer returns false.");
    }

    @Test
    public void testProcessBitMaps_WithNullConsumer() {
        assertThrows(NullPointerException.class, () -> {
            bloomFilter.processBitMaps(null);
        }, "Expected NullPointerException when consumer is null.");
    }

    @Test
    public void testProcessBitMaps_WithFinalBlock() {
        setCells(new int[] { 1, 1, 0 });
        LongPredicate consumer = value -> value == 3;
        boolean result = bloomFilter.processBitMaps(consumer);
        assertTrue(result, "Expected processBitMaps to return true when final block matches consumer.");
    }
}

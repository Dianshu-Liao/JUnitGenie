package org.apache.commons.collections4.bloomfilter;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.function.LongPredicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

class ArrayCountingBloomFilter_processBitMaps_13_0_Test {

    private ArrayCountingBloomFilter bloomFilter;

    @BeforeEach
    void setUp() {
        // Example with 3 hash functions and 128 bits
        Shape shape = createShape(3, 128);
        bloomFilter = new ArrayCountingBloomFilter(shape);
    }

    @Test
    void testProcessBitMaps_withConsumerReturningTrue() {
        LongPredicate consumer = value -> {
            // Example consumer that always returns true
            return true;
        };
        boolean result = bloomFilter.processBitMaps(consumer);
        assertTrue(result);
    }

    @Test
    void testProcessBitMaps_withConsumerReturningFalse() {
        LongPredicate consumer = value -> {
            // Example consumer that returns false for a specific value
            // Will return false if the value is 0
            return value != 0;
        };
        boolean result = bloomFilter.processBitMaps(consumer);
        assertFalse(result);
    }

    @Test
    void testProcessBitMaps_withNullConsumer() {
        assertThrows(NullPointerException.class, () -> {
            bloomFilter.processBitMaps(null);
        });
    }

    @Test
    void testProcessBitMaps_withCellsHavingValues() {
        // Set some values in cells for testing
        // Assuming we have a way to manipulate the internal cells for testing
        // This will require reflection if cells are private
        // Example values
        setCells(new int[] { 1, 0, 1, 0, 0, 1 });
        // Returns false if the value is 0
        LongPredicate consumer = value -> value != 0;
        boolean result = bloomFilter.processBitMaps(consumer);
        // Expecting true as we have non-zero values
        assertTrue(result);
    }

    private void setCells(int[] values) {
        try {
            java.lang.reflect.Field cellsField = ArrayCountingBloomFilter.class.getDeclaredField("cells");
            cellsField.setAccessible(true);
            cellsField.set(bloomFilter, values);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set cells: " + e.getMessage());
        }
    }

    private Shape createShape(int hashFunctions, int bits) {
        try {
            java.lang.reflect.Constructor<Shape> constructor = Shape.class.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true);
            return constructor.newInstance(hashFunctions, bits);
        } catch (Exception e) {
            fail("Failed to create Shape: " + e.getMessage());
            // Unreachable, but required for compilation
            return null;
        }
    }
}

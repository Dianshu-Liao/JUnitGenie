package org.apache.commons.collections4.bloomfilter;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.function.Consumer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;

class SimpleBloomFilter_merge_8_4_Test {

    private SimpleBloomFilter bloomFilter;

    private Shape shape;

    @BeforeEach
    void setUp() {
        shape = mock(Shape.class);
        // Example number of bits
        when(shape.getNumberOfBits()).thenReturn(64);
        bloomFilter = new SimpleBloomFilter(shape);
    }

    @Test
    void testMergeWithValidBitMapExtractor() {
        // Create a mock BitMapExtractor
        BitMapExtractor bitMapExtractor = mock(BitMapExtractor.class);
        // Simulate processing bitmaps
        doAnswer(invocation -> {
            Consumer<Long> consumer = invocation.getArgument(0);
            // Simulating a valid bitmap
            consumer.accept(1L);
            return null;
        }).when(bitMapExtractor).processBitMaps(any());
        // Call the merge method
        boolean result = bloomFilter.merge(bitMapExtractor);
        // Verify the result
        assertTrue(result);
    }

    @Test
    void testMergeWithNullBitMapExtractor() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            bloomFilter.merge((BitMapExtractor) null);
        });
        assertEquals("bitMapExtractor", thrown.getMessage());
    }

    @Test
    void testMergeWithExceedingBitMapIndex() {
        BitMapExtractor bitMapExtractor = mock(BitMapExtractor.class);
        doAnswer(invocation -> {
            Consumer<Long> consumer = invocation.getArgument(0);
            // Simulating an exceeding bitmap
            consumer.accept(65L);
            return null;
        }).when(bitMapExtractor).processBitMaps(any());
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            bloomFilter.merge(bitMapExtractor);
        });
        assertTrue(thrown.getMessage().contains("BitMapExtractor set a bit higher than the limit for the shape: 64"));
    }

    @Test
    void testMergeWithIndexOutOfBounds() {
        BitMapExtractor bitMapExtractor = mock(BitMapExtractor.class);
        // Simulate processing bitmaps with out of bounds
        doAnswer(invocation -> {
            Consumer<Long> consumer = invocation.getArgument(0);
            throw new IndexOutOfBoundsException();
        }).when(bitMapExtractor).processBitMaps(any());
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            bloomFilter.merge(bitMapExtractor);
        });
        assertTrue(thrown.getMessage().contains("BitMapExtractor should send at most"));
    }
}

package org.apache.commons.collections4.bloomfilter;

import java.util.function.LongPredicate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import java.util.TreeSet;
import java.util.function.IntPredicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SparseBloomFilter_merge_10_1_Test {

    private SparseBloomFilter bloomFilter;

    private Shape shape;

    @BeforeEach
    void setUp() {
        // Create a mock Shape instance
        shape = mock(Shape.class);
        when(shape.getNumberOfBits()).thenReturn(10);
        when(shape.getNumberOfHashFunctions()).thenReturn(3);
        bloomFilter = new SparseBloomFilter(shape);
    }

    @Test
    void testMergeWithValidBitMapExtractor() {
        BitMapExtractor bitMapExtractor = new BitMapExtractor() {

            @Override
            public boolean processBitMaps(LongPredicate longPredicate) {
                longPredicate.test(1L);
                longPredicate.test(2L);
                return true;
            }
        };
        assertTrue(bloomFilter.merge(bitMapExtractor));
    }

    @Test
    void testMergeWithEmptyBitMapExtractor() {
        BitMapExtractor bitMapExtractor = new BitMapExtractor() {

            @Override
            public boolean processBitMaps(LongPredicate longPredicate) {
                return true;
            }
        };
        assertTrue(bloomFilter.merge(bitMapExtractor));
    }

    @Test
    void testMergeWithInvalidBitMapExtractor() {
        BitMapExtractor bitMapExtractor = new BitMapExtractor() {

            @Override
            public boolean processBitMaps(LongPredicate longPredicate) {
                longPredicate.test(-1L);
                return true;
            }
        };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bloomFilter.merge(bitMapExtractor);
        });
        assertTrue(exception.getMessage().contains("Value in list"));
    }

    @Test
    void testMergeWithOutOfBoundBitMapExtractor() {
        BitMapExtractor bitMapExtractor = new BitMapExtractor() {

            @Override
            public boolean processBitMaps(LongPredicate longPredicate) {
                longPredicate.test(10L);
                return true;
            }
        };
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bloomFilter.merge(bitMapExtractor);
        });
        assertTrue(exception.getMessage().contains("Value in list"));
    }
}

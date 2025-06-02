package org.apache.commons.collections4.bloomfilter;

import java.util.Objects;
import java.util.TreeSet;
import java.util.function.IntPredicate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.function.LongPredicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class SparseBloomFilter_merge_10_2_Test {

    private SparseBloomFilter sparseBloomFilter;

    private Shape shape;

    @BeforeEach
    public void setUp() {
        shape = mock(Shape.class);
        when(shape.getNumberOfBits()).thenReturn(10);
        when(shape.getNumberOfHashFunctions()).thenReturn(3);
        sparseBloomFilter = new SparseBloomFilter(shape);
    }

    @Test
    public void testMergeWithValidIndexExtractor() {
        IndexExtractor indexExtractor = mock(IndexExtractor.class);
        doAnswer(invocation -> {
            IntPredicate consumer = invocation.getArgument(0);
            // Simulate adding a valid index
            consumer.test(1);
            return null;
        }).when(indexExtractor).processIndices(any());
        boolean result = sparseBloomFilter.merge((IndexExtractor) indexExtractor);
        assertTrue(result);
    }

    @Test
    public void testMergeWithEmptyIndices() {
        IndexExtractor indexExtractor = mock(IndexExtractor.class);
        doAnswer(invocation -> {
            IntPredicate consumer = invocation.getArgument(0);
            // Simulate no indices
            return null;
        }).when(indexExtractor).processIndices(any());
        boolean result = sparseBloomFilter.merge((IndexExtractor) indexExtractor);
        assertTrue(result);
    }

    @Test
    public void testMergeWithNegativeIndex() {
        IndexExtractor indexExtractor = mock(IndexExtractor.class);
        doAnswer(invocation -> {
            IntPredicate consumer = invocation.getArgument(0);
            // Simulate adding a negative index
            consumer.test(-1);
            return null;
        }).when(indexExtractor).processIndices(any());
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            sparseBloomFilter.merge((IndexExtractor) indexExtractor);
        });
        assertEquals("Value in list -1 is less than 0", exception.getMessage());
    }

    @Test
    public void testMergeWithIndexGreaterThanMax() {
        IndexExtractor indexExtractor = mock(IndexExtractor.class);
        doAnswer(invocation -> {
            IntPredicate consumer = invocation.getArgument(0);
            // Simulate adding an index greater than the maximum value
            consumer.test(10);
            return null;
        }).when(indexExtractor).processIndices(any());
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            sparseBloomFilter.merge((IndexExtractor) indexExtractor);
        });
        assertEquals("Value in list 10 is greater than maximum value (9)", exception.getMessage());
    }
}

package org.apache.commons.collections4.bloomfilter;

import org.apache.commons.collections4.bloomfilter.Shape;
import org.apache.commons.collections4.bloomfilter.SparseBloomFilter;
import org.apache.commons.collections4.bloomfilter.BloomFilter;
import org.apache.commons.collections4.bloomfilter.IndexExtractor;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import java.util.TreeSet;
import java.util.function.IntPredicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.function.LongPredicate;

class SparseBloomFilter_merge_11_3_Test {

    private SparseBloomFilter sparseBloomFilter;

    private Shape shape;

    @BeforeEach
    void setUp() {
        // Assuming Shape has a public constructor for testing
        shape = Mockito.mock(Shape.class);
        sparseBloomFilter = new SparseBloomFilter(shape);
    }

    @Test
    void testMergeWithValidIndexExtractor() throws Exception {
        // Create a mock IndexExtractor
        IndexExtractor mockIndexExtractor = mock(IndexExtractor.class);
        doAnswer(invocation -> {
            IntPredicate consumer = invocation.getArgument(0);
            consumer.test(10);
            consumer.test(20);
            return null;
        }).when(mockIndexExtractor).processIndices(any());
        // Create a mock BloomFilter
        BloomFilter<?> mockBloomFilter = mock(BloomFilter.class);
        // Assuming SPARSE is 1
        when(mockBloomFilter.characteristics()).thenReturn(1);
        // Invoke the private merge method using reflection
        Method mergeMethod = SparseBloomFilter.class.getDeclaredMethod("merge", BloomFilter.class);
        mergeMethod.setAccessible(true);
        // Execute merge
        boolean result = (boolean) mergeMethod.invoke(sparseBloomFilter, mockBloomFilter);
        // Verify the result
        assertTrue(result);
        // Additional assertions can be made on the internal state of sparseBloomFilter if necessary
    }

    @Test
    void testMergeWithNullBloomFilter() throws Exception {
        Method mergeMethod = SparseBloomFilter.class.getDeclaredMethod("merge", BloomFilter.class);
        mergeMethod.setAccessible(true);
        Exception exception = assertThrows(NullPointerException.class, () -> {
            mergeMethod.invoke(sparseBloomFilter, null);
        });
        assertEquals("other", exception.getMessage());
    }

    @Test
    void testMergeWithInvalidIndexExtractor() throws Exception {
        // Create a mock IndexExtractor that provides a negative index
        IndexExtractor mockIndexExtractor = mock(IndexExtractor.class);
        doAnswer(invocation -> {
            IntPredicate consumer = invocation.getArgument(0);
            consumer.test(-1);
            return null;
        }).when(mockIndexExtractor).processIndices(any());
        Method mergeMethod = SparseBloomFilter.class.getDeclaredMethod("merge", BloomFilter.class);
        mergeMethod.setAccessible(true);
        BloomFilter<?> mockBloomFilter = mock(BloomFilter.class);
        when(mockBloomFilter.characteristics()).thenReturn(1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            mergeMethod.invoke(sparseBloomFilter, mockBloomFilter);
        });
        assertTrue(exception.getMessage().contains("Value in list -1 is less than 0"));
    }

    @Test
    void testMergeWithOutOfBoundsIndex() throws Exception {
        // Create a mock IndexExtractor that provides an out-of-bounds index
        IndexExtractor mockIndexExtractor = mock(IndexExtractor.class);
        doAnswer(invocation -> {
            IntPredicate consumer = invocation.getArgument(0);
            consumer.test(101);
            return null;
        }).when(mockIndexExtractor).processIndices(any());
        Method mergeMethod = SparseBloomFilter.class.getDeclaredMethod("merge", BloomFilter.class);
        mergeMethod.setAccessible(true);
        BloomFilter<?> mockBloomFilter = mock(BloomFilter.class);
        when(mockBloomFilter.characteristics()).thenReturn(1);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            mergeMethod.invoke(sparseBloomFilter, mockBloomFilter);
        });
        assertTrue(exception.getMessage().contains("Value in list 101 is greater than maximum value (99)"));
    }
}

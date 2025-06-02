package org.apache.commons.collections4.bloomfilter;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleBloomFilter_merge_9_0_Test {

    private SimpleBloomFilter bloomFilter;

    private BloomFilter<?> mockBloomFilter;

    @BeforeEach
    public void setUp() {
        Shape shape = mock(Shape.class);
        bloomFilter = new SimpleBloomFilter(shape);
        mockBloomFilter = mock(BloomFilter.class);
    }

    @Test
    public void testMerge_NonSparse() {
        // Non-sparse
        when(mockBloomFilter.characteristics()).thenReturn(0);
        assertTrue(bloomFilter.merge(mockBloomFilter));
        // Verify that the merge method for BitMapExtractor was called
        // You may need to mock the BitMapExtractor behavior if necessary
    }

    @Test
    public void testMerge_Sparse() {
        // Sparse
        when(mockBloomFilter.characteristics()).thenReturn(SimpleBloomFilter.SPARSE);
        assertTrue(bloomFilter.merge(mockBloomFilter));
        // Verify that the merge method for IndexExtractor was called
        // You may need to mock the IndexExtractor behavior if necessary
    }

    @Test
    public void testMerge_NullOther() {
        assertThrows(NullPointerException.class, () -> {
            // Fixed line: casting to Hasher
            bloomFilter.merge((Hasher) null);
        });
    }

    // Reflection test for private merge methods
    @Test
    public void testPrivateMergeMethods() throws Exception {
        Method mergeIndexExtractorMethod = SimpleBloomFilter.class.getDeclaredMethod("merge", IndexExtractor.class);
        mergeIndexExtractorMethod.setAccessible(true);
        Method mergeBitMapExtractorMethod = SimpleBloomFilter.class.getDeclaredMethod("merge", BitMapExtractor.class);
        mergeBitMapExtractorMethod.setAccessible(true);
        // You can create instances of IndexExtractor and BitMapExtractor for testing
        IndexExtractor indexExtractor = mock(IndexExtractor.class);
        BitMapExtractor bitMapExtractor = mock(BitMapExtractor.class);
        // Test private merge method for IndexExtractor
        mergeIndexExtractorMethod.invoke(bloomFilter, indexExtractor);
        // Test private merge method for BitMapExtractor
        mergeBitMapExtractorMethod.invoke(bloomFilter, bitMapExtractor);
        // Assertions can be added based on the expected behavior of these private methods
    }
}

package org.apache.commons.collections4.bloomfilter;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.TreeSet;
import java.util.function.IntPredicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.function.LongPredicate;

@ExtendWith(MockitoExtension.class)
class SparseBloomFilter_merge_10_4_Test {

    private SparseBloomFilter sparseBloomFilter;

    private Shape shape;

    @BeforeEach
    void setUp() throws Exception {
        // Use reflection to access the private constructor of Shape
        Constructor<Shape> constructor = Shape.class.getDeclaredConstructor(int.class, int.class);
        constructor.setAccessible(true);
        shape = constructor.newInstance(3, 10);
        sparseBloomFilter = new SparseBloomFilter(shape);
    }

    @Test
    void testMergeWithValidIndexExtractor() {
        // Arrange
        BitMapExtractor bitMapExtractor = mock(BitMapExtractor.class);
        IndexExtractor indexExtractor = mock(IndexExtractor.class);
        when(IndexExtractor.fromBitMapExtractor(bitMapExtractor)).thenReturn(indexExtractor);
        doAnswer(invocation -> {
            IntPredicate action = invocation.getArgument(0);
            // Simulate processing index 1
            action.test(1);
            return null;
        }).when(indexExtractor).processIndices(any());
        // Act
        boolean result = invokeMerge(bitMapExtractor);
        // Assert
        assertTrue(result);
    }

    @Test
    void testMergeWithNullBitMapExtractor() {
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeMerge(null);
        });
        assertEquals("bitMapExtractor", exception.getMessage());
    }

    @Test
    void testMergeWithIndexExtractorThrowsIllegalArgumentExceptionForNegativeIndex() {
        // Arrange
        BitMapExtractor bitMapExtractor = mock(BitMapExtractor.class);
        IndexExtractor indexExtractor = mock(IndexExtractor.class);
        when(IndexExtractor.fromBitMapExtractor(bitMapExtractor)).thenReturn(indexExtractor);
        doAnswer(invocation -> {
            IntPredicate action = invocation.getArgument(0);
            // Simulate processing index -1
            action.test(-1);
            return null;
        }).when(indexExtractor).processIndices(any());
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeMerge(bitMapExtractor);
        });
        assertEquals("Value in list -1 is less than 0", exception.getMessage());
    }

    @Test
    void testMergeWithIndexExtractorThrowsIllegalArgumentExceptionForOutOfBoundIndex() {
        // Arrange
        BitMapExtractor bitMapExtractor = mock(BitMapExtractor.class);
        IndexExtractor indexExtractor = mock(IndexExtractor.class);
        when(IndexExtractor.fromBitMapExtractor(bitMapExtractor)).thenReturn(indexExtractor);
        doAnswer(invocation -> {
            IntPredicate action = invocation.getArgument(0);
            // Simulate processing index 10 which is out of bounds
            action.test(10);
            return null;
        }).when(indexExtractor).processIndices(any());
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            invokeMerge(bitMapExtractor);
        });
        assertEquals("Value in list 10 is greater than maximum value (9)", exception.getMessage());
    }

    @Test
    void testMergeWithEmptyIndices() {
        // Arrange
        BitMapExtractor bitMapExtractor = mock(BitMapExtractor.class);
        IndexExtractor indexExtractor = mock(IndexExtractor.class);
        when(IndexExtractor.fromBitMapExtractor(bitMapExtractor)).thenReturn(indexExtractor);
        doAnswer(invocation -> {
            IntPredicate action = invocation.getArgument(0);
            // No indices processed
            return null;
        }).when(indexExtractor).processIndices(any());
        // Act
        boolean result = invokeMerge(bitMapExtractor);
        // Assert
        assertTrue(result);
    }

    private boolean invokeMerge(BitMapExtractor bitMapExtractor) {
        try {
            Method mergeMethod = SparseBloomFilter.class.getDeclaredMethod("merge", BitMapExtractor.class);
            mergeMethod.setAccessible(true);
            return (boolean) mergeMethod.invoke(sparseBloomFilter, bitMapExtractor);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

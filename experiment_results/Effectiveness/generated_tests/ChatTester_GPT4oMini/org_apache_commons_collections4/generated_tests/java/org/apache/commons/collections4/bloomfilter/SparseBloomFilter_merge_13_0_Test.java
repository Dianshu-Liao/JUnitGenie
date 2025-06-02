// Test method
package org.apache.commons.collections4.bloomfilter;

import java.util.TreeSet;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class SparseBloomFilter_merge_13_0_Test {

    private SparseBloomFilter sparseBloomFilter;

    private Shape shapeMock;

    private IndexExtractor indexExtractorMock;

    @BeforeEach
    void setUp() {
        shapeMock = mock(Shape.class);
        indexExtractorMock = mock(IndexExtractor.class);
        // Assuming a shape with 10 bits
        when(shapeMock.getNumberOfBits()).thenReturn(10);
        sparseBloomFilter = new SparseBloomFilter(shapeMock);
    }

    @Test
    void testMergeWithValidIndices() {
        // Given
        TreeSet<Integer> indices = new TreeSet<>();
        indices.add(0);
        indices.add(5);
        indices.add(9);
        // Use reflection to set the private field `indices`
        setPrivateField(sparseBloomFilter, "indices", indices);
        // When
        boolean result = sparseBloomFilter.merge(indexExtractorMock);
        // Then
        assertTrue(result);
        verify(indexExtractorMock).processIndices(any());
    }

    @Test
    void testMergeWithIndexGreaterThanMax() {
        // Given
        TreeSet<Integer> indices = new TreeSet<>();
        // Greater than the maximum allowed
        indices.add(11);
        setPrivateField(sparseBloomFilter, "indices", indices);
        // When & Then
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            sparseBloomFilter.merge(indexExtractorMock);
        });
        assertEquals("Value in list 11 is greater than maximum value (9)", thrown.getMessage());
    }

    @Test
    void testMergeWithIndexLessThanZero() {
        // Given
        TreeSet<Integer> indices = new TreeSet<>();
        // Less than zero
        indices.add(-1);
        setPrivateField(sparseBloomFilter, "indices", indices);
        // When & Then
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            sparseBloomFilter.merge(indexExtractorMock);
        });
        assertEquals("Value in list -1 is less than 0", thrown.getMessage());
    }

    @Test
    void testMergeWithNullIndexExtractor() {
        // When & Then
        NullPointerException thrown = assertThrows(NullPointerException.class, () -> {
            sparseBloomFilter.merge((IndexExtractor) null);
        });
        assertEquals("indexExtractor", thrown.getMessage());
    }

    private void setPrivateField(Object target, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

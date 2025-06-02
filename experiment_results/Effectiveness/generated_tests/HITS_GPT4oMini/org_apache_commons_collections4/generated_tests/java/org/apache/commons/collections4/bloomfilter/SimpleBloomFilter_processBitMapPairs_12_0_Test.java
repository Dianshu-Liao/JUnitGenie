package org.apache.commons.collections4.bloomfilter;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.LongPredicate;

@ExtendWith(MockitoExtension.class)
public class SimpleBloomFilter_processBitMapPairs_12_0_Test {

    private SimpleBloomFilter bloomFilter;

    private Shape shape;

    @BeforeEach
    public void setUp() {
        // Assuming we can create Shape through some factory method
        shape = mock(Shape.class);
        when(shape.getNumberOfBits()).thenReturn(64);
        when(shape.getNumberOfHashFunctions()).thenReturn(3);
        bloomFilter = new SimpleBloomFilter(shape);
    }

    @Test
    public void testProcessBitMapPairs_WhenPredicateReturnsTrue() {
        // Arrange
        BitMapExtractor extractor = mock(BitMapExtractor.class);
        LongBiPredicate predicate = (value, index) -> true;
        when(extractor.processBitMaps(any(CountingLongPredicate.class))).thenReturn(true);
        // Act
        boolean result = bloomFilter.processBitMapPairs(extractor, predicate);
        // Assert
        assertTrue(result);
        verify(extractor, times(1)).processBitMaps(any(CountingLongPredicate.class));
    }

    @Test
    public void testProcessBitMapPairs_WhenPredicateReturnsFalse() {
        // Arrange
        BitMapExtractor extractor = mock(BitMapExtractor.class);
        LongBiPredicate predicate = (value, index) -> false;
        when(extractor.processBitMaps(any(CountingLongPredicate.class))).thenReturn(true);
        // Act
        boolean result = bloomFilter.processBitMapPairs(extractor, predicate);
        // Assert
        assertFalse(result);
        verify(extractor, times(1)).processBitMaps(any(CountingLongPredicate.class));
    }

    @Test
    public void testProcessBitMapPairs_WhenExtractorReturnsFalse() {
        // Arrange
        BitMapExtractor extractor = mock(BitMapExtractor.class);
        LongBiPredicate predicate = (value, index) -> true;
        when(extractor.processBitMaps(any(CountingLongPredicate.class))).thenReturn(false);
        // Act
        boolean result = bloomFilter.processBitMapPairs(extractor, predicate);
        // Assert
        assertFalse(result);
        verify(extractor, times(1)).processBitMaps(any(CountingLongPredicate.class));
    }
}

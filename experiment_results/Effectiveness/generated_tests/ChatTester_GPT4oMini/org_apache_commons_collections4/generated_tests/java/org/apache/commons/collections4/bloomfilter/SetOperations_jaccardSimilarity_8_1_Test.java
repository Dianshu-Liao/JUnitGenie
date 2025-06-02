// Test method
package org.apache.commons.collections4.bloomfilter;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.function.LongConsumer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.function.LongBinaryOperator;

@ExtendWith(MockitoExtension.class)
public class SetOperations_jaccardSimilarity_8_1_Test {

    private BitMapExtractor first;

    private BitMapExtractor second;

    @BeforeEach
    public void setUp() {
        first = mock(BitMapExtractor.class);
        second = mock(BitMapExtractor.class);
    }

    @Test
    public void testJaccardSimilarityBothEmpty() {
        when(first.processBitMapPairs(any(), any())).thenAnswer(invocation -> {
            // No pairs to process
            return true;
        });
        double result = SetOperations.jaccardSimilarity(first, second);
        assertEquals(0.0, result);
    }

    @Test
    public void testJaccardSimilarityNoIntersection() {
        when(first.processBitMapPairs(any(), any())).thenAnswer(invocation -> {
            LongConsumer consumer = invocation.getArgument(1);
            consumer.accept(0b0000_0000_0000_0000_0000_0000_0000_0001L);
            consumer.accept(0b0000_0000_0000_0000_0000_0000_0000_0010L);
            return true;
        });
        double result = SetOperations.jaccardSimilarity(first, second);
        assertEquals(0.0, result);
    }

    @Test
    public void testJaccardSimilarityWithIntersection() {
        when(first.processBitMapPairs(any(), any())).thenAnswer(invocation -> {
            LongConsumer consumer = invocation.getArgument(1);
            consumer.accept(0b0000_0000_0000_0000_0000_0000_0000_0011L);
            consumer.accept(0b0000_0000_0000_0000_0000_0000_0000_0011L);
            return true;
        });
        double result = SetOperations.jaccardSimilarity(first, second);
        assertEquals(1.0, result);
    }

    @Test
    public void testJaccardSimilarityPartialIntersection() {
        when(first.processBitMapPairs(any(), any())).thenAnswer(invocation -> {
            LongConsumer consumer = invocation.getArgument(1);
            consumer.accept(0b0000_0000_0000_0000_0000_0000_0000_0011L);
            consumer.accept(0b0000_0000_0000_0000_0000_0000_0000_0111L);
            return true;
        });
        double result = SetOperations.jaccardSimilarity(first, second);
        assertEquals(0.5, result);
    }
}

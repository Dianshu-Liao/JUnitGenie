package org.apache.commons.collections4.bloomfilter;

import org.apache.commons.collections4.bloomfilter.BitMapExtractor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.function.LongBinaryOperator;

public class SetOperations_jaccardSimilarity_8_0_Test {

    @Test
    public void testJaccardSimilarity_NoIntersection() {
        BitMapExtractor first = Mockito.mock(BitMapExtractor.class);
        BitMapExtractor second = Mockito.mock(BitMapExtractor.class);
        // Simulate the processBitMapPairs method to have no intersection
        Mockito.doAnswer(invocation -> {
            LongBinaryOperator operator = invocation.getArgument(1);
            // No bits set
            operator.applyAsLong(0b0000, 0b0000);
            return true;
        }).when(first).processBitMapPairs(Mockito.eq(second), Mockito.any());
        double result = SetOperations.jaccardSimilarity(first, second);
        assertEquals(0.0, result);
    }

    @Test
    public void testJaccardSimilarity_FullIntersection() {
        BitMapExtractor first = Mockito.mock(BitMapExtractor.class);
        BitMapExtractor second = Mockito.mock(BitMapExtractor.class);
        // Simulate the processBitMapPairs method to have full intersection
        Mockito.doAnswer(invocation -> {
            LongBinaryOperator operator = invocation.getArgument(1);
            // All bits set
            operator.applyAsLong(0b1111, 0b1111);
            return true;
        }).when(first).processBitMapPairs(Mockito.eq(second), Mockito.any());
        double result = SetOperations.jaccardSimilarity(first, second);
        assertEquals(1.0, result);
    }

    @Test
    public void testJaccardSimilarity_PartialIntersection() {
        BitMapExtractor first = Mockito.mock(BitMapExtractor.class);
        BitMapExtractor second = Mockito.mock(BitMapExtractor.class);
        // Simulate the processBitMapPairs method to have partial intersection
        Mockito.doAnswer(invocation -> {
            LongBinaryOperator operator = invocation.getArgument(1);
            // 2 bits in common, 3 bits total
            operator.applyAsLong(0b1100, 0b1110);
            return true;
        }).when(first).processBitMapPairs(Mockito.eq(second), Mockito.any());
        double result = SetOperations.jaccardSimilarity(first, second);
        assertEquals(2.0 / 3.0, result);
    }
}

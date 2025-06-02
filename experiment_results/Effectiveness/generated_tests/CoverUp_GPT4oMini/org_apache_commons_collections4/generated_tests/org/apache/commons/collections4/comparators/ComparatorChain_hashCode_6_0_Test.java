package org.apache.commons.collections4.comparators;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Objects;

class ComparatorChain_hashCode_6_0_Test {

    private ComparatorChain<Integer> comparatorChain;

    @BeforeEach
    void setUp() {
        comparatorChain = new ComparatorChain<>();
    }

    @Test
    void testHashCode_NullComparatorsAndOrderingBits() {
        // Given
        ComparatorChain<Integer> chain = new ComparatorChain<>();
        // When
        int hashCode = chain.hashCode();
        // Then
        assertEquals(0, hashCode);
    }

    @Test
    void testHashCode_WithComparators() {
        // Given
        List<Comparator<Integer>> comparators = new ArrayList<>();
        comparators.add(Comparator.naturalOrder());
        comparatorChain = new ComparatorChain<>(comparators);
        // When
        int hashCode = comparatorChain.hashCode();
        // Then
        assertEquals(comparators.hashCode(), hashCode);
    }

    @Test
    void testHashCode_WithOrderingBits() {
        // Given
        List<Comparator<Integer>> comparators = new ArrayList<>();
        BitSet bits = new BitSet();
        bits.set(0);
        comparatorChain = new ComparatorChain<>(comparators, bits);
        // When
        int hashCode = comparatorChain.hashCode();
        // Then
        assertEquals(comparators.hashCode() ^ bits.hashCode(), hashCode);
    }

    @Test
    void testHashCode_WithBothComparatorsAndOrderingBits() {
        // Given
        List<Comparator<Integer>> comparators = new ArrayList<>();
        comparators.add(Comparator.naturalOrder());
        BitSet bits = new BitSet();
        bits.set(0);
        comparatorChain = new ComparatorChain<>(comparators, bits);
        // When
        int hashCode = comparatorChain.hashCode();
        // Then
        assertEquals(comparators.hashCode() ^ bits.hashCode(), hashCode);
    }

    @Test
    void testHashCode_WithEmptyComparatorsAndOrderingBits() {
        // Given
        List<Comparator<Integer>> comparators = new ArrayList<>();
        BitSet bits = new BitSet();
        comparatorChain = new ComparatorChain<>(comparators, bits);
        // When
        int hashCode = comparatorChain.hashCode();
        // Then
        assertEquals(comparators.hashCode() ^ bits.hashCode(), hashCode);
    }
}

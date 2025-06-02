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

public class ComparatorChain_hashCode_6_0_Test {

    private ComparatorChain comparatorChain;

    @BeforeEach
    public void setUp() {
        comparatorChain = new ComparatorChain();
    }

    @Test
    public void testHashCode_WithNullComparatorChainAndOrderingBits() {
        // Given
        ComparatorChain chain = new ComparatorChain();
        // When
        int hashCode = chain.hashCode();
        // Then
        assertEquals(0, hashCode);
    }

    @Test
    public void testHashCode_WithNonNullComparatorChain() {
        // Given
        List<Comparator<String>> comparators = new ArrayList<>();
        comparators.add(Comparator.naturalOrder());
        ComparatorChain chain = new ComparatorChain(comparators);
        // When
        int hashCode = chain.hashCode();
        // Then
        assertEquals(comparators.hashCode(), hashCode);
    }

    @Test
    public void testHashCode_WithNonNullOrderingBits() {
        // Given
        BitSet bits = new BitSet();
        bits.set(0);
        ComparatorChain chain = new ComparatorChain(new ArrayList<>(), bits);
        // When
        int hashCode = chain.hashCode();
        // Then
        assertEquals(bits.hashCode(), hashCode);
    }

    @Test
    public void testHashCode_WithBothNonNullComparatorChainAndOrderingBits() {
        // Given
        List<Comparator<String>> comparators = new ArrayList<>();
        comparators.add(Comparator.naturalOrder());
        BitSet bits = new BitSet();
        bits.set(0);
        ComparatorChain chain = new ComparatorChain(comparators, bits);
        // When
        int hashCode = chain.hashCode();
        // Then
        int expectedHashCode = comparators.hashCode() ^ bits.hashCode();
        assertEquals(expectedHashCode, hashCode);
    }
}

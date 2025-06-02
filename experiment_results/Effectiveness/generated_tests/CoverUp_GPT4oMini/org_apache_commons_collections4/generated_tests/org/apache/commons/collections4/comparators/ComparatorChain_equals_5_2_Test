package org.apache.commons.collections4.comparators;

import org.apache.commons.collections4.comparators.ComparatorChain;
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

class ComparatorChain_equals_5_2_Test {

    @Test
    void testEquals_SameInstance() {
        ComparatorChain<String> chain = new ComparatorChain<>();
        assertTrue(chain.equals(chain));
    }

    @Test
    void testEquals_NullObject() {
        ComparatorChain<String> chain = new ComparatorChain<>();
        assertFalse(chain.equals(null));
    }

    @Test
    void testEquals_DifferentClass() {
        ComparatorChain<String> chain = new ComparatorChain<>();
        assertFalse(chain.equals("Not a ComparatorChain"));
    }

    @Test
    void testEquals_EqualChains() {
        List<Comparator<String>> comparators1 = new ArrayList<>();
        List<Comparator<String>> comparators2 = new ArrayList<>();
        BitSet bits1 = new BitSet();
        BitSet bits2 = new BitSet();
        ComparatorChain<String> chain1 = new ComparatorChain<>(comparators1, bits1);
        ComparatorChain<String> chain2 = new ComparatorChain<>(comparators2, bits2);
        assertTrue(chain1.equals(chain2));
    }

    @Test
    void testEquals_DifferentOrderingBits() {
        List<Comparator<String>> comparators = new ArrayList<>();
        BitSet bits1 = new BitSet();
        BitSet bits2 = new BitSet();
        // Different ordering
        bits2.set(0);
        ComparatorChain<String> chain1 = new ComparatorChain<>(comparators, bits1);
        ComparatorChain<String> chain2 = new ComparatorChain<>(comparators, bits2);
        assertFalse(chain1.equals(chain2));
    }

    @Test
    void testEquals_DifferentComparators() {
        List<Comparator<String>> comparators1 = new ArrayList<>();
        List<Comparator<String>> comparators2 = new ArrayList<>();
        comparators1.add(Comparator.naturalOrder());
        // Different comparator
        comparators2.add(Comparator.reverseOrder());
        BitSet bits = new BitSet();
        ComparatorChain<String> chain1 = new ComparatorChain<>(comparators1, bits);
        ComparatorChain<String> chain2 = new ComparatorChain<>(comparators2, bits);
        assertFalse(chain1.equals(chain2));
    }

    @Test
    void testEquals_EqualChainsWithDifferentOrderings() {
        List<Comparator<String>> comparators = new ArrayList<>();
        BitSet bits1 = new BitSet();
        BitSet bits2 = new BitSet();
        // Different ordering
        bits1.set(0);
        ComparatorChain<String> chain1 = new ComparatorChain<>(comparators, bits1);
        ComparatorChain<String> chain2 = new ComparatorChain<>(comparators, bits2);
        assertFalse(chain1.equals(chain2));
    }
}

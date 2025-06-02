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

public class ComparatorChain_equals_5_0_Test {

    @Test
    public void testEquals_SameReference() {
        ComparatorChain<String> chain = new ComparatorChain<>(new ArrayList<>(), new BitSet());
        assertTrue(chain.equals(chain), "Should be equal to itself");
    }

    @Test
    public void testEquals_Null() {
        ComparatorChain<String> chain = new ComparatorChain<>(new ArrayList<>(), new BitSet());
        assertFalse(chain.equals(null), "Should not be equal to null");
    }

    @Test
    public void testEquals_DifferentClass() {
        ComparatorChain<String> chain = new ComparatorChain<>(new ArrayList<>(), new BitSet());
        assertFalse(chain.equals(new Object()), "Should not be equal to an object of different class");
    }

    @Test
    public void testEquals_SameContent() {
        List<Comparator<String>> comparators = new ArrayList<>();
        BitSet bits = new BitSet();
        ComparatorChain<String> chain1 = new ComparatorChain<>(comparators, bits);
        ComparatorChain<String> chain2 = new ComparatorChain<>(comparators, bits);
        assertTrue(chain1.equals(chain2), "Should be equal to another chain with same content");
    }

    @Test
    public void testEquals_DifferentContent() {
        List<Comparator<String>> comparators1 = new ArrayList<>();
        List<Comparator<String>> comparators2 = new ArrayList<>();
        BitSet bits1 = new BitSet();
        BitSet bits2 = new BitSet();
        ComparatorChain<String> chain1 = new ComparatorChain<>(comparators1, bits1);
        ComparatorChain<String> chain2 = new ComparatorChain<>(comparators2, bits2);
        // Add a different comparator to chain2
        comparators2.add((o1, o2) -> 0);
        assertFalse(chain1.equals(chain2), "Should not be equal to another chain with different content");
    }
}

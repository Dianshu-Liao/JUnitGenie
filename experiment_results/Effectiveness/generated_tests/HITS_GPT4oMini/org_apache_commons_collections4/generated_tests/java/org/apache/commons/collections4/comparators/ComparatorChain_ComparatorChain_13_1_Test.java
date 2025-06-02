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

public class ComparatorChain_ComparatorChain_13_1_Test {

    private ComparatorChain<Integer> chain;

    @BeforeEach
    public void setUp() {
        List<Comparator<Integer>> comparators = new ArrayList<>();
        // Ascending order
        comparators.add(Comparator.naturalOrder());
        chain = new ComparatorChain<>(comparators);
    }

    @Test
    public void testCompare_LesserElement() {
        int result = chain.compare(1, 2);
        assertEquals(-1, result, "Expected 1 to be less than 2");
    }

    @Test
    public void testCompare_GreaterElement() {
        int result = chain.compare(3, 2);
        assertEquals(1, result, "Expected 3 to be greater than 2");
    }

    @Test
    public void testCompare_EqualElements() {
        int result = chain.compare(2, 2);
        assertEquals(0, result, "Expected 2 to be equal to 2");
    }

    @Test
    public void testCompareWithReverseOrder() {
        List<Comparator<Integer>> comparators = new ArrayList<>();
        // Descending order
        comparators.add(Comparator.reverseOrder());
        chain = new ComparatorChain<>(comparators);
        int result = chain.compare(1, 2);
        assertEquals(1, result, "Expected 1 to be greater than 2 in reverse order");
    }

    @Test
    public void testCompareWithMultipleComparators() {
        List<Comparator<Integer>> comparators = new ArrayList<>();
        // Ascending order
        comparators.add(Comparator.naturalOrder());
        // Descending order (not used here)
        comparators.add(Comparator.reverseOrder());
        chain = new ComparatorChain<>(comparators);
        int result = chain.compare(1, 2);
        assertEquals(-1, result, "Expected 1 to be less than 2 with multiple comparators");
    }

    @Test
    public void testCompareWithCustomComparator() {
        Comparator<Integer> customComparator = (a, b) -> {
            // Descending order
            return Integer.compare(b, a);
        };
        List<Comparator<Integer>> comparators = new ArrayList<>();
        comparators.add(customComparator);
        chain = new ComparatorChain<>(comparators);
        int result = chain.compare(1, 2);
        assertEquals(1, result, "Expected 1 to be greater than 2 with custom comparator");
    }
}

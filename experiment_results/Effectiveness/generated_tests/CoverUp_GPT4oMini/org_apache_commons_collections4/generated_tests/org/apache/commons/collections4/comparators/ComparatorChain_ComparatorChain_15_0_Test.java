package org.apache.commons.collections4.comparators;

import org.apache.commons.collections4.comparators.ComparatorChain;
import java.util.BitSet;
import java.util.Comparator;
import java.lang.reflect.Field;
import java.util.ArrayList;
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

class ComparatorChain_ComparatorChain_15_0_Test {

    private ComparatorChain<String> comparatorChain;

    @BeforeEach
    void setUp() {
        // Setup can be done here if needed for other tests
    }

    @Test
    void testComparatorChainWithReverseTrue() {
        Comparator<String> comparator = String::compareTo;
        comparatorChain = new ComparatorChain<>(comparator, true);
        // Access private fields using reflection
        try {
            Field orderingBitsField = ComparatorChain.class.getDeclaredField("orderingBits");
            orderingBitsField.setAccessible(true);
            BitSet orderingBits = (BitSet) orderingBitsField.get(comparatorChain);
            assertTrue(orderingBits.get(0), "Ordering bit should be set for reverse sort");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }

    @Test
    void testComparatorChainWithReverseFalse() {
        Comparator<String> comparator = String::compareTo;
        comparatorChain = new ComparatorChain<>(comparator, false);
        // Access private fields using reflection
        try {
            Field orderingBitsField = ComparatorChain.class.getDeclaredField("orderingBits");
            orderingBitsField.setAccessible(true);
            BitSet orderingBits = (BitSet) orderingBitsField.get(comparatorChain);
            assertFalse(orderingBits.get(0), "Ordering bit should not be set for forward sort");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }

    @Test
    void testComparatorChainWithNullComparator() {
        assertThrows(NullPointerException.class, () -> {
            new ComparatorChain<String>(null, true);
        });
    }

    @Test
    void testComparatorChainWithEmptyComparatorChain() {
        comparatorChain = new ComparatorChain<>(new ArrayList<>());
        // Access private fields using reflection
        try {
            Field comparatorChainField = ComparatorChain.class.getDeclaredField("comparatorChain");
            comparatorChainField.setAccessible(true);
            @SuppressWarnings("unchecked")
            List<Comparator<String>> chain = (List<Comparator<String>>) comparatorChainField.get(comparatorChain);
            assertTrue(chain.isEmpty(), "Comparator chain should be empty");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection failed: " + e.getMessage());
        }
    }
}

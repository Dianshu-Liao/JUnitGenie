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

class ComparatorChain_ComparatorChain_17_0_Test {

    private ComparatorChain<String> comparatorChain;

    @BeforeEach
    void setUp() {
        List<Comparator<String>> comparators = new ArrayList<>();
        comparators.add(String::compareTo);
        BitSet orderingBits = new BitSet();
        comparatorChain = new ComparatorChain<>(comparators, orderingBits);
    }

    @Test
    void testComparatorChainInitialization() {
        assertNotNull(comparatorChain);
        assertEquals(1, comparatorChain.size());
        assertFalse(comparatorChain.isLocked());
    }

    @Test
    void testCompareWithDifferentStrings() {
        int result = comparatorChain.compare("apple", "banana");
        assertTrue(result < 0, "Expected 'apple' to be less than 'banana'");
        result = comparatorChain.compare("banana", "apple");
        assertTrue(result > 0, "Expected 'banana' to be greater than 'apple'");
    }

    @Test
    void testCompareWithEqualStrings() {
        int result = comparatorChain.compare("apple", "apple");
        assertEquals(0, result, "Expected 'apple' to be equal to 'apple'");
    }

    @Test
    void testLockingMechanism() {
        comparatorChain.compare("apple", "banana");
        assertTrue(comparatorChain.isLocked(), "Expected comparator chain to be locked after first comparison");
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
            comparatorChain.addComparator(String::compareTo);
        });
        assertEquals("Comparator ordering cannot be changed after the first comparison is performed", exception.getMessage());
    }

    @Test
    void testCheckChainIntegrityWithEmptyChain() {
        ComparatorChain<String> emptyChain = new ComparatorChain<>(new ArrayList<>(), new BitSet());
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
            emptyChain.compare("apple", "banana");
        });
        assertEquals("ComparatorChains must contain at least one Comparator", exception.getMessage());
    }

    @Test
    void testEqualsAndHashCode() {
        List<Comparator<String>> comparators = new ArrayList<>();
        comparators.add(String::compareTo);
        BitSet orderingBits = new BitSet();
        ComparatorChain<String> anotherChain = new ComparatorChain<>(comparators, orderingBits);
        assertEquals(comparatorChain, anotherChain);
        assertEquals(comparatorChain.hashCode(), anotherChain.hashCode());
    }

    @Test
    void testSetComparator() {
        comparatorChain.setComparator(0, String::compareToIgnoreCase);
        assertEquals(1, comparatorChain.size());
    }

    @Test
    void testSetReverseSort() {
        comparatorChain.setReverseSort(0);
        assertTrue(comparatorChain.isLocked(), "Expected comparator chain to be locked after setting reverse sort");
    }

    @Test
    void testSetForwardSort() {
        comparatorChain.setForwardSort(0);
        assertTrue(comparatorChain.isLocked(), "Expected comparator chain to be locked after setting forward sort");
    }
}

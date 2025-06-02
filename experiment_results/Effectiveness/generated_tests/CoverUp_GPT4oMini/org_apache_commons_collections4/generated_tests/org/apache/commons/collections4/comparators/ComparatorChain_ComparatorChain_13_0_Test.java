package org.apache.commons.collections4.comparators;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Iterator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class ComparatorChain_ComparatorChain_13_0_Test {

    private ComparatorChain<String> comparatorChain;

    @BeforeEach
    void setUp() {
        comparatorChain = new ComparatorChain<>();
    }

    @Test
    void testDefaultConstructor() {
        assertNotNull(comparatorChain);
        assertEquals(0, comparatorChain.size());
        assertFalse(comparatorChain.isLocked());
    }

    @Test
    void testAddComparator() {
        Comparator<String> comparator = String::compareTo;
        comparatorChain.addComparator(comparator);
        assertEquals(1, comparatorChain.size());
        assertFalse(comparatorChain.isLocked());
    }

    @Test
    void testAddComparatorWithReverse() {
        Comparator<String> comparator = String::compareTo;
        comparatorChain.addComparator(comparator, true);
        assertEquals(1, comparatorChain.size());
        assertTrue(comparatorChain.isLocked());
    }

    @Test
    void testCompare() {
        Comparator<String> comparator = String::compareTo;
        comparatorChain.addComparator(comparator);
        int result1 = comparatorChain.compare("apple", "banana");
        int result2 = comparatorChain.compare("banana", "apple");
        int result3 = comparatorChain.compare("apple", "apple");
        assertTrue(result1 < 0);
        assertTrue(result2 > 0);
        assertEquals(0, result3);
    }

    @Test
    void testCompareWithReverse() {
        Comparator<String> comparator = String::compareTo;
        comparatorChain.addComparator(comparator, true);
        int result1 = comparatorChain.compare("apple", "banana");
        int result2 = comparatorChain.compare("banana", "apple");
        int result3 = comparatorChain.compare("apple", "apple");
        assertTrue(result1 > 0);
        assertTrue(result2 < 0);
        assertEquals(0, result3);
    }

    @Test
    void testCheckLocked() {
        Comparator<String> comparator = String::compareTo;
        comparatorChain.addComparator(comparator);
        comparatorChain.compare("apple", "banana");
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            comparatorChain.addComparator(comparator);
        });
        assertEquals("Comparator ordering cannot be changed after the first comparison is performed", exception.getMessage());
    }

    @Test
    void testCheckChainIntegrity() {
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            comparatorChain.compare("apple", "banana");
        });
        assertEquals("ComparatorChains must contain at least one Comparator", exception.getMessage());
    }

    @Test
    void testEqualsAndHashCode() {
        Comparator<String> comparator1 = String::compareTo;
        Comparator<String> comparator2 = String::compareTo;
        comparatorChain.addComparator(comparator1);
        ComparatorChain<String> anotherChain = new ComparatorChain<>();
        anotherChain.addComparator(comparator2);
        assertEquals(comparatorChain, anotherChain);
        assertEquals(comparatorChain.hashCode(), anotherChain.hashCode());
    }

    @Test
    void testSetComparator() {
        Comparator<String> comparator1 = String::compareTo;
        Comparator<String> comparator2 = (s1, s2) -> s2.compareTo(s1);
        comparatorChain.addComparator(comparator1);
        comparatorChain.setComparator(0, comparator2);
        int result = comparatorChain.compare("apple", "banana");
        assertTrue(result > 0);
    }

    @Test
    void testSetComparatorWithReverse() {
        Comparator<String> comparator = String::compareTo;
        comparatorChain.addComparator(comparator, true);
        comparatorChain.setComparator(0, comparator, false);
        int result = comparatorChain.compare("apple", "banana");
        assertTrue(result < 0);
    }

    @Test
    void testSetForwardSort() {
        Comparator<String> comparator = String::compareTo;
        comparatorChain.addComparator(comparator, true);
        comparatorChain.setForwardSort(0);
        assertFalse(comparatorChain.isLocked());
    }

    @Test
    void testSetReverseSort() {
        Comparator<String> comparator = String::compareTo;
        comparatorChain.addComparator(comparator);
        comparatorChain.setReverseSort(0);
        assertTrue(comparatorChain.isLocked());
    }
}

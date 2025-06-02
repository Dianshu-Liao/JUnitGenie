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

class ComparatorChain_ComparatorChain_14_0_Test {

    private ComparatorChain<String> comparatorChain;

    @BeforeEach
    void setUp() {
        comparatorChain = new ComparatorChain<>();
    }

    @Test
    void testConstructorWithComparator() {
        Comparator<String> comparator = String::compareTo;
        ComparatorChain<String> chain = new ComparatorChain<>(comparator);
        assertNotNull(chain);
        assertEquals(1, chain.size());
    }

    @Test
    void testAddComparator() {
        Comparator<String> comparator = String::compareTo;
        comparatorChain.addComparator(comparator);
        assertEquals(1, comparatorChain.size());
    }

    @Test
    void testAddComparatorWithReverse() {
        Comparator<String> comparator = String::compareTo;
        comparatorChain.addComparator(comparator, true);
        assertEquals(1, comparatorChain.size());
        assertTrue(comparatorChain.isLocked());
    }

    @Test
    void testCompareWithUnorderedStrings() {
        Comparator<String> comparator = String::compareTo;
        comparatorChain.addComparator(comparator);
        assertEquals(0, comparatorChain.compare("apple", "apple"));
        assertTrue(comparatorChain.compare("apple", "banana") < 0);
        assertTrue(comparatorChain.compare("banana", "apple") > 0);
    }

    @Test
    void testCompareWithReversedOrder() {
        Comparator<String> comparator = String::compareTo;
        comparatorChain.addComparator(comparator, true);
        assertEquals(0, comparatorChain.compare("apple", "apple"));
        assertTrue(comparatorChain.compare("apple", "banana") > 0);
        assertTrue(comparatorChain.compare("banana", "apple") < 0);
    }

    @Test
    void testCheckLocked() {
        Comparator<String> comparator = String::compareTo;
        comparatorChain.addComparator(comparator);
        comparatorChain.compare("apple", "banana");
        assertThrows(UnsupportedOperationException.class, () -> {
            comparatorChain.addComparator(comparator);
        });
    }

    @Test
    void testCheckChainIntegrity() {
        assertThrows(UnsupportedOperationException.class, () -> {
            comparatorChain.compare("apple", "banana");
        });
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
        Comparator<String> comparator = String::compareTo;
        comparatorChain.addComparator(comparator);
        Comparator<String> newComparator = (o1, o2) -> o1.length() - o2.length();
        comparatorChain.setComparator(0, newComparator);
        assertNotEquals(comparator, comparatorChain.compare("apple", "banana"));
    }

    @Test
    void testSetReverseSort() {
        Comparator<String> comparator = String::compareTo;
        comparatorChain.addComparator(comparator);
        comparatorChain.setReverseSort(0);
        assertTrue(comparatorChain.compare("apple", "banana") > 0);
    }

    @Test
    void testSetForwardSort() {
        Comparator<String> comparator = String::compareTo;
        comparatorChain.addComparator(comparator);
        comparatorChain.setReverseSort(0);
        comparatorChain.setForwardSort(0);
        assertTrue(comparatorChain.compare("apple", "banana") < 0);
    }

    @Test
    void testSize() {
        assertEquals(0, comparatorChain.size());
        comparatorChain.addComparator(String::compareTo);
        assertEquals(1, comparatorChain.size());
    }
}

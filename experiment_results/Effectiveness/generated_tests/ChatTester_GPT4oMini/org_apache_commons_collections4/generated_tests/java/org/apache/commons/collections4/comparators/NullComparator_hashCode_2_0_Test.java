package org.apache.commons.collections4.comparators;

import java.util.Comparator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.collections4.ComparatorUtils;

public class NullComparator_hashCode_2_0_Test {

    @Test
    public void testHashCode_NonNullComparator_NullsAreHigh() {
        Comparator<String> comparator = Comparator.naturalOrder();
        NullComparator nullComparator = new NullComparator(comparator, true);
        int expectedHashCode = -1 * comparator.hashCode();
        assertEquals(expectedHashCode, nullComparator.hashCode());
    }

    @Test
    public void testHashCode_NonNullComparator_NullsAreLow() {
        Comparator<String> comparator = Comparator.naturalOrder();
        NullComparator nullComparator = new NullComparator(comparator, false);
        int expectedHashCode = 1 * comparator.hashCode();
        assertEquals(expectedHashCode, nullComparator.hashCode());
    }

    @Test
    public void testHashCode_NullComparator_NullsAreHigh() {
        NullComparator nullComparator = new NullComparator(true);
        int expectedHashCode = -1 * new NullComparator().hashCode();
        assertEquals(expectedHashCode, nullComparator.hashCode());
    }

    @Test
    public void testHashCode_NullComparator_NullsAreLow() {
        NullComparator nullComparator = new NullComparator(false);
        int expectedHashCode = 1 * new NullComparator().hashCode();
        assertEquals(expectedHashCode, nullComparator.hashCode());
    }

    @Test
    public void testHashCode_EmptyComparator_NullsAreHigh() {
        Comparator<String> emptyComparator = Comparator.naturalOrder();
        NullComparator nullComparator = new NullComparator(emptyComparator, true);
        int expectedHashCode = -1 * emptyComparator.hashCode();
        assertEquals(expectedHashCode, nullComparator.hashCode());
    }

    @Test
    public void testHashCode_EmptyComparator_NullsAreLow() {
        Comparator<String> emptyComparator = Comparator.naturalOrder();
        NullComparator nullComparator = new NullComparator(emptyComparator, false);
        int expectedHashCode = 1 * emptyComparator.hashCode();
        assertEquals(expectedHashCode, nullComparator.hashCode());
    }
}

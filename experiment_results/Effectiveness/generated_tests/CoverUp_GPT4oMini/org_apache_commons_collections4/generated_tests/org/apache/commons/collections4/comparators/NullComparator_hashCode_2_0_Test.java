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

    private Comparator<Object> nonNullComparator;

    private NullComparator nullComparatorHigh;

    private NullComparator nullComparatorLow;

    @BeforeEach
    public void setUp() {
        nonNullComparator = mock(Comparator.class);
        // Mocking hashCode return value
        when(nonNullComparator.hashCode()).thenReturn(42);
        nullComparatorHigh = new NullComparator(nonNullComparator, true);
        nullComparatorLow = new NullComparator(nonNullComparator, false);
    }

    @Test
    public void testHashCode_NullsAreHigh() {
        int expectedHashCode = -1 * nonNullComparator.hashCode();
        assertEquals(expectedHashCode, nullComparatorHigh.hashCode());
    }

    @Test
    public void testHashCode_NullsAreLow() {
        int expectedHashCode = 1 * nonNullComparator.hashCode();
        assertEquals(expectedHashCode, nullComparatorLow.hashCode());
    }

    @Test
    public void testHashCode_WithDifferentNonNullComparator() {
        Comparator<Object> anotherNonNullComparator = mock(Comparator.class);
        when(anotherNonNullComparator.hashCode()).thenReturn(100);
        NullComparator anotherNullComparatorHigh = new NullComparator(anotherNonNullComparator, true);
        NullComparator anotherNullComparatorLow = new NullComparator(anotherNonNullComparator, false);
        assertEquals(-1 * anotherNonNullComparator.hashCode(), anotherNullComparatorHigh.hashCode());
        assertEquals(1 * anotherNonNullComparator.hashCode(), anotherNullComparatorLow.hashCode());
    }
}

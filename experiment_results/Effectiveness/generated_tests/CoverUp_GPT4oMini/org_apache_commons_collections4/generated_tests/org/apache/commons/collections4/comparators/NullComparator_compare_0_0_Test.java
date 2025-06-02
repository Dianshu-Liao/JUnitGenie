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

public class NullComparator_compare_0_0_Test {

    private NullComparator<String> nullComparatorHigh;

    private NullComparator<String> nullComparatorLow;

    private Comparator<String> stringComparator;

    @BeforeEach
    public void setUp() {
        stringComparator = Comparator.naturalOrder();
        nullComparatorHigh = new NullComparator<>(stringComparator, true);
        nullComparatorLow = new NullComparator<>(stringComparator, false);
    }

    @Test
    public void testCompare_BothNulls() {
        assertEquals(0, nullComparatorHigh.compare(null, null));
    }

    @Test
    public void testCompare_FirstNull_High() {
        assertEquals(1, nullComparatorHigh.compare(null, "a"));
    }

    @Test
    public void testCompare_FirstNull_Low() {
        assertEquals(-1, nullComparatorLow.compare(null, "a"));
    }

    @Test
    public void testCompare_SecondNull_High() {
        assertEquals(-1, nullComparatorHigh.compare("a", null));
    }

    @Test
    public void testCompare_SecondNull_Low() {
        assertEquals(1, nullComparatorLow.compare("a", null));
    }

    @Test
    public void testCompare_NonNulls() {
        assertEquals(-1, nullComparatorHigh.compare("a", "b"));
        assertEquals(1, nullComparatorHigh.compare("b", "a"));
        assertEquals(0, nullComparatorHigh.compare("a", "a"));
    }
}

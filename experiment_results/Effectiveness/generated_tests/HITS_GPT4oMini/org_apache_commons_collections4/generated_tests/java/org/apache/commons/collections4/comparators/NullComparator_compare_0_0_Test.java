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
        stringComparator = String::compareTo;
        nullComparatorHigh = new NullComparator<>(stringComparator, true);
        nullComparatorLow = new NullComparator<>(stringComparator, false);
    }

    @Test
    public void testCompare_BothNulls() {
        assertEquals(0, nullComparatorHigh.compare(null, null));
        assertEquals(0, nullComparatorLow.compare(null, null));
    }

    @Test
    public void testCompare_FirstNull_High() {
        assertEquals(1, nullComparatorHigh.compare(null, "test"));
    }

    @Test
    public void testCompare_FirstNull_Low() {
        assertEquals(-1, nullComparatorLow.compare(null, "test"));
    }

    @Test
    public void testCompare_SecondNull_High() {
        assertEquals(-1, nullComparatorHigh.compare("test", null));
    }

    @Test
    public void testCompare_SecondNull_Low() {
        assertEquals(1, nullComparatorLow.compare("test", null));
    }

    @Test
    public void testCompare_NonNulls() {
        assertEquals(0, nullComparatorHigh.compare("test", "test"));
        assertEquals(0, nullComparatorLow.compare("test", "test"));
        assertEquals(-1, nullComparatorHigh.compare("apple", "banana"));
        assertEquals(-1, nullComparatorLow.compare("apple", "banana"));
        assertEquals(1, nullComparatorHigh.compare("banana", "apple"));
        assertEquals(1, nullComparatorLow.compare("banana", "apple"));
    }

    @Test
    public void testCompare_NullAndNonNull() {
        assertEquals(1, nullComparatorHigh.compare(null, "apple"));
        assertEquals(-1, nullComparatorLow.compare(null, "apple"));
        assertEquals(-1, nullComparatorHigh.compare("apple", null));
        assertEquals(1, nullComparatorLow.compare("apple", null));
    }
}

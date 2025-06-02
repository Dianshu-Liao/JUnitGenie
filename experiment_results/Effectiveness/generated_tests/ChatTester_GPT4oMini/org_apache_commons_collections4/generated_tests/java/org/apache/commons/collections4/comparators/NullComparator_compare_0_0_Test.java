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

    private NullComparator<String> nullComparator;

    @BeforeEach
    public void setUp() {
        // Initialize with a non-null comparator for testing
        Comparator<String> mockComparator = mock(Comparator.class);
        when(mockComparator.compare("a", "b")).thenReturn(-1);
        when(mockComparator.compare("b", "a")).thenReturn(1);
        when(mockComparator.compare("a", "a")).thenReturn(0);
        nullComparator = new NullComparator<>(mockComparator, true);
    }

    @Test
    public void testCompare_BothNulls() {
        assertEquals(0, nullComparator.compare(null, null));
    }

    @Test
    public void testCompare_FirstNull_High() {
        nullComparator = new NullComparator<>(true);
        assertEquals(1, nullComparator.compare(null, "a"));
    }

    @Test
    public void testCompare_FirstNull_Low() {
        nullComparator = new NullComparator<>(false);
        assertEquals(-1, nullComparator.compare(null, "a"));
    }

    @Test
    public void testCompare_SecondNull_High() {
        nullComparator = new NullComparator<>(true);
        assertEquals(-1, nullComparator.compare("a", null));
    }

    @Test
    public void testCompare_SecondNull_Low() {
        nullComparator = new NullComparator<>(false);
        assertEquals(1, nullComparator.compare("a", null));
    }

    @Test
    public void testCompare_NonNulls() {
        assertEquals(-1, nullComparator.compare("a", "b"));
        assertEquals(1, nullComparator.compare("b", "a"));
        assertEquals(0, nullComparator.compare("a", "a"));
    }

    @Test
    public void testCompare_EqualObjects() {
        assertEquals(0, nullComparator.compare("test", "test"));
    }

    @Test
    public void testCompare_NullComparator() {
        nullComparator = new NullComparator<>(null);
        assertThrows(NullPointerException.class, () -> nullComparator.compare("a", "b"));
    }
}

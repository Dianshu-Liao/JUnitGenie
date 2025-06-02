package org.apache.commons.lang3;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

final class CharRange_equals_6_0_Test {

    private CharRange range1;

    private CharRange range2;

    private CharRange range3;

    @BeforeEach
    void setUp() {
        // Using isIn method to create the range
        range1 = CharRange.isIn('a', 'z');
        // Using isIn method to create the range
        range2 = CharRange.isIn('a', 'z');
        // Using isNotIn method to create the range
        range3 = CharRange.isNotIn('A', 'Z');
    }

    @Test
    void testEquals_SameObject() {
        assertTrue(range1.equals(range1));
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(range1.equals(null));
    }

    @Test
    void testEquals_DifferentClass() {
        assertFalse(range1.equals("Not a CharRange"));
    }

    @Test
    void testEquals_EqualRanges() {
        assertTrue(range1.equals(range2));
    }

    @Test
    void testEquals_NegatedDifference() {
        assertFalse(range1.equals(range3));
    }

    @Test
    void testEquals_StartDifference() {
        // Using isIn method to create the range
        CharRange range4 = CharRange.isIn('b', 'z');
        assertFalse(range1.equals(range4));
    }

    @Test
    void testEquals_EndDifference() {
        // Using isIn method to create the range
        CharRange range5 = CharRange.isIn('a', 'y');
        assertFalse(range1.equals(range5));
    }
}

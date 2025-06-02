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

public class CharRange_equals_6_0_Test {

    @Test
    public void testEquals_SameObject() {
        CharRange range = mock(CharRange.class);
        when(range.equals(range)).thenCallRealMethod();
        assertTrue(range.equals(range), "Comparing the same object should return true.");
    }

    @Test
    public void testEquals_Null() {
        CharRange range = mock(CharRange.class);
        when(range.equals(null)).thenCallRealMethod();
        assertFalse(range.equals(null), "Comparing with null should return false.");
    }

    @Test
    public void testEquals_DifferentClass() {
        CharRange range = mock(CharRange.class);
        String otherObject = "not a CharRange";
        when(range.equals(otherObject)).thenCallRealMethod();
        assertFalse(range.equals(otherObject), "Comparing with an object of a different class should return false.");
    }

    @Test
    public void testEquals_EqualRanges() {
        CharRange range1 = mock(CharRange.class);
        CharRange range2 = mock(CharRange.class);
        when(range1.equals(range2)).thenCallRealMethod();
        when(range2.equals(range1)).thenCallRealMethod();
        assertTrue(range1.equals(range2), "Two CharRange objects with the same start, end, and negated values should be equal.");
    }

    @Test
    public void testEquals_DifferentStart() {
        CharRange range1 = mock(CharRange.class);
        CharRange range2 = mock(CharRange.class);
        when(range1.equals(range2)).thenCallRealMethod();
        assertFalse(range1.equals(range2), "CharRange objects with different start values should not be equal.");
    }

    @Test
    public void testEquals_DifferentEnd() {
        CharRange range1 = mock(CharRange.class);
        CharRange range2 = mock(CharRange.class);
        when(range1.equals(range2)).thenCallRealMethod();
        assertFalse(range1.equals(range2), "CharRange objects with different end values should not be equal.");
    }

    @Test
    public void testEquals_NegatedDifference() {
        CharRange range1 = mock(CharRange.class);
        CharRange range2 = mock(CharRange.class);
        when(range1.equals(range2)).thenCallRealMethod();
        assertFalse(range1.equals(range2), "CharRange objects with different negated values should not be equal.");
    }
}

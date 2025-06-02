package org.apache.commons.collections4.comparators;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Comparator;

public class BooleanComparator_compare_3_0_Test {

    private final BooleanComparator trueFirstComparator = new BooleanComparator(true);

    private final BooleanComparator falseFirstComparator = new BooleanComparator(false);

    @Test
    public void testCompareTrueFirstBothTrue() {
        assertEquals(0, trueFirstComparator.compare(Boolean.TRUE, Boolean.TRUE));
    }

    @Test
    public void testCompareTrueFirstTrueAndFalse() {
        assertEquals(1, trueFirstComparator.compare(Boolean.TRUE, Boolean.FALSE));
    }

    @Test
    public void testCompareTrueFirstFalseAndTrue() {
        assertEquals(-1, trueFirstComparator.compare(Boolean.FALSE, Boolean.TRUE));
    }

    @Test
    public void testCompareTrueFirstBothFalse() {
        assertEquals(0, trueFirstComparator.compare(Boolean.FALSE, Boolean.FALSE));
    }

    @Test
    public void testCompareFalseFirstBothTrue() {
        assertEquals(-1, falseFirstComparator.compare(Boolean.TRUE, Boolean.TRUE));
    }

    @Test
    public void testCompareFalseFirstTrueAndFalse() {
        assertEquals(1, falseFirstComparator.compare(Boolean.TRUE, Boolean.FALSE));
    }

    @Test
    public void testCompareFalseFirstFalseAndTrue() {
        assertEquals(1, falseFirstComparator.compare(Boolean.FALSE, Boolean.TRUE));
    }

    @Test
    public void testCompareFalseFirstBothFalse() {
        assertEquals(0, falseFirstComparator.compare(Boolean.FALSE, Boolean.FALSE));
    }
}

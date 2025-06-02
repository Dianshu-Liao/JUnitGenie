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

    private BooleanComparator trueFirstComparator;

    private BooleanComparator falseFirstComparator;

    @BeforeEach
    public void setUp() {
        trueFirstComparator = new BooleanComparator(true);
        falseFirstComparator = new BooleanComparator(false);
    }

    @Test
    public void testCompareTrueFirstBothTrue() {
        assertEquals(0, trueFirstComparator.compare(Boolean.TRUE, Boolean.TRUE));
    }

    @Test
    public void testCompareTrueFirstFirstTrueSecondFalse() {
        assertEquals(1, trueFirstComparator.compare(Boolean.TRUE, Boolean.FALSE));
    }

    @Test
    public void testCompareTrueFirstFirstFalseSecondTrue() {
        assertEquals(-1, trueFirstComparator.compare(Boolean.FALSE, Boolean.TRUE));
    }

    @Test
    public void testCompareFalseFirstBothTrue() {
        assertEquals(0, falseFirstComparator.compare(Boolean.TRUE, Boolean.TRUE));
    }

    @Test
    public void testCompareFalseFirstFirstTrueSecondFalse() {
        assertEquals(-1, falseFirstComparator.compare(Boolean.TRUE, Boolean.FALSE));
    }

    @Test
    public void testCompareFalseFirstFirstFalseSecondTrue() {
        assertEquals(1, falseFirstComparator.compare(Boolean.FALSE, Boolean.TRUE));
    }

    @Test
    public void testCompareNulls() {
        assertEquals(0, trueFirstComparator.compare(null, null));
        assertEquals(1, trueFirstComparator.compare(Boolean.TRUE, null));
        assertEquals(-1, trueFirstComparator.compare(null, Boolean.TRUE));
        assertEquals(0, falseFirstComparator.compare(null, null));
        assertEquals(1, falseFirstComparator.compare(Boolean.TRUE, null));
        assertEquals(-1, falseFirstComparator.compare(null, Boolean.TRUE));
    }
}

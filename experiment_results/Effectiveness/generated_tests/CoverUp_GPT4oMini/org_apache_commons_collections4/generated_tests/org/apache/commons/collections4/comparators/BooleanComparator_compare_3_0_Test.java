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
        trueFirstComparator = BooleanComparator.getTrueFirstComparator();
        falseFirstComparator = BooleanComparator.getFalseFirstComparator();
    }

    @Test
    public void testCompare_TrueFirstComparator_TrueTrue() {
        assertEquals(0, trueFirstComparator.compare(Boolean.TRUE, Boolean.TRUE));
    }

    @Test
    public void testCompare_TrueFirstComparator_TrueFalse() {
        assertEquals(1, trueFirstComparator.compare(Boolean.TRUE, Boolean.FALSE));
    }

    @Test
    public void testCompare_TrueFirstComparator_FalseTrue() {
        assertEquals(-1, trueFirstComparator.compare(Boolean.FALSE, Boolean.TRUE));
    }

    @Test
    public void testCompare_TrueFirstComparator_FalseFalse() {
        assertEquals(0, trueFirstComparator.compare(Boolean.FALSE, Boolean.FALSE));
    }

    @Test
    public void testCompare_FalseFirstComparator_TrueTrue() {
        assertEquals(-1, falseFirstComparator.compare(Boolean.TRUE, Boolean.TRUE));
    }

    @Test
    public void testCompare_FalseFirstComparator_TrueFalse() {
        assertEquals(-1, falseFirstComparator.compare(Boolean.TRUE, Boolean.FALSE));
    }

    @Test
    public void testCompare_FalseFirstComparator_FalseTrue() {
        assertEquals(1, falseFirstComparator.compare(Boolean.FALSE, Boolean.TRUE));
    }

    @Test
    public void testCompare_FalseFirstComparator_FalseFalse() {
        assertEquals(0, falseFirstComparator.compare(Boolean.FALSE, Boolean.FALSE));
    }

    @Test
    public void testCompare_NullValues() {
        assertEquals(0, trueFirstComparator.compare(null, null));
        assertEquals(0, falseFirstComparator.compare(null, null));
    }
}

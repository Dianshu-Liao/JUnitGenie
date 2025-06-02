package org.apache.commons.collections4.comparators;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Comparator;

public class BooleanComparator_hashCode_5_0_Test {

    @Test
    public void testHashCodeTrueFirst() {
        BooleanComparator comparator = BooleanComparator.getTrueFirstComparator();
        int expectedHashCode = -1 * "BooleanComparator".hashCode();
        assertEquals(expectedHashCode, comparator.hashCode());
    }

    @Test
    public void testHashCodeFalseFirst() {
        BooleanComparator comparator = BooleanComparator.getFalseFirstComparator();
        int expectedHashCode = "BooleanComparator".hashCode();
        assertEquals(expectedHashCode, comparator.hashCode());
    }
}

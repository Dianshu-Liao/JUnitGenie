package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.BooleanComparator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class comparators_BooleanComparator_hashCode__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHashCodeTrueFirst() {
        BooleanComparator comparator = new BooleanComparator(true);
        int expectedHashCode = -1 * "BooleanComparator".hashCode();
        assertEquals(expectedHashCode, comparator.hashCode());
    }

    @Test(timeout = 4000)
    public void testHashCodeFalseFirst() {
        BooleanComparator comparator = new BooleanComparator(false);
        int expectedHashCode = "BooleanComparator".hashCode();
        assertEquals(expectedHashCode, comparator.hashCode());
    }

}
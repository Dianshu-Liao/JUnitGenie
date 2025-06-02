package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.BooleanComparator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class comparators_BooleanComparator_compare_Boolean_Boolean_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCompareBothTrue() {
        BooleanComparator comparator = new BooleanComparator();
        int result = comparator.compare(Boolean.TRUE, Boolean.TRUE);
        assertEquals(0, result);
    }

    @Test(timeout = 4000)
    public void testCompareTrueAndFalse() {
        BooleanComparator comparator = new BooleanComparator();
        int result = comparator.compare(Boolean.TRUE, Boolean.FALSE);
        assertEquals(1, result);
    }

    @Test(timeout = 4000)
    public void testCompareFalseAndTrue() {
        BooleanComparator comparator = new BooleanComparator();
        int result = comparator.compare(Boolean.FALSE, Boolean.TRUE);
        assertEquals(-1, result);
    }

    @Test(timeout = 4000)
    public void testCompareBothFalse() {
        BooleanComparator comparator = new BooleanComparator();
        int result = comparator.compare(Boolean.FALSE, Boolean.FALSE);
        assertEquals(0, result);
    }

}
package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.BooleanComparator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class comparators_BooleanComparator_compare_Boolean_Boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCompareWithTrueFirstTrue() {
        BooleanComparator comparator = new BooleanComparator(true);
        Boolean b1 = Boolean.TRUE;
        Boolean b2 = Boolean.FALSE;
        try {
            int result = comparator.compare(b1, b2);
            assertEquals(1, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testCompareWithTrueFirstFalse() {
        BooleanComparator comparator = new BooleanComparator(false);
        Boolean b1 = Boolean.TRUE;
        Boolean b2 = Boolean.FALSE;
        try {
            int result = comparator.compare(b1, b2);
            assertEquals(-1, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testCompareBothTrue() {
        BooleanComparator comparator = new BooleanComparator(true);
        Boolean b1 = Boolean.TRUE;
        Boolean b2 = Boolean.TRUE;
        try {
            int result = comparator.compare(b1, b2);
            assertEquals(0, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testCompareBothFalse() {
        BooleanComparator comparator = new BooleanComparator(true);
        Boolean b1 = Boolean.FALSE;
        Boolean b2 = Boolean.FALSE;
        try {
            int result = comparator.compare(b1, b2);
            assertEquals(0, result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}
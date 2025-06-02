package org.apache.commons.lang3;
import org.apache.commons.lang3.Range;
import org.junit.Test;
import java.util.Comparator;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Range_contains_Object_cfg_path_2_Test {

    private static class TestComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
        }
    }

    @Test(timeout = 4000)
    public void testContainsElementWithinRange() {
        Range<Integer> range = new Range<>(1, 10, new TestComparator());
        assertTrue(range.contains(5));
    }

    @Test(timeout = 4000)
    public void testContainsElementAtMinimum() {
        Range<Integer> range = new Range<>(1, 10, new TestComparator());
        assertTrue(range.contains(1));
    }

    @Test(timeout = 4000)
    public void testContainsElementAtMaximum() {
        Range<Integer> range = new Range<>(1, 10, new TestComparator());
        assertTrue(range.contains(10));
    }

    @Test(timeout = 4000)
    public void testContainsElementBelowRange() {
        Range<Integer> range = new Range<>(1, 10, new TestComparator());
        assertFalse(range.contains(0));
    }

    @Test(timeout = 4000)
    public void testContainsElementAboveRange() {
        Range<Integer> range = new Range<>(1, 10, new TestComparator());
        assertFalse(range.contains(11));
    }

    @Test(timeout = 4000)
    public void testContainsNullElement() {
        Range<Integer> range = new Range<>(1, 10, new TestComparator());
        assertFalse(range.contains(null));
    }

}
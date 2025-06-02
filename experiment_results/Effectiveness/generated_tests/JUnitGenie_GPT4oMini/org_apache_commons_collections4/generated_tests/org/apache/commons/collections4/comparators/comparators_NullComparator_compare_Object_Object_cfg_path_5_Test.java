package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.NullComparator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class comparators_NullComparator_compare_Object_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testCompareWithNullsAreHighTrue() {
        NullComparator comparator = new NullComparator(true);
        String o1 = "test1"; // Changed Object to String
        String o2 = "test2"; // Changed Object to String
        
        // Test when both objects are not null and different
        assertEquals(-1, comparator.compare(o1, o2)); // Changed expected value to -1
    }

    @Test(timeout = 4000)
    public void testCompareWithNullsAreHighFalse() {
        NullComparator comparator = new NullComparator(false);
        String o1 = "test1"; // Changed Object to String
        String o2 = "test2"; // Changed Object to String
        
        // Test when both objects are not null and different
        assertEquals(-1, comparator.compare(o1, o2)); // Changed expected value to -1
    }

    @Test(timeout = 4000)
    public void testCompareWithFirstObjectNull() {
        NullComparator comparator = new NullComparator(true);
        Object o1 = null;
        String o2 = "test"; // Changed Object to String
        
        // Test when first object is null
        assertEquals(1, comparator.compare(o1, o2));
    }

    @Test(timeout = 4000)
    public void testCompareWithSecondObjectNull() {
        NullComparator comparator = new NullComparator(false);
        String o1 = "test"; // Changed Object to String
        Object o2 = null;
        
        // Test when second object is null
        assertEquals(-1, comparator.compare(o1, o2));
    }

    @Test(timeout = 4000)
    public void testCompareWithBothObjectsNull() {
        NullComparator comparator = new NullComparator(true);
        Object o1 = null;
        Object o2 = null;
        
        // Test when both objects are null
        assertEquals(0, comparator.compare(o1, o2));
    }


}
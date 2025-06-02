package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.NullComparator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class comparators_NullComparator_compare_Object_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testCompareWithNullsAreHighTrue() {
        NullComparator<Object> comparator = new NullComparator<>(true);
        Object o1 = new Object();
        Object o2 = new Object();
        
        // Test when both objects are not null and different
        assertEquals(0, comparator.compare(o1, o2));
    }

    @Test(timeout = 4000)
    public void testCompareWithNullsAreHighFalse() {
        NullComparator<Object> comparator = new NullComparator<>(false);
        Object o1 = new Object();
        Object o2 = new Object();
        
        // Test when both objects are not null and different
        assertEquals(0, comparator.compare(o1, o2));
    }

    @Test(timeout = 4000)
    public void testCompareWithFirstNull() {
        NullComparator<Object> comparator = new NullComparator<>(true);
        Object o1 = null;
        Object o2 = new Object();
        
        // Test when first object is null
        assertEquals(1, comparator.compare(o1, o2));
    }

    @Test(timeout = 4000)
    public void testCompareWithSecondNull() {
        NullComparator<Object> comparator = new NullComparator<>(false);
        Object o1 = new Object();
        Object o2 = null;
        
        // Test when second object is null
        assertEquals(-1, comparator.compare(o1, o2));
    }

    @Test(timeout = 4000)
    public void testCompareWithBothNulls() {
        NullComparator<Object> comparator = new NullComparator<>(true);
        Object o1 = null;
        Object o2 = null;
        
        // Test when both objects are null
        assertEquals(0, comparator.compare(o1, o2));
    }


}
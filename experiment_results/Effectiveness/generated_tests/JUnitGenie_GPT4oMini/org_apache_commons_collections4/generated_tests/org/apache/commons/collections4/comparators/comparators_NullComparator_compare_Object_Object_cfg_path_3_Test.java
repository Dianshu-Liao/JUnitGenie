package org.apache.commons.collections4.comparators;
import org.apache.commons.collections4.comparators.NullComparator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class comparators_NullComparator_compare_Object_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCompare_NonNullObjects() {
        NullComparator<String> comparator = new NullComparator<>();
        String str1 = "apple";
        String str2 = "banana";

        // Test comparing two non-null objects
        int result = comparator.compare(str1, str2);
        assertEquals(-1, result); // "apple" should be less than "banana"
    }

    @Test(timeout = 4000)
    public void testCompare_FirstObjectIsNull() {
        NullComparator<String> comparator = new NullComparator<>(true); // nulls are high
        String str1 = null;
        String str2 = "banana";

        // Test comparing null with a non-null object
        int result = comparator.compare(str1, str2);
        assertEquals(1, result); // null should be considered greater than "banana"
    }

    @Test(timeout = 4000)
    public void testCompare_SecondObjectIsNull() {
        NullComparator<String> comparator = new NullComparator<>(false); // nulls are low
        String str1 = "apple";
        String str2 = null;

        // Test comparing a non-null object with null
        int result = comparator.compare(str1, str2);
        assertEquals(-1, result); // "apple" should be considered less than null
    }

    @Test(timeout = 4000)
    public void testCompare_BothObjectsAreNull() {
        NullComparator<String> comparator = new NullComparator<>();
        String str1 = null;
        String str2 = null;

        // Test comparing two null objects
        int result = comparator.compare(str1, str2);
        assertEquals(0, result); // Both nulls should be equal
    }

}
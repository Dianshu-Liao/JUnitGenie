package org.apache.commons.lang3;
import org.apache.commons.lang3.Range;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Range_containsRange_Range_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testContainsRangeWithValidRange() {
        // Create a Range instance for 'this'
        Range<Integer> thisRange = Range.between(1, 10);
        
        // Create a valid Range instance for 'otherRange'
        Range<Integer> otherRange = Range.between(3, 7);
        
        // Test the containsRange method
        try {
            boolean result = thisRange.containsRange(otherRange);
            assertTrue(result); // Expecting true since 3 and 7 are within the range of 1 to 10
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testContainsRangeWithNullRange() {
        // Create a Range instance for 'this'
        Range<Integer> thisRange = Range.between(1, 10);
        
        // Test the containsRange method with null
        try {
            boolean result = thisRange.containsRange(null);
            assertFalse(result); // Expecting false since otherRange is null
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testContainsRangeWithOutOfBoundRange() {
        // Create a Range instance for 'this'
        Range<Integer> thisRange = Range.between(1, 10);
        
        // Create a Range instance for 'otherRange' that is out of bounds
        Range<Integer> otherRange = Range.between(0, 12);
        
        // Test the containsRange method
        try {
            boolean result = thisRange.containsRange(otherRange);
            assertFalse(result); // Expecting false since 0 and 12 are out of the range of 1 to 10
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}
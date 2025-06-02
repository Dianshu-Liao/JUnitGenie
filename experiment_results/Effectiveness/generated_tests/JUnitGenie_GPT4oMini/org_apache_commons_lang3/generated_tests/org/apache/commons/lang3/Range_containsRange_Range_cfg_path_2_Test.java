package org.apache.commons.lang3;
import org.apache.commons.lang3.Range;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class Range_containsRange_Range_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testContainsRange_ValidRange() {
        Range<Integer> range1 = Range.between(1, 10);
        Range<Integer> range2 = Range.between(5, 7);
        
        try {
            boolean result = range1.containsRange(range2);
            assertTrue(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testContainsRange_NullRange() {
        Range<Integer> range1 = Range.between(1, 10);
        
        try {
            boolean result = range1.containsRange(null);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testContainsRange_OutsideRange() {
        Range<Integer> range1 = Range.between(1, 10);
        Range<Integer> range2 = Range.between(11, 15);
        
        try {
            boolean result = range1.containsRange(range2);
            assertFalse(result);
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}
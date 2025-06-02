package org.apache.commons.lang3;
import org.apache.commons.lang3.Range;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class Range_containsRange_Range_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testContainsRangeWithNull() {
        Range<Integer> range = new Range<>(1, 10, null);
        Range<Integer> otherRange = null;

        try {
            boolean result = range.containsRange(otherRange);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

}
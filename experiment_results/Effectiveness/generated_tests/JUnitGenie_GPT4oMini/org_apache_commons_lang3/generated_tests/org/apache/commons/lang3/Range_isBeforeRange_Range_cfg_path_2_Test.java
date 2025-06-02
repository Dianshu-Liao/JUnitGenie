package org.apache.commons.lang3;
import org.apache.commons.lang3.Range;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class Range_isBeforeRange_Range_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsBeforeRangeWithNull() {
        Range<Integer> range = new Range<>(1, 5, null);
        try {
            boolean result = range.isBeforeRange(null);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}
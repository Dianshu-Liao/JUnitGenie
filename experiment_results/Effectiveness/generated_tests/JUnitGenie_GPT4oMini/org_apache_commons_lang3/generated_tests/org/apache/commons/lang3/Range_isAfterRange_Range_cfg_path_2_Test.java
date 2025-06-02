package org.apache.commons.lang3;
import org.apache.commons.lang3.Range;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class Range_isAfterRange_Range_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsAfterRangeWithNull() {
        Range<Integer> range = new Range<>(1, 10, null);
        boolean result;

        try {
            result = range.isAfterRange(null);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}
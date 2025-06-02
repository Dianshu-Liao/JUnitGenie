package org.apache.commons.lang3;
import org.apache.commons.lang3.Range;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class Range_containsRange_Range_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testContainsRangeWithNull() {
        Range<Integer> range = new Range<>(1, 10, null);
        boolean result = false;
        try {
            result = range.containsRange(null);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        assertFalse(result);
    }

}
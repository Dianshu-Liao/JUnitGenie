package org.joda.time;
import org.joda.time.MutableDateTime;
import org.joda.time.DurationField;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.fail;

public class MutableDateTime_addWeekyears_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAddWeekyearsNonZero() {
        MutableDateTime mutableDateTime = new MutableDateTime(); // Initializing MutableDateTime
        int weekyearsToAdd = 1; // Test with a non-zero weekyear

        try {
            mutableDateTime.addWeekyears(weekyearsToAdd);
            // Add assertions if needed to verify the state after adding weekyears
        } catch (Exception e) {
            fail("Expected no exception, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAddWeekyearsZero() {
        MutableDateTime mutableDateTime = new MutableDateTime(); // Initializing MutableDateTime
        int weekyearsToAdd = 0; // Test with zero weekyears

        try {
            mutableDateTime.addWeekyears(weekyearsToAdd);
            // Verify there is no change in the state (if required)
        } catch (Exception e) {
            fail("Expected no exception, but got: " + e.getMessage());
        }
    }

}
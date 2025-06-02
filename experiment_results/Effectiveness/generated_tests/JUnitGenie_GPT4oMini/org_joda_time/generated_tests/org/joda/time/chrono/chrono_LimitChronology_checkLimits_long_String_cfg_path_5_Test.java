package org.joda.time.chrono;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_LimitChronology_checkLimits_long_String_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testCheckLimitsThrowsLimitExceptionForLowerLimit() {
        try {
            // Create a LimitChronology instance using reflection
            LimitChronology limitChronology = (LimitChronology) LimitChronology.class.getDeclaredConstructors()[0].newInstance(null, new DateTime(1000), new DateTime(2000));
            long instant = 500; // This is less than the lower limit (1000)
            String desc = "Lower limit exceeded";

            limitChronology.checkLimits(instant, desc);
            fail("Expected LimitException to be thrown");
        } catch (Exception e) { // Catch generic Exception since LimitException is private
            // Check if the caught exception is of the expected type
            if (e.getClass().getSimpleName().equals("LimitException")) {
                assertEquals("Lower limit exceeded", e.getMessage());
            } else {
                fail("Expected LimitException to be thrown, but got: " + e.getMessage());
            }
        }
    }

    @Test(timeout = 4000)
    public void testCheckLimitsThrowsLimitExceptionForUpperLimit() {
        try {
            // Create a LimitChronology instance using reflection
            LimitChronology limitChronology = (LimitChronology) LimitChronology.class.getDeclaredConstructors()[0].newInstance(null, new DateTime(1000), new DateTime(2000));
            long instant = 2000; // This is equal to the upper limit (2000)
            String desc = "Upper limit exceeded";

            limitChronology.checkLimits(instant, desc);
            fail("Expected LimitException to be thrown");
        } catch (Exception e) { // Catch generic Exception since LimitException is private
            // Check if the caught exception is of the expected type
            if (e.getClass().getSimpleName().equals("LimitException")) {
                assertEquals("Upper limit exceeded", e.getMessage());
            } else {
                fail("Expected LimitException to be thrown, but got: " + e.getMessage());
            }
        }
    }

    @Test(timeout = 4000)
    public void testCheckLimitsDoesNotThrowExceptionWithinLimits() {
        try {
            // Create a LimitChronology instance using reflection
            LimitChronology limitChronology = (LimitChronology) LimitChronology.class.getDeclaredConstructors()[0].newInstance(null, new DateTime(1000), new DateTime(2000));
            long instant = 1500; // This is within the limits (1000 < 1500 < 2000)
            String desc = "Should not throw";

            limitChronology.checkLimits(instant, desc);
        } catch (Exception e) {
            fail("Expected no exception to be thrown, but got: " + e.getMessage());
        }
    }

}
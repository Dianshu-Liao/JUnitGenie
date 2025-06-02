package org.joda.time.chrono;
import org.joda.time.chrono.LimitChronology;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_LimitChronology_checkLimits_long_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCheckLimitsThrowsLimitExceptionForLowerLimit() {
        try {
            // Create an instance of LimitChronology using reflection
            LimitChronology limitChronology = (LimitChronology) LimitChronology.class.getDeclaredConstructors()[0].newInstance(null, new DateTime(1000), new DateTime(2000));
            long instant = 500; // This is below the lower limit
            String desc = "Instant is below the lower limit";
            limitChronology.checkLimits(instant, desc);
            fail("Expected LimitException to be thrown");
        } catch (Exception e) {
            Throwable cause = e.getCause();
            if (cause != null && cause.getClass().getName().equals("org.joda.time.chrono.LimitChronology$LimitException")) {
                assertEquals("Instant is below the lower limit", cause.getMessage());
            } else {
                fail("Expected LimitException to be thrown, but got: " + e.getMessage());
            }
        }
    }

    @Test(timeout = 4000)
    public void testCheckLimitsThrowsLimitExceptionForUpperLimit() {
        try {
            // Create an instance of LimitChronology using reflection
            LimitChronology limitChronology = (LimitChronology) LimitChronology.class.getDeclaredConstructors()[0].newInstance(null, new DateTime(1000), new DateTime(2000));
            long instant = 2000; // This is equal to the upper limit
            String desc = "Instant is above or equal to the upper limit";
            limitChronology.checkLimits(instant, desc);
            fail("Expected LimitException to be thrown");
        } catch (Exception e) {
            Throwable cause = e.getCause();
            if (cause != null && cause.getClass().getName().equals("org.joda.time.chrono.LimitChronology$LimitException")) {
                assertEquals("Instant is above or equal to the upper limit", cause.getMessage());
            } else {
                fail("Expected LimitException to be thrown, but got: " + e.getMessage());
            }
        }
    }

    @Test(timeout = 4000)
    public void testCheckLimitsDoesNotThrowForValidInstant() {
        try {
            // Create an instance of LimitChronology using reflection
            LimitChronology limitChronology = (LimitChronology) LimitChronology.class.getDeclaredConstructors()[0].newInstance(null, new DateTime(1000), new DateTime(2000));
            long instant = 1500; // This is within the limits
            String desc = "Instant is within limits";
            limitChronology.checkLimits(instant, desc); // Should not throw
        } catch (Exception e) {
            fail("Expected no exception to be thrown, but got: " + e.getMessage());
        }
    }


}
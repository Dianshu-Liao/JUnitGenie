package org.joda.time.chrono;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_LimitChronology_checkLimits_long_String_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testCheckLimits_NoLimits() {
        // Arrange
        DateTime lowerLimit = null; // iLowerLimit is null
        DateTime upperLimit = null; // iUpperLimit is null
        LimitChronology limitChronology = createLimitChronology(lowerLimit, upperLimit);
        
        long instant = System.currentTimeMillis();
        String desc = "Test description";

        // Act
        try {
            limitChronology.checkLimits(instant, desc);
        } catch (Exception e) {
            fail("Exception should not be thrown when both limits are null.");
        }
    }

    private LimitChronology createLimitChronology(DateTime lowerLimit, DateTime upperLimit) {
        // Instead of using reflection, we will use a public method or a factory method if available
        // Assuming LimitChronology has a public static method to create an instance
        return LimitChronology.getInstance(org.joda.time.chrono.ISOChronology.getInstance(), lowerLimit, upperLimit);
    }

}
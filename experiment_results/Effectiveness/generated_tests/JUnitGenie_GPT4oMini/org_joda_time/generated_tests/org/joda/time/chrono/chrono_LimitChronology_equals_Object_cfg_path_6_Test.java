package org.joda.time.chrono;
import org.joda.time.DateTime;
import org.joda.time.Chronology;
import org.joda.time.chrono.LimitChronology;
import org.joda.time.chrono.ISOChronology;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class chrono_LimitChronology_equals_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testEqualsWithDifferentObject() {
        // Create a Chronology instance to pass to LimitChronology constructor
        Chronology baseChronology = ISOChronology.getInstance(); // Use the correct method to get ISOChronology
        DateTime lowerLimit = new DateTime(2020, 1, 1, 0, 0); // Use a valid DateTime instance
        DateTime upperLimit = new DateTime(2021, 1, 1, 0, 0); // Use a valid DateTime instance

        // Create a LimitChronology instance using the public method
        LimitChronology chrono1 = LimitChronology.getInstance(baseChronology, lowerLimit, upperLimit);
        Object obj = new Object(); // Different type of object

        boolean result = chrono1.equals(obj);
        assertFalse(result);
    }


}
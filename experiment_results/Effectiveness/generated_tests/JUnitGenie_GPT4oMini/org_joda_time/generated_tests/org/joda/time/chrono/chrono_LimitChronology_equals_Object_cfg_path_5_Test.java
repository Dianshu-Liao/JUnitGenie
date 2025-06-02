package org.joda.time.chrono;
import org.joda.time.chrono.LimitChronology;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class chrono_LimitChronology_equals_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testEqualsWithDifferentObjectType() {
        // Create instances of DateTime for the LimitChronology constructor
        DateTime start = new DateTime(0); // Example start time
        DateTime end = new DateTime(1000); // Example end time
        Chronology baseChronology = org.joda.time.chrono.GregorianChronology.getInstance(); // Use a valid Chronology

        // Create a LimitChronology with the required parameters
        LimitChronology limitChronology = LimitChronology.getInstance(baseChronology, start, end);
        Object differentObject = new Object(); // An object of a different type

        // This should return false as the object is not an instance of LimitChronology
        assertFalse(limitChronology.equals(differentObject));
    }

}
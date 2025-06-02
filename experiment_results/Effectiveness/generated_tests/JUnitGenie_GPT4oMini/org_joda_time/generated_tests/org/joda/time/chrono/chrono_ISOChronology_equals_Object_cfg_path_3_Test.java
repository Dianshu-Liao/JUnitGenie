package org.joda.time.chrono;
import org.joda.time.chrono.ISOChronology;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class chrono_ISOChronology_equals_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEqualsWithDifferentObject() {
        ISOChronology chrono1 = ISOChronology.getInstanceUTC();
        Object differentObject = new Object(); // A different type of object

        try {
            boolean result = chrono1.equals(differentObject);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}
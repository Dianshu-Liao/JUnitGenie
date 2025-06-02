package org.joda.time.chrono;
import org.joda.time.chrono.ISOChronology;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class chrono_ISOChronology_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEqualsWithDifferentObject() {
        ISOChronology chrono1 = ISOChronology.getInstance();
        Object obj = new Object(); // Different type of object
        try {
            assertFalse(chrono1.equals(obj));
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}
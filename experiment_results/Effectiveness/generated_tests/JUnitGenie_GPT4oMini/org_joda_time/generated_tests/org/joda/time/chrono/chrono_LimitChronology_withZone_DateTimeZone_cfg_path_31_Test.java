package org.joda.time.chrono;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.LimitChronology;
import org.joda.time.MutableDateTime;
import org.joda.time.Chronology;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class chrono_LimitChronology_withZone_DateTimeZone_cfg_path_31_Test {

    @Test(timeout = 4000)
    public void testWithZone_NullZone() {
        LimitChronology chronology = LimitChronology.getInstance(null, null, null); // Use getInstance method
        Chronology result = null;
        try {
            result = chronology.withZone(null);
        } catch (Exception e) {
            // Handle exception if needed
        }
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testWithZone_DefaultZone() {
        LimitChronology chronology = LimitChronology.getInstance(null, null, null); // Use getInstance method
        Chronology result = null;
        try {
            result = chronology.withZone(DateTimeZone.getDefault());
        } catch (Exception e) {
            // Handle exception if needed
        }
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testWithZone_UTCZone() {
        LimitChronology chronology = LimitChronology.getInstance(null, null, null); // Use getInstance method
        Chronology result = null;
        try {
            result = chronology.withZone(DateTimeZone.UTC);
        } catch (Exception e) {
            // Handle exception if needed
        }
        assertNotNull(result);
    }




}

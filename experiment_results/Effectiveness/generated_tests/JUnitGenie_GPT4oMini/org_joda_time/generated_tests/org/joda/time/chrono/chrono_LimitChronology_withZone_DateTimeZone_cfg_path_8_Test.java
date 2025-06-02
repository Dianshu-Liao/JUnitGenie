package org.joda.time.chrono;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.LimitChronology;
import org.joda.time.MutableDateTime;
import org.joda.time.Chronology;
import org.joda.time.chrono.ISOChronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_LimitChronology_withZone_DateTimeZone_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testWithZone() {
        // Create a concrete implementation of DateTimeZone
        DateTimeZone zone = new DateTimeZone("UTC") {
            @Override
            public boolean isFixed() {
                return true;
            }

            @Override
            public boolean equals(Object obj) {
                return obj instanceof DateTimeZone && ((DateTimeZone) obj).getID().equals(this.getID());
            }

            @Override
            public String getNameKey(long instant) {
                return "UTC";
            }

            @Override
            public int getStandardOffset(long instant) {
                return 0;
            }

            @Override
            public long previousTransition(long instant) {
                return instant;
            }

            @Override
            public int getOffset(long instant) {
                return 0;
            }

            @Override
            public long nextTransition(long instant) {
                return instant;
            }
        };

        // Create instances of DateTime for lower and upper limits
        DateTime lowerLimit = new DateTime(2020, 1, 1, 0, 0);
        DateTime upperLimit = new DateTime(2020, 12, 31, 23, 59);

        // Create an instance of LimitChronology using ISOChronology
        LimitChronology chronology = LimitChronology.getInstance(ISOChronology.getInstance(), lowerLimit, upperLimit);

        // Call the focal method
        Chronology result = chronology.withZone(zone);

        // Validate the result
        assertNotNull(result);
        assertTrue(result instanceof LimitChronology);
    }

    @Test(timeout = 4000)
    public void testWithZoneNullZone() {
        // Create instances of DateTime for lower and upper limits
        DateTime lowerLimit = new DateTime(2020, 1, 1, 0, 0);
        DateTime upperLimit = new DateTime(2020, 12, 31, 23, 59);

        // Create an instance of LimitChronology using ISOChronology
        LimitChronology chronology = LimitChronology.getInstance(ISOChronology.getInstance(), lowerLimit, upperLimit);

        // Call the focal method with null zone
        Chronology result = null;
        try {
            result = chronology.withZone(null);
        } catch (Exception e) {
            fail("Exception should not be thrown for null zone");
        }

        // Validate the result
        assertNotNull(result);
        assertTrue(result instanceof LimitChronology);
    }


}
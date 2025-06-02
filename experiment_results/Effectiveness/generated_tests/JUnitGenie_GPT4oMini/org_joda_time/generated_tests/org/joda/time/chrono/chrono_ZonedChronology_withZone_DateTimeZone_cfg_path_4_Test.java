package org.joda.time.chrono;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ZonedChronology;
import org.joda.time.Chronology;
import org.joda.time.chrono.ISOChronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_ZonedChronology_withZone_DateTimeZone_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWithZone_NullZone() {
        // Adjusted to handle null zone case
        ZonedChronology zonedChronology = ZonedChronology.getInstance(ISOChronology.getInstance(), DateTimeZone.UTC); // Use a default zone instead of null
        Chronology result = zonedChronology.withZone(null);
        assertNotNull(result);
        assertEquals(zonedChronology, result);
    }

    @Test(timeout = 4000)
    public void testWithZone_SameZone() {
        ZonedChronology zonedChronology = ZonedChronology.getInstance(ISOChronology.getInstance(), DateTimeZone.UTC);
        DateTimeZone zone = zonedChronology.getZone();
        Chronology result = zonedChronology.withZone(zone);
        assertNotNull(result);
        assertEquals(zonedChronology, result);
    }


    @Test(timeout = 4000)
    public void testWithZone_ValidZone() {
        ZonedChronology zonedChronology = ZonedChronology.getInstance(ISOChronology.getInstance(), DateTimeZone.UTC);
        DateTimeZone zone = new CustomDateTimeZone("CustomZone");
        Chronology result = zonedChronology.withZone(zone);
        assertNotNull(result);
        // Additional assertions can be added here to verify the properties of the result
    }

    // Custom implementation of DateTimeZone for testing
    private static class CustomDateTimeZone extends DateTimeZone {
        protected CustomDateTimeZone(String id) {
            super(id);
        }

        @Override
        public boolean isFixed() {
            return false;
        }

        @Override
        public boolean equals(Object obj) {
            return this == obj;
        }

        @Override
        public String getNameKey(long instant) {
            return "CustomZone";
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
    }

}

package org.joda.time.chrono;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
import org.joda.time.DateTime;
import org.joda.time.Chronology;
import org.joda.time.chrono.LimitChronology;
import org.joda.time.chrono.ISOChronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_LimitChronology_withZone_DateTimeZone_cfg_path_1_Test {

    private class TestDateTimeZone extends DateTimeZone {
        protected TestDateTimeZone(String id) {
            super(id);
        }

        @Override
        public boolean isFixed() {
            return false;
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof TestDateTimeZone && this.getID().equals(((TestDateTimeZone) obj).getID());
        }

        @Override
        public String getNameKey(long instant) {
            return "TestZone";
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

    @Test(timeout = 4000)
    public void testWithZone() {
        // Creating a LimitChronology with required parameters
        LimitChronology chronology = LimitChronology.getInstance(ISOChronology.getInstance(), new DateTime(0), new DateTime(0)); // Changed to ISOChronology.getInstance()
        TestDateTimeZone testZone = new TestDateTimeZone("TestZone");

        // Test with a non-null DateTimeZone
        Chronology result = chronology.withZone(testZone);
        assertNotNull(result);
        assertNotSame(chronology, result);

        // Test with UTC
        result = chronology.withZone(DateTimeZone.UTC);
        assertNotNull(result);
        assertNotSame(chronology, result);
    }

    @Test(timeout = 4000)
    public void testWithZoneNull() {
        // Creating a LimitChronology with required parameters
        LimitChronology chronology = LimitChronology.getInstance(ISOChronology.getInstance(), new DateTime(0), new DateTime(0)); // Changed to ISOChronology.getInstance()

        // Test with null DateTimeZone
        Chronology result = chronology.withZone(null);
        assertNotNull(result);
        assertSame(chronology, result);
    }

}
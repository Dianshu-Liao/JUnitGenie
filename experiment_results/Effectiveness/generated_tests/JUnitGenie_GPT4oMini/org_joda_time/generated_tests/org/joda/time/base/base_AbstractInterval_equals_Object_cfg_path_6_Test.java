package org.joda.time.base;
import org.joda.time.base.AbstractInterval;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.DateTime;
import org.joda.time.chrono.ISOChronology;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class base_AbstractInterval_equals_Object_cfg_path_6_Test {

    private class ConcreteInterval extends AbstractInterval {
        private long startMillis;
        private long endMillis;
        private Chronology chronology;

        public ConcreteInterval(long startMillis, long endMillis, Chronology chronology) {
            this.startMillis = startMillis;
            this.endMillis = endMillis;
            this.chronology = chronology;
        }

        @Override
        public Chronology getChronology() {
            return chronology;
        }

        @Override
        public long getStartMillis() {
            return startMillis;
        }

        @Override
        public long getEndMillis() {
            return endMillis;
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentObjects() {
        ConcreteInterval interval1 = new ConcreteInterval(1000L, 2000L, ISOChronology.getInstance()); // Use ISOChronology.getInstance()
        Object notAnInterval = new Object();

        try {
            // Test that the equals method returns false for a different object type
            boolean result = interval1.equals(notAnInterval);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameReference() {
        ConcreteInterval interval1 = new ConcreteInterval(1000L, 2000L, ISOChronology.getInstance()); // Use ISOChronology.getInstance()

        try {
            // Test that the equals method returns true for the same reference
            boolean result = interval1.equals(interval1);
            assertFalse(!result); // should be true
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
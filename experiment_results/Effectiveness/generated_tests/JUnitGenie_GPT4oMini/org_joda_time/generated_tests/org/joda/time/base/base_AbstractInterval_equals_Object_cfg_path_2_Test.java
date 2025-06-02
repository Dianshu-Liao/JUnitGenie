package org.joda.time.base;
import org.joda.time.base.AbstractInterval;
import org.joda.time.ReadableInterval;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.junit.Test;
import static org.junit.Assert.*;

public class base_AbstractInterval_equals_Object_cfg_path_2_Test {

    private class TestInterval extends AbstractInterval {
        private long startMillis;
        private long endMillis;
        private Chronology chronology;

        public TestInterval(long startMillis, long endMillis, Chronology chronology) {
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
    public void testEquals_SameObject() {
        TestInterval interval = new TestInterval(1000, 2000, null);
        assertTrue(interval.equals(interval));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        TestInterval interval = new TestInterval(1000, 2000, null);
        assertFalse(interval.equals("Not an interval"));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentIntervals() {
        TestInterval interval1 = new TestInterval(1000, 2000, null);
        TestInterval interval2 = new TestInterval(1500, 2500, null);
        assertFalse(interval1.equals(interval2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameIntervals() {
        TestInterval interval1 = new TestInterval(1000, 2000, null);
        TestInterval interval2 = new TestInterval(1000, 2000, null);
        assertTrue(interval1.equals(interval2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameChronology() {
        Chronology chronology = null; // Replace with a valid Chronology instance if needed
        TestInterval interval1 = new TestInterval(1000, 2000, chronology);
        TestInterval interval2 = new TestInterval(1000, 2000, chronology);
        assertTrue(interval1.equals(interval2));
    }



}

package org.joda.time.base;
import org.joda.time.base.AbstractInterval;
import org.joda.time.ReadableInterval;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class base_AbstractInterval_equals_Object_cfg_path_5_Test {

    private class TestInterval extends AbstractInterval {
        private long startMillis;
        private long endMillis;
        private org.joda.time.Chronology chronology;

        public TestInterval(long startMillis, long endMillis, org.joda.time.Chronology chronology) {
            this.startMillis = startMillis;
            this.endMillis = endMillis;
            this.chronology = chronology;
        }

        @Override
        public org.joda.time.Chronology getChronology() {
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
    public void testEqualsWithDifferentType() {
        AbstractInterval interval = new TestInterval(1000, 2000, null);
        Object nonReadableInterval = new Object(); // Not an instance of ReadableInterval

        try {
            assertFalse(interval.equals(nonReadableInterval));
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}
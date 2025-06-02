package org.joda.time.base;
import static org.junit.Assert.*;
import org.joda.time.base.AbstractInterval;
import org.joda.time.Chronology;
import org.joda.time.ReadableInterval;
import org.joda.time.DateTimeZone;
import org.joda.time.Interval;
import org.junit.Test;

public class base_AbstractInterval_equals_Object_cfg_path_3_Test {

    private class TestReadableInterval extends AbstractInterval implements ReadableInterval {
        private final long startMillis;
        private final long endMillis;
        private final Chronology chronology;

        public TestReadableInterval(long startMillis, long endMillis, Chronology chronology) {
            this.startMillis = startMillis;
            this.endMillis = endMillis;
            this.chronology = chronology;
        }

        @Override
        public long getStartMillis() {
            return startMillis;
        }

        @Override
        public long getEndMillis() {
            return endMillis;
        }

        @Override
        public Chronology getChronology() {
            return chronology;
        }
    }







}

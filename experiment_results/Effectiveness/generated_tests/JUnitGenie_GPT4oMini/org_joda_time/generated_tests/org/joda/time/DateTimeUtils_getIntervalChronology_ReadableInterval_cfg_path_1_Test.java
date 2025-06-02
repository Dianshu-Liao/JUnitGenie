package org.joda.time;
import org.joda.time.Chronology;
import org.joda.time.DateTimeZone;
import org.joda.time.ReadableInterval;
import org.joda.time.Interval;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.ReadableInstant;
import org.joda.time.MutableInterval;
import org.joda.time.DateTime;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeUtils_getIntervalChronology_ReadableInterval_cfg_path_1_Test {

    private static class TestReadableInterval implements ReadableInterval {
        private final Interval interval;

        public TestReadableInterval(long startMillis, long endMillis) {
            this.interval = new Interval(startMillis, endMillis);
        }

        @Override
        public long getStartMillis() {
            return interval.getStartMillis();
        }

        @Override
        public long getEndMillis() {
            return interval.getEndMillis();
        }

        @Override
        public Chronology getChronology() {
            return ISOChronology.getInstance(DateTimeZone.UTC);
        }

        @Override
        public boolean overlaps(ReadableInterval interval) {
            return this.interval.overlaps(interval);
        }

        @Override
        public boolean contains(ReadableInstant instant) {
            return this.interval.contains(instant);
        }

        @Override
        public boolean isBefore(ReadableInstant instant) {
            return this.interval.isBefore(instant);
        }

        @Override
        public boolean isAfter(ReadableInstant instant) {
            return this.interval.isAfter(instant);
        }

        @Override
        public boolean isBefore(ReadableInterval interval) {
            return this.interval.isBefore(interval);
        }

        @Override
        public boolean contains(ReadableInterval interval) {
            return this.interval.contains(interval);
        }

        @Override
        public DateTime getStart() {
            return interval.getStart();
        }

        @Override
        public DateTime getEnd() {
            return interval.getEnd();
        }

        @Override
        public long toDurationMillis() {
            return interval.toDurationMillis();
        }

        @Override
        public Period toPeriod() {
            return interval.toPeriod();
        }

        @Override
        public Period toPeriod(PeriodType type) {
            return interval.toPeriod(type);
        }

        @Override
        public Interval toInterval() {
            return interval.toInterval();
        }

        @Override
        public MutableInterval toMutableInterval() {
            return interval.toMutableInterval();
        }

        @Override
        public int hashCode() {
            return interval.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return interval.equals(obj);
        }

        @Override
        public String toString() {
            return interval.toString();
        }

        @Override
        public org.joda.time.Duration toDuration() {
            return interval.toDuration(); // Implementing the missing method
        }

        // Implementing the missing method from ReadableInterval
        @Override
        public boolean isAfter(ReadableInterval interval) {
            return this.interval.isAfter(interval);
        }
    }

    @Test(timeout = 4000)
    public void testGetIntervalChronologyWithValidInterval() {
        ReadableInterval interval = new TestReadableInterval(0, 1000);
        Chronology result = DateTimeUtils.getIntervalChronology(interval);
        assertNotNull(result);
        assertEquals(ISOChronology.getInstance(DateTimeZone.UTC), result);
    }

    @Test(timeout = 4000)
    public void testGetIntervalChronologyWithNullInterval() {
        ReadableInterval interval = null;
        Chronology result = DateTimeUtils.getIntervalChronology(interval);
        assertNotNull(result);
        assertEquals(ISOChronology.getInstance(), result);
    }

    @Test(timeout = 4000)
    public void testGetIntervalChronologyWithIntervalWithoutChronology() {
        ReadableInterval interval = new TestReadableInterval(0, 1000) {
            @Override
            public Chronology getChronology() {
                return null; // Simulating an interval without a chronology
            }
        };
        Chronology result = DateTimeUtils.getIntervalChronology(interval);
        assertNotNull(result);
        assertEquals(ISOChronology.getInstance(), result);
    }


}
package org.joda.time;
import org.joda.time.DateTimeUtils;
import org.joda.time.ReadableInterval;
import org.joda.time.Interval;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTimeUtils_getReadableInterval_ReadableInterval_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetReadableIntervalWithNonNullInterval() {
        // Create a mock ReadableInterval
        ReadableInterval mockInterval = new ReadableInterval() {
            @Override
            public org.joda.time.Period toPeriod() {
                return null;
            }

            @Override
            public boolean equals(Object obj) {
                return false;
            }

            @Override
            public boolean isBefore(org.joda.time.ReadableInstant instant) {
                return false;
            }

            @Override
            public long toDurationMillis() {
                return 0;
            }

            @Override
            public org.joda.time.Period toPeriod(org.joda.time.PeriodType type) {
                return null;
            }

            @Override
            public boolean isAfter(org.joda.time.ReadableInstant instant) {
                return false;
            }

            @Override
            public boolean isBefore(org.joda.time.ReadableInterval interval) {
                return false;
            }

            @Override
            public org.joda.time.MutableInterval toMutableInterval() {
                return null;
            }

            @Override
            public org.joda.time.Duration toDuration() {
                return null;
            }

            @Override
            public boolean overlaps(org.joda.time.ReadableInterval interval) {
                return false;
            }

            @Override
            public org.joda.time.DateTime getEnd() {
                return null;
            }

            @Override
            public org.joda.time.Chronology getChronology() {
                return null;
            }

            @Override
            public org.joda.time.DateTime getStart() {
                return null;
            }

            @Override
            public boolean isAfter(org.joda.time.ReadableInterval interval) {
                return false;
            }

            @Override
            public long getStartMillis() {
                return 0;
            }

            @Override
            public boolean contains(org.joda.time.ReadableInterval interval) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public boolean contains(org.joda.time.ReadableInstant instant) {
                return false;
            }

            @Override
            public org.joda.time.Interval toInterval() {
                return null;
            }

            @Override
            public String toString() {
                return "Mock ReadableInterval";
            }

            @Override
            public long getEndMillis() {
                return 0;
            }
        };

        // Call the focal method
        ReadableInterval result = DateTimeUtils.getReadableInterval(mockInterval);

        // Assert that the result is the same as the input
        assertEquals(mockInterval, result);
    }

    @Test(timeout = 4000)
    public void testGetReadableIntervalWithNullInterval() {
        // Call the focal method with null
        ReadableInterval result = DateTimeUtils.getReadableInterval(null);

        // Assert that the result is not null and is an instance of Interval
        assertEquals(Interval.class, result.getClass());
    }

}
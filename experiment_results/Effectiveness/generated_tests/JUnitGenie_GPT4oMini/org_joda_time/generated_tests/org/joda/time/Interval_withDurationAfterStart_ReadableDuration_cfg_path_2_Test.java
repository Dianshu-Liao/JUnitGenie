package org.joda.time;
import org.joda.time.Interval;
import org.joda.time.ReadableDuration;
import org.joda.time.Duration;
import org.joda.time.DateTimeUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Interval_withDurationAfterStart_ReadableDuration_cfg_path_2_Test {

    private class TestReadableDuration implements ReadableDuration, Comparable<ReadableDuration> {
        private final long millis;

        public TestReadableDuration(long millis) {
            this.millis = millis;
        }

        @Override
        public long getMillis() {
            return millis;
        }

        @Override
        public Duration toDuration() {
            return new Duration(millis);
        }

        @Override
        public org.joda.time.Period toPeriod() {
            return new org.joda.time.Period(millis);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            TestReadableDuration that = (TestReadableDuration) obj;
            return millis == that.millis;
        }

        @Override
        public int hashCode() {
            return Long.hashCode(millis);
        }

        @Override
        public boolean isLongerThan(ReadableDuration duration) {
            return this.millis > duration.getMillis();
        }

        @Override
        public boolean isShorterThan(ReadableDuration duration) {
            return this.millis < duration.getMillis();
        }

        @Override
        public boolean isEqual(ReadableDuration duration) {
            return this.millis == duration.getMillis();
        }

        @Override
        public String toString() {
            return "TestReadableDuration{" + "millis=" + millis + '}';
        }

        @Override
        public int compareTo(ReadableDuration other) {
            return Long.compare(this.millis, other.getMillis());
        }
    }

    @Test(timeout = 4000)
    public void testWithDurationAfterStart() {
        Interval interval = new Interval(1000, 2000);
        ReadableDuration duration = new TestReadableDuration(1000);
        
        Interval result = interval.withDurationAfterStart(duration);
        
        // Verify that the result is the same as the original interval
        assertEquals(interval, result);
    }


}
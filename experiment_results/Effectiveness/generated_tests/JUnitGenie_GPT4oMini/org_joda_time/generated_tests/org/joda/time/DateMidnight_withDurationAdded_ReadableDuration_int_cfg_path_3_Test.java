package org.joda.time;
import org.joda.time.DateMidnight;
import org.joda.time.ReadableDuration;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateMidnight_withDurationAdded_ReadableDuration_int_cfg_path_3_Test {

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
        public org.joda.time.Period toPeriod() {
            return null; // Simplified for testing
        }

        @Override
        public boolean equals(Object obj) {
            return obj instanceof TestReadableDuration && millis == ((TestReadableDuration) obj).millis;
        }

        @Override
        public org.joda.time.Duration toDuration() {
            return null; // Simplified for testing
        }

        @Override
        public boolean isLongerThan(ReadableDuration duration) {
            return millis > duration.getMillis();
        }

        @Override
        public boolean isShorterThan(ReadableDuration duration) {
            return millis < duration.getMillis();
        }

        @Override
        public boolean isEqual(ReadableDuration duration) {
            return millis == duration.getMillis();
        }

        @Override
        public int hashCode() {
            return Long.hashCode(millis);
        }

        @Override
        public String toString() {
            return String.valueOf(millis);
        }

        @Override
        public int compareTo(ReadableDuration other) {
            return Long.compare(this.millis, other.getMillis());
        }
    }

    @Test(timeout = 4000)
    public void testWithDurationAdded_NullDuration() {
        DateMidnight dateMidnight = new DateMidnight();
        DateMidnight result = dateMidnight.withDurationAdded(null, 5);
        assertEquals(dateMidnight, result);
    }

    @Test(timeout = 4000)
    public void testWithDurationAdded_ZeroScalar() {
        DateMidnight dateMidnight = new DateMidnight();
        TestReadableDuration duration = new TestReadableDuration(1000);
        DateMidnight result = dateMidnight.withDurationAdded(duration, 0);
        assertEquals(dateMidnight, result);
    }


}
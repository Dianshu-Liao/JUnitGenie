package org.joda.time;
import org.joda.time.Instant;
import org.joda.time.ReadableDuration;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Instant_withDurationAdded_ReadableDuration_int_cfg_path_3_Test {

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
            // Simple implementation for testing
            return null;
        }

        @Override
        public org.joda.time.Duration toDuration() {
            // Simple implementation for testing
            return null;
        }

        @Override
        public boolean isLongerThan(ReadableDuration other) {
            return this.millis > other.getMillis();
        }

        @Override
        public boolean isShorterThan(ReadableDuration other) {
            return this.millis < other.getMillis();
        }

        @Override
        public boolean isEqual(ReadableDuration other) {
            return this.millis == other.getMillis();
        }

        @Override
        public int hashCode() {
            return Long.hashCode(millis);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof ReadableDuration)) return false;
            return millis == ((ReadableDuration) obj).getMillis();
        }

        @Override
        public String toString() {
            return Long.toString(millis);
        }

        @Override
        public int compareTo(ReadableDuration other) {
            return Long.compare(this.millis, other.getMillis());
        }
    }

    @Test(timeout = 4000)
    public void testWithDurationAdded_NullDuration() {
        Instant instant = new Instant();
        ReadableDuration durationToAdd = null;
        int scalar = 5;
        Instant result = instant.withDurationAdded(durationToAdd, scalar);
        assertEquals(instant, result);
    }

    @Test(timeout = 4000)
    public void testWithDurationAdded_ZeroScalar() {
        Instant instant = new Instant();
        ReadableDuration durationToAdd = new TestReadableDuration(1000);
        int scalar = 0;
        Instant result = instant.withDurationAdded(durationToAdd, scalar);
        assertEquals(instant, result);
    }


}
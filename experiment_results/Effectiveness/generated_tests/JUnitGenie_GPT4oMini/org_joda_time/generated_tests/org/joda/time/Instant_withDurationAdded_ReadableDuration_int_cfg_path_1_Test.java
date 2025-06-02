package org.joda.time;
import org.joda.time.Instant;
import org.joda.time.ReadableDuration;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Instant_withDurationAdded_ReadableDuration_int_cfg_path_1_Test {

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
        public org.joda.time.Duration toDuration() {
            return new org.joda.time.Duration(millis);
        }

        @Override
        public org.joda.time.Period toPeriod() {
            return org.joda.time.Period.millis((int) millis);
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
        public int hashCode() {
            return Long.hashCode(millis);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            TestReadableDuration that = (TestReadableDuration) obj;
            return millis == that.millis;
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
    public void testWithDurationAdded() {
        Instant instant = new Instant();
        ReadableDuration durationToAdd = new TestReadableDuration(1000); // 1 second
        int scalar = 2;

        Instant result = instant.withDurationAdded(durationToAdd, scalar);
        Instant expected = instant.withDurationAdded(durationToAdd.getMillis(), scalar);

        assertEquals(expected, result);
    }

    @Test(timeout = 4000)
    public void testWithDurationAdded_NullDuration() {
        Instant instant = new Instant();
        ReadableDuration durationToAdd = null;
        int scalar = 2;

        Instant result = instant.withDurationAdded(durationToAdd, scalar);

        assertEquals(instant, result);
    }

    @Test(timeout = 4000)
    public void testWithDurationAdded_ZeroScalar() {
        Instant instant = new Instant();
        ReadableDuration durationToAdd = new TestReadableDuration(1000); // 1 second
        int scalar = 0;

        Instant result = instant.withDurationAdded(durationToAdd, scalar);

        assertEquals(instant, result);
    }


}
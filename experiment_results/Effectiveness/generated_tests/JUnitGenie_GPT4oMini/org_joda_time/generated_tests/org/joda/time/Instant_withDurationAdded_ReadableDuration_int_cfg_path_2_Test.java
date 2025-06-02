package org.joda.time;
import org.joda.time.Instant;
import org.joda.time.ReadableDuration;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Instant_withDurationAdded_ReadableDuration_int_cfg_path_2_Test {

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
            return null; // Implement as needed for your tests
        }

        @Override
        public org.joda.time.Duration toDuration() {
            return null; // Implement as needed for your tests
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
        TestReadableDuration duration = new TestReadableDuration(1000);
        int scalar = 1;

        Instant result = instant.withDurationAdded(duration, scalar);
        assertEquals(instant.plus(duration.getMillis()), result); // Adjust the expected result based on your logic
    }

    @Test(timeout = 4000)
    public void testWithDurationAdded_NullDuration() {
        Instant instant = new Instant();
        ReadableDuration duration = null;
        int scalar = 1;

        Instant result = instant.withDurationAdded(duration, scalar);
        assertEquals(instant, result);
    }

    @Test(timeout = 4000)
    public void testWithDurationAdded_ScalarZero() {
        Instant instant = new Instant();
        TestReadableDuration duration = new TestReadableDuration(1000);
        int scalar = 0;

        Instant result = instant.withDurationAdded(duration, scalar);
        assertEquals(instant, result);
    }


}
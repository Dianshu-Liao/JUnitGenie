package org.joda.time;
import org.joda.time.DateTime;
import org.joda.time.ReadableDuration;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTime_withDurationAdded_ReadableDuration_int_cfg_path_3_Test {

    private class MockReadableDuration implements ReadableDuration, Comparable<ReadableDuration> {
        private final long millis;

        public MockReadableDuration(long millis) {
            this.millis = millis;
        }

        @Override
        public long getMillis() {
            return millis;
        }

        @Override
        public org.joda.time.Period toPeriod() {
            return null; // Implement as needed for other tests
        }

        @Override
        public org.joda.time.Duration toDuration() {
            return null; // Implement as needed for other tests
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
            MockReadableDuration that = (MockReadableDuration) obj;
            return millis == that.millis;
        }

        @Override
        public String toString() {
            return "MockReadableDuration{" + "millis=" + millis + '}';
        }

        @Override
        public int compareTo(ReadableDuration other) {
            return Long.compare(this.millis, other.getMillis());
        }
    }

    @Test(timeout = 4000)
    public void testWithDurationAdded_NullDuration() {
        DateTime dateTime = new DateTime();
        ReadableDuration durationToAdd = null;
        int scalar = 5;

        DateTime result = dateTime.withDurationAdded(durationToAdd, scalar);
        assertEquals(dateTime, result);
    }

    @Test(timeout = 4000)
    public void testWithDurationAdded_ScalarZero() {
        DateTime dateTime = new DateTime();
        ReadableDuration durationToAdd = new MockReadableDuration(1000);
        int scalar = 0;

        DateTime result = dateTime.withDurationAdded(durationToAdd, scalar);
        assertEquals(dateTime, result);
    }


}
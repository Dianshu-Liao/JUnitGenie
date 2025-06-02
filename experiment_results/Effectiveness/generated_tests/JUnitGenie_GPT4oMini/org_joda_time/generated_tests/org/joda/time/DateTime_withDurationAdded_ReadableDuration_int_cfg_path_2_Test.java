package org.joda.time;
import org.joda.time.DateTime;
import org.joda.time.ReadableDuration;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTime_withDurationAdded_ReadableDuration_int_cfg_path_2_Test {

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
        public boolean equals(Object obj) {
            return false; // Implement as needed for your tests
        }

        @Override
        public int hashCode() {
            return Long.hashCode(millis);
        }

        @Override
        public boolean isLongerThan(ReadableDuration duration) {
            return false; // Implement as needed for your tests
        }

        @Override
        public boolean isShorterThan(ReadableDuration duration) {
            return false; // Implement as needed for your tests
        }

        @Override
        public boolean isEqual(ReadableDuration duration) {
            return false; // Implement as needed for your tests
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
    public void testWithDurationAdded_NullDuration() {
        DateTime dateTime = new DateTime();
        DateTime result = dateTime.withDurationAdded(null, 5);
        assertEquals(dateTime, result);
    }

    @Test(timeout = 4000)
    public void testWithDurationAdded_ZeroScalar() {
        DateTime dateTime = new DateTime();
        TestReadableDuration duration = new TestReadableDuration(1000);
        DateTime result = dateTime.withDurationAdded(duration, 0);
        assertEquals(dateTime, result);
    }


}
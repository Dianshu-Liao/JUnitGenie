package org.joda.time.base;
import org.joda.time.base.AbstractDuration;
import org.joda.time.ReadableDuration;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class base_AbstractDuration_compareTo_ReadableDuration_cfg_path_1_Test {

    // Concrete implementation of AbstractDuration for testing
    private static class TestDuration extends AbstractDuration implements ReadableDuration {
        private final long millis;

        public TestDuration(long millis) {
            this.millis = millis;
        }

        @Override
        public long getMillis() {
            return millis;
        }

        @Override
        public boolean isLongerThan(ReadableDuration duration) {
            return this.getMillis() > duration.getMillis();
        }

        @Override
        public boolean isEqual(ReadableDuration duration) {
            return this.getMillis() == duration.getMillis();
        }

        @Override
        public boolean isShorterThan(ReadableDuration duration) {
            return this.getMillis() < duration.getMillis();
        }

        @Override
        public org.joda.time.Duration toDuration() {
            return new org.joda.time.Duration(millis);
        }

        @Override
        public org.joda.time.Period toPeriod() {
            return new org.joda.time.Period(millis);
        }

        @Override
        public String toString() {
            return String.valueOf(millis);
        }

        @Override
        public int hashCode() {
            return Long.hashCode(millis);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof ReadableDuration)) return false;
            ReadableDuration other = (ReadableDuration) obj;
            return this.getMillis() == other.getMillis();
        }
    }

    @Test(timeout = 4000)
    public void testCompareTo_LessThan() {
        TestDuration duration1 = new TestDuration(1000);
        TestDuration duration2 = new TestDuration(2000);
        assertEquals(-1, duration1.compareTo(duration2));
    }

    @Test(timeout = 4000)
    public void testCompareTo_GreaterThan() {
        TestDuration duration1 = new TestDuration(2000);
        TestDuration duration2 = new TestDuration(1000);
        assertEquals(1, duration1.compareTo(duration2));
    }

    @Test(timeout = 4000)
    public void testCompareTo_Equal() {
        TestDuration duration1 = new TestDuration(1000);
        TestDuration duration2 = new TestDuration(1000);
        assertEquals(0, duration1.compareTo(duration2));
    }

}
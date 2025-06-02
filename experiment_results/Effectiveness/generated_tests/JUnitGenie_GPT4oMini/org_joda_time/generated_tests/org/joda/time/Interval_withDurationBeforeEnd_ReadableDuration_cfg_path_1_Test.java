package org.joda.time;
import org.joda.time.Interval;
import org.joda.time.ReadableDuration;
import org.joda.time.Chronology;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.DateTimeUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class Interval_withDurationBeforeEnd_ReadableDuration_cfg_path_1_Test {

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
        public Period toPeriod() {
            return Period.millis((int) millis);
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
    public void testWithDurationBeforeEnd() {
        try {
            // Arrange
            long durationMillis = 1000L; // Example duration in milliseconds
            TestReadableDuration duration = new TestReadableDuration(durationMillis);
            Interval interval = new Interval(0, 5000); // Example interval from 0 to 5000 milliseconds

            // Act
            Interval result = interval.withDurationBeforeEnd(duration);

            // Assert
            Chronology chrono = interval.getChronology();
            long expectedStartMillis = chrono.add(interval.getEndMillis(), -durationMillis, -1);
            assertEquals(expectedStartMillis, result.getStartMillis());
            assertEquals(interval.getEndMillis(), result.getEndMillis());
            assertEquals(chrono, result.getChronology());
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }


}
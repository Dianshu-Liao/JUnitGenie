package org.joda.time;
import org.joda.time.Interval;
import org.joda.time.ReadableDuration;
import org.joda.time.Duration;
import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import org.joda.time.chrono.ISOChronology;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Interval_withDurationAfterStart_ReadableDuration_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWithDurationAfterStart() {
        // Arrange
        long startMillis = 1000L; // Example start time
        long durationMillis = 5000L; // Example duration
        Chronology chrono = ISOChronology.getInstance(); // Corrected to use ISOChronology.getInstance()
        Interval interval = new Interval(startMillis, startMillis + durationMillis, chrono);
        
        // Create a ReadableDuration that meets the constraints
        ReadableDuration duration = new ReadableDuration() {
            @Override
            public long getMillis() {
                return durationMillis; // Must equal to durationMillis
            }

            @Override
            public Duration toDuration() {
                return new Duration(getMillis());
            }

            @Override
            public org.joda.time.Period toPeriod() {
                return null; // Not used in this test
            }

            @Override
            public boolean isLongerThan(ReadableDuration other) {
                return false; // Not used in this test
            }

            @Override
            public boolean isShorterThan(ReadableDuration other) {
                return false; // Not used in this test
            }

            @Override
            public boolean isEqual(ReadableDuration other) {
                return false; // Not used in this test
            }

            @Override
            public int hashCode() {
                return 0; // Not used in this test
            }

            @Override
            public boolean equals(Object obj) {
                return false; // Not used in this test
            }

            @Override
            public String toString() {
                return "ReadableDuration"; // Not used in this test
            }

            @Override
            public int compareTo(ReadableDuration other) {
                return Long.compare(this.getMillis(), other.getMillis()); // Implemented compareTo method
            }
        };

        // Act
        Interval result = interval.withDurationAfterStart(duration);

        // Assert
        long expectedEndMillis = chrono.add(startMillis, durationMillis, 1);
        Interval expectedInterval = new Interval(startMillis, expectedEndMillis, chrono);
        assertEquals(expectedInterval, result);
    }

}
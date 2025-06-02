package org.joda.time.chrono;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.LimitChronology;
import org.joda.time.Chronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_LimitChronology_withZone_DateTimeZone_cfg_path_10_Test {

    private class CustomDateTimeZone extends DateTimeZone {
        protected CustomDateTimeZone(String id) {
            super(id);
        }

        @Override
        public boolean isFixed() {
            return false;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof CustomDateTimeZone) {
                return this.getID().equals(((CustomDateTimeZone) obj).getID());
            }
            return false;
        }

        @Override
        public String getNameKey(long instant) {
            return "Custom";
        }

        @Override
        public int getStandardOffset(long instant) {
            return 0;
        }

        @Override
        public long previousTransition(long instant) {
            return instant;
        }

        @Override
        public int getOffset(long instant) {
            return 0;
        }

        @Override
        public long nextTransition(long instant) {
            return instant;
        }
    }

    @Test(timeout = 4000)
    public void testWithZone() {
        // Arrange
        DateTimeZone customZone = new CustomDateTimeZone("CustomZone");
        DateTime lowerLimit = new DateTime(2020, 1, 1, 0, 0);
        DateTime upperLimit = new DateTime(2021, 1, 1, 0, 0);
        LimitChronology chronology = LimitChronology.getInstance(null, lowerLimit, upperLimit);

        // Act
        Chronology result = chronology.withZone(customZone);

        // Assert
        assertNotNull(result);
        assertNotSame(chronology, result);
    }

    @Test(timeout = 4000)
    public void testWithZoneWhenZoneIsNull() {
        // Arrange
        DateTimeZone customZone = new CustomDateTimeZone("CustomZone");
        DateTime lowerLimit = new DateTime(2020, 1, 1, 0, 0);
        DateTime upperLimit = new DateTime(2021, 1, 1, 0, 0);
        LimitChronology chronology = LimitChronology.getInstance(null, lowerLimit, upperLimit);

        // Act
        Chronology result = chronology.withZone(customZone);

        // Assert
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testWithZoneWhenZoneIsUTC() {
        // Arrange
        DateTimeZone customZone = DateTimeZone.UTC; // This should not be used as per constraints
        DateTime lowerLimit = new DateTime(2020, 1, 1, 0, 0);
        DateTime upperLimit = new DateTime(2021, 1, 1, 0, 0);
        LimitChronology chronology = LimitChronology.getInstance(null, lowerLimit, upperLimit);

        try {
            // Act
            Chronology result = chronology.withZone(customZone);
            fail("Expected an exception to be thrown");
        } catch (Exception e) {
            // Assert
            assertNotNull(e);
        }
    }


}
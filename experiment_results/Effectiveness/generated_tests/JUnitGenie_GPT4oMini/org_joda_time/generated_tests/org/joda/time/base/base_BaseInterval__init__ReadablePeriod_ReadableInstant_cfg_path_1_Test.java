package org.joda.time.base;
import org.joda.time.ReadableInstant;
import org.joda.time.ReadablePeriod;
import org.joda.time.Period;
import org.joda.time.DateTime;
import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class base_BaseInterval__init__ReadablePeriod_ReadableInstant_cfg_path_1_Test {

    private class TestBaseInterval extends BaseInterval {
        protected TestBaseInterval(ReadablePeriod period, ReadableInstant end) {
            super(period, end);
        }
    }

    @Test(timeout = 4000)
    public void testBaseIntervalWithValidInputs() {
        // Arrange
        ReadablePeriod period = Period.days(5); // A valid period
        ReadableInstant end = new DateTime(); // A valid instant

        // Act
        TestBaseInterval interval = null;
        try {
            interval = new TestBaseInterval(period, end);
        } catch (Exception e) {
            fail("Constructor threw an exception: " + e.getMessage());
        }

        // Assert
        assertNotNull(interval);
    }

    @Test(timeout = 4000)
    public void testBaseIntervalWithNullPeriod() {
        // Arrange
        ReadablePeriod period = null; // Null period
        ReadableInstant end = new DateTime(); // A valid instant

        // Act
        TestBaseInterval interval = null;
        try {
            interval = new TestBaseInterval(period, end);
        } catch (Exception e) {
            fail("Constructor threw an exception: " + e.getMessage());
        }

        // Assert
        assertNotNull(interval);
    }

    @Test(timeout = 4000)
    public void testBaseIntervalWithInvalidInstant() {
        // Arrange
        ReadablePeriod period = Period.days(5); // A valid period
        ReadableInstant end = null; // Invalid instant

        // Act
        TestBaseInterval interval = null;
        try {
            interval = new TestBaseInterval(period, end);
            fail("Constructor should have thrown an exception due to null ReadableInstant");
        } catch (Exception e) {
            // Expected exception
        }
    }

}
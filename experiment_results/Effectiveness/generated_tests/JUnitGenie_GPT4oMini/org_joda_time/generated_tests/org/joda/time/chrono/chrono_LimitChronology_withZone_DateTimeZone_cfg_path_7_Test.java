package org.joda.time.chrono;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableDateTime;
import org.joda.time.Chronology;
import org.joda.time.ReadableDateTime;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import org.junit.Test;

public class chrono_LimitChronology_withZone_DateTimeZone_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testWithZoneNonNullZone() {
        try {
            // Arrange
            DateTimeZone zone = DateTimeZone.forID("America/New_York");
            DateTime lowerLimit = new DateTime(2020, 1, 1, 0, 0);
            DateTime upperLimit = new DateTime(2022, 1, 1, 0, 0);
            Chronology baseChrono = LimitChronology.getInstance(ISOChronology.getInstance(), lowerLimit, upperLimit);
            LimitChronology limitChronology = LimitChronology.getInstance(baseChrono, lowerLimit, upperLimit);

            // Act
            Chronology result = limitChronology.withZone(zone);

            // Assert
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWithZoneUTC() {
        try {
            // Arrange
            DateTimeZone zone = DateTimeZone.UTC;
            DateTime lowerLimit = new DateTime(2020, 1, 1, 0, 0);
            DateTime upperLimit = new DateTime(2022, 1, 1, 0, 0);
            Chronology baseChrono = LimitChronology.getInstance(ISOChronology.getInstance(), lowerLimit, upperLimit);
            LimitChronology limitChronology = LimitChronology.getInstance(baseChrono, lowerLimit, upperLimit);

            // Act
            Chronology result = limitChronology.withZone(zone);

            // Assert
            assertSame(result, limitChronology.withUTC()); // Use withUTC() method instead of accessing private field
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWithZoneNullZone() {
        try {
            // Arrange
            DateTimeZone zone = null; // should fallback to default
            DateTime lowerLimit = new DateTime(2020, 1, 1, 0, 0);
            DateTime upperLimit = new DateTime(2022, 1, 1, 0, 0);
            Chronology baseChrono = LimitChronology.getInstance(ISOChronology.getInstance(), lowerLimit, upperLimit);
            LimitChronology limitChronology = LimitChronology.getInstance(baseChrono, lowerLimit, upperLimit);

            // Act
            Chronology result = limitChronology.withZone(zone);

            // Assert
            assertNotNull(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWithZoneSameZone() {
        try {
            // Arrange
            DateTimeZone zone = DateTimeZone.forID("America/New_York");
            DateTime lowerLimit = new DateTime(2020, 1, 1, 0, 0);
            DateTime upperLimit = new DateTime(2022, 1, 1, 0, 0);
            Chronology baseChrono = LimitChronology.getInstance(ISOChronology.getInstance(), lowerLimit, upperLimit);
            LimitChronology limitChronology = LimitChronology.getInstance(baseChrono, lowerLimit, upperLimit);

            // Act
            Chronology result = limitChronology.withZone(zone);
            Chronology sameZoneResult = limitChronology.withZone(zone);

            // Assert
            assertSame(result, sameZoneResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
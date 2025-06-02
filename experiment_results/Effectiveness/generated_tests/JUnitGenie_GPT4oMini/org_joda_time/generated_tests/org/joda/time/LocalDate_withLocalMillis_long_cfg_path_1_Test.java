package org.joda.time;
import org.joda.time.LocalDate;
import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.junit.Test;
import static org.junit.Assert.*;

public class LocalDate_withLocalMillis_long_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWithLocalMillis() {
        // Arrange
        long newMillis = 1622505600000L; // Example millis (June 1, 2021)
        LocalDate localDate = new LocalDate(); // Using the default constructor

        // Act
        LocalDate result = null;
        try {
            result = localDate.withLocalMillis(newMillis);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Assert
        assertNotNull(result);
        assertEquals(newMillis, result.getLocalMillis());
    }

    @Test(timeout = 4000)
    public void testWithLocalMillisWhenSameMillis() {
        // Arrange
        long sameMillis = new LocalDate().getLocalMillis(); // Get current millis
        LocalDate localDate = new LocalDate(); // Using the default constructor

        // Act
        LocalDate result = null;
        try {
            result = localDate.withLocalMillis(sameMillis);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Assert
        assertNotNull(result);
        assertSame(localDate, result); // Should return the same instance
    }

}
package org.joda.time;
import org.joda.time.Partial;
import org.joda.time.DateTimeFieldType;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class Partial_getFormatter__cfg_path_14_Test {

    @Test(timeout = 4000)
    public void testGetFormatter() {
        // Arrange
        DateTimeFieldType[] types = {DateTimeFieldType.year(), DateTimeFieldType.monthOfYear()};
        int[] values = {2023, 1}; // Create an array of values for the Partial constructor
        Partial partial = new Partial(types, values); // Use the correct constructor

        // Act
        DateTimeFormatter formatter = null;
        try {
            formatter = partial.getFormatter();
        } catch (Exception e) {
            // Handle the exception as per rule 4
            fail("Exception thrown during getFormatter: " + e.getMessage());
        }

        // Assert
        assertNotNull("Formatter should not be null", formatter);
        assertEquals("Formatter should be of expected type", ISODateTimeFormat.forFields(Arrays.asList(types), true, false), formatter);
    }

}
package org.joda.time;
import org.joda.time.Partial;
import org.joda.time.DateTimeFieldType;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class Partial_getFormatter__cfg_path_13_Test {

    @Test(timeout = 4000)
    public void testGetFormatter() {
        // Arrange
        DateTimeFieldType[] types = new DateTimeFieldType[] { DateTimeFieldType.year(), DateTimeFieldType.monthOfYear() };
        Partial partial = new Partial(types, null); // Added null for chronology
        
        // Act
        DateTimeFormatter formatter = partial.getFormatter();
        
        // Assert
        assertNotNull(formatter);
        assertEquals(formatter, ISODateTimeFormat.forFields(Arrays.asList(types), true, false));
    }

    @Test(timeout = 4000)
    public void testGetFormatterWhenIFormatterIsNull() {
        // Arrange
        DateTimeFieldType[] types = new DateTimeFieldType[] { DateTimeFieldType.dayOfMonth() };
        Partial partial = new Partial(types, null); // Added null for chronology
        
        // Act
        DateTimeFormatter formatter = partial.getFormatter();
        
        // Assert
        assertNotNull(formatter);
        assertEquals(formatter, ISODateTimeFormat.forFields(Arrays.asList(types), true, false));
    }

    @Test(timeout = 4000)
    public void testGetFormatterWhenSizeIsZero() {
        // Arrange
        Partial partial = new Partial(new DateTimeFieldType[0], null); // Added null for chronology
        
        // Act
        DateTimeFormatter formatter = partial.getFormatter();
        
        // Assert
        assertNull(formatter);
    }

    @Test(timeout = 4000)
    public void testGetFormatterHandlesIllegalArgumentException() {
        // Arrange
        DateTimeFieldType[] types = new DateTimeFieldType[] { DateTimeFieldType.dayOfMonth(), null }; // This should cause IllegalArgumentException
        Partial partial = new Partial(types, null); // Added null for chronology
        
        // Act
        DateTimeFormatter formatter = null;
        try {
            formatter = partial.getFormatter();
        } catch (IllegalArgumentException ex) {
            // ignore
        }
        
        // Assert
        assertNull(formatter); // Ensure that formatter is null if exception occurs
    }

}
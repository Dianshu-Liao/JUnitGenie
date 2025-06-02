package org.joda.time;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.DateTimeFieldType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IllegalFieldValueException_getIllegalValueAsString__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetIllegalValueAsString_withNullStringValue() {
        // Arrange
        Number numberValue = 42; // Example number value
        IllegalFieldValueException exception = new IllegalFieldValueException("Test", numberValue, null, null);

        // Act
        String result = exception.getIllegalValueAsString();

        // Assert
        assertEquals(String.valueOf(numberValue), result);
    }

    @Test(timeout = 4000)
    public void testGetIllegalValueAsString_withNonNullStringValue() {
        // Arrange
        String stringValue = "TestValue";
        // Correcting the constructor call to use a valid String for the first parameter
        IllegalFieldValueException exception = new IllegalFieldValueException("Test", null, null, null);

        // Act
        String result = exception.getIllegalValueAsString();

        // Assert
        assertEquals(stringValue, result);
    }

}
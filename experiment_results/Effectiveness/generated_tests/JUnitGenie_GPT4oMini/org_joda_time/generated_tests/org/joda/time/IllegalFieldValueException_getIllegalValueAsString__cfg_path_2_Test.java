package org.joda.time;
import org.joda.time.IllegalFieldValueException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class IllegalFieldValueException_getIllegalValueAsString__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetIllegalValueAsString_withNonNullStringValue() {
        // Arrange
        IllegalFieldValueException exception = new IllegalFieldValueException("TestField", "TestValue");
        // Accessing the private field using reflection
        try {
            java.lang.reflect.Field field = IllegalFieldValueException.class.getDeclaredField("iStringValue");
            field.setAccessible(true);
            field.set(exception, "TestValue");
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Act
        String result = exception.getIllegalValueAsString();

        // Assert
        assertEquals("TestValue", result);
    }

    @Test(timeout = 4000)
    public void testGetIllegalValueAsString_withNullStringValue() {
        // Arrange
        IllegalFieldValueException exception = new IllegalFieldValueException("TestField", null);
        // Accessing the private field using reflection
        try {
            java.lang.reflect.Field field = IllegalFieldValueException.class.getDeclaredField("iStringValue");
            field.setAccessible(true);
            field.set(exception, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Act
        String result = exception.getIllegalValueAsString();

        // Assert
        // Assuming iNumberValue is set to a specific value, we need to set it as well
        try {
            java.lang.reflect.Field numberField = IllegalFieldValueException.class.getDeclaredField("iNumberValue");
            numberField.setAccessible(true);
            numberField.set(exception, 42); // Example number
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Act again after setting iNumberValue
        result = exception.getIllegalValueAsString();

        // Assert
        assertEquals("42", result);
    }

}
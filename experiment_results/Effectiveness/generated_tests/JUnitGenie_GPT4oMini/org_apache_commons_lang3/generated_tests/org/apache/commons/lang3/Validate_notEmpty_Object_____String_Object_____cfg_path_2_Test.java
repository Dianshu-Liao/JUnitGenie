package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

public class Validate_notEmpty_Object_____String_Object_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testNotEmpty_validInput() {
        // Arrange
        Object[] inputArray = new Object[]{"value1", "value2"};
        String message = "Array must not be empty";
        Object[] values = new Object[]{};

        // Act
        Object[] result = Validate.notEmpty(inputArray, message, values);

        // Assert
        assertArrayEquals(inputArray, result);
    }

    @Test(timeout = 4000)
    public void testNotEmpty_nullArray() {
        // Arrange
        Object[] inputArray = null;
        String message = "Array must not be null";
        Object[] values = new Object[]{};

        try {
            // Act
            Validate.notEmpty(inputArray, message, values);
        } catch (NullPointerException e) {
            // Assert
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testNotEmpty_emptyArray() {
        // Arrange
        Object[] inputArray = new Object[]{};
        String message = "Array must not be empty";
        Object[] values = new Object[]{};

        try {
            // Act
            Validate.notEmpty(inputArray, message, values);
        } catch (IllegalArgumentException e) {
            // Assert
            // Expected exception
        }
    }

}
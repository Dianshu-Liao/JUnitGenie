package org.apache.commons.compress.archivers.sevenz;
import org.apache.commons.compress.archivers.sevenz.SevenZMethod;
import org.apache.commons.compress.archivers.sevenz.SevenZMethodConfiguration;
import org.junit.Test;

public class archivers_sevenz_SevenZMethodConfiguration__init__SevenZMethod_Object_cfg_path_1_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithInvalidOptions() {
        // Arrange
        SevenZMethod method = SevenZMethod.values()[0]; // Use a valid enum constant
        Object invalidOptions = new Object(); // This should not match any class in optionClasses

        // Act
        try {
            new SevenZMethodConfiguration(method, invalidOptions);
        } catch (IllegalArgumentException e) {
            // Assert
            String expectedMessage = "The " + method + " method doesn't support options of type " + invalidOptions.getClass();
            assert e.getMessage().equals(expectedMessage);
            throw e; // Rethrow to satisfy the expected exception
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithNullOptions() {
        // Arrange
        SevenZMethod method = SevenZMethod.values()[0]; // Use a valid enum constant

        // Act
        SevenZMethodConfiguration config = new SevenZMethodConfiguration(method, null);

        // Assert
        // No exception should be thrown, and we can check the internal state if needed
    }


}
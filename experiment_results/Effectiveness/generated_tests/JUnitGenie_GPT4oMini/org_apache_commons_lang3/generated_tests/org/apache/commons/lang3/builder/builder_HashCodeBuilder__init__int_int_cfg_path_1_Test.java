package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.Validate;
import org.junit.Test;

public class builder_HashCodeBuilder__init__int_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testConstructorWithValidOddNumbers() {
        // Arrange
        int initialOddNumber = 1; // valid odd number
        int multiplierOddNumber = 3; // valid odd number

        // Act
        HashCodeBuilder builder = new HashCodeBuilder(initialOddNumber, multiplierOddNumber);

        // Assert
        // Since there are no return values, we can only verify that no exceptions are thrown
    }

    @Test(timeout = 4000)
    public void testConstructorWithInvalidInitialOddNumber() {
        // Arrange
        int initialOddNumber = 2; // invalid even number
        int multiplierOddNumber = 3; // valid odd number

        // Act
        try {
            HashCodeBuilder builder = new HashCodeBuilder(initialOddNumber, multiplierOddNumber);
        } catch (IllegalArgumentException e) {
            // Assert
            assert e.getMessage().equals("HashCodeBuilder requires an odd initial value");
        }
    }

    @Test(timeout = 4000)
    public void testConstructorWithInvalidMultiplierOddNumber() {
        // Arrange
        int initialOddNumber = 1; // valid odd number
        int multiplierOddNumber = 2; // invalid even number

        // Act
        try {
            HashCodeBuilder builder = new HashCodeBuilder(initialOddNumber, multiplierOddNumber);
        } catch (IllegalArgumentException e) {
            // Assert
            assert e.getMessage().equals("HashCodeBuilder requires an odd multiplier");
        }
    }

}
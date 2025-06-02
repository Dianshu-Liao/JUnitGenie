package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.Validate;
import org.junit.Test;

public class builder_HashCodeBuilder__init__int_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testHashCodeBuilderWithValidOddNumbers() {
        // Arrange
        int initialOddNumber = 3; // odd
        int multiplierOddNumber = 5; // odd

        // Act
        HashCodeBuilder builder = new HashCodeBuilder(initialOddNumber, multiplierOddNumber);

        // Assert
        // No exception should be thrown, so we can just check if the object is created
        // (additional assertions can be added based on the expected behavior of the builder)
    }

    @Test(timeout = 4000)
    public void testHashCodeBuilderWithInvalidInitialOddNumber() {
        // Arrange
        int initialOddNumber = 2; // even
        int multiplierOddNumber = 5; // odd

        // Act
        try {
            HashCodeBuilder builder = new HashCodeBuilder(initialOddNumber, multiplierOddNumber);
        } catch (IllegalArgumentException e) {
            // Assert
            assert e.getMessage().equals("HashCodeBuilder requires an odd initial value");
            return; // Test passes if exception is caught
        }
        // If we reach here, the test has failed
        assert false : "Expected IllegalArgumentException was not thrown";
    }

    @Test(timeout = 4000)
    public void testHashCodeBuilderWithInvalidMultiplierOddNumber() {
        // Arrange
        int initialOddNumber = 3; // odd
        int multiplierOddNumber = 2; // even

        // Act
        try {
            HashCodeBuilder builder = new HashCodeBuilder(initialOddNumber, multiplierOddNumber);
        } catch (IllegalArgumentException e) {
            // Assert
            assert e.getMessage().equals("HashCodeBuilder requires an odd multiplier");
            return; // Test passes if exception is caught
        }
        // If we reach here, the test has failed
        assert false : "Expected IllegalArgumentException was not thrown";
    }

}
package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import org.junit.Test;
import static org.junit.Assert.*;

public class StreamReadConstraints_validateIntegerLength_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testValidateIntegerLength_ThrowsException_WhenLengthExceedsMax() {
        // Arrange
        int maxNumLen = 5; // Example maximum length
        StreamReadConstraints constraints = createStreamReadConstraints(maxNumLen);
        int testLength = maxNumLen + 1; // Length that exceeds the maximum

        // Act & Assert
        try {
            constraints.validateIntegerLength(testLength);
            fail("Expected StreamConstraintsException to be thrown");
        } catch (StreamConstraintsException e) {
            // Exception is expected, test passes
        }
    }

    @Test(timeout = 4000)
    public void testValidateIntegerLength_DoesNotThrow_WhenLengthIsValid() {
        // Arrange
        int maxNumLen = 5; // Example maximum length
        StreamReadConstraints constraints = createStreamReadConstraints(maxNumLen);
        int testLength = maxNumLen; // Length that is equal to the maximum

        // Act
        try {
            constraints.validateIntegerLength(testLength);
            // If no exception is thrown, the test passes
        } catch (StreamConstraintsException e) {
            fail("Did not expect StreamConstraintsException to be thrown");
        }
    }

    private StreamReadConstraints createStreamReadConstraints(int maxNumLen) {
        try {
            // Using reflection to access the protected constructor
            return (StreamReadConstraints) StreamReadConstraints.class
                .getDeclaredConstructors()[0]
                .newInstance(maxNumLen, 0L, 0, 0, 0);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create StreamReadConstraints instance", e);
        }
    }

}
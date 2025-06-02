package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import org.junit.Test;
import static org.junit.Assert.fail;

public class StreamReadConstraints_validateFPLength_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testValidateFPLength_ExceedsMaxLength() {
        // Arrange
        int length = 10; // Example length that exceeds _maxNumLen
        StreamReadConstraints constraints = createStreamReadConstraintsInstance(5, 0L, 0, 0); // _maxNumLen is set to 5

        // Act
        try {
            constraints.validateFPLength(length);
            fail("Expected StreamConstraintsException to be thrown");
        } catch (StreamConstraintsException e) {
            // Assert
            // Exception is expected, test passes
        }
    }

    private StreamReadConstraints createStreamReadConstraintsInstance(int a, long b, int c, int d) {
        try {
            return (StreamReadConstraints) StreamReadConstraints.class.getDeclaredConstructors()[0].newInstance(a, b, c, d);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create StreamReadConstraints instance", e);
        }
    }


}
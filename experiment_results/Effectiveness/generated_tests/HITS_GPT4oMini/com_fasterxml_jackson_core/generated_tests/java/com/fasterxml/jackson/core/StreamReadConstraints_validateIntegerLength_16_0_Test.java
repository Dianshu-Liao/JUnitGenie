package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class StreamReadConstraints_validateIntegerLength_16_0_Test {

    private StreamReadConstraints constraints;

    @BeforeEach
    public void setUp() {
        constraints = new StreamReadConstraints(StreamReadConstraints.DEFAULT_MAX_DEPTH, StreamReadConstraints.DEFAULT_MAX_DOC_LEN, StreamReadConstraints.DEFAULT_MAX_NUM_LEN, StreamReadConstraints.DEFAULT_MAX_STRING_LEN, StreamReadConstraints.DEFAULT_MAX_NAME_LEN);
    }

    @Test
    public void validateIntegerLength_ShouldNotThrowException_WhenLengthIsLessThanOrEqualToMaxNumLen() {
        // Arrange
        int validLength = StreamReadConstraints.DEFAULT_MAX_NUM_LEN;
        // Act & Assert
        assertDoesNotThrow(() -> constraints.validateIntegerLength(validLength));
    }

    @Test
    public void validateIntegerLength_ShouldNotThrowException_WhenLengthIsZero() {
        // Arrange
        int zeroLength = 0;
        // Act & Assert
        assertDoesNotThrow(() -> constraints.validateIntegerLength(zeroLength));
    }

    @Test
    public void validateIntegerLength_ShouldThrowException_WhenLengthExceedsMaxNumLen() {
        // Arrange
        int exceedingLength = StreamReadConstraints.DEFAULT_MAX_NUM_LEN + 1;
        // Act & Assert
        StreamConstraintsException exception = assertThrows(StreamConstraintsException.class, () -> constraints.validateIntegerLength(exceedingLength));
        assertEquals("Number value length (1001) exceeds the maximum allowed (1000, from `StreamReadConstraints.getMaxNumberLength()`)", exception.getMessage());
    }

    @Test
    public void validateIntegerLength_ShouldThrowException_WhenLengthIsNegative() {
        // Arrange
        int negativeLength = -1;
        // Act & Assert
        StreamConstraintsException exception = assertThrows(StreamConstraintsException.class, () -> constraints.validateIntegerLength(negativeLength));
        assertEquals("Number value length (-1) exceeds the maximum allowed (1000, from `StreamReadConstraints.getMaxNumberLength()`)", exception.getMessage());
    }
}

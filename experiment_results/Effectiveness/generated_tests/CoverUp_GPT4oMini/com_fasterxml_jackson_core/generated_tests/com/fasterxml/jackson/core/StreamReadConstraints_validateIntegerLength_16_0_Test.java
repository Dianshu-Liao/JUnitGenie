package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import java.lang.reflect.Method;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
class StreamReadConstraints_validateIntegerLength_16_0_Test {

    private StreamReadConstraints constraints;

    @BeforeEach
    void setUp() {
        constraints = new StreamReadConstraints(StreamReadConstraints.DEFAULT_MAX_DEPTH, StreamReadConstraints.DEFAULT_MAX_DOC_LEN, StreamReadConstraints.DEFAULT_MAX_NUM_LEN, StreamReadConstraints.DEFAULT_MAX_STRING_LEN, StreamReadConstraints.DEFAULT_MAX_NAME_LEN);
    }

    @Test
    void testValidateIntegerLength_ExceedsMaxNumLen() {
        int length = StreamReadConstraints.DEFAULT_MAX_NUM_LEN + 1;
        StreamConstraintsException exception = assertThrows(StreamConstraintsException.class, () -> {
            invokeValidateIntegerLength(length);
        });
        // Optionally check the exception message
        assertTrue(exception.getMessage().contains("exceeds the maximum allowed"));
    }

    @Test
    void testValidateIntegerLength_EqualsMaxNumLen() {
        int length = StreamReadConstraints.DEFAULT_MAX_NUM_LEN;
        // Should not throw
        assertDoesNotThrow(() -> invokeValidateIntegerLength(length));
    }

    @Test
    void testValidateIntegerLength_LessThanMaxNumLen() {
        int length = StreamReadConstraints.DEFAULT_MAX_NUM_LEN - 1;
        // Should not throw
        assertDoesNotThrow(() -> invokeValidateIntegerLength(length));
    }

    private void invokeValidateIntegerLength(int length) {
        try {
            Method method = StreamReadConstraints.class.getDeclaredMethod("validateIntegerLength", int.class);
            method.setAccessible(true);
            method.invoke(constraints, length);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

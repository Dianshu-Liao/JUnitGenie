package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class StreamReadConstraints_validateFPLength_15_0_Test {

    private StreamReadConstraints constraints;

    @BeforeEach
    void setUp() {
        // Initialize with default values
        constraints = new StreamReadConstraints(StreamReadConstraints.DEFAULT_MAX_DEPTH, StreamReadConstraints.DEFAULT_MAX_DOC_LEN, StreamReadConstraints.DEFAULT_MAX_NUM_LEN, StreamReadConstraints.DEFAULT_MAX_STRING_LEN, StreamReadConstraints.DEFAULT_MAX_NAME_LEN);
    }

    @Test
    void testValidateFPLength_ValidLength() {
        // Test with a length that is less than or equal to _maxNumLen
        assertDoesNotThrow(() -> constraints.validateFPLength(500));
    }

    @Test
    void testValidateFPLength_ExceedingLength() {
        // Test with a length that exceeds _maxNumLen
        assertThrows(StreamConstraintsException.class, () -> {
            constraints.validateFPLength(1500);
        });
    }

    @Test
    void testValidateFPLength_EqualToMaxNumLen() {
        // Test with a length that is exactly equal to _maxNumLen
        assertDoesNotThrow(() -> constraints.validateFPLength(StreamReadConstraints.DEFAULT_MAX_NUM_LEN));
    }

    @Test
    void testValidateFPLength_NegativeLength() {
        // Test with a negative length
        assertDoesNotThrow(() -> constraints.validateFPLength(-1));
    }

    @Test
    void testValidateFPLength_ZeroLength() {
        // Test with a zero length
        assertDoesNotThrow(() -> constraints.validateFPLength(0));
    }

    @Test
    void testPrivateMethodReflection() throws Exception {
        // Accessing private method _constructException using reflection
        Method method = StreamReadConstraints.class.getDeclaredMethod("_constructException", String.class, Object[].class);
        method.setAccessible(true);
        String message = (String) method.invoke(constraints, "Test message: %s", new Object[] { "Error" });
        assertEquals("Test message: Error", message);
    }

    @Test
    void testPrivateMethodReflection_ConstrainRef() throws Exception {
        // Accessing private method _constrainRef using reflection
        Method method = StreamReadConstraints.class.getDeclaredMethod("_constrainRef", String.class);
        method.setAccessible(true);
        String result = (String) method.invoke(constraints, "getMaxNumberLength");
        assertEquals("`StreamReadConstraints.getMaxNumberLength()`", result);
    }
}

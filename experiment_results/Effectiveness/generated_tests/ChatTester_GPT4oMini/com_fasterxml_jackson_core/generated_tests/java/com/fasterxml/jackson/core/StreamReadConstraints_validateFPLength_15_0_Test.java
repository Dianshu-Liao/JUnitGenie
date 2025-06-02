package com.fasterxml.jackson.core;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class StreamReadConstraints_validateFPLength_15_0_Test {

    private StreamReadConstraints streamReadConstraints;

    @BeforeEach
    void setUp() {
        // Using reflection to access the constructor as it's protected
        streamReadConstraints = (StreamReadConstraints) java.lang.reflect.Proxy.newProxyInstance(StreamReadConstraints.class.getClassLoader(), new Class[] { StreamReadConstraints.class }, (proxy, method, args) -> {
            if ("<init>".equals(method.getName())) {
                return null;
            }
            return method.invoke(streamReadConstraints, args);
        });
    }

    @Test
    void testValidateFPLength_ValidLength() {
        // Set up the necessary fields using reflection
        setField(streamReadConstraints, "_maxNumLen", 10);
        // This should not throw an exception
        assertDoesNotThrow(() -> streamReadConstraints.validateFPLength(5));
    }

    @Test
    void testValidateFPLength_ExceedsMaxLength() {
        // Set up the necessary fields using reflection
        setField(streamReadConstraints, "_maxNumLen", 10);
        // This should throw a StreamConstraintsException
        StreamConstraintsException exception = assertThrows(StreamConstraintsException.class, () -> {
            streamReadConstraints.validateFPLength(15);
        });
        assertEquals("Number value length (15) exceeds the maximum allowed (10, from getMaxNumberLength)", exception.getMessage());
    }

    @Test
    void testValidateFPLength_EqualToMaxLength() {
        // Set up the necessary fields using reflection
        setField(streamReadConstraints, "_maxNumLen", 10);
        // This should not throw an exception
        assertDoesNotThrow(() -> streamReadConstraints.validateFPLength(10));
    }

    // Helper method to set private fields using reflection
    private void setField(Object target, String fieldName, Object value) {
        try {
            // Fixed line
            java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

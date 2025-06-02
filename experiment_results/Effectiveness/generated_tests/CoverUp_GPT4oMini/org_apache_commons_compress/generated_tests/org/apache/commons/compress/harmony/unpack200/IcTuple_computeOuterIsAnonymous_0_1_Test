package org.apache.commons.compress.harmony.unpack200;

import java.lang.reflect.Method;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class IcTuple_computeOuterIsAnonymous_0_1_Test {

    private IcTuple icTuple;

    @BeforeEach
    void setUp() {
        // Initialize with default values
        icTuple = new IcTuple("TestClass", 1, "OuterClass", "TestN", 0, 0, 0, 0);
    }

    @Test
    void testComputeOuterIsAnonymous_ThrowsErrorWhenOuterClassStringIsEmpty() {
        // Set cachedOuterClassString to empty
        setPrivateField(icTuple, "cachedOuterClassString", "");
        Error exception = assertThrows(Error.class, () -> {
            invokePrivateMethod(icTuple, "computeOuterIsAnonymous");
        });
        assertEquals("Should have an outer before checking if it's anonymous", exception.getMessage());
    }

    @Test
    void testComputeOuterIsAnonymous_ReturnsTrueWhenAllElementsAreDigits() {
        // Set cachedOuterClassString to a string with digits
        setPrivateField(icTuple, "cachedOuterClassString", "123");
        boolean result = invokePrivateMethod(icTuple, "computeOuterIsAnonymous");
        assertTrue(result);
    }

    @Test
    void testComputeOuterIsAnonymous_ReturnsFalseWhenNoElementsAreDigits() {
        // Set cachedOuterClassString to a string without digits
        setPrivateField(icTuple, "cachedOuterClassString", "OuterClass");
        boolean result = invokePrivateMethod(icTuple, "computeOuterIsAnonymous");
        assertFalse(result);
    }

    @Test
    void testComputeOuterIsAnonymous_ReturnsTrueWhenMixedElements() {
        // Set cachedOuterClassString to a string with mixed elements
        setPrivateField(icTuple, "cachedOuterClassString", "Outer123Class");
        boolean result = invokePrivateMethod(icTuple, "computeOuterIsAnonymous");
        assertTrue(result);
    }

    private void setPrivateField(IcTuple instance, String fieldName, Object value) {
        try {
            Field field = IcTuple.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(instance, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private boolean invokePrivateMethod(IcTuple instance, String methodName) {
        try {
            Method method = IcTuple.class.getDeclaredMethod(methodName);
            method.setAccessible(true);
            return (boolean) method.invoke(instance);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

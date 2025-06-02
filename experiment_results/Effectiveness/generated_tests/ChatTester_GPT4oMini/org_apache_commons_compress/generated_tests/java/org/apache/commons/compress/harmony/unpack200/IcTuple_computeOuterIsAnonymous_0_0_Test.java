package org.apache.commons.compress.harmony.unpack200;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class IcTuple_computeOuterIsAnonymous_0_0_Test {

    private IcTuple icTuple;

    @BeforeEach
    void setUp() {
        // Initialize IcTuple with dummy values
        icTuple = new IcTuple("C", 1, "C2", "N", 0, 0, 0, 0);
    }

    @Test
    void testComputeOuterIsAnonymous_WithValidOuterClass() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Set up the private field
        setPrivateField(icTuple, "cachedOuterClassString", "OuterClass$1");
        // Access the private method using reflection
        Method method = IcTuple.class.getDeclaredMethod("computeOuterIsAnonymous");
        method.setAccessible(true);
        // Invoke the method and assert the result
        boolean result = (boolean) method.invoke(icTuple);
        assertTrue(result);
    }

    @Test
    void testComputeOuterIsAnonymous_WithNonAnonymousOuterClass() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // Set up the private field
        setPrivateField(icTuple, "cachedOuterClassString", "OuterClass");
        // Access the private method using reflection
        Method method = IcTuple.class.getDeclaredMethod("computeOuterIsAnonymous");
        method.setAccessible(true);
        // Invoke the method and assert the result
        boolean result = (boolean) method.invoke(icTuple);
        assertFalse(result);
    }

    @Test
    void testComputeOuterIsAnonymous_WithEmptyOuterClass() throws NoSuchMethodException, InvocationTargetException {
        // Set up the private field
        setPrivateField(icTuple, "cachedOuterClassString", "");
        // Access the private method using reflection
        Method method = IcTuple.class.getDeclaredMethod("computeOuterIsAnonymous");
        method.setAccessible(true);
        // Invoke the method and assert the result
        Exception exception = assertThrows(IllegalStateException.class, () -> method.invoke(icTuple));
        assertEquals("Should have an outer before checking if it's anonymous", exception.getMessage());
    }

    private void setPrivateField(IcTuple icTuple, String fieldName, String value) {
        try {
            Field field = IcTuple.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(icTuple, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set private field: " + e.getMessage());
        }
    }
}

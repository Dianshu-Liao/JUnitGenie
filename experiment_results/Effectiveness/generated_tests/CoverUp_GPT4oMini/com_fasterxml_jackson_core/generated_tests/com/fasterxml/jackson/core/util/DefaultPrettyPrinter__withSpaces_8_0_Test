package com.fasterxml.jackson.core.util;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.SerializedString;

public class DefaultPrettyPrinter__withSpaces_8_0_Test {

    private DefaultPrettyPrinter printer;

    @BeforeEach
    public void setUp() {
        printer = new DefaultPrettyPrinter();
    }

    @Test
    public void testWithSpacesTrue() throws Exception {
        // Ensure the initial state is true
        assertTrue(printer._spacesInObjectEntries);
        // Invoke the private method _withSpaces with true
        Method method = DefaultPrettyPrinter.class.getDeclaredMethod("_withSpaces", boolean.class);
        method.setAccessible(true);
        DefaultPrettyPrinter result = (DefaultPrettyPrinter) method.invoke(printer, true);
        // Verify that the returned object is not the same instance
        assertNotSame(printer, result);
        // Verify that the _spacesInObjectEntries property is set to true
        assertTrue(result._spacesInObjectEntries);
    }

    @Test
    public void testWithSpacesFalse() throws Exception {
        // Change the state to false
        Method method = DefaultPrettyPrinter.class.getDeclaredMethod("_withSpaces", boolean.class);
        method.setAccessible(true);
        DefaultPrettyPrinter result = (DefaultPrettyPrinter) method.invoke(printer, false);
        // Verify that the returned object is not the same instance
        assertNotSame(printer, result);
        // Verify that the _spacesInObjectEntries property is set to false
        assertFalse(result._spacesInObjectEntries);
    }

    @Test
    public void testWithSpacesNoChange() throws Exception {
        // Ensure the initial state is true
        assertTrue(printer._spacesInObjectEntries);
        // Invoke the private method _withSpaces with true (no change)
        Method method = DefaultPrettyPrinter.class.getDeclaredMethod("_withSpaces", boolean.class);
        method.setAccessible(true);
        DefaultPrettyPrinter result = (DefaultPrettyPrinter) method.invoke(printer, true);
        // Verify that the returned object is the same instance
        assertSame(printer, result);
    }

    @Test
    public void testWithSpacesChangeFromTrueToFalse() throws Exception {
        // Ensure the initial state is true
        assertTrue(printer._spacesInObjectEntries);
        // Invoke the private method _withSpaces with false
        Method method = DefaultPrettyPrinter.class.getDeclaredMethod("_withSpaces", boolean.class);
        method.setAccessible(true);
        DefaultPrettyPrinter result = (DefaultPrettyPrinter) method.invoke(printer, false);
        // Verify that the returned object is not the same instance
        assertNotSame(printer, result);
        // Verify that the _spacesInObjectEntries property is set to false
        assertFalse(result._spacesInObjectEntries);
    }
}

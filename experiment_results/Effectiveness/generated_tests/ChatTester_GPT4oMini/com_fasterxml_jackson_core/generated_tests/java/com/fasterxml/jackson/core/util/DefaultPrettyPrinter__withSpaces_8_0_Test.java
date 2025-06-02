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
    public void test_WithSpaces_True() throws Exception {
        // Arrange
        Method method = DefaultPrettyPrinter.class.getDeclaredMethod("_withSpaces", boolean.class);
        method.setAccessible(true);
        // Act
        DefaultPrettyPrinter result = (DefaultPrettyPrinter) method.invoke(printer, true);
        // Assert
        assertNotNull(result);
        assertNotSame(printer, result);
        assertTrue(result._spacesInObjectEntries);
    }

    @Test
    public void test_WithSpaces_False() throws Exception {
        // Arrange
        Method method = DefaultPrettyPrinter.class.getDeclaredMethod("_withSpaces", boolean.class);
        method.setAccessible(true);
        // Set initial state
        printer._spacesInObjectEntries = true;
        // Act
        DefaultPrettyPrinter result = (DefaultPrettyPrinter) method.invoke(printer, false);
        // Assert
        assertNotNull(result);
        assertNotSame(printer, result);
        assertFalse(result._spacesInObjectEntries);
    }

    @Test
    public void test_WithSpaces_NoChange() throws Exception {
        // Arrange
        Method method = DefaultPrettyPrinter.class.getDeclaredMethod("_withSpaces", boolean.class);
        method.setAccessible(true);
        // Set initial state
        printer._spacesInObjectEntries = false;
        // Act
        DefaultPrettyPrinter result = (DefaultPrettyPrinter) method.invoke(printer, false);
        // Assert
        assertSame(printer, result);
    }

    @Test
    public void test_WithSpaces_NoChange_True() throws Exception {
        // Arrange
        Method method = DefaultPrettyPrinter.class.getDeclaredMethod("_withSpaces", boolean.class);
        method.setAccessible(true);
        // Set initial state
        printer._spacesInObjectEntries = true;
        // Act
        DefaultPrettyPrinter result = (DefaultPrettyPrinter) method.invoke(printer, true);
        // Assert
        assertSame(printer, result);
    }
}

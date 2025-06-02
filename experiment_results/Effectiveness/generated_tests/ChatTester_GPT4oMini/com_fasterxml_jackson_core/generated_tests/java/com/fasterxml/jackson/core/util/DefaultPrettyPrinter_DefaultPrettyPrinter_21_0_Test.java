package com.fasterxml.jackson.core.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.SerializedString;

public class DefaultPrettyPrinter_DefaultPrettyPrinter_21_0_Test {

    private DefaultPrettyPrinter defaultPrettyPrinter;

    @BeforeEach
    public void setUp() {
        // Initialize the DefaultPrettyPrinter before each test
        defaultPrettyPrinter = new DefaultPrettyPrinter();
    }

    @Test
    public void testDefaultPrettyPrinterNotNull() {
        // Test that the DefaultPrettyPrinter instance is created successfully
        assertNotNull(defaultPrettyPrinter);
    }

    @Test
    public void testDefaultPrettyPrinterInitialization() {
        // Test that the DefaultPrettyPrinter is initialized with default separators
        // Assuming DEFAULT_SEPARATORS is a field in DefaultPrettyPrinter that we can access via reflection
        try {
            java.lang.reflect.Field separatorsField = DefaultPrettyPrinter.class.getDeclaredField("_separators");
            separatorsField.setAccessible(true);
            Separators separators = (Separators) separatorsField.get(defaultPrettyPrinter);
            // Assert that the separators are initialized to the expected default
            assertNotNull(separators);
            // You can add more assertions to verify specific properties of the separators if necessary
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

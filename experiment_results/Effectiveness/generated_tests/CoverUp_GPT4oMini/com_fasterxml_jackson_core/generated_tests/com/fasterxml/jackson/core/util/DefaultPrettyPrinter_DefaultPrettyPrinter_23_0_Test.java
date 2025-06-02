package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.Separators;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;

class DefaultPrettyPrinter_DefaultPrettyPrinter_23_0_Test {

    private DefaultPrettyPrinter defaultPrettyPrinter;

    @BeforeEach
    void setUp() {
        // Initialize with a default root separator
        SerializedString rootSeparator = new SerializedString(" | ");
        defaultPrettyPrinter = new DefaultPrettyPrinter(rootSeparator);
    }

    @Test
    void testDefaultPrettyPrinterWithSerializableString() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Use reflection to access the private constructor
        Constructor<DefaultPrettyPrinter> constructor = DefaultPrettyPrinter.class.getDeclaredConstructor(SerializedString.class);
        constructor.setAccessible(true);
        // Create a new instance using the private constructor
        DefaultPrettyPrinter instance = constructor.newInstance(new SerializedString(" : "));
        // Validate that the instance is created successfully
        assertNotNull(instance);
    }

    @Test
    void testDefaultPrettyPrinterWithSeparators() {
        Separators separators = new Separators();
        DefaultPrettyPrinter printerWithSeparators = new DefaultPrettyPrinter(separators);
        // Validate that the instance is created successfully
        assertNotNull(printerWithSeparators);
    }

    @Test
    void testDefaultPrettyPrinterWithString() {
        DefaultPrettyPrinter printerWithString = new DefaultPrettyPrinter(" | ");
        // Validate that the instance is created successfully
        assertNotNull(printerWithString);
    }

    @Test
    void testDefaultPrettyPrinterWithBase() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Use reflection to access the private constructor
        Constructor<DefaultPrettyPrinter> constructor = DefaultPrettyPrinter.class.getDeclaredConstructor(DefaultPrettyPrinter.class, SerializedString.class);
        constructor.setAccessible(true);
        // Create a base instance
        DefaultPrettyPrinter base = new DefaultPrettyPrinter(new SerializedString(" , "));
        // Create a new instance using the private constructor
        DefaultPrettyPrinter instance = constructor.newInstance(base, new SerializedString(" : "));
        // Validate that the instance is created successfully
        assertNotNull(instance);
    }
}

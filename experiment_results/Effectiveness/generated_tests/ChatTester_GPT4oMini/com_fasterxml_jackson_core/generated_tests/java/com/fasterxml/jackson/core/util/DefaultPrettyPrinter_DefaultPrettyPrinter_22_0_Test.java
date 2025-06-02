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

public class DefaultPrettyPrinter_DefaultPrettyPrinter_22_0_Test {

    private DefaultPrettyPrinter defaultPrettyPrinter;

    @BeforeEach
    public void setUp() {
        // Initialize the DefaultPrettyPrinter with a default root separator
        defaultPrettyPrinter = new DefaultPrettyPrinter(" ");
    }

    @Test
    public void testDefaultPrettyPrinterWithNull() {
        // Testing the constructor with null root separator
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter((String) null);
        // Verify that the root separator is null
        assertNull(printer._rootSeparator);
    }

    @Test
    public void testDefaultPrettyPrinterWithValidSeparator() {
        // Testing the constructor with a valid root separator
        String separator = " - ";
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter(separator);
        // Verify that the root separator is correctly initialized
        assertNotNull(printer._rootSeparator);
        assertEquals(" - ", printer._rootSeparator.getValue());
    }

    @Test
    public void testDefaultPrettyPrinterWithEmptyString() {
        // Testing the constructor with an empty string as root separator
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter("");
        // Verify that the root separator is an empty SerializedString
        assertNotNull(printer._rootSeparator);
        assertEquals("", printer._rootSeparator.getValue());
    }

    @Test
    public void testDefaultPrettyPrinterWithWhitespaceString() {
        // Testing the constructor with a whitespace string as root separator
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter("   ");
        // Verify that the root separator is initialized with whitespace
        assertNotNull(printer._rootSeparator);
        assertEquals("   ", printer._rootSeparator.getValue());
    }
}

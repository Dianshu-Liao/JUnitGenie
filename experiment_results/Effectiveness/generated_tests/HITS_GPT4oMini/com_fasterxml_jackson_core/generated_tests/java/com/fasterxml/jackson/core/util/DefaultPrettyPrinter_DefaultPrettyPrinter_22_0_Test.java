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

    @Test
    public void testConstructorWithValidRootSeparator() {
        String rootSeparator = ",";
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter(rootSeparator);
        assertNotNull(printer);
        assertEquals(new SerializedString(rootSeparator), printer._rootSeparator);
    }

    @Test
    public void testConstructorWithNullRootSeparator() {
        String rootSeparator = null;
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter(rootSeparator);
        assertNotNull(printer);
        assertNull(printer._rootSeparator);
    }

    @Test
    public void testConstructorWithEmptyRootSeparator() {
        String rootSeparator = "";
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter(rootSeparator);
        assertNotNull(printer);
        assertEquals(new SerializedString(rootSeparator), printer._rootSeparator);
    }

    @Test
    public void testConstructorWithWhitespaceRootSeparator() {
        String rootSeparator = "   ";
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter(rootSeparator);
        assertNotNull(printer);
        assertEquals(new SerializedString(rootSeparator), printer._rootSeparator);
    }

    @Test
    public void testConstructorWithSpecialCharacterRootSeparator() {
        String rootSeparator = "\n";
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter(rootSeparator);
        assertNotNull(printer);
        assertEquals(new SerializedString(rootSeparator), printer._rootSeparator);
    }
}

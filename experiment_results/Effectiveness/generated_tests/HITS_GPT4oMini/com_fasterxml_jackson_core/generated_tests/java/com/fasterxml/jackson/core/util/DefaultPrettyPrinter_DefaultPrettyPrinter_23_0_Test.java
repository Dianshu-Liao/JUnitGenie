package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.io.SerializedString;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;

public class DefaultPrettyPrinter_DefaultPrettyPrinter_23_0_Test {

    private DefaultPrettyPrinter defaultPrettyPrinter;

    @BeforeEach
    public void setUp() {
        // Setup a DefaultPrettyPrinter with a default root separator
        defaultPrettyPrinter = new DefaultPrettyPrinter(new SerializedString(" "));
    }

    @Test
    public void testDefaultPrettyPrinterWithNonNullSeparator() {
        // Test the constructor with a non-null SerializableString
        SerializedString separator = new SerializedString(";");
        DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter(separator);
        assertNotNull(prettyPrinter);
    }

    @Test
    public void testDefaultPrettyPrinterWithNullSeparator() {
        // Test the constructor with a null SerializableString
        DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter((SerializableString) null);
        assertNotNull(prettyPrinter);
        assertNull(prettyPrinter._rootSeparator);
    }

    @Test
    public void testDefaultPrettyPrinterWithSeparators() {
        // Test the constructor with Separators
        Separators separators = new Separators();
        DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter(separators);
        assertNotNull(prettyPrinter);
        assertNotNull(prettyPrinter._rootSeparator);
    }

    @Test
    public void testDefaultPrettyPrinterCopyConstructor() {
        // Test the copy constructor
        DefaultPrettyPrinter copyPrinter = new DefaultPrettyPrinter(defaultPrettyPrinter);
        assertNotNull(copyPrinter);
        assertNotNull(copyPrinter._rootSeparator);
        assertNotNull(copyPrinter._arrayIndenter);
        assertNotNull(copyPrinter._objectIndenter);
    }

    @Test
    public void testDefaultPrettyPrinterWithBaseAndSeparator() {
        // Test the constructor with a base printer and a separator
        DefaultPrettyPrinter basePrinter = new DefaultPrettyPrinter(new SerializedString(","));
        DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter(basePrinter, new SerializedString(";"));
        assertNotNull(prettyPrinter);
        assertNotNull(prettyPrinter._rootSeparator);
    }
}

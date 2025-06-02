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

public class DefaultPrettyPrinter_DefaultPrettyPrinter_24_0_Test {

    private DefaultPrettyPrinter basePrinter;

    private SerializableString rootSeparator;

    @BeforeEach
    public void setUp() {
        // Initialize a base DefaultPrettyPrinter and a rootSeparator for testing
        basePrinter = new DefaultPrettyPrinter();
        rootSeparator = new SerializedString(";");
    }

    @Test
    public void testDefaultPrettyPrinterConstructorWithBaseAndRootSeparator() {
        DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter(basePrinter, rootSeparator);
        assertEquals(basePrinter._arrayIndenter, prettyPrinter._arrayIndenter);
        assertEquals(basePrinter._objectIndenter, prettyPrinter._objectIndenter);
        assertEquals(basePrinter._spacesInObjectEntries, prettyPrinter._spacesInObjectEntries);
        assertEquals(basePrinter._nesting, prettyPrinter._nesting);
        assertEquals(basePrinter._separators, prettyPrinter._separators);
        assertEquals(basePrinter._objectFieldValueSeparatorWithSpaces, prettyPrinter._objectFieldValueSeparatorWithSpaces);
        assertEquals(basePrinter._objectEntrySeparator, prettyPrinter._objectEntrySeparator);
        assertEquals(basePrinter._objectEmptySeparator, prettyPrinter._objectEmptySeparator);
        assertEquals(basePrinter._arrayValueSeparator, prettyPrinter._arrayValueSeparator);
        assertEquals(basePrinter._arrayEmptySeparator, prettyPrinter._arrayEmptySeparator);
        assertEquals(rootSeparator, prettyPrinter._rootSeparator);
    }

    @Test
    public void testDefaultPrettyPrinterConstructorWithNullBase() {
        DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter(null, rootSeparator);
        assertEquals(null, prettyPrinter._arrayIndenter);
        assertEquals(null, prettyPrinter._objectIndenter);
        assertEquals(false, prettyPrinter._spacesInObjectEntries);
        assertEquals(0, prettyPrinter._nesting);
        assertEquals(null, prettyPrinter._separators);
        assertEquals(null, prettyPrinter._objectFieldValueSeparatorWithSpaces);
        assertEquals(null, prettyPrinter._objectEntrySeparator);
        assertEquals(null, prettyPrinter._objectEmptySeparator);
        assertEquals(null, prettyPrinter._arrayValueSeparator);
        assertEquals(null, prettyPrinter._arrayEmptySeparator);
        assertEquals(rootSeparator, prettyPrinter._rootSeparator);
    }

    @Test
    public void testDefaultPrettyPrinterConstructorWithEmptyRootSeparator() {
        SerializableString emptySeparator = new SerializedString("");
        DefaultPrettyPrinter prettyPrinter = new DefaultPrettyPrinter(basePrinter, emptySeparator);
        assertEquals(emptySeparator, prettyPrinter._rootSeparator);
    }
}

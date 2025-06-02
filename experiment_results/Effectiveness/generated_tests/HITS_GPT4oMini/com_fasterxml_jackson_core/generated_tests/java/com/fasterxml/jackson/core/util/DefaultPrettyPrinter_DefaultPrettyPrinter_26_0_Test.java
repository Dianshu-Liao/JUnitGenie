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

public class DefaultPrettyPrinter_DefaultPrettyPrinter_26_0_Test {

    private DefaultPrettyPrinter defaultPrettyPrinter;

    private DefaultPrettyPrinter basePrettyPrinter;

    @BeforeEach
    public void setUp() {
        basePrettyPrinter = new DefaultPrettyPrinter();
        defaultPrettyPrinter = new DefaultPrettyPrinter(basePrettyPrinter);
    }

    @Test
    public void testConstructorWithBase() {
        assertNotNull(defaultPrettyPrinter);
        assertEquals(basePrettyPrinter._rootSeparator, defaultPrettyPrinter._rootSeparator);
        assertEquals(basePrettyPrinter._arrayIndenter, defaultPrettyPrinter._arrayIndenter);
        assertEquals(basePrettyPrinter._objectIndenter, defaultPrettyPrinter._objectIndenter);
        assertEquals(basePrettyPrinter._spacesInObjectEntries, defaultPrettyPrinter._spacesInObjectEntries);
        assertEquals(basePrettyPrinter._nesting, defaultPrettyPrinter._nesting);
        assertEquals(basePrettyPrinter._separators, defaultPrettyPrinter._separators);
        assertEquals(basePrettyPrinter._objectFieldValueSeparatorWithSpaces, defaultPrettyPrinter._objectFieldValueSeparatorWithSpaces);
        assertEquals(basePrettyPrinter._objectEntrySeparator, defaultPrettyPrinter._objectEntrySeparator);
        assertEquals(basePrettyPrinter._objectEmptySeparator, defaultPrettyPrinter._objectEmptySeparator);
        assertEquals(basePrettyPrinter._arrayValueSeparator, defaultPrettyPrinter._arrayValueSeparator);
        assertEquals(basePrettyPrinter._arrayEmptySeparator, defaultPrettyPrinter._arrayEmptySeparator);
    }

    @Test
    public void testDefaultConstructor() {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        assertNotNull(printer);
        assertNotNull(printer._separators);
    }

    @Test
    public void testDefaultPrettyPrinterWithSeparators() {
        Separators separators = new Separators(':', ',', ',');
        DefaultPrettyPrinter printerWithSeparators = new DefaultPrettyPrinter(separators);
        assertNotNull(printerWithSeparators);
        assertEquals(separators.getRootSeparator(), printerWithSeparators._rootSeparator.getValue());
    }

    @Test
    public void testConstructorWithRootSeparator() {
        SerializableString rootSeparator = new SerializedString("rootSeparator");
        DefaultPrettyPrinter printerWithRootSeparator = new DefaultPrettyPrinter(basePrettyPrinter, rootSeparator);
        assertNotNull(printerWithRootSeparator);
        assertEquals(rootSeparator.getValue(), printerWithRootSeparator._rootSeparator.getValue());
    }

    @Test
    public void testConstructorWithBaseAndRootSeparator() {
        SerializableString rootSeparator = new SerializedString("rootSeparator");
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter(basePrettyPrinter, rootSeparator);
        assertNotNull(printer);
        assertEquals(basePrettyPrinter._arrayIndenter, printer._arrayIndenter);
        assertEquals(basePrettyPrinter._objectIndenter, printer._objectIndenter);
        assertEquals(basePrettyPrinter._spacesInObjectEntries, printer._spacesInObjectEntries);
        assertEquals(basePrettyPrinter._nesting, printer._nesting);
        assertEquals(basePrettyPrinter._separators, printer._separators);
        assertEquals(basePrettyPrinter._objectFieldValueSeparatorWithSpaces, printer._objectFieldValueSeparatorWithSpaces);
        assertEquals(basePrettyPrinter._objectEntrySeparator, printer._objectEntrySeparator);
        assertEquals(basePrettyPrinter._objectEmptySeparator, printer._objectEmptySeparator);
        assertEquals(basePrettyPrinter._arrayValueSeparator, printer._arrayValueSeparator);
        assertEquals(basePrettyPrinter._arrayEmptySeparator, printer._arrayEmptySeparator);
        assertEquals(rootSeparator.getValue(), printer._rootSeparator.getValue());
    }
}

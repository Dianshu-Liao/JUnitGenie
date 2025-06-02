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

public class DefaultPrettyPrinter_DefaultPrettyPrinter_25_0_Test {

    private Separators separators;

    private DefaultPrettyPrinter defaultPrettyPrinter;

    @BeforeEach
    public void setUp() {
        // Initialize default separators for testing
        separators = new Separators(':', ',', ',');
        defaultPrettyPrinter = new DefaultPrettyPrinter(separators);
    }

    @Test
    public void testConstructorWithSeparators() {
        assertNotNull(defaultPrettyPrinter);
        assertEquals(separators, defaultPrettyPrinter._separators);
        assertNotNull(defaultPrettyPrinter._rootSeparator);
    }

    @Test
    public void testObjectFieldValueSeparatorWithSpaces() {
        String expectedSeparator = String.valueOf(separators.getObjectFieldValueSeparator()) + " ";
        assertEquals(expectedSeparator, defaultPrettyPrinter._objectFieldValueSeparatorWithSpaces);
    }

    @Test
    public void testObjectEntrySeparator() {
        assertEquals(String.valueOf(separators.getObjectEntrySeparator()), defaultPrettyPrinter._objectEntrySeparator);
    }

    @Test
    public void testObjectEmptySeparator() {
        assertEquals(separators.getObjectEmptySeparator(), defaultPrettyPrinter._objectEmptySeparator);
    }

    @Test
    public void testArrayValueSeparator() {
        assertEquals(String.valueOf(separators.getArrayValueSeparator()), defaultPrettyPrinter._arrayValueSeparator);
    }

    @Test
    public void testArrayEmptySeparator() {
        assertEquals(separators.getArrayEmptySeparator(), defaultPrettyPrinter._arrayEmptySeparator);
    }

    @Test
    public void testRootSeparator() {
        assertEquals(separators.getRootSeparator(), defaultPrettyPrinter._rootSeparator.getValue());
    }

    @Test
    public void testArrayIndenter() {
        assertNotNull(defaultPrettyPrinter._arrayIndenter);
    }

    @Test
    public void testObjectIndenter() {
        assertNotNull(defaultPrettyPrinter._objectIndenter);
    }

    @Test
    public void testNesting() {
        assertEquals(0, defaultPrettyPrinter._nesting);
    }

    @Test
    public void testSpacesInObjectEntries() {
        assertEquals(true, defaultPrettyPrinter._spacesInObjectEntries);
    }
}

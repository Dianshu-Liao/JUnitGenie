package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.Separators;
import com.fasterxml.jackson.core.io.SerializedString;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;

class DefaultPrettyPrinter_DefaultPrettyPrinter_25_0_Test {

    private Separators separators;

    @BeforeEach
    void setUp() {
        separators = new Separators(':', ',', ' ');
    }

    @Test
    void testConstructorWithValidSeparators() throws Exception {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter(separators);
        // Using reflection to access private fields
        Field rootSeparatorField = DefaultPrettyPrinter.class.getDeclaredField("_rootSeparator");
        rootSeparatorField.setAccessible(true);
        Field objectFieldValueSeparatorWithSpacesField = DefaultPrettyPrinter.class.getDeclaredField("_objectFieldValueSeparatorWithSpaces");
        objectFieldValueSeparatorWithSpacesField.setAccessible(true);
        Field objectEntrySeparatorField = DefaultPrettyPrinter.class.getDeclaredField("_objectEntrySeparator");
        objectEntrySeparatorField.setAccessible(true);
        Field arrayValueSeparatorField = DefaultPrettyPrinter.class.getDeclaredField("_arrayValueSeparator");
        arrayValueSeparatorField.setAccessible(true);
        Field arrayEmptySeparatorField = DefaultPrettyPrinter.class.getDeclaredField("_arrayEmptySeparator");
        arrayEmptySeparatorField.setAccessible(true);
        // Assertions to check if the constructor initializes the fields correctly
        assertNotNull(rootSeparatorField.get(printer));
        assertEquals(":", ((SerializedString) rootSeparatorField.get(printer)).getValue());
        assertEquals(" ", objectFieldValueSeparatorWithSpacesField.get(printer));
        assertEquals(",", objectEntrySeparatorField.get(printer));
        assertEquals(" ", arrayValueSeparatorField.get(printer));
        assertEquals(" ", arrayEmptySeparatorField.get(printer));
    }

    @Test
    void testConstructorWithNullSeparators() throws Exception {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter((Separators) null);
        // Using reflection to access private fields
        Field rootSeparatorField = DefaultPrettyPrinter.class.getDeclaredField("_rootSeparator");
        rootSeparatorField.setAccessible(true);
        Field objectFieldValueSeparatorWithSpacesField = DefaultPrettyPrinter.class.getDeclaredField("_objectFieldValueSeparatorWithSpaces");
        objectFieldValueSeparatorWithSpacesField.setAccessible(true);
        Field objectEntrySeparatorField = DefaultPrettyPrinter.class.getDeclaredField("_objectEntrySeparator");
        objectEntrySeparatorField.setAccessible(true);
        Field arrayValueSeparatorField = DefaultPrettyPrinter.class.getDeclaredField("_arrayValueSeparator");
        arrayValueSeparatorField.setAccessible(true);
        Field arrayEmptySeparatorField = DefaultPrettyPrinter.class.getDeclaredField("_arrayEmptySeparator");
        arrayEmptySeparatorField.setAccessible(true);
        assertNull(rootSeparatorField.get(printer));
        assertNull(objectFieldValueSeparatorWithSpacesField.get(printer));
        assertNull(objectEntrySeparatorField.get(printer));
        assertNull(arrayValueSeparatorField.get(printer));
        assertNull(arrayEmptySeparatorField.get(printer));
    }

    @Test
    void testConstructorWithDefaultSeparators() throws Exception {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        // Using reflection to access private fields
        Field rootSeparatorField = DefaultPrettyPrinter.class.getDeclaredField("_rootSeparator");
        rootSeparatorField.setAccessible(true);
        assertNotNull(rootSeparatorField.get(printer));
        assertEquals(" ", ((SerializedString) rootSeparatorField.get(printer)).getValue());
    }
}

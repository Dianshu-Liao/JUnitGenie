package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.util.Separators;
import com.fasterxml.jackson.core.io.SerializedString;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;

public class DefaultPrettyPrinter_DefaultPrettyPrinter_26_0_Test {

    private DefaultPrettyPrinter basePrinter;

    private DefaultPrettyPrinter copyPrinter;

    @BeforeEach
    public void setUp() {
        basePrinter = new DefaultPrettyPrinter();
        // Setting some values in the basePrinter using reflection for testing
        setField(basePrinter, "_rootSeparator", new SerializedString("rootSeparator"));
        setField(basePrinter, "_arrayValueSeparator", ",");
        setField(basePrinter, "_objectEntrySeparator", ":");
    }

    @Test
    public void testDefaultPrettyPrinterCopyConstructor() throws Exception {
        // Create a copy using the focal method
        Constructor<DefaultPrettyPrinter> constructor = DefaultPrettyPrinter.class.getDeclaredConstructor(DefaultPrettyPrinter.class);
        constructor.setAccessible(true);
        copyPrinter = constructor.newInstance(basePrinter);
        // Assert that the copied printer's fields match the base printer's fields
        assertEquals(getField(basePrinter, "_rootSeparator"), getField(copyPrinter, "_rootSeparator"));
        assertEquals(getField(basePrinter, "_arrayValueSeparator"), getField(copyPrinter, "_arrayValueSeparator"));
        assertEquals(getField(basePrinter, "_objectEntrySeparator"), getField(copyPrinter, "_objectEntrySeparator"));
    }

    private Object getField(DefaultPrettyPrinter printer, String fieldName) {
        try {
            Field field = DefaultPrettyPrinter.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(printer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void setField(DefaultPrettyPrinter printer, String fieldName, Object value) {
        try {
            Field field = DefaultPrettyPrinter.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(printer, value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

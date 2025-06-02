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

public class DefaultPrettyPrinter_withRootSeparator_0_0_Test {

    @Test
    public void testWithRootSeparator_NullRootSeparator() {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        DefaultPrettyPrinter result = printer.withRootSeparator((SerializableString) null);
        assertNotSame(printer, result);
        assertNull(result._rootSeparator);
    }

    @Test
    public void testWithRootSeparator_SameRootSeparator() {
        SerializableString rootSeparator = new SerializedString(" ");
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter(rootSeparator);
        DefaultPrettyPrinter result = printer.withRootSeparator(rootSeparator);
        assertSame(printer, result);
    }

    @Test
    public void testWithRootSeparator_DifferentRootSeparator() {
        SerializableString oldRootSeparator = new SerializedString(" ");
        SerializableString newRootSeparator = new SerializedString(",");
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter(oldRootSeparator);
        DefaultPrettyPrinter result = printer.withRootSeparator(newRootSeparator);
        assertNotSame(printer, result);
        assertEquals(newRootSeparator, result._rootSeparator);
    }

    @Test
    public void testWithRootSeparator_EmptyRootSeparator() {
        SerializableString rootSeparator = new SerializedString("");
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        DefaultPrettyPrinter result = printer.withRootSeparator(rootSeparator);
        assertNotSame(printer, result);
        assertEquals(rootSeparator, result._rootSeparator);
    }

    @Test
    public void testWithRootSeparator_ChangingRootSeparator() {
        SerializableString oldRootSeparator = new SerializedString(" ");
        SerializableString newRootSeparator = new SerializedString("\n");
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter(oldRootSeparator);
        DefaultPrettyPrinter result = printer.withRootSeparator(newRootSeparator);
        assertNotSame(printer, result);
        assertEquals(newRootSeparator, result._rootSeparator);
    }

    @Test
    public void testWithRootSeparator_NonSerializableString() {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        Exception exception = assertThrows(ClassCastException.class, () -> {
            // Simulating a non-SerializableString
            printer.withRootSeparator((SerializableString) null);
        });
        assertNotNull(exception);
    }
}

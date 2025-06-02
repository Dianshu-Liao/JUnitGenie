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

public class DefaultPrettyPrinter_withRootSeparator_1_0_Test {

    @Test
    public void testWithRootSeparator_NullSeparator() {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        DefaultPrettyPrinter result = printer.withRootSeparator((String) null);
        assertNotNull(result);
        assertNull(result._rootSeparator);
    }

    @Test
    public void testWithRootSeparator_EmptySeparator() {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        DefaultPrettyPrinter result = printer.withRootSeparator("");
        assertNotNull(result);
        assertEquals("", result._rootSeparator.getValue());
    }

    @Test
    public void testWithRootSeparator_SingleSpace() {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        DefaultPrettyPrinter result = printer.withRootSeparator(" ");
        assertNotNull(result);
        assertEquals(" ", result._rootSeparator.getValue());
    }

    @Test
    public void testWithRootSeparator_CustomSeparator() {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        String customSeparator = "->";
        DefaultPrettyPrinter result = printer.withRootSeparator(customSeparator);
        assertNotNull(result);
        assertEquals(customSeparator, result._rootSeparator.getValue());
    }

    @Test
    public void testWithRootSeparator_SameSeparator() {
        String existingSeparator = " ";
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter(existingSeparator);
        DefaultPrettyPrinter result = printer.withRootSeparator(existingSeparator);
        assertSame(printer, result);
    }

    @Test
    public void testWithRootSeparator_DifferentSeparator() {
        String existingSeparator = " ";
        String newSeparator = ",";
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter(existingSeparator);
        DefaultPrettyPrinter result = printer.withRootSeparator(newSeparator);
        assertNotSame(printer, result);
        assertEquals(newSeparator, result._rootSeparator.getValue());
    }
}

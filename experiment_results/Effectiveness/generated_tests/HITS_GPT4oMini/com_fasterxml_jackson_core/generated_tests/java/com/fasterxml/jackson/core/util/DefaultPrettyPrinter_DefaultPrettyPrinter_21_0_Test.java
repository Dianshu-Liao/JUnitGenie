package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.FixedSpaceIndenter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;

public class DefaultPrettyPrinter_DefaultPrettyPrinter_21_0_Test {

    private DefaultPrettyPrinter defaultPrettyPrinter;

    @BeforeEach
    public void setUp() {
        defaultPrettyPrinter = new DefaultPrettyPrinter();
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(defaultPrettyPrinter);
        assertEquals(FixedSpaceIndenter.instance, defaultPrettyPrinter._arrayIndenter);
        assertEquals(defaultPrettyPrinter._objectIndenter, defaultPrettyPrinter._objectIndenter);
        assertEquals(0, defaultPrettyPrinter._nesting);
    }

    @Test
    public void testConstructorWithSeparators() {
        Separators separators = new Separators();
        DefaultPrettyPrinter printerWithSeparators = new DefaultPrettyPrinter(separators);
        assertNotNull(printerWithSeparators);
        assertEquals(separators, printerWithSeparators._separators);
    }

    @Test
    public void testConstructorWithBase() {
        DefaultPrettyPrinter basePrinter = new DefaultPrettyPrinter();
        DefaultPrettyPrinter printerWithBase = new DefaultPrettyPrinter(basePrinter);
        assertNotNull(printerWithBase);
        assertNotSame(basePrinter, printerWithBase);
    }

    @Test
    public void testConstructorWithRootSeparator() {
        SerializedString rootSeparator = new SerializedString(",");
        DefaultPrettyPrinter printerWithRootSeparator = new DefaultPrettyPrinter(rootSeparator);
        assertNotNull(printerWithRootSeparator);
        assertEquals(rootSeparator, printerWithRootSeparator._rootSeparator);
    }

    @Test
    public void testConstructorWithBaseAndRootSeparator() {
        DefaultPrettyPrinter basePrinter = new DefaultPrettyPrinter();
        SerializedString rootSeparator = new SerializedString(",");
        DefaultPrettyPrinter printerWithBaseAndRootSeparator = new DefaultPrettyPrinter(basePrinter, rootSeparator);
        assertNotNull(printerWithBaseAndRootSeparator);
        assertEquals(rootSeparator, printerWithBaseAndRootSeparator._rootSeparator);
    }
}

package com.fasterxml.jackson.core.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
        basePrinter = new DefaultPrettyPrinter();
        rootSeparator = new SerializedString("|");
    }

    @Test
    public void testConstructorWithBaseAndRootSeparator() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<DefaultPrettyPrinter> constructor = DefaultPrettyPrinter.class.getDeclaredConstructor(DefaultPrettyPrinter.class, SerializableString.class);
        constructor.setAccessible(true);
        DefaultPrettyPrinter printer = constructor.newInstance(basePrinter, rootSeparator);
        assertNotNull(printer);
        assertEquals(basePrinter._arrayIndenter, printer._arrayIndenter);
        assertEquals(basePrinter._objectIndenter, printer._objectIndenter);
        assertEquals(basePrinter._spacesInObjectEntries, printer._spacesInObjectEntries);
        assertEquals(basePrinter._nesting, printer._nesting);
        assertEquals(basePrinter._separators, printer._separators);
        assertEquals(basePrinter._objectFieldValueSeparatorWithSpaces, printer._objectFieldValueSeparatorWithSpaces);
        assertEquals(basePrinter._objectEntrySeparator, printer._objectEntrySeparator);
        assertEquals(basePrinter._objectEmptySeparator, printer._objectEmptySeparator);
        assertEquals(basePrinter._arrayValueSeparator, printer._arrayValueSeparator);
        assertEquals(basePrinter._arrayEmptySeparator, printer._arrayEmptySeparator);
        assertEquals(rootSeparator, printer._rootSeparator);
    }
}

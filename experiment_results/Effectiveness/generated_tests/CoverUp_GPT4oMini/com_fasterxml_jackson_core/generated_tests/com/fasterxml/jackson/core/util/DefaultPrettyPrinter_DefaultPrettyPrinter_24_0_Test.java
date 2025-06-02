package com.fasterxml.jackson.core.util;

import java.lang.reflect.Constructor;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.core.io.SerializedString;
import com.fasterxml.jackson.core.util.Separators;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;

public class DefaultPrettyPrinter_DefaultPrettyPrinter_24_0_Test {

    private DefaultPrettyPrinter basePrinter;

    private SerializedString rootSeparator;

    @BeforeEach
    public void setUp() {
        basePrinter = new DefaultPrettyPrinter();
        rootSeparator = new SerializedString(":");
    }

    @Test
    public void testDefaultPrettyPrinterWithBaseAndRootSeparator() throws Exception {
        Constructor<DefaultPrettyPrinter> constructor = DefaultPrettyPrinter.class.getDeclaredConstructor(DefaultPrettyPrinter.class, SerializedString.class);
        constructor.setAccessible(true);
        DefaultPrettyPrinter prettyPrinter = constructor.newInstance(basePrinter, rootSeparator);
        assertNotNull(prettyPrinter);
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
}

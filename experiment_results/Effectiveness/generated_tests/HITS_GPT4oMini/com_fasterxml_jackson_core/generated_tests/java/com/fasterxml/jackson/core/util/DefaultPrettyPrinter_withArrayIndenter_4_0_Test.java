package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.Indenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.FixedSpaceIndenter;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter.NopIndenter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.SerializedString;

public class DefaultPrettyPrinter_withArrayIndenter_4_0_Test {

    private DefaultPrettyPrinter defaultPrettyPrinter;

    @BeforeEach
    public void setUp() {
        defaultPrettyPrinter = new DefaultPrettyPrinter();
    }

    @Test
    public void testWithArrayIndenter_NullIndenter() {
        DefaultPrettyPrinter result = defaultPrettyPrinter.withArrayIndenter(null);
        assertEquals(NopIndenter.instance, result._arrayIndenter);
        assertEquals(defaultPrettyPrinter._arrayIndenter, defaultPrettyPrinter._arrayIndenter);
    }

    @Test
    public void testWithArrayIndenter_SameIndenter() {
        Indenter sameIndenter = FixedSpaceIndenter.instance;
        defaultPrettyPrinter._arrayIndenter = sameIndenter;
        DefaultPrettyPrinter result = defaultPrettyPrinter.withArrayIndenter(sameIndenter);
        assertSame(defaultPrettyPrinter, result);
    }

    @Test
    public void testWithArrayIndenter_DifferentIndenter() {
        Indenter newIndenter = new FixedSpaceIndenter();
        DefaultPrettyPrinter result = defaultPrettyPrinter.withArrayIndenter(newIndenter);
        assertEquals(newIndenter, result._arrayIndenter);
        assertEquals(defaultPrettyPrinter._arrayIndenter, defaultPrettyPrinter._arrayIndenter);
    }
}

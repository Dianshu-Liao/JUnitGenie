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

public class DefaultPrettyPrinter_withArrayIndenter_4_1_Test {

    @Test
    public void testWithArrayIndenter_NullIndenter() {
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        DefaultPrettyPrinter result = printer.withArrayIndenter(null);
        assertNotNull(result);
        assertSame(NopIndenter.instance, result._arrayIndenter);
    }

    @Test
    public void testWithArrayIndenter_SameIndenter() {
        Indenter indenter = FixedSpaceIndenter.instance;
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        printer = printer.withArrayIndenter(indenter);
        DefaultPrettyPrinter result = printer.withArrayIndenter(indenter);
        assertSame(printer, result);
    }

    @Test
    public void testWithArrayIndenter_DifferentIndenter() {
        Indenter indenter1 = FixedSpaceIndenter.instance;
        Indenter indenter2 = NopIndenter.instance;
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        printer = printer.withArrayIndenter(indenter1);
        DefaultPrettyPrinter result = printer.withArrayIndenter(indenter2);
        assertNotSame(printer, result);
        assertSame(indenter2, result._arrayIndenter);
    }

    @Test
    public void testWithArrayIndenter_IndenterNotNull() {
        Indenter indenter = NopIndenter.instance;
        DefaultPrettyPrinter printer = new DefaultPrettyPrinter();
        DefaultPrettyPrinter result = printer.withArrayIndenter(indenter);
        assertNotNull(result);
        assertSame(indenter, result._arrayIndenter);
    }
}

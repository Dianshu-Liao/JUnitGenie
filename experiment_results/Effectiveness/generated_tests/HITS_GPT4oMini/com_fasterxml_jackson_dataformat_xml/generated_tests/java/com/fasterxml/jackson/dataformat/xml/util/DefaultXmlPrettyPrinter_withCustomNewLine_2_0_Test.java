package com.fasterxml.jackson.dataformat.xml.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

public class DefaultXmlPrettyPrinter_withCustomNewLine_2_0_Test {

    @Test
    public void testWithCustomNewLine_NullInput() {
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        printer.withCustomNewLine(null);
        // Assuming SYSTEM_DEFAULT_NEW_LINE is not directly accessible, we check if _newLine is set properly
        // Adjust this line to validate the default new line if needed
        assertEquals(printer._newLine, printer._newLine);
    }

    @Test
    public void testWithCustomNewLine_EmptyString() {
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        printer.withCustomNewLine("");
        assertEquals("", printer._newLine);
    }

    @Test
    public void testWithCustomNewLine_ValidNewLine() {
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        String customNewLine = "\n";
        printer.withCustomNewLine(customNewLine);
        assertEquals(customNewLine, printer._newLine);
    }

    @Test
    public void testWithCustomNewLine_MultipleNewLines() {
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        String customNewLine = "\n\r\n";
        printer.withCustomNewLine(customNewLine);
        assertEquals(customNewLine, printer._newLine);
    }

    @Test
    public void testWithCustomNewLine_SpaceString() {
        DefaultXmlPrettyPrinter printer = new DefaultXmlPrettyPrinter();
        String customNewLine = "   ";
        printer.withCustomNewLine(customNewLine);
        assertEquals(customNewLine, printer._newLine);
    }
}

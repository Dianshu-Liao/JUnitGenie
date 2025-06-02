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

public class DefaultXmlPrettyPrinter_withCustomNewLine_2_2_Test {

    private DefaultXmlPrettyPrinter printer;

    @BeforeEach
    public void setUp() {
        printer = new DefaultXmlPrettyPrinter();
    }

    @Test
    public void testWithCustomNewLine_NonNullValue() {
        String customNewLine = "\n";
        printer.withCustomNewLine(customNewLine);
        assertEquals(customNewLine, getPrivateField(printer, "_newLine"));
    }

    @Test
    public void testWithCustomNewLine_NullValue() {
        String expectedNewLine = getPrivateField(printer, "SYSTEM_DEFAULT_NEW_LINE");
        printer.withCustomNewLine(null);
        assertEquals(expectedNewLine, getPrivateField(printer, "_newLine"));
    }

    @Test
    public void testWithCustomNewLine_EmptyString() {
        String emptyNewLine = "";
        printer.withCustomNewLine(emptyNewLine);
        assertEquals(emptyNewLine, getPrivateField(printer, "_newLine"));
    }

    @Test
    public void testWithCustomNewLine_Chainable() {
        String customNewLine = "\n";
        DefaultXmlPrettyPrinter result = printer.withCustomNewLine(customNewLine);
        assertEquals(printer, result);
    }

    // Reflection method to access private fields
    private String getPrivateField(DefaultXmlPrettyPrinter printer, String fieldName) {
        try {
            java.lang.reflect.Field field = DefaultXmlPrettyPrinter.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return (String) field.get(printer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

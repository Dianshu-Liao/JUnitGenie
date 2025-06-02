package com.fasterxml.jackson.dataformat.xml.util;

import java.math.BigDecimal;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

public class DefaultXmlPrettyPrinter_writeLeafElement_24_2_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_WithInlineObjectIndenter() throws Exception {
        // Set up the mock for _objectIndenter to be inline
        Indenter inlineIndenter = mock(Indenter.class);
        when(inlineIndenter.isInline()).thenReturn(true);
        setPrivateField(prettyPrinter, "_objectIndenter", inlineIndenter);
        // Call the method
        BigDecimal value = new BigDecimal("123.45");
        prettyPrinter.writeLeafElement(xmlStreamWriter, "http://example.com", "value", value);
        // Verify interactions
        verify(xmlStreamWriter).writeStartElement("http://example.com", "value");
        verify(xmlStreamWriter).writeDecimal(value);
        verify(xmlStreamWriter).writeEndElement();
        verifyNoMoreInteractions(xmlStreamWriter);
    }

    @Test
    public void testWriteLeafElement_WithNonInlineObjectIndenter() throws Exception {
        // Set up the mock for _objectIndenter to be non-inline
        Indenter nonInlineIndenter = mock(Indenter.class);
        when(nonInlineIndenter.isInline()).thenReturn(false);
        setPrivateField(prettyPrinter, "_objectIndenter", nonInlineIndenter);
        // Mock indentation behavior
        doNothing().when(nonInlineIndenter).writeIndentation(xmlStreamWriter, prettyPrinter._nesting);
        // Call the method
        BigDecimal value = new BigDecimal("123.45");
        prettyPrinter.writeLeafElement(xmlStreamWriter, "http://example.com", "value", value);
        // Verify interactions
        verify(nonInlineIndenter).writeIndentation(xmlStreamWriter, prettyPrinter._nesting);
        verify(xmlStreamWriter).writeStartElement("http://example.com", "value");
        verify(xmlStreamWriter).writeDecimal(value);
        verify(xmlStreamWriter).writeEndElement();
        verifyNoMoreInteractions(xmlStreamWriter);
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    // Mock Indenter class to avoid compilation error
    private static class Indenter {

        public boolean isInline() {
            return false;
        }

        public void writeIndentation(XMLStreamWriter2 sw, int nesting) throws XMLStreamException {
            // Mock implementation
        }
    }
}

package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

@ExtendWith(MockitoExtension.class)
public class DefaultXmlPrettyPrinter_writeLeafElement_19_1_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 mockWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        mockWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_WithNonInlineIndentation() throws XMLStreamException, NoSuchFieldException, IllegalAccessException {
        // Mocking the behavior of _objectIndenter to return false for isInline
        Indenter mockIndenter = mock(Indenter.class);
        when(mockIndenter.isInline()).thenReturn(false);
        setField(prettyPrinter, "_objectIndenter", mockIndenter);
        // Invoke the method
        prettyPrinter.writeLeafElement(mockWriter, "http://example.com", "testElement", 42);
        // Verify the interactions
        verify(mockIndenter).writeIndentation(mockWriter, prettyPrinter._nesting);
        verify(mockWriter).writeStartElement("http://example.com", "testElement");
        verify(mockWriter).writeInt(42);
        verify(mockWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_WithInlineIndentation() throws XMLStreamException, NoSuchFieldException, IllegalAccessException {
        // Mocking the behavior of _objectIndenter to return true for isInline
        Indenter mockIndenter = mock(Indenter.class);
        when(mockIndenter.isInline()).thenReturn(true);
        setField(prettyPrinter, "_objectIndenter", mockIndenter);
        // Invoke the method
        prettyPrinter.writeLeafElement(mockWriter, "http://example.com", "testElement", 42);
        // Verify the interactions
        verify(mockIndenter, never()).writeIndentation(mockWriter, prettyPrinter._nesting);
        verify(mockWriter).writeStartElement("http://example.com", "testElement");
        verify(mockWriter).writeInt(42);
        verify(mockWriter).writeEndElement();
    }

    private void setField(Object target, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    // Mock Indenter class for testing
    private static class Indenter {

        public boolean isInline() {
            // Default implementation
            return false;
        }

        public void writeIndentation(XMLStreamWriter2 sw, int nesting) throws XMLStreamException {
            // Implementation for indentation
        }
    }
}

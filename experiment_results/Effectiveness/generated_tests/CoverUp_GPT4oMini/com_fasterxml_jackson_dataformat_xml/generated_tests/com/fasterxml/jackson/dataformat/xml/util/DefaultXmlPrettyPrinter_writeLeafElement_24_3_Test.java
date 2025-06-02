package com.fasterxml.jackson.dataformat.xml.util;

import java.math.BigDecimal;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

@ExtendWith(MockitoExtension.class)
class DefaultXmlPrettyPrinter_writeLeafElement_24_3_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    void testWriteLeafElement_WithIndentation() throws Exception {
        // Arrange
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        BigDecimal value = BigDecimal.valueOf(123.45);
        // Mock the behavior of _objectIndenter
        Indenter mockIndenter = mock(Indenter.class);
        setField(prettyPrinter, "_objectIndenter", mockIndenter);
        when(mockIndenter.isInline()).thenReturn(false);
        // Act
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        // Assert
        verify(mockIndenter).writeIndentation(xmlStreamWriter, prettyPrinter._nesting);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeDecimal(value);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    void testWriteLeafElement_WithoutIndentation() throws Exception {
        // Arrange
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        BigDecimal value = BigDecimal.valueOf(123.45);
        // Mock the behavior of _objectIndenter
        Indenter mockIndenter = mock(Indenter.class);
        setField(prettyPrinter, "_objectIndenter", mockIndenter);
        when(mockIndenter.isInline()).thenReturn(true);
        // Act
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        // Assert
        verify(mockIndenter, never()).writeIndentation(any(), anyInt());
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeDecimal(value);
        verify(xmlStreamWriter).writeEndElement();
    }

    private void setField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    // Mocked Indenter class for testing
    private static class Indenter {

        public boolean isInline() {
            return false;
        }

        public void writeIndentation(XMLStreamWriter2 sw, int nesting) throws XMLStreamException {
            // Mock implementation
        }
    }

    // Mocked FixedSpaceIndenter class for testing
    private static class FixedSpaceIndenter extends Indenter {
        // Implementation can be added if needed
    }

    // Mocked Lf2SpacesIndenter class for testing
    private static class Lf2SpacesIndenter extends Indenter {
        // Implementation can be added if needed
    }
}

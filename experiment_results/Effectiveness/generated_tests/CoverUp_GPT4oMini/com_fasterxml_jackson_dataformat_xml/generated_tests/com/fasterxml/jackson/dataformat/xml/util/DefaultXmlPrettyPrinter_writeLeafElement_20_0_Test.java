package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.math.BigDecimal;
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

public class DefaultXmlPrettyPrinter_writeLeafElement_20_0_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_WithIndentation() throws Exception {
        // Arrange
        String nsURI = "http://example.com/ns";
        String localName = "element";
        long value = 123456789L;
        // Mock the behavior of the _objectIndenter to return false for isInline
        Indenter indenterMock = mock(Indenter.class);
        when(indenterMock.isInline()).thenReturn(false);
        setPrivateField(prettyPrinter, "_objectIndenter", indenterMock);
        // Act
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        // Assert
        verify(indenterMock).writeIndentation(xmlStreamWriter, 0);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeLong(value);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_WithoutIndentation() throws Exception {
        // Arrange
        String nsURI = "http://example.com/ns";
        String localName = "element";
        long value = 123456789L;
        // Mock the behavior of the _objectIndenter to return true for isInline
        Indenter indenterMock = mock(Indenter.class);
        when(indenterMock.isInline()).thenReturn(true);
        setPrivateField(prettyPrinter, "_objectIndenter", indenterMock);
        // Act
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        // Assert
        verify(indenterMock, never()).writeIndentation(any(), anyInt());
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeLong(value);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_ThrowsXMLStreamException() throws Exception {
        // Arrange
        String nsURI = "http://example.com/ns";
        String localName = "element";
        long value = 123456789L;
        // Arrange to throw XMLStreamException when writing start element
        doThrow(new XMLStreamException("Test Exception")).when(xmlStreamWriter).writeStartElement(nsURI, localName);
        // Act & Assert
        assertThrows(XMLStreamException.class, () -> {
            prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        });
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    // Mock Indenter class for testing purposes
    protected static class Indenter {

        public boolean isInline() {
            // Default implementation
            return false;
        }

        public void writeIndentation(XMLStreamWriter2 sw, int nesting) throws XMLStreamException {
            // Mock implementation
        }
    }
}

package com.fasterxml.jackson.dataformat.xml.util;

import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.stream.XMLStreamException;
import java.math.BigDecimal;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

class DefaultXmlPrettyPrinter_writeLeafElement_24_1_Test {

    private DefaultXmlPrettyPrinter printer;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    void setUp() {
        printer = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    void testWriteLeafElement_WithInlineIndenter() throws XMLStreamException {
        // Arrange
        when(printer._objectIndenter.isInline()).thenReturn(true);
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        BigDecimal value = new BigDecimal("123.45");
        // Act
        printer.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        // Assert
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeDecimal(value);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    void testWriteLeafElement_WithNonInlineIndenter() throws XMLStreamException {
        // Arrange
        when(printer._objectIndenter.isInline()).thenReturn(false);
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        BigDecimal value = new BigDecimal("123.45");
        // Act
        printer.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        // Assert
        verify(printer._objectIndenter).writeIndentation(xmlStreamWriter, printer._nesting);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeDecimal(value);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    void testWriteLeafElement_WithNullValue() throws XMLStreamException {
        // Arrange
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        BigDecimal value = null;
        // Act
        printer.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        // Assert
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        // Assuming the writer handles null values gracefully
        verify(xmlStreamWriter).writeDecimal(value);
        verify(xmlStreamWriter).writeEndElement();
    }
}

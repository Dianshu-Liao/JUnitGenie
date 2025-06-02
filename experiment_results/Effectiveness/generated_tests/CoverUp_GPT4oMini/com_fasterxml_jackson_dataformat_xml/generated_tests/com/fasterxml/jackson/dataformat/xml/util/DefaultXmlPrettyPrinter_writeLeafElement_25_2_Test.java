package com.fasterxml.jackson.dataformat.xml.util;

import org.codehaus.stax2.XMLStreamWriter2;
import org.codehaus.stax2.typed.Base64Variant;
import javax.xml.stream.XMLStreamException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

class DefaultXmlPrettyPrinter_writeLeafElement_25_2_Test {

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
        String nsURI = "http://example.com";
        String localName = "exampleElement";
        Base64Variant base64Variant = mock(Base64Variant.class);
        byte[] data = "test".getBytes();
        int offset = 0;
        int len = data.length;
        // Act
        printer.writeLeafElement(xmlStreamWriter, nsURI, localName, base64Variant, data, offset, len);
        // Assert
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeBinary(base64Variant, data, offset, len);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    void testWriteLeafElement_WithNonInlineIndenter() throws XMLStreamException {
        // Arrange
        when(printer._objectIndenter.isInline()).thenReturn(false);
        String nsURI = "http://example.com";
        String localName = "exampleElement";
        Base64Variant base64Variant = mock(Base64Variant.class);
        byte[] data = "test".getBytes();
        int offset = 0;
        int len = data.length;
        // Act
        printer.writeLeafElement(xmlStreamWriter, nsURI, localName, base64Variant, data, offset, len);
        // Assert
        verify(printer._objectIndenter).writeIndentation(xmlStreamWriter, printer._nesting);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeBinary(base64Variant, data, offset, len);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    void testWriteLeafElement_EmptyData() throws XMLStreamException {
        // Arrange
        when(printer._objectIndenter.isInline()).thenReturn(false);
        String nsURI = "http://example.com";
        String localName = "exampleElement";
        Base64Variant base64Variant = mock(Base64Variant.class);
        // empty data
        byte[] data = new byte[0];
        int offset = 0;
        int len = data.length;
        // Act
        printer.writeLeafElement(xmlStreamWriter, nsURI, localName, base64Variant, data, offset, len);
        // Assert
        verify(printer._objectIndenter).writeIndentation(xmlStreamWriter, printer._nesting);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeBinary(base64Variant, data, offset, len);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    void testWriteLeafElement_WithException() throws XMLStreamException {
        // Arrange
        when(printer._objectIndenter.isInline()).thenReturn(false);
        String nsURI = "http://example.com";
        String localName = "exampleElement";
        Base64Variant base64Variant = mock(Base64Variant.class);
        byte[] data = "test".getBytes();
        int offset = 0;
        int len = data.length;
        doThrow(new XMLStreamException("Test Exception")).when(xmlStreamWriter).writeBinary(base64Variant, data, offset, len);
        // Act & Assert
        assertThrows(XMLStreamException.class, () -> {
            printer.writeLeafElement(xmlStreamWriter, nsURI, localName, base64Variant, data, offset, len);
        });
    }
}

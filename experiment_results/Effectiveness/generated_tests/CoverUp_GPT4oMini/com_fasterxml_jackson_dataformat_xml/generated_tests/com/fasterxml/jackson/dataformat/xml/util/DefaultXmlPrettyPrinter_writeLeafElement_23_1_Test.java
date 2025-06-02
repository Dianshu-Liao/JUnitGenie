package com.fasterxml.jackson.dataformat.xml.util;

import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.stream.XMLStreamException;
import java.math.BigInteger;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

public class DefaultXmlPrettyPrinter_writeLeafElement_23_1_Test {

    private DefaultXmlPrettyPrinter printer;

    private XMLStreamWriter2 mockWriter;

    @BeforeEach
    public void setUp() {
        printer = new DefaultXmlPrettyPrinter();
        mockWriter = Mockito.mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_WithIndentation() throws XMLStreamException {
        // Arrange
        String nsURI = "http://example.com/ns";
        String localName = "element";
        BigInteger value = BigInteger.valueOf(42);
        when(printer._objectIndenter.isInline()).thenReturn(false);
        // Act
        printer.writeLeafElement(mockWriter, nsURI, localName, value);
        // Assert
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeInteger(value);
        verify(mockWriter).writeEndElement();
        verify(mockWriter, times(1)).writeStartElement(nsURI, localName);
    }

    @Test
    public void testWriteLeafElement_WithoutIndentation() throws XMLStreamException {
        // Arrange
        String nsURI = "http://example.com/ns";
        String localName = "element";
        BigInteger value = BigInteger.valueOf(42);
        when(printer._objectIndenter.isInline()).thenReturn(true);
        // Act
        printer.writeLeafElement(mockWriter, nsURI, localName, value);
        // Assert
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeInteger(value);
        verify(mockWriter).writeEndElement();
        verify(mockWriter, times(1)).writeStartElement(nsURI, localName);
    }
}

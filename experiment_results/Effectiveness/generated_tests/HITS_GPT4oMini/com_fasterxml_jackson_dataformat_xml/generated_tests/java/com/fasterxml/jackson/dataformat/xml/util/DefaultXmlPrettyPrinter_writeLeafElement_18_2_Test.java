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
// Import Indenter
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter.Indenter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

public class DefaultXmlPrettyPrinter_writeLeafElement_18_2_Test {

    private DefaultXmlPrettyPrinter printer;

    private XMLStreamWriter2 writer;

    @BeforeEach
    public void setUp() {
        printer = new DefaultXmlPrettyPrinter();
        writer = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_WithFalseValue() throws XMLStreamException {
        // Arrange
        String nsURI = "http://example.com/ns";
        String localName = "testElement";
        boolean value = false;
        // Act
        printer.writeLeafElement(writer, nsURI, localName, value);
        // Assert
        verify(writer).writeStartElement(nsURI, localName);
        verify(writer).writeBoolean(value);
        verify(writer).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_WithTrueValue() throws XMLStreamException {
        // Arrange
        String nsURI = "http://example.com/ns";
        String localName = "testElement";
        boolean value = true;
        // Act
        printer.writeLeafElement(writer, nsURI, localName, value);
        // Assert
        verify(writer).writeStartElement(nsURI, localName);
        verify(writer).writeBoolean(value);
        verify(writer).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_WithInlineIndentation() throws XMLStreamException {
        // Arrange
        String nsURI = "http://example.com/ns";
        String localName = "testElement";
        boolean value = true;
        Indenter mockIndenter = mock(Indenter.class);
        printer._objectIndenter = mockIndenter;
        when(mockIndenter.isInline()).thenReturn(true);
        // Act
        printer.writeLeafElement(writer, nsURI, localName, value);
        // Assert
        verify(mockIndenter, never()).writeIndentation(writer, printer._nesting);
        verify(writer).writeStartElement(nsURI, localName);
        verify(writer).writeBoolean(value);
        verify(writer).writeEndElement();
    }
}

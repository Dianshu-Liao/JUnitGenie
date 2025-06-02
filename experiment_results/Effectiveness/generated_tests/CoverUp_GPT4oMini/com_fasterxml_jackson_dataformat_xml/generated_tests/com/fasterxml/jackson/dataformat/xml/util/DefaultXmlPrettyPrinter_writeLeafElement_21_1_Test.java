package com.fasterxml.jackson.dataformat.xml.util;

import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.stream.XMLStreamException;
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
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

public class DefaultXmlPrettyPrinter_writeLeafElement_21_1_Test {

    private DefaultXmlPrettyPrinter printer;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        printer = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = Mockito.mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_WithIndentation() throws XMLStreamException {
        // Arrange
        when(printer._objectIndenter.isInline()).thenReturn(false);
        // Act
        printer.writeLeafElement(xmlStreamWriter, "http://example.com", "value", 123.45);
        // Assert
        verify(printer._objectIndenter).writeIndentation(xmlStreamWriter, printer._nesting);
        verify(xmlStreamWriter).writeStartElement("http://example.com", "value");
        verify(xmlStreamWriter).writeDouble(123.45);
        verify(xmlStreamWriter).writeEndElement();
        verifyNoMoreInteractions(xmlStreamWriter);
    }

    @Test
    public void testWriteLeafElement_WithoutIndentation() throws XMLStreamException {
        // Arrange
        when(printer._objectIndenter.isInline()).thenReturn(true);
        // Act
        printer.writeLeafElement(xmlStreamWriter, "http://example.com", "value", 123.45);
        // Assert
        verify(xmlStreamWriter).writeStartElement("http://example.com", "value");
        verify(xmlStreamWriter).writeDouble(123.45);
        verify(xmlStreamWriter).writeEndElement();
        verifyNoMoreInteractions(xmlStreamWriter);
    }
}

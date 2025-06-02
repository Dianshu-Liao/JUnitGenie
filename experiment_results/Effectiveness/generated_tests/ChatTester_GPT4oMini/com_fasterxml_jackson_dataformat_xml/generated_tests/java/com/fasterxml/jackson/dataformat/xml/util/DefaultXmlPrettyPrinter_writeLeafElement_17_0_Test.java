package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
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
import org.codehaus.stax2.XMLStreamWriter2;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

class DefaultXmlPrettyPrinter_writeLeafElement_17_0_Test {

    private DefaultXmlPrettyPrinter printer;

    private XMLStreamWriter2 mockWriter;

    @BeforeEach
    void setUp() {
        printer = new DefaultXmlPrettyPrinter();
        mockWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    void testWriteLeafElement_WithCData() throws XMLStreamException {
        String nsURI = "http://example.com";
        String localName = "example";
        char[] buffer = "CDataContent".toCharArray();
        int offset = 0;
        int len = buffer.length;
        boolean isCData = true;
        printer.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCData(buffer, offset, len);
        verify(mockWriter).writeEndElement();
    }

    @Test
    void testWriteLeafElement_WithoutCData() throws XMLStreamException {
        String nsURI = "http://example.com";
        String localName = "example";
        char[] buffer = "RegularContent".toCharArray();
        int offset = 0;
        int len = buffer.length;
        boolean isCData = false;
        printer.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCharacters(buffer, offset, len);
        verify(mockWriter).writeEndElement();
    }

    @Test
    void testWriteLeafElement_Indentation() throws XMLStreamException {
        String nsURI = "http://example.com";
        String localName = "example";
        char[] buffer = "Content".toCharArray();
        int offset = 0;
        int len = buffer.length;
        boolean isCData = false;
        // Simulate the indentation behavior
        when(printer._objectIndenter.isInline()).thenReturn(false);
        printer.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCharacters(buffer, offset, len);
        verify(mockWriter).writeEndElement();
        // Verify that indentation is called
        verify(printer._objectIndenter).writeIndentation(mockWriter, printer._nesting);
    }
}

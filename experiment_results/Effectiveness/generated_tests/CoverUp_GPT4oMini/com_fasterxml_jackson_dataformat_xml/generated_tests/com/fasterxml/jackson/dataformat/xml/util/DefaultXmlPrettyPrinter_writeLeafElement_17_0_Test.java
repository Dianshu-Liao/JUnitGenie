package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
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

public class DefaultXmlPrettyPrinter_writeLeafElement_17_0_Test {

    private DefaultXmlPrettyPrinter printer;

    private XMLStreamWriter2 mockWriter;

    @BeforeEach
    public void setUp() {
        printer = new DefaultXmlPrettyPrinter();
        mockWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElementWithCData() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        char[] buffer = "CData content".toCharArray();
        int offset = 0;
        int len = buffer.length;
        boolean isCData = true;
        printer.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCData(buffer, offset, len);
        verify(mockWriter).writeEndElement();
        verifyNoMoreInteractions(mockWriter);
    }

    @Test
    public void testWriteLeafElementWithoutCData() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        char[] buffer = "Regular text content".toCharArray();
        int offset = 0;
        int len = buffer.length;
        boolean isCData = false;
        printer.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCharacters(buffer, offset, len);
        verify(mockWriter).writeEndElement();
        verifyNoMoreInteractions(mockWriter);
    }

    @Test
    public void testWriteLeafElementWithEmptyBuffer() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "emptyElement";
        char[] buffer = new char[0];
        int offset = 0;
        int len = 0;
        boolean isCData = false;
        printer.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCharacters(buffer, offset, len);
        verify(mockWriter).writeEndElement();
        verifyNoMoreInteractions(mockWriter);
    }

    @Test
    public void testWriteLeafElementWithNesting() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "nestedElement";
        char[] buffer = "Nesting content".toCharArray();
        int offset = 0;
        int len = buffer.length;
        boolean isCData = false;
        // Simulate indentation
        // Set nesting to simulate indentation behavior
        printer._nesting = 1;
        printer.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCharacters(buffer, offset, len);
        verify(mockWriter).writeEndElement();
        verifyNoMoreInteractions(mockWriter);
    }
}

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

public class DefaultXmlPrettyPrinter_writeLeafElement_17_3_Test {

    private DefaultXmlPrettyPrinter printer;

    private XMLStreamWriter2 mockWriter;

    @BeforeEach
    public void setUp() {
        printer = new DefaultXmlPrettyPrinter();
        mockWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_WithCData() throws XMLStreamException {
        char[] buffer = "Test Data".toCharArray();
        String nsURI = "http://example.com/ns";
        String localName = "testElement";
        int offset = 0;
        int len = buffer.length;
        boolean isCData = true;
        // Mock behavior for the indenter
        when(printer._objectIndenter.isInline()).thenReturn(false);
        // Call the method under test
        printer.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
        // Verify interactions
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCData(buffer, offset, len);
        verify(mockWriter).writeEndElement();
        assertFalse(printer._justHadStartElement);
    }

    @Test
    public void testWriteLeafElement_WithoutCData() throws XMLStreamException {
        char[] buffer = "Test Data".toCharArray();
        String nsURI = "http://example.com/ns";
        String localName = "testElement";
        int offset = 0;
        int len = buffer.length;
        boolean isCData = false;
        // Mock behavior for the indenter
        when(printer._objectIndenter.isInline()).thenReturn(false);
        // Call the method under test
        printer.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
        // Verify interactions
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCharacters(buffer, offset, len);
        verify(mockWriter).writeEndElement();
        assertFalse(printer._justHadStartElement);
    }

    @Test
    public void testWriteLeafElement_WithInlineIndenter() throws XMLStreamException {
        char[] buffer = "Test Data".toCharArray();
        String nsURI = "http://example.com/ns";
        String localName = "testElement";
        int offset = 0;
        int len = buffer.length;
        boolean isCData = false;
        // Mock behavior for the indenter
        when(printer._objectIndenter.isInline()).thenReturn(true);
        // Call the method under test
        printer.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
        // Verify interactions
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCharacters(buffer, offset, len);
        verify(mockWriter).writeEndElement();
        assertFalse(printer._justHadStartElement);
    }
}

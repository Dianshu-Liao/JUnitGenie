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

public class DefaultXmlPrettyPrinter_writeLeafElement_17_2_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElementWithCData() throws XMLStreamException {
        String nsURI = "http://example.com/namespace";
        String localName = "element";
        char[] buffer = "CData content".toCharArray();
        int offset = 0;
        int len = buffer.length;
        boolean isCData = true;
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, buffer, offset, len, isCData);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeCData(buffer, offset, len);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElementWithoutCData() throws XMLStreamException {
        String nsURI = "http://example.com/namespace";
        String localName = "element";
        char[] buffer = "Regular content".toCharArray();
        int offset = 0;
        int len = buffer.length;
        boolean isCData = false;
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, buffer, offset, len, isCData);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeCharacters(buffer, offset, len);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElementWithEmptyBuffer() throws XMLStreamException {
        String nsURI = "http://example.com/namespace";
        String localName = "element";
        char[] buffer = new char[0];
        int offset = 0;
        int len = 0;
        boolean isCData = false;
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, buffer, offset, len, isCData);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeCharacters(buffer, offset, len);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElementWithInvalidOffset() {
        String nsURI = "http://example.com/namespace";
        String localName = "element";
        char[] buffer = "Content".toCharArray();
        int offset = -1;
        int len = buffer.length;
        boolean isCData = false;
        assertThrows(XMLStreamException.class, () -> {
            prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, buffer, offset, len, isCData);
        });
    }

    @Test
    public void testWriteLeafElementWithInvalidLength() {
        String nsURI = "http://example.com/namespace";
        String localName = "element";
        char[] buffer = "Content".toCharArray();
        int offset = 0;
        // Invalid length
        int len = buffer.length + 1;
        boolean isCData = false;
        assertThrows(XMLStreamException.class, () -> {
            prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, buffer, offset, len, isCData);
        });
    }
}

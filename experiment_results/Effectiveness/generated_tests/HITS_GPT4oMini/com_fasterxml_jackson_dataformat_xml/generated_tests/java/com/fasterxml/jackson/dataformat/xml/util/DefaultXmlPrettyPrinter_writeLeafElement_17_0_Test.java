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

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 mockWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        mockWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_WithCData() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        char[] buffer = "CData content".toCharArray();
        int offset = 0;
        int len = buffer.length;
        boolean isCData = true;
        prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCData(buffer, offset, len);
        verify(mockWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_WithoutCData() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        char[] buffer = "Regular content".toCharArray();
        int offset = 0;
        int len = buffer.length;
        boolean isCData = false;
        prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCharacters(buffer, offset, len);
        verify(mockWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_WithEmptyBuffer() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "emptyElement";
        char[] buffer = new char[0];
        int offset = 0;
        int len = 0;
        boolean isCData = false;
        prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeEndElement();
        verify(mockWriter, never()).writeCharacters(any(), anyInt(), anyInt());
    }

    @Test
    public void testWriteLeafElement_WithNullWriter() {
        assertThrows(NullPointerException.class, () -> {
            prettyPrinter.writeLeafElement(null, "nsURI", "localName", new char[] {}, 0, 0, false);
        });
    }

    @Test
    public void testWriteLeafElement_WithNullLocalName() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        char[] buffer = "Content".toCharArray();
        int offset = 0;
        int len = buffer.length;
        boolean isCData = false;
        assertThrows(XMLStreamException.class, () -> {
            prettyPrinter.writeLeafElement(mockWriter, nsURI, null, buffer, offset, len, isCData);
        });
    }
}

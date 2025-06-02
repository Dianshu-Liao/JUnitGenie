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

    private XMLStreamWriter2 mockWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        mockWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_CData() throws XMLStreamException {
        String nsURI = "http://example.com";
        String localName = "example";
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
    public void testWriteLeafElement_RegularContent() throws XMLStreamException {
        String nsURI = "http://example.com";
        String localName = "example";
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
    public void testWriteLeafElement_EmptyBuffer() throws XMLStreamException {
        String nsURI = "http://example.com";
        String localName = "example";
        char[] buffer = "".toCharArray();
        int offset = 0;
        int len = 0;
        boolean isCData = false;
        prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCharacters(buffer, offset, len);
        verify(mockWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_NegativeLength() {
        String nsURI = "http://example.com";
        String localName = "example";
        char[] buffer = "Content".toCharArray();
        int offset = 0;
        int len = -1;
        boolean isCData = false;
        assertThrows(XMLStreamException.class, () -> {
            prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, buffer, offset, len, isCData);
        });
    }
}

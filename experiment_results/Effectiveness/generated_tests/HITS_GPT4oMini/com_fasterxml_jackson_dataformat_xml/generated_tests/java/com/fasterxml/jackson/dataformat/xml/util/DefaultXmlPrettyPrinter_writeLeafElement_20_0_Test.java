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

public class DefaultXmlPrettyPrinter_writeLeafElement_20_0_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_WithValidInputs() throws XMLStreamException {
        String nsURI = "http://example.com";
        String localName = "exampleElement";
        long value = 12345L;
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeLong(value);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_WithZeroValue() throws XMLStreamException {
        String nsURI = "http://example.com";
        String localName = "zeroValueElement";
        long value = 0L;
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeLong(value);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_WithNegativeValue() throws XMLStreamException {
        String nsURI = "http://example.com";
        String localName = "negativeValueElement";
        long value = -12345L;
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeLong(value);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_WithNullNamespaceURI() throws XMLStreamException {
        String nsURI = null;
        String localName = "nullNamespaceElement";
        long value = 67890L;
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeLong(value);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_WithEmptyLocalName() throws XMLStreamException {
        String nsURI = "http://example.com";
        String localName = "";
        long value = 54321L;
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeLong(value);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_ThrowsXMLStreamException() throws XMLStreamException {
        String nsURI = "http://example.com";
        String localName = "exceptionElement";
        long value = 99999L;
        doThrow(new XMLStreamException("Mock exception")).when(xmlStreamWriter).writeStartElement(nsURI, localName);
        assertThrows(XMLStreamException.class, () -> {
            prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        });
    }
}

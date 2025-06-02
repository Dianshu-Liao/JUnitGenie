package com.fasterxml.jackson.dataformat.xml.util;

import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import java.io.StringWriter;
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

public class DefaultXmlPrettyPrinter_writeLeafElement_21_0_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 mockWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        mockWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_WithValidParameters() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        double value = 123.45;
        // Call the method under test
        prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, value);
        // Verify the interactions with the mock
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeDouble(value);
        verify(mockWriter).writeEndElement();
        verifyNoMoreInteractions(mockWriter);
    }

    @Test
    public void testWriteLeafElement_WithZeroValue() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "zeroElement";
        double value = 0.0;
        // Call the method under test
        prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, value);
        // Verify the interactions with the mock
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeDouble(value);
        verify(mockWriter).writeEndElement();
        verifyNoMoreInteractions(mockWriter);
    }

    @Test
    public void testWriteLeafElement_WithNegativeValue() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "negativeElement";
        double value = -123.45;
        // Call the method under test
        prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, value);
        // Verify the interactions with the mock
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeDouble(value);
        verify(mockWriter).writeEndElement();
        verifyNoMoreInteractions(mockWriter);
    }

    @Test
    public void testWriteLeafElement_WithSpecialValue() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "specialElement";
        double value = Double.NaN;
        // Call the method under test
        prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, value);
        // Verify the interactions with the mock
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeDouble(value);
        verify(mockWriter).writeEndElement();
        verifyNoMoreInteractions(mockWriter);
    }

    @Test
    public void testWriteLeafElement_WithInfinityValue() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "infinityElement";
        double value = Double.POSITIVE_INFINITY;
        // Call the method under test
        prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, value);
        // Verify the interactions with the mock
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeDouble(value);
        verify(mockWriter).writeEndElement();
        verifyNoMoreInteractions(mockWriter);
    }
}

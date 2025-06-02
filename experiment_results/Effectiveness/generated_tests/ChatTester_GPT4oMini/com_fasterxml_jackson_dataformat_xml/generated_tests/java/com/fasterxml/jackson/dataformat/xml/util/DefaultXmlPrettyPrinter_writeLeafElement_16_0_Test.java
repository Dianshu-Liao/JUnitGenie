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

class DefaultXmlPrettyPrinter_writeLeafElement_16_0_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 mockWriter;

    @BeforeEach
    void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        mockWriter = Mockito.mock(XMLStreamWriter2.class);
    }

    @Test
    void testWriteLeafElement_WithCData() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "element";
        String text = "some text";
        boolean isCData = true;
        // Mock the behavior of the indenter
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(false);
        prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, text, isCData);
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCData(text);
        verify(mockWriter).writeEndElement();
        assertFalse(prettyPrinter._justHadStartElement);
    }

    @Test
    void testWriteLeafElement_WithoutCData() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "element";
        String text = "some text";
        boolean isCData = false;
        // Mock the behavior of the indenter
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(false);
        prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, text, isCData);
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCharacters(text);
        verify(mockWriter).writeEndElement();
        assertFalse(prettyPrinter._justHadStartElement);
    }

    @Test
    void testWriteLeafElement_WithInlineIndenter() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "element";
        String text = "some text";
        boolean isCData = false;
        // Mock the behavior of the indenter
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(true);
        prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, text, isCData);
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCharacters(text);
        verify(mockWriter).writeEndElement();
        assertFalse(prettyPrinter._justHadStartElement);
    }
}

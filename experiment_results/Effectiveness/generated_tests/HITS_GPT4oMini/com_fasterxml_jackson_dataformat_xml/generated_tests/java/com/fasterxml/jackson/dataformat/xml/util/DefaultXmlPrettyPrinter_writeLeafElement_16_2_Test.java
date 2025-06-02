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

public class DefaultXmlPrettyPrinter_writeLeafElement_16_2_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 mockWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        mockWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElementWithCData() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "element";
        String text = "This is CDATA text.";
        boolean isCData = true;
        prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, text, isCData);
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCData(text);
        verify(mockWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElementWithoutCData() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "element";
        String text = "This is normal text.";
        boolean isCData = false;
        prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, text, isCData);
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCharacters(text);
        verify(mockWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElementWithEmptyText() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "element";
        String text = "";
        boolean isCData = false;
        prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, text, isCData);
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCharacters(text);
        verify(mockWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElementWithNullText() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "element";
        String text = null;
        boolean isCData = false;
        prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, text, isCData);
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeCharacters(null);
        verify(mockWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElementWithDifferentNamespaces() throws XMLStreamException {
        String nsURI1 = "http://example.com/ns1";
        String localName1 = "element1";
        String text1 = "Text for element1.";
        boolean isCData1 = false;
        String nsURI2 = "http://example.com/ns2";
        String localName2 = "element2";
        String text2 = "Text for element2.";
        boolean isCData2 = true;
        prettyPrinter.writeLeafElement(mockWriter, nsURI1, localName1, text1, isCData1);
        prettyPrinter.writeLeafElement(mockWriter, nsURI2, localName2, text2, isCData2);
        verify(mockWriter, times(2)).writeStartElement(anyString(), anyString());
        verify(mockWriter, times(1)).writeCharacters(text1);
        verify(mockWriter, times(1)).writeCData(text2);
        verify(mockWriter, times(2)).writeEndElement();
    }
}

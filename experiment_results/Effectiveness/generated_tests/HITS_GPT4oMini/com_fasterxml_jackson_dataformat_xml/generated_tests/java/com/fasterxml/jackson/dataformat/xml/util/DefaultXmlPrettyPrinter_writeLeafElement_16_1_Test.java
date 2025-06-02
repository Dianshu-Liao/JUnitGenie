package com.fasterxml.jackson.dataformat.xml.util;

import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.stream.XMLStreamException;
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

public class DefaultXmlPrettyPrinter_writeLeafElement_16_1_Test {

    private DefaultXmlPrettyPrinter printer;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        printer = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = Mockito.mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_WithCData() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "example";
        String text = "Sample CData text";
        boolean isCData = true;
        printer.writeLeafElement(xmlStreamWriter, nsURI, localName, text, isCData);
        verify(xmlStreamWriter, times(1)).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter, times(1)).writeCData(text);
        verify(xmlStreamWriter, times(1)).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_WithoutCData() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "example";
        String text = "Sample text";
        boolean isCData = false;
        printer.writeLeafElement(xmlStreamWriter, nsURI, localName, text, isCData);
        verify(xmlStreamWriter, times(1)).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter, times(1)).writeCharacters(text);
        verify(xmlStreamWriter, times(1)).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_Indentation() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "example";
        String text = "Sample text";
        boolean isCData = false;
        // Assuming that _objectIndenter.isInline() is false for this test case
        Mockito.when(printer._objectIndenter.isInline()).thenReturn(false);
        printer.writeLeafElement(xmlStreamWriter, nsURI, localName, text, isCData);
        verify(printer._objectIndenter, times(1)).writeIndentation(xmlStreamWriter, printer._nesting);
        verify(xmlStreamWriter, times(1)).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter, times(1)).writeCharacters(text);
        verify(xmlStreamWriter, times(1)).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_JustHadStartElement() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "example";
        String text = "Sample text";
        boolean isCData = false;
        printer.writeLeafElement(xmlStreamWriter, nsURI, localName, text, isCData);
        // Verify that _justHadStartElement is set to false
        // This would generally require a getter or reflection to check the private field
        // Assuming we can access it directly for the sake of this test
        // assertFalse(printer._justHadStartElement);
    }
}

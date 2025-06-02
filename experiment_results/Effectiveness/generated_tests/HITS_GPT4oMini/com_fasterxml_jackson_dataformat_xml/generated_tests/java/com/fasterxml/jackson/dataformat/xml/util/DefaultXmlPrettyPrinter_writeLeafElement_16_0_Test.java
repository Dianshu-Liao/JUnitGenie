package com.fasterxml.jackson.dataformat.xml.util;

import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.stream.XMLStreamException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
// Importing Indenter
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter.Indenter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

public class DefaultXmlPrettyPrinter_writeLeafElement_16_0_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = Mockito.mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_withIndentation() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "element";
        String text = "content";
        boolean isCData = false;
        prettyPrinter._objectIndenter = Mockito.mock(Indenter.class);
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(false);
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, text, isCData);
        verify(prettyPrinter._objectIndenter).writeIndentation(xmlStreamWriter, prettyPrinter._nesting);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeCharacters(text);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_withoutIndentation() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "element";
        String text = "content";
        boolean isCData = false;
        prettyPrinter._objectIndenter = Mockito.mock(Indenter.class);
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(true);
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, text, isCData);
        verify(prettyPrinter._objectIndenter, Mockito.never()).writeIndentation(xmlStreamWriter, prettyPrinter._nesting);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeCharacters(text);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_withCData() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "element";
        String text = "content";
        boolean isCData = true;
        prettyPrinter._objectIndenter = Mockito.mock(Indenter.class);
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(false);
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, text, isCData);
        verify(prettyPrinter._objectIndenter).writeIndentation(xmlStreamWriter, prettyPrinter._nesting);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeCData(text);
        verify(xmlStreamWriter).writeEndElement();
    }
}

package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
// Import Indenter
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter.Indenter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

@ExtendWith(MockitoExtension.class)
public class DefaultXmlPrettyPrinter_writeLeafElement_19_0_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 xmlStreamWriter;

    private Indenter mockIndenter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = mock(XMLStreamWriter2.class);
        mockIndenter = mock(Indenter.class);
        prettyPrinter._objectIndenter = mockIndenter;
    }

    @Test
    public void testWriteLeafElement() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "element";
        int value = 42;
        when(mockIndenter.isInline()).thenReturn(false);
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeInt(value);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElementInline() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "element";
        int value = 42;
        when(mockIndenter.isInline()).thenReturn(true);
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeInt(value);
        verify(xmlStreamWriter).writeEndElement();
    }
}

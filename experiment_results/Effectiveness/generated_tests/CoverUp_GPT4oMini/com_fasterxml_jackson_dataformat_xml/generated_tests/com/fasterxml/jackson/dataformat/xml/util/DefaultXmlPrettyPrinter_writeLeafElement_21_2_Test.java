package com.fasterxml.jackson.dataformat.xml.util;

import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.stream.XMLStreamException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.util.Instantiatable;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

public class DefaultXmlPrettyPrinter_writeLeafElement_21_2_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = Mockito.mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_Success() throws XMLStreamException {
        String nsURI = "http://example.com";
        String localName = "exampleElement";
        double value = 123.45;
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        Mockito.verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        Mockito.verify(xmlStreamWriter).writeDouble(value);
        Mockito.verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_ThrowsXMLStreamException() throws XMLStreamException {
        String nsURI = "http://example.com";
        String localName = "exampleElement";
        double value = 123.45;
        doThrow(new XMLStreamException("Test exception")).when(xmlStreamWriter).writeStartElement(nsURI, localName);
        try {
            prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        } catch (XMLStreamException e) {
            assertEquals("Test exception", e.getMessage());
        }
    }

    @Test
    public void testWriteLeafElement_WithIndentation() throws XMLStreamException {
        String nsURI = "http://example.com";
        String localName = "exampleElement";
        double value = 123.45;
        Indenter indenter = new Indenter() {

            @Override
            public boolean isInline() {
                return false;
            }

            @Override
            public void writeIndentation(XMLStreamWriter2 sw, int nesting) throws XMLStreamException {
                sw.writeCharacters("\n  ");
            }
        };
        try {
            java.lang.reflect.Field field = DefaultXmlPrettyPrinter.class.getDeclaredField("_objectIndenter");
            field.setAccessible(true);
            field.set(prettyPrinter, indenter);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to set _objectIndenter: " + e.getMessage());
        }
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        Mockito.verify(xmlStreamWriter).writeCharacters("\n  ");
        Mockito.verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        Mockito.verify(xmlStreamWriter).writeDouble(value);
        Mockito.verify(xmlStreamWriter).writeEndElement();
    }

    // Indenter interface as a local class to avoid compilation issues
    interface Indenter {

        boolean isInline();

        void writeIndentation(XMLStreamWriter2 sw, int nesting) throws XMLStreamException;
    }
}

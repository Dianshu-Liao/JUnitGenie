package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

class DefaultXmlPrettyPrinter_writeLeafElement_16_2_Test {

    private DefaultXmlPrettyPrinter printer;

    private XMLStreamWriter2 writer;

    @BeforeEach
    void setUp() {
        printer = new DefaultXmlPrettyPrinter();
        writer = mock(XMLStreamWriter2.class);
    }

    @Test
    void testWriteLeafElement_withCData() throws XMLStreamException {
        String nsURI = "http://example.com";
        String localName = "exampleElement";
        String text = "exampleCDataText";
        boolean isCData = true;
        printer.writeLeafElement(writer, nsURI, localName, text, isCData);
        verify(writer).writeStartElement(nsURI, localName);
        verify(writer).writeCData(text);
        verify(writer).writeEndElement();
    }

    @Test
    void testWriteLeafElement_withoutCData() throws XMLStreamException {
        String nsURI = "http://example.com";
        String localName = "exampleElement";
        String text = "exampleText";
        boolean isCData = false;
        printer.writeLeafElement(writer, nsURI, localName, text, isCData);
        verify(writer).writeStartElement(nsURI, localName);
        verify(writer).writeCharacters(text);
        verify(writer).writeEndElement();
    }

    @Test
    void testWriteLeafElement_withIndentation() throws XMLStreamException, Exception {
        // Mocking the Indenter behavior
        Class<?> indenterClass = Class.forName("com.fasterxml.jackson.dataformat.xml.util.Indenter");
        Object mockIndenter = mock(indenterClass);
        when(mockIndenter.getClass().getMethod("isInline").invoke(mockIndenter)).thenReturn(false);
        // Using reflection to set the private field _objectIndenter
        java.lang.reflect.Field objectIndenterField = DefaultXmlPrettyPrinter.class.getDeclaredField("_objectIndenter");
        objectIndenterField.setAccessible(true);
        objectIndenterField.set(printer, mockIndenter);
        String nsURI = "http://example.com";
        String localName = "exampleElement";
        String text = "exampleText";
        boolean isCData = false;
        printer.writeLeafElement(writer, nsURI, localName, text, isCData);
        verify(mockIndenter).getClass().getMethod("writeIndentation", XMLStreamWriter2.class, int.class).invoke(mockIndenter, writer, printer._nesting);
        verify(writer).writeStartElement(nsURI, localName);
        verify(writer).writeCharacters(text);
        verify(writer).writeEndElement();
    }
}

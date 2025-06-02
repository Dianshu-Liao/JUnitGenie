package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
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

@ExtendWith(MockitoExtension.class)
public class DefaultXmlPrettyPrinter_writeLeafElement_16_4_Test {

    private DefaultXmlPrettyPrinter printer;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        printer = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElementWithCData() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        String text = "example text";
        boolean isCData = true;
        printer.writeLeafElement(xmlStreamWriter, nsURI, localName, text, isCData);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeCData(text);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElementWithoutCData() throws XMLStreamException {
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        String text = "example text";
        boolean isCData = false;
        printer.writeLeafElement(xmlStreamWriter, nsURI, localName, text, isCData);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeCharacters(text);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElementWithIndentation() throws XMLStreamException, NoSuchFieldException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        // Set the _objectIndenter to a state that requires indentation
        Class<?> indenterClass = Class.forName("com.fasterxml.jackson.dataformat.xml.util.Indenter");
        Object mockIndenter = mock(indenterClass);
        when((Boolean) indenterClass.getMethod("isInline").invoke(mockIndenter)).thenReturn(false);
        Field indenterField = DefaultXmlPrettyPrinter.class.getDeclaredField("_objectIndenter");
        indenterField.setAccessible(true);
        indenterField.set(printer, mockIndenter);
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        String text = "example text";
        boolean isCData = false;
        printer.writeLeafElement(xmlStreamWriter, nsURI, localName, text, isCData);
        indenterClass.getMethod("writeIndentation", XMLStreamWriter2.class, int.class).invoke(mockIndenter, xmlStreamWriter, printer._nesting);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeCharacters(text);
        verify(xmlStreamWriter).writeEndElement();
    }
}

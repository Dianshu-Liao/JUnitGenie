package com.fasterxml.jackson.dataformat.xml.util;

import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.stream.XMLStreamException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import java.io.IOException;
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

public class DefaultXmlPrettyPrinter_writeLeafElement_22_2_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = Mockito.mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement() throws XMLStreamException {
        String namespace = "http://example.com/ns";
        String localName = "exampleElement";
        float value = 123.45f;
        // Mock the behavior of XMLStreamWriter2
        Mockito.doNothing().when(xmlStreamWriter).writeStartElement(namespace, localName);
        Mockito.doNothing().when(xmlStreamWriter).writeFloat(value);
        Mockito.doNothing().when(xmlStreamWriter).writeEndElement();
        // Call the method under test
        prettyPrinter.writeLeafElement(xmlStreamWriter, namespace, localName, value);
        // Verify interactions with the mock
        Mockito.verify(xmlStreamWriter).writeStartElement(namespace, localName);
        Mockito.verify(xmlStreamWriter).writeFloat(value);
        Mockito.verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElementWithIndentation() throws XMLStreamException, NoSuchFieldException, IllegalAccessException {
        String namespace = "http://example.com/ns";
        String localName = "exampleElement";
        float value = 123.45f;
        // Set the objectIndenter to be inline for this test using reflection
        Indenter indenter = new Indenter() {

            @Override
            public boolean isInline() {
                return false;
            }

            @Override
            public void writeIndentation(XMLStreamWriter2 sw, int nesting) throws XMLStreamException {
                // Simulate indentation
                sw.writeCharacters("\n  ");
            }
        };
        Field objectIndenterField = DefaultXmlPrettyPrinter.class.getDeclaredField("_objectIndenter");
        objectIndenterField.setAccessible(true);
        objectIndenterField.set(prettyPrinter, indenter);
        // Mock the behavior of XMLStreamWriter2
        Mockito.doNothing().when(xmlStreamWriter).writeStartElement(namespace, localName);
        Mockito.doNothing().when(xmlStreamWriter).writeFloat(value);
        Mockito.doNothing().when(xmlStreamWriter).writeEndElement();
        // Call the method under test
        prettyPrinter.writeLeafElement(xmlStreamWriter, namespace, localName, value);
        // Verify interactions with the mock
        Mockito.verify(xmlStreamWriter).writeStartElement(namespace, localName);
        Mockito.verify(xmlStreamWriter).writeFloat(value);
        Mockito.verify(xmlStreamWriter).writeEndElement();
    }

    // Define the Indenter interface to avoid compilation errors
    interface Indenter {

        boolean isInline();

        void writeIndentation(XMLStreamWriter2 sw, int nesting) throws XMLStreamException;
    }
}

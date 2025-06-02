package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

public class DefaultXmlPrettyPrinter_writeLeafElement_19_0_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_WithIndentation() throws XMLStreamException, NoSuchFieldException, IllegalAccessException {
        // Arrange
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
        setPrivateField(prettyPrinter, "_objectIndenter", indenter);
        String nsURI = "http://example.com";
        String localName = "testElement";
        int value = 42;
        // Act
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        // Assert
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeInt(value);
        verify(xmlStreamWriter).writeEndElement();
        assertFalse(getPrivateField(prettyPrinter, "_justHadStartElement"));
    }

    @Test
    public void testWriteLeafElement_WithoutIndentation() throws XMLStreamException, NoSuchFieldException, IllegalAccessException {
        // Arrange
        Indenter indenter = new Indenter() {

            @Override
            public boolean isInline() {
                return true;
            }

            @Override
            public void writeIndentation(XMLStreamWriter2 sw, int nesting) throws XMLStreamException {
                // No indentation to write
            }
        };
        setPrivateField(prettyPrinter, "_objectIndenter", indenter);
        String nsURI = "http://example.com";
        String localName = "testElement";
        int value = 42;
        // Act
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        // Assert
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeInt(value);
        verify(xmlStreamWriter).writeEndElement();
        assertFalse(getPrivateField(prettyPrinter, "_justHadStartElement"));
    }

    private void setPrivateField(Object object, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(object, value);
    }

    private boolean getPrivateField(Object object, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.getBoolean(object);
    }

    // Add a simple Indenter interface to resolve the compilation error
    interface Indenter {

        boolean isInline();

        void writeIndentation(XMLStreamWriter2 sw, int nesting) throws XMLStreamException;
    }
}

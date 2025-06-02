package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
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

class DefaultXmlPrettyPrinter_writeLeafElement_22_1_Test {

    private DefaultXmlPrettyPrinter printer;

    private XMLStreamWriter2 writer;

    @BeforeEach
    void setUp() {
        printer = new DefaultXmlPrettyPrinter();
        writer = mock(XMLStreamWriter2.class);
    }

    @Test
    void testWriteLeafElement_WithIndentation() throws XMLStreamException, NoSuchFieldException, IllegalAccessException {
        // Arrange
        String nsURI = "http://example.com";
        String localName = "exampleElement";
        float value = 1.23f;
        // Mocking _objectIndenter to simulate not inline
        Indenter mockIndenter = mock(Indenter.class);
        when(mockIndenter.isInline()).thenReturn(false);
        setField(printer, "_objectIndenter", mockIndenter);
        // Act
        printer.writeLeafElement(writer, nsURI, localName, value);
        // Assert
        verify(mockIndenter).writeIndentation(writer, 0);
        verify(writer).writeStartElement(nsURI, localName);
        verify(writer).writeFloat(value);
        verify(writer).writeEndElement();
    }

    @Test
    void testWriteLeafElement_WithoutIndentation() throws XMLStreamException, NoSuchFieldException, IllegalAccessException {
        // Arrange
        String nsURI = "http://example.com";
        String localName = "exampleElement";
        float value = 4.56f;
        // Mocking _objectIndenter to simulate inline
        Indenter mockIndenter = mock(Indenter.class);
        when(mockIndenter.isInline()).thenReturn(true);
        setField(printer, "_objectIndenter", mockIndenter);
        // Act
        printer.writeLeafElement(writer, nsURI, localName, value);
        // Assert
        verify(mockIndenter, never()).writeIndentation(any(), anyInt());
        verify(writer).writeStartElement(nsURI, localName);
        verify(writer).writeFloat(value);
        verify(writer).writeEndElement();
    }

    private void setField(DefaultXmlPrettyPrinter printer, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field field = DefaultXmlPrettyPrinter.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(printer, value);
    }

    // Mocking the Indenter class
    private static class Indenter {

        public boolean isInline() {
            return false;
        }

        public void writeIndentation(XMLStreamWriter2 writer, int nesting) throws XMLStreamException {
            // Implementation for indentation
        }
    }

    private static class FixedSpaceIndenter extends Indenter {
        // Implementation specific to FixedSpaceIndenter
    }

    private static class Lf2SpacesIndenter extends Indenter {
        // Implementation specific to Lf2SpacesIndenter
    }
}

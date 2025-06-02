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

@ExtendWith(MockitoExtension.class)
class DefaultXmlPrettyPrinter_writeLeafElement_20_2_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    void testWriteLeafElement_withIndentation() throws XMLStreamException, NoSuchFieldException, IllegalAccessException {
        // Arrange
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        long value = 12345L;
        // Mock the behavior of _objectIndenter
        Indenter objectIndenter = mock(Indenter.class);
        when(objectIndenter.isInline()).thenReturn(false);
        setPrivateField(prettyPrinter, "_objectIndenter", objectIndenter);
        // Act
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        // Assert
        verify(objectIndenter).writeIndentation(xmlStreamWriter, prettyPrinter._nesting);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeLong(value);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    void testWriteLeafElement_withoutIndentation() throws XMLStreamException, NoSuchFieldException, IllegalAccessException {
        // Arrange
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        long value = 12345L;
        // Mock the behavior of _objectIndenter
        Indenter objectIndenter = mock(Indenter.class);
        when(objectIndenter.isInline()).thenReturn(true);
        setPrivateField(prettyPrinter, "_objectIndenter", objectIndenter);
        // Act
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        // Assert
        verify(objectIndenter, never()).writeIndentation(any(), anyInt());
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeLong(value);
        verify(xmlStreamWriter).writeEndElement();
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    // Mock Indenter class for testing
    private static class Indenter {

        public boolean isInline() {
            return false;
        }

        public void writeIndentation(XMLStreamWriter2 sw, int nesting) throws XMLStreamException {
            // Mock implementation
        }
    }

    private static class FixedSpaceIndenter extends Indenter {
        // Implementation details for FixedSpaceIndenter
    }

    private static class Lf2SpacesIndenter extends Indenter {
        // Implementation details for Lf2SpacesIndenter
    }
}

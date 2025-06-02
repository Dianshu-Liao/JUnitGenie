package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.lang.reflect.Field;
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

public class DefaultXmlPrettyPrinter_writeLeafElement_16_1_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_CData() throws Exception {
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        String text = "example text";
        boolean isCData = true;
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, text, isCData);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeCData(text);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_RegularText() throws Exception {
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        String text = "example text";
        boolean isCData = false;
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, text, isCData);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeCharacters(text);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_WithIndentation() throws Exception {
        // Set _objectIndenter to inline for testing indentation
        Indenter mockIndenter = mock(Indenter.class);
        when(mockIndenter.isInline()).thenReturn(false);
        setPrivateField(prettyPrinter, "_objectIndenter", mockIndenter);
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        String text = "example text";
        boolean isCData = false;
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, text, isCData);
        verify(mockIndenter).writeIndentation(xmlStreamWriter, prettyPrinter._nesting);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeCharacters(text);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_EmptyText() throws Exception {
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        String text = "";
        boolean isCData = false;
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, text, isCData);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeCharacters(text);
        verify(xmlStreamWriter).writeEndElement();
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }

    // Assuming Indenter is an interface in the same package
    interface Indenter {

        boolean isInline();

        void writeIndentation(XMLStreamWriter2 sw, int nesting) throws XMLStreamException;
    }

    // Assuming FixedSpaceIndenter and Lf2SpacesIndenter are defined elsewhere in the same package
    class FixedSpaceIndenter implements Indenter {

        @Override
        public boolean isInline() {
            return false;
        }

        @Override
        public void writeIndentation(XMLStreamWriter2 sw, int nesting) throws XMLStreamException {
            // Implementation here
        }
    }

    class Lf2SpacesIndenter implements Indenter {

        @Override
        public boolean isInline() {
            return false;
        }

        @Override
        public void writeIndentation(XMLStreamWriter2 sw, int nesting) throws XMLStreamException {
            // Implementation here
        }
    }
}

package com.fasterxml.jackson.dataformat.xml.util;

import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.stream.XMLStreamException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
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
class DefaultXmlPrettyPrinter_writeLeafElement_22_0_Test {

    private DefaultXmlPrettyPrinter printer;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    void setUp() {
        printer = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    void testWriteLeafElement_WithIndentation() throws Exception {
        // Arrange
        when(printer._objectIndenter.isInline()).thenReturn(false);
        float value = 1.5f;
        String nsURI = "http://example.com";
        String localName = "exampleElement";
        // Act
        invokeWriteLeafElement(printer, xmlStreamWriter, nsURI, localName, value);
        // Assert
        verify(printer._objectIndenter, times(1)).writeIndentation(any(XMLStreamWriter2.class), anyInt());
        verify(xmlStreamWriter, times(1)).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter, times(1)).writeFloat(value);
        verify(xmlStreamWriter, times(1)).writeEndElement();
        assertFalse(printer._justHadStartElement);
    }

    @Test
    void testWriteLeafElement_WithoutIndentation() throws Exception {
        // Arrange
        when(printer._objectIndenter.isInline()).thenReturn(true);
        float value = 2.5f;
        String nsURI = "http://example.com";
        String localName = "exampleElement";
        // Act
        invokeWriteLeafElement(printer, xmlStreamWriter, nsURI, localName, value);
        // Assert
        verify(printer._objectIndenter, never()).writeIndentation(any(XMLStreamWriter2.class), anyInt());
        verify(xmlStreamWriter, times(1)).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter, times(1)).writeFloat(value);
        verify(xmlStreamWriter, times(1)).writeEndElement();
        assertFalse(printer._justHadStartElement);
    }

    @Test
    void testWriteLeafElement_HandlesXMLStreamException() throws Exception {
        // Arrange
        float value = 3.5f;
        String nsURI = "http://example.com";
        String localName = "exampleElement";
        doThrow(new XMLStreamException("Test Exception")).when(xmlStreamWriter).writeStartElement(nsURI, localName);
        // Act & Assert
        try {
            invokeWriteLeafElement(printer, xmlStreamWriter, nsURI, localName, value);
        } catch (XMLStreamException e) {
            assertEquals("Test Exception", e.getMessage());
        }
        // Verify that the exception was thrown correctly
        verify(xmlStreamWriter, times(1)).writeStartElement(nsURI, localName);
    }

    private void invokeWriteLeafElement(DefaultXmlPrettyPrinter printer, XMLStreamWriter2 sw, String nsURI, String localName, float value) throws Exception {
        Method method = DefaultXmlPrettyPrinter.class.getDeclaredMethod("writeLeafElement", XMLStreamWriter2.class, String.class, String.class, float.class);
        method.setAccessible(true);
        method.invoke(printer, sw, nsURI, localName, value);
    }
}

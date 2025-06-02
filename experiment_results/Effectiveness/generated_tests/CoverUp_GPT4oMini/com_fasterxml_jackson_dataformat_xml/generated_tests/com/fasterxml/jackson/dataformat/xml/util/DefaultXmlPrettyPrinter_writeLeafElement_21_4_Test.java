package com.fasterxml.jackson.dataformat.xml.util;

import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.stream.XMLStreamException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

class DefaultXmlPrettyPrinter_writeLeafElement_21_4_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    void testWriteLeafElement_WithInlineObjectIndenter() throws Exception {
        // Arrange
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(true);
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        double value = 123.45;
        // Act
        invokeWriteLeafElement(nsURI, localName, value);
        // Assert
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeDouble(value);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    void testWriteLeafElement_WithoutInlineObjectIndenter() throws Exception {
        // Arrange
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(false);
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        double value = 123.45;
        // Act
        invokeWriteLeafElement(nsURI, localName, value);
        // Assert
        verify(prettyPrinter._objectIndenter).writeIndentation(xmlStreamWriter, prettyPrinter._nesting);
        verify(xmlStreamWriter).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter).writeDouble(value);
        verify(xmlStreamWriter).writeEndElement();
    }

    private void invokeWriteLeafElement(String nsURI, String localName, double value) throws Exception {
        Method method = DefaultXmlPrettyPrinter.class.getDeclaredMethod("writeLeafElement", XMLStreamWriter2.class, String.class, String.class, double.class);
        method.setAccessible(true);
        method.invoke(prettyPrinter, xmlStreamWriter, nsURI, localName, value);
    }
}

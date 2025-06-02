package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
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
public class DefaultXmlPrettyPrinter_writeLeafElement_18_2_Test {

    private DefaultXmlPrettyPrinter printer;

    private XMLStreamWriter2 mockWriter;

    @BeforeEach
    public void setUp() {
        printer = new DefaultXmlPrettyPrinter();
        mockWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_WithIndentation() throws XMLStreamException, Exception {
        // Arrange
        when(printer._objectIndenter.isInline()).thenReturn(false);
        // Act
        invokeWriteLeafElement(mockWriter, "http://example.com", "testElement", true);
        // Assert
        verify(printer._objectIndenter).writeIndentation(mockWriter, printer._nesting);
        verify(mockWriter).writeStartElement("http://example.com", "testElement");
        verify(mockWriter).writeBoolean(true);
        verify(mockWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_WithoutIndentation() throws XMLStreamException, Exception {
        // Arrange
        when(printer._objectIndenter.isInline()).thenReturn(true);
        // Act
        invokeWriteLeafElement(mockWriter, "http://example.com", "testElement", false);
        // Assert
        verify(mockWriter).writeStartElement("http://example.com", "testElement");
        verify(mockWriter).writeBoolean(false);
        verify(mockWriter).writeEndElement();
        verify(printer._objectIndenter, never()).writeIndentation(any(XMLStreamWriter2.class), anyInt());
    }

    @Test
    public void testWriteLeafElement_JustHadStartElement() throws XMLStreamException, Exception {
        // Arrange
        when(printer._objectIndenter.isInline()).thenReturn(false);
        // Act
        invokeWriteLeafElement(mockWriter, "http://example.com", "testElement", true);
        // Assert
        assertFalse(printer._justHadStartElement);
    }

    private void invokeWriteLeafElement(XMLStreamWriter2 sw, String nsURI, String localName, boolean value) throws Exception {
        Method method = DefaultXmlPrettyPrinter.class.getDeclaredMethod("writeLeafElement", XMLStreamWriter2.class, String.class, String.class, boolean.class);
        method.setAccessible(true);
        method.invoke(printer, sw, nsURI, localName, value);
    }
}

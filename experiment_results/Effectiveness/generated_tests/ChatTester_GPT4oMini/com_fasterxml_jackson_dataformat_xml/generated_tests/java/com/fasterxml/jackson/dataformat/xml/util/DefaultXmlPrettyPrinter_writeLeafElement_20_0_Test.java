// Test method
package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.lang.reflect.Method;
import static org.mockito.ArgumentMatchers.any;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import org.codehaus.stax2.XMLStreamWriter2;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

public class DefaultXmlPrettyPrinter_writeLeafElement_20_0_Test {

    private DefaultXmlPrettyPrinter printer;

    private XMLStreamWriter2 mockWriter;

    @BeforeEach
    public void setUp() {
        printer = new DefaultXmlPrettyPrinter();
        mockWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_WithIndentation() throws Exception {
        // Arrange
        when(printer._objectIndenter.isInline()).thenReturn(false);
        // Act
        invokeWriteLeafElement(printer, mockWriter, "http://example.com", "element", 12345L);
        // Assert
        verify(printer._objectIndenter).writeIndentation(mockWriter, printer._nesting);
        verify(mockWriter).writeStartElement("http://example.com", "element");
        verify(mockWriter).writeLong(12345L);
        verify(mockWriter).writeEndElement();
        // Check that _justHadStartElement is set to false
        assertFalse(printer._justHadStartElement);
    }

    @Test
    public void testWriteLeafElement_WithoutIndentation() throws Exception {
        // Arrange
        when(printer._objectIndenter.isInline()).thenReturn(true);
        // Act
        invokeWriteLeafElement(printer, mockWriter, "http://example.com", "element", 12345L);
        verify(printer._objectIndenter, never()).writeIndentation(any(XMLStreamWriter2.class), anyInt());
        verify(mockWriter).writeStartElement("http://example.com", "element");
        verify(mockWriter).writeLong(12345L);
        verify(mockWriter).writeEndElement();
        // Check that _justHadStartElement is set to false
        assertFalse(printer._justHadStartElement);
    }

    private void invokeWriteLeafElement(DefaultXmlPrettyPrinter printer, XMLStreamWriter2 sw, String nsURI, String localName, long value) throws Exception {
        Method method = DefaultXmlPrettyPrinter.class.getDeclaredMethod("writeLeafElement", XMLStreamWriter2.class, String.class, String.class, long.class);
        method.setAccessible(true);
        method.invoke(printer, sw, nsURI, localName, value);
    }
}

// Test method
package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
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

class DefaultXmlPrettyPrinter_writeLeafElement_21_0_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 mockWriter;

    @BeforeEach
    void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        mockWriter = Mockito.mock(XMLStreamWriter2.class);
    }

    @Test
    void testWriteLeafElement_WithIndentation() throws XMLStreamException {
        // Arrange
        prettyPrinter._nesting = 1;
        prettyPrinter._objectIndenter = mock(DefaultXmlPrettyPrinter.Indenter.class);
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(false);
        // Act
        prettyPrinter.writeLeafElement(mockWriter, "http://example.com", "element", 123.45);
        // Assert
        verify(prettyPrinter._objectIndenter).writeIndentation(mockWriter, 1);
        verify(mockWriter).writeStartElement("http://example.com", "element");
        verify(mockWriter).writeDouble(123.45);
        verify(mockWriter).writeEndElement();
        assertFalse(prettyPrinter._justHadStartElement);
    }

    @Test
    void testWriteLeafElement_WithoutIndentation() throws XMLStreamException {
        // Arrange
        prettyPrinter._nesting = 0;
        prettyPrinter._objectIndenter = mock(DefaultXmlPrettyPrinter.Indenter.class);
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(true);
        // Act
        prettyPrinter.writeLeafElement(mockWriter, "http://example.com", "element", 678.90);
        // Fixed Line: Specify the correct method for writeIndentation
        verify(prettyPrinter._objectIndenter, never()).writeIndentation(mockWriter, anyInt());
        verify(mockWriter).writeStartElement("http://example.com", "element");
        verify(mockWriter).writeDouble(678.90);
        verify(mockWriter).writeEndElement();
        assertFalse(prettyPrinter._justHadStartElement);
    }
}

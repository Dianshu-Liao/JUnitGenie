package com.fasterxml.jackson.dataformat.xml.util;

import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
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

public class DefaultXmlPrettyPrinter_writeLeafElement_18_0_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 mockWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        mockWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_WithInlineIndenter() throws XMLStreamException {
        // Arrange
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(true);
        // Act
        prettyPrinter.writeLeafElement(mockWriter, "http://example.com", "testElement", true);
        // Assert
        verify(mockWriter).writeStartElement("http://example.com", "testElement");
        verify(mockWriter).writeBoolean(true);
        verify(mockWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_WithNonInlineIndenter() throws XMLStreamException {
        // Arrange
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(false);
        // Act
        prettyPrinter.writeLeafElement(mockWriter, "http://example.com", "testElement", false);
        // Assert
        verify(prettyPrinter._objectIndenter).writeIndentation(mockWriter, prettyPrinter._nesting);
        verify(mockWriter).writeStartElement("http://example.com", "testElement");
        verify(mockWriter).writeBoolean(false);
        verify(mockWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_SetJustHadStartElement() throws XMLStreamException {
        // Arrange
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(false);
        // Act
        prettyPrinter.writeLeafElement(mockWriter, "http://example.com", "testElement", true);
        // Assert
        assertFalse(prettyPrinter._justHadStartElement);
    }
}

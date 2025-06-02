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

public class DefaultXmlPrettyPrinter_writeLeafElement_22_1_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 mockWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        mockWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_withIndentation() throws XMLStreamException {
        // Arrange
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(false);
        // Act
        prettyPrinter.writeLeafElement(mockWriter, "http://example.com", "testElement", 3.14f);
        // Assert
        verify(prettyPrinter._objectIndenter).writeIndentation(mockWriter, prettyPrinter._nesting);
        verify(mockWriter).writeStartElement("http://example.com", "testElement");
        verify(mockWriter).writeFloat(3.14f);
        verify(mockWriter).writeEndElement();
        assertFalse(prettyPrinter._justHadStartElement);
    }

    @Test
    public void testWriteLeafElement_withoutIndentation() throws XMLStreamException {
        // Arrange
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(true);
        // Act
        prettyPrinter.writeLeafElement(mockWriter, "http://example.com", "testElement", 3.14f);
        // Fixed line: Use the correct method for the writer type
        verify(prettyPrinter._objectIndenter, never()).writeIndentation(any(XMLStreamWriter2.class), anyInt());
        verify(mockWriter).writeStartElement("http://example.com", "testElement");
        verify(mockWriter).writeFloat(3.14f);
        verify(mockWriter).writeEndElement();
        assertFalse(prettyPrinter._justHadStartElement);
    }
}

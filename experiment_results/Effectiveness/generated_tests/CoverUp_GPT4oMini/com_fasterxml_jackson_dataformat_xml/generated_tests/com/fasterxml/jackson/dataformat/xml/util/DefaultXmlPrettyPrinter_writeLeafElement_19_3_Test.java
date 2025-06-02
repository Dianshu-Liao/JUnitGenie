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

public class DefaultXmlPrettyPrinter_writeLeafElement_19_3_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 mockWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        mockWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_WithIndentation() throws XMLStreamException {
        // Arrange
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(false);
        int value = 42;
        String nsURI = "http://example.com/namespace";
        String localName = "exampleElement";
        // Act
        prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, value);
        // Assert
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeInt(value);
        verify(mockWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_WithoutIndentation() throws XMLStreamException {
        // Arrange
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(true);
        int value = 42;
        String nsURI = "http://example.com/namespace";
        String localName = "exampleElement";
        // Act
        prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, value);
        // Assert
        verify(mockWriter).writeStartElement(nsURI, localName);
        verify(mockWriter).writeInt(value);
        verify(mockWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_ExceptionHandling() throws XMLStreamException {
        // Arrange
        int value = 42;
        String nsURI = "http://example.com/namespace";
        String localName = "exampleElement";
        doThrow(new XMLStreamException("Test Exception")).when(mockWriter).writeStartElement(nsURI, localName);
        // Act & Assert
        assertThrows(XMLStreamException.class, () -> {
            prettyPrinter.writeLeafElement(mockWriter, nsURI, localName, value);
        });
    }
}

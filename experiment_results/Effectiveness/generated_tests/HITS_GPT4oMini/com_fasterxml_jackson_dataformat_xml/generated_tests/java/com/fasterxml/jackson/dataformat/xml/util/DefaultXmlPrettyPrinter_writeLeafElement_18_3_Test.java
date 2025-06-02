package com.fasterxml.jackson.dataformat.xml.util;

import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.stream.XMLStreamException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
// Import the Indenter class
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter.Indenter;
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

public class DefaultXmlPrettyPrinter_writeLeafElement_18_3_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = Mockito.mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_WhenInline_ShouldWriteStartElementAndBoolean() throws XMLStreamException {
        // Arrange
        String nsURI = "http://example.com/ns";
        String localName = "exampleElement";
        boolean value = true;
        // Mock inline behavior
        prettyPrinter._objectIndenter = Mockito.mock(Indenter.class);
        // Change to true for inline test
        Mockito.when(prettyPrinter._objectIndenter.isInline()).thenReturn(true);
        // Act
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        // Assert
        verify(xmlStreamWriter, times(1)).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter, times(1)).writeBoolean(value);
        verify(xmlStreamWriter, times(1)).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_WhenNotInline_ShouldIndentAndWriteElements() throws XMLStreamException {
        // Arrange
        String nsURI = "http://example.com/ns";
        String localName = "anotherElement";
        boolean value = false;
        // Mock indentation behavior
        prettyPrinter._objectIndenter = Mockito.mock(Indenter.class);
        Mockito.when(prettyPrinter._objectIndenter.isInline()).thenReturn(false);
        // Act
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        // Assert
        verify(prettyPrinter._objectIndenter, times(1)).writeIndentation(xmlStreamWriter, prettyPrinter._nesting);
        verify(xmlStreamWriter, times(1)).writeStartElement(nsURI, localName);
        verify(xmlStreamWriter, times(1)).writeBoolean(value);
        verify(xmlStreamWriter, times(1)).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_WhenCalled_ShouldSetJustHadStartElementToFalse() throws XMLStreamException {
        // Arrange
        String nsURI = "http://example.com/ns";
        String localName = "testElement";
        boolean value = true;
        // Act
        prettyPrinter.writeLeafElement(xmlStreamWriter, nsURI, localName, value);
        // Assert
        // Since _justHadStartElement is a protected member, we can use reflection to access it
        assertFalse(prettyPrinter._justHadStartElement);
    }
}

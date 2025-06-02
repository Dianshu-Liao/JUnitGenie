package com.fasterxml.jackson.dataformat.xml.util;

import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.stream.XMLStreamException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
// Importing Indenter class
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

public class DefaultXmlPrettyPrinter_writeEndElement_15_0_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = Mockito.mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteEndElement_WithJustHadStartElement() throws XMLStreamException {
        // Arrange
        prettyPrinter._justHadStartElement = true;
        // Act
        prettyPrinter.writeEndElement(xmlStreamWriter, 0);
        // Assert
        verify(xmlStreamWriter, times(1)).writeEndElement();
        // Ensure that _nesting is not decremented
        assertEquals(0, prettyPrinter._nesting);
    }

    @Test
    public void testWriteEndElement_WithNoJustHadStartElement() throws XMLStreamException {
        // Arrange
        prettyPrinter._justHadStartElement = false;
        // Set nesting to 1 for testing indentation
        prettyPrinter._nesting = 1;
        // Act
        prettyPrinter.writeEndElement(xmlStreamWriter, 0);
        // Assert
        verify(xmlStreamWriter, times(1)).writeEndElement();
        // Ensure that _nesting is decremented
        assertEquals(0, prettyPrinter._nesting);
    }

    @Test
    public void testWriteEndElement_WithInlineIndenter() throws XMLStreamException {
        // Arrange
        prettyPrinter._objectIndenter = mock(Indenter.class);
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(true);
        prettyPrinter._nesting = 1;
        // Act
        prettyPrinter.writeEndElement(xmlStreamWriter, 0);
        // Assert
        verify(xmlStreamWriter, times(1)).writeEndElement();
        // Ensure that _nesting is not decremented
        assertEquals(1, prettyPrinter._nesting);
    }

    @Test
    public void testWriteEndElement_ShouldCallWriteIndentation() throws XMLStreamException {
        // Arrange
        prettyPrinter._justHadStartElement = false;
        // Set nesting for indentation
        prettyPrinter._nesting = 1;
        Indenter indenterMock = mock(Indenter.class);
        prettyPrinter._objectIndenter = indenterMock;
        // Act
        prettyPrinter.writeEndElement(xmlStreamWriter, 0);
        // Assert
        verify(indenterMock, times(1)).writeIndentation(xmlStreamWriter, 1);
        verify(xmlStreamWriter, times(1)).writeEndElement();
    }
}

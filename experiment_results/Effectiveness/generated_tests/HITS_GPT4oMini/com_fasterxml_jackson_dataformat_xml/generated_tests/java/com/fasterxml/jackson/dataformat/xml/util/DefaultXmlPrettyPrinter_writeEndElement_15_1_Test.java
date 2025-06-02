package com.fasterxml.jackson.dataformat.xml.util;

import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.stream.XMLStreamException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
// Importing Indenter
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

public class DefaultXmlPrettyPrinter_writeEndElement_15_1_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = Mockito.mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteEndElement_NestingDecremented_WhenNotInline() throws XMLStreamException {
        // Arrange
        prettyPrinter._objectIndenter = mock(Indenter.class);
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(false);
        // Initial nesting value
        prettyPrinter._nesting = 1;
        // Act
        prettyPrinter.writeEndElement(xmlStreamWriter, 0);
        // Assert
        // Verify nesting is decremented
        assertEquals(0, prettyPrinter._nesting);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteEndElement_NestingNotDecremented_WhenInline() throws XMLStreamException {
        // Arrange
        prettyPrinter._objectIndenter = mock(Indenter.class);
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(true);
        // Initial nesting value
        prettyPrinter._nesting = 1;
        // Act
        prettyPrinter.writeEndElement(xmlStreamWriter, 0);
        // Assert
        // Verify nesting remains the same
        assertEquals(1, prettyPrinter._nesting);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteEndElement_JustHadStartElement() throws XMLStreamException {
        // Arrange
        prettyPrinter._justHadStartElement = true;
        prettyPrinter._objectIndenter = mock(Indenter.class);
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(false);
        // Initial nesting value
        prettyPrinter._nesting = 1;
        // Act
        prettyPrinter.writeEndElement(xmlStreamWriter, 0);
        // Assert
        // Verify nesting is decremented and justHadStartElement is reset
        // Should not decrement
        assertEquals(1, prettyPrinter._nesting);
        assertFalse(prettyPrinter._justHadStartElement);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteEndElement_NestingDecrementedAndIndentationWritten() throws XMLStreamException {
        // Arrange
        prettyPrinter._objectIndenter = mock(Indenter.class);
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(false);
        // Initial nesting value
        prettyPrinter._nesting = 1;
        doNothing().when(prettyPrinter._objectIndenter).writeIndentation(any(XMLStreamWriter2.class), anyInt());
        // Act
        prettyPrinter.writeEndElement(xmlStreamWriter, 0);
        // Assert
        // Nesting should be decremented
        assertEquals(0, prettyPrinter._nesting);
    }
}

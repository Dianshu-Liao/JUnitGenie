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

public class DefaultXmlPrettyPrinter_writeLeafNullElement_26_0_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 mockWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        mockWriter = Mockito.mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafNullElement_WhenIndentationIsNotInline() throws XMLStreamException {
        // Arrange
        prettyPrinter._objectIndenter = Mockito.mock(Indenter.class);
        Mockito.when(prettyPrinter._objectIndenter.isInline()).thenReturn(false);
        // Set nesting level
        prettyPrinter._nesting = 1;
        // Act
        prettyPrinter.writeLeafNullElement(mockWriter, "http://example.com/ns", "element");
        // Assert
        verify(prettyPrinter._objectIndenter, times(1)).writeIndentation(mockWriter, 1);
        verify(mockWriter, times(1)).writeEmptyElement("http://example.com/ns", "element");
    }

    @Test
    public void testWriteLeafNullElement_WhenIndentationIsInline() throws XMLStreamException {
        // Arrange
        prettyPrinter._objectIndenter = Mockito.mock(Indenter.class);
        Mockito.when(prettyPrinter._objectIndenter.isInline()).thenReturn(true);
        // Set nesting level
        prettyPrinter._nesting = 1;
        // Act
        prettyPrinter.writeLeafNullElement(mockWriter, "http://example.com/ns", "element");
        // Assert
        verify(prettyPrinter._objectIndenter, times(0)).writeIndentation(mockWriter, 1);
        verify(mockWriter, times(1)).writeEmptyElement("http://example.com/ns", "element");
    }
}

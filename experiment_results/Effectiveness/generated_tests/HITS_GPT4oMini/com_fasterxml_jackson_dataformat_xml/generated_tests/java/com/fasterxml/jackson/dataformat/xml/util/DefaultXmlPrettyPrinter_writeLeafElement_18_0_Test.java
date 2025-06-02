package com.fasterxml.jackson.dataformat.xml.util;

import org.codehaus.stax2.XMLStreamWriter2;
import javax.xml.stream.XMLStreamException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.dataformat.xml.util.DefaultXmlPrettyPrinter;
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

public class DefaultXmlPrettyPrinter_writeLeafElement_18_0_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 xmlStreamWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        xmlStreamWriter = Mockito.mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafElement_WithNonInlineIndenter_ShouldWriteIndentation() throws XMLStreamException {
        // Arrange
        DefaultXmlPrettyPrinter.Indenter indenter = mock(DefaultXmlPrettyPrinter.Indenter.class);
        prettyPrinter._objectIndenter = indenter;
        when(indenter.isInline()).thenReturn(false);
        prettyPrinter._nesting = 1;
        // Act
        prettyPrinter.writeLeafElement(xmlStreamWriter, "http://example.com/ns", "leaf", true);
        // Assert
        verify(indenter).writeIndentation(xmlStreamWriter, prettyPrinter._nesting);
        verify(xmlStreamWriter).writeStartElement("http://example.com/ns", "leaf");
        verify(xmlStreamWriter).writeBoolean(true);
        verify(xmlStreamWriter).writeEndElement();
    }

    @Test
    public void testWriteLeafElement_WithInlineIndenter_ShouldNotWriteIndentation() throws XMLStreamException {
        // Arrange
        DefaultXmlPrettyPrinter.Indenter indenter = mock(DefaultXmlPrettyPrinter.Indenter.class);
        prettyPrinter._objectIndenter = indenter;
        when(indenter.isInline()).thenReturn(true);
        // Act
        prettyPrinter.writeLeafElement(xmlStreamWriter, "http://example.com/ns", "leaf", false);
        // Assert
        verify(indenter, never()).writeIndentation(any(XMLStreamWriter2.class), anyInt());
        verify(xmlStreamWriter).writeStartElement("http://example.com/ns", "leaf");
        verify(xmlStreamWriter).writeBoolean(false);
        verify(xmlStreamWriter).writeEndElement();
    }
}

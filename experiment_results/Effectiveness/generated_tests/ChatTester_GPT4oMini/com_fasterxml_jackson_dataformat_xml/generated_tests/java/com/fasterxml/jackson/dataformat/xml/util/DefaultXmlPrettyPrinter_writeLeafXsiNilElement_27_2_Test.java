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

@ExtendWith(MockitoExtension.class)
public class DefaultXmlPrettyPrinter_writeLeafXsiNilElement_27_2_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private XMLStreamWriter2 mockWriter;

    @BeforeEach
    public void setUp() {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        mockWriter = mock(XMLStreamWriter2.class);
    }

    @Test
    public void testWriteLeafXsiNilElement_WhenNotInline() throws Exception {
        prettyPrinter._objectIndenter = mock(DefaultXmlPrettyPrinter.Indenter.class);
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(false);
        // Act
        prettyPrinter.writeLeafXsiNilElement(mockWriter, "http://example.com/ns", "exampleElement");
        // Assert
        verify(prettyPrinter._objectIndenter).writeIndentation(mockWriter, prettyPrinter._nesting);
        verify(mockWriter).writeEmptyElement("http://example.com/ns", "exampleElement");
        verify(mockWriter).writeAttribute("xsi", XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, "nil", "true");
        assertFalse(prettyPrinter._justHadStartElement);
    }

    @Test
    public void testWriteLeafXsiNilElement_WhenInline() throws Exception {
        prettyPrinter._objectIndenter = mock(DefaultXmlPrettyPrinter.Indenter.class);
        when(prettyPrinter._objectIndenter.isInline()).thenReturn(true);
        // Act
        prettyPrinter.writeLeafXsiNilElement(mockWriter, "http://example.com/ns", "exampleElement");
        // Fixed Line
        verify(prettyPrinter._objectIndenter, never()).writeIndentation(any(XMLStreamWriter2.class), anyInt());
        verify(mockWriter).writeEmptyElement("http://example.com/ns", "exampleElement");
        verify(mockWriter).writeAttribute("xsi", XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, "nil", "true");
        assertFalse(prettyPrinter._justHadStartElement);
    }
}

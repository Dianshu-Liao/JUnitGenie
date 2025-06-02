package com.fasterxml.jackson.dataformat.xml.util;

import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import javax.xml.stream.XMLStreamWriter;
import java.io.StringWriter;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamException;
import org.codehaus.stax2.XMLStreamWriter2;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.Instantiatable;
import com.fasterxml.jackson.dataformat.xml.XmlPrettyPrinter;

public class DefaultXmlPrettyPrinter_writeStartObject_10_4_Test {

    private DefaultXmlPrettyPrinter prettyPrinter;

    private ToXmlGenerator mockToXmlGenerator;

    @BeforeEach
    public void setUp() throws Exception {
        prettyPrinter = new DefaultXmlPrettyPrinter();
        StringWriter stringWriter = new StringWriter();
        XMLStreamWriter xmlStreamWriter = mock(XMLStreamWriter.class);
        mockToXmlGenerator = mock(ToXmlGenerator.class);
        when(mockToXmlGenerator.getStaxWriter()).thenReturn(xmlStreamWriter);
    }

    @Test
    public void testWriteStartObject_WithNesting() throws IOException {
        // Setup
        // Simulating nesting
        prettyPrinter._nesting = 1;
        DefaultXmlPrettyPrinter.Indenter mockIndenter = mock(DefaultXmlPrettyPrinter.Indenter.class);
        prettyPrinter._objectIndenter = mockIndenter;
        when(mockIndenter.isInline()).thenReturn(false);
        // Act
        prettyPrinter.writeStartObject(mockToXmlGenerator);
        // Assert
        verify(mockIndenter).writeIndentation(eq(mockToXmlGenerator), eq(prettyPrinter._nesting));
        verify(mockToXmlGenerator)._handleStartObject();
        assertEquals(2, prettyPrinter._nesting);
        assertTrue(prettyPrinter._justHadStartElement);
    }

    @Test
    public void testWriteStartObject_WithoutNesting() throws IOException {
        // Setup
        // Simulating no nesting
        prettyPrinter._nesting = 0;
        DefaultXmlPrettyPrinter.Indenter mockIndenter = mock(DefaultXmlPrettyPrinter.Indenter.class);
        prettyPrinter._objectIndenter = mockIndenter;
        when(mockIndenter.isInline()).thenReturn(false);
        // Act
        prettyPrinter.writeStartObject(mockToXmlGenerator);
        // Assert
        verify(mockIndenter, never()).writeIndentation(any(JsonGenerator.class), anyInt());
        verify(mockToXmlGenerator)._handleStartObject();
        assertEquals(1, prettyPrinter._nesting);
        assertTrue(prettyPrinter._justHadStartElement);
    }

    @Test
    public void testWriteStartObject_WhenInline() throws IOException {
        // Setup
        // Simulating no nesting
        prettyPrinter._nesting = 0;
        DefaultXmlPrettyPrinter.Indenter mockIndenter = mock(DefaultXmlPrettyPrinter.Indenter.class);
        prettyPrinter._objectIndenter = mockIndenter;
        when(mockIndenter.isInline()).thenReturn(true);
        // Act
        prettyPrinter.writeStartObject(mockToXmlGenerator);
        // Assert
        verify(mockIndenter, never()).writeIndentation(any(JsonGenerator.class), anyInt());
        verify(mockToXmlGenerator)._handleStartObject();
        assertEquals(1, prettyPrinter._nesting);
        assertTrue(prettyPrinter._justHadStartElement);
    }
}

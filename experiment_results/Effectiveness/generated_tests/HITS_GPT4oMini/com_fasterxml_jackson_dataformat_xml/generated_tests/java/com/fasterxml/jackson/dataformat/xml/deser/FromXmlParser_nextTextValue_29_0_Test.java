package com.fasterxml.jackson.dataformat.xml.deser;

import java.io.IOException;
import javax.xml.stream.XMLStreamReader;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.PackageVersion;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class FromXmlParser_nextTextValue_29_0_Test {

    @Mock
    private IOContext mockIoContext;

    @Mock
    private XMLStreamReader mockXmlStreamReader;

    private FromXmlParser parser;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        parser = new FromXmlParser(mockIoContext, 0, 0, null, mockXmlStreamReader, null);
    }

    @Test
    public void testNextTextValueReturnsString() throws Exception {
        // Setup mock behavior
        when(mockXmlStreamReader.getText()).thenReturn("sample text");
        when(mockXmlStreamReader.next()).thenReturn(XmlTokenStream.XML_TEXT);
        // Execute the method
        String result = parser.nextTextValue();
        // Verify the result
        assertEquals("sample text", result);
    }

    @Test
    public void testNextTextValueHandlesEndElement() throws Exception {
        // Setup mock behavior
        when(mockXmlStreamReader.next()).thenReturn(XmlTokenStream.XML_END_ELEMENT);
        // Execute the method
        String result = parser.nextTextValue();
        // Verify the result
        assertNull(result);
    }

    @Test
    public void testNextTextValueHandlesAttributeValue() throws Exception {
        // Setup mock behavior
        when(mockXmlStreamReader.next()).thenReturn(XmlTokenStream.XML_ATTRIBUTE_VALUE);
        when(mockXmlStreamReader.getText()).thenReturn("attribute value");
        // Execute the method
        String result = parser.nextTextValue();
        // Verify the result
        assertEquals("attribute value", result);
    }

    @Test
    public void testNextTextValueHandlesNullText() throws Exception {
        // Setup mock behavior
        when(mockXmlStreamReader.next()).thenReturn(XmlTokenStream.XML_TEXT);
        when(mockXmlStreamReader.getText()).thenReturn(null);
        // Execute the method
        String result = parser.nextTextValue();
        // Verify the result
        assertNull(result);
    }

    @Test
    public void testNextTextValueHandlesUnexpectedToken() throws Exception {
        // Setup mock behavior
        // Invalid token
        when(mockXmlStreamReader.next()).thenReturn(99);
        // Execute the method
        String result = parser.nextTextValue();
        // Verify the result
        assertNull(result);
    }

    @Test
    public void testNextTextValueHandlesMultipleTokens() throws Exception {
        // Setup mock behavior
        when(mockXmlStreamReader.next()).thenReturn(XmlTokenStream.XML_START_ELEMENT, XmlTokenStream.XML_TEXT);
        when(mockXmlStreamReader.getText()).thenReturn("text after start");
        // Execute the method
        // First call to move to XML_TEXT
        parser.nextTextValue();
        // Second call to get the text
        String result = parser.nextTextValue();
        // Verify the result
        assertEquals("text after start", result);
    }

    @Test
    public void testNextTextValueAdvancesContext() throws Exception {
        // Setup mock behavior for a valid text token
        when(mockXmlStreamReader.next()).thenReturn(XmlTokenStream.XML_TEXT);
        when(mockXmlStreamReader.getText()).thenReturn("text value");
        // Execute the method
        String firstResult = parser.nextTextValue();
        String secondResult = parser.nextTextValue();
        // Verify the results
        assertEquals("text value", firstResult);
        // Should return null after the first read
        assertNull(secondResult);
    }
}

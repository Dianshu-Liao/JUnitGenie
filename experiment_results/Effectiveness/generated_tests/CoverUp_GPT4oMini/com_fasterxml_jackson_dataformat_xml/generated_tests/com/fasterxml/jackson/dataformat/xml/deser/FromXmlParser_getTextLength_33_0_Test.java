package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext;
import com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream;
import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
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
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.PackageVersion;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class FromXmlParser_getTextLength_33_0_Test {

    private FromXmlParser parser;

    private IOContext ioContext;

    private XMLStreamReader xmlStreamReader;

    private ObjectCodec objectCodec;

    @BeforeEach
    public void setUp() throws Exception {
        ioContext = mock(IOContext.class);
        xmlStreamReader = mock(XMLStreamReader.class);
        objectCodec = mock(ObjectCodec.class);
        // Initialize the parser with mocked dependencies
        parser = new FromXmlParser(ioContext, 0, 0, objectCodec, xmlStreamReader, null);
    }

    @Test
    public void testGetTextLength_NullText() throws IOException {
        // Mock the behavior of getText() to return null
        when(parser.getText()).thenReturn(null);
        // Verify that getTextLength() returns 0
        assertEquals(0, parser.getTextLength());
    }

    @Test
    public void testGetTextLength_EmptyText() throws IOException {
        // Mock the behavior of getText() to return an empty string
        when(parser.getText()).thenReturn("");
        // Verify that getTextLength() returns 0
        assertEquals(0, parser.getTextLength());
    }

    @Test
    public void testGetTextLength_NonEmptyText() throws IOException {
        // Mock the behavior of getText() to return a non-empty string
        when(parser.getText()).thenReturn("Hello, World!");
        // Verify that getTextLength() returns the length of the string
        assertEquals(13, parser.getTextLength());
    }

    @Test
    public void testGetTextLength_WhitespaceText() throws IOException {
        // Mock the behavior of getText() to return a string with whitespace
        when(parser.getText()).thenReturn("   ");
        // Verify that getTextLength() returns the length of the whitespace
        assertEquals(3, parser.getTextLength());
    }

    @Test
    public void testGetTextLength_LeadingMixedText() throws IOException {
        // Mock the behavior of getText() to return a string with leading mixed content
        when(parser.getText()).thenReturn("   Mixed Content   ");
        // Verify that getTextLength() returns the length of the string
        assertEquals(18, parser.getTextLength());
    }
}

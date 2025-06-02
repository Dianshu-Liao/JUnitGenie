package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext;
import com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream;
import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamReader;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
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

public class FromXmlParser_overrideCurrentName_18_2_Test {

    private FromXmlParser parser;

    private XmlReadContext mockContext;

    private ObjectCodec mockCodec;

    private IOContext mockIOContext;

    private XMLStreamReader mockXmlReader;

    @BeforeEach
    public void setUp() throws Exception {
        mockIOContext = mock(IOContext.class);
        mockCodec = mock(ObjectCodec.class);
        mockXmlReader = mock(XMLStreamReader.class);
        mockContext = mock(XmlReadContext.class);
        XmlTokenStream mockTokenStream = mock(XmlTokenStream.class);
        parser = new FromXmlParser(mockIOContext, 0, 0, mockCodec, mockXmlReader, null);
        // Set up the necessary internal state for the parser
        parser._parsingContext = mockContext;
    }

    @Test
    public void testOverrideCurrentNameWithStartObject() throws Exception {
        // Arrange
        setCurrToken(parser, JsonToken.START_OBJECT);
        String newName = "newName";
        // Act
        parser.overrideCurrentName(newName);
        // Assert
        verify(mockContext).setCurrentName(newName);
    }

    @Test
    public void testOverrideCurrentNameWithStartArray() throws Exception {
        // Arrange
        setCurrToken(parser, JsonToken.START_ARRAY);
        String newName = "newName";
        // Act
        parser.overrideCurrentName(newName);
        // Assert
        verify(mockContext).setCurrentName(newName);
    }

    @Test
    public void testOverrideCurrentNameWithNullToken() throws Exception {
        // Arrange
        setCurrToken(parser, null);
        String newName = "newName";
        // Act
        parser.overrideCurrentName(newName);
        // Assert
        verify(mockContext, never()).setCurrentName(anyString());
    }

    @Test
    public void testOverrideCurrentNameWithOtherToken() throws Exception {
        // Arrange
        setCurrToken(parser, JsonToken.FIELD_NAME);
        String newName = "newName";
        // Act
        parser.overrideCurrentName(newName);
        // Assert
        verify(mockContext).setCurrentName(newName);
    }

    private void setCurrToken(FromXmlParser parser, JsonToken token) throws Exception {
        Field currTokenField = FromXmlParser.class.getDeclaredField("_currToken");
        currTokenField.setAccessible(true);
        currTokenField.set(parser, token);
    }
}

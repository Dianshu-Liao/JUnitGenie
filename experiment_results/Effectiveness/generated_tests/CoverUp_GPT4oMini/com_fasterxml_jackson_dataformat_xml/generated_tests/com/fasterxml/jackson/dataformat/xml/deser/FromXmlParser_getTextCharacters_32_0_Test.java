package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import com.fasterxml.jackson.dataformat.xml.deser.XmlReadContext;
import com.fasterxml.jackson.dataformat.xml.deser.XmlTokenStream;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
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
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class FromXmlParser_getTextCharacters_32_0_Test {

    private FromXmlParser parser;

    private IOContext ioContext;

    private ObjectCodec codec;

    private XMLStreamReader xmlReader;

    private XmlNameProcessor tagProcessor;

    @BeforeEach
    public void setUp() throws Exception {
        ioContext = Mockito.mock(IOContext.class);
        codec = Mockito.mock(ObjectCodec.class);
        xmlReader = Mockito.mock(XMLStreamReader.class);
        tagProcessor = Mockito.mock(XmlNameProcessor.class);
        parser = new FromXmlParser(ioContext, 0, 0, codec, xmlReader, tagProcessor);
    }

    @Test
    public void testGetTextCharacters_NullText() throws IOException {
        // Simulate that the current token is null
        Mockito.when(parser.getText()).thenReturn(null);
        char[] result = parser.getTextCharacters();
        assertNull(result);
    }

    @Test
    public void testGetTextCharacters_EmptyText() throws IOException {
        // Simulate that the current token returns an empty string
        Mockito.when(parser.getText()).thenReturn("");
        char[] result = parser.getTextCharacters();
        assertArrayEquals(new char[] {}, result);
    }

    @Test
    public void testGetTextCharacters_NonEmptyText() throws IOException {
        // Simulate that the current token returns a non-empty string
        String text = "Hello, World!";
        Mockito.when(parser.getText()).thenReturn(text);
        char[] result = parser.getTextCharacters();
        assertArrayEquals(text.toCharArray(), result);
    }

    @Test
    public void testGetTextCharacters_MixedText() throws IOException {
        // Simulate that the current token returns a string with mixed characters
        String text = "Test123!@#";
        Mockito.when(parser.getText()).thenReturn(text);
        char[] result = parser.getTextCharacters();
        assertArrayEquals(text.toCharArray(), result);
    }
}

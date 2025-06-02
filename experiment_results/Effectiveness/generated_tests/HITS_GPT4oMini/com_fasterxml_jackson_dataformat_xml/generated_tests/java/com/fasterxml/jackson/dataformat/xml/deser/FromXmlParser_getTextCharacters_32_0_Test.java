package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

@ExtendWith(MockitoExtension.class)
public class FromXmlParser_getTextCharacters_32_0_Test {

    private FromXmlParser parser;

    private XMLStreamReader xmlStreamReader;

    private ObjectCodec objectCodec;

    @BeforeEach
    public void setUp() throws Exception {
        xmlStreamReader = mock(XMLStreamReader.class);
        objectCodec = mock(ObjectCodec.class);
        IOContext ioContext = new IOContext(null, null, false);
        parser = new FromXmlParser(ioContext, 0, 0, objectCodec, xmlStreamReader, null);
    }

    @Test
    public void testGetTextCharacters_NullText() throws IOException {
        parser._currText = null;
        assertNull(parser.getTextCharacters());
    }

    @Test
    public void testGetTextCharacters_EmptyText() throws IOException {
        parser._currText = "";
        assertArrayEquals(new char[] {}, parser.getTextCharacters());
    }

    @Test
    public void testGetTextCharacters_ValidText() throws IOException {
        String expectedText = "Hello, World!";
        parser._currText = expectedText;
        char[] result = parser.getTextCharacters();
        assertArrayEquals(expectedText.toCharArray(), result);
    }
}

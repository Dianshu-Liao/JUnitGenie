package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
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
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

class FromXmlParser_overrideCurrentName_18_0_Test {

    private FromXmlParser parser;

    private IOContext ioContext;

    private ObjectCodec objectCodec;

    private XMLStreamReader xmlStreamReader;

    private XmlNameProcessor xmlNameProcessor;

    @BeforeEach
    void setUp() throws Exception {
        ioContext = Mockito.mock(IOContext.class);
        objectCodec = Mockito.mock(ObjectCodec.class);
        xmlStreamReader = Mockito.mock(XMLStreamReader.class);
        xmlNameProcessor = Mockito.mock(XmlNameProcessor.class);
        parser = new FromXmlParser(ioContext, 0, 0, objectCodec, xmlStreamReader, xmlNameProcessor);
    }

    private void setCurrentToken(JsonToken token) throws Exception {
        Field currTokenField = FromXmlParser.class.getDeclaredField("_currToken");
        currTokenField.setAccessible(true);
        currTokenField.set(parser, token);
    }

    @Test
    void testOverrideCurrentNameForStartObject() throws Exception {
        setCurrentToken(JsonToken.START_OBJECT);
        parser.overrideCurrentName("newName");
        XmlReadContext context = parser._parsingContext;
        assertEquals("newName", context.getCurrentName());
    }

    @Test
    void testOverrideCurrentNameForStartArray() throws Exception {
        setCurrentToken(JsonToken.START_ARRAY);
        parser.overrideCurrentName("newName");
        XmlReadContext context = parser._parsingContext;
        assertEquals("newName", context.getCurrentName());
    }

    @Test
    void testOverrideCurrentNameForOtherToken() throws Exception {
        setCurrentToken(JsonToken.VALUE_STRING);
        parser.overrideCurrentName("newName");
        XmlReadContext context = parser._parsingContext;
        assertEquals("newName", context.getCurrentName());
    }
}

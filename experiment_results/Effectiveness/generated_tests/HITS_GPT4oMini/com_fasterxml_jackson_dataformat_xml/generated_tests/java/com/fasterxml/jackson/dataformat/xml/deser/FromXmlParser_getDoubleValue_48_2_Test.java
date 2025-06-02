package com.fasterxml.jackson.dataformat.xml.deser;

import java.io.IOException;
import javax.xml.stream.XMLStreamReader;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.math.BigInteger;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.math.BigDecimal;
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

class FromXmlParser_getDoubleValue_48_2_Test extends FromXmlParser {

    public FromXmlParser_getDoubleValue_48_2_Test(IOContext ctxt, int genericParserFeatures, int xmlFeatures, ObjectCodec codec, XMLStreamReader xmlReader, XmlNameProcessor tagProcessor) throws IOException {
        super(ctxt, genericParserFeatures, xmlFeatures, codec, xmlReader, tagProcessor);
    }

    public static final int NR_UNKNOWN = ParserMinimalBase.NR_UNKNOWN;

    public static final int NR_DOUBLE = ParserMinimalBase.NR_DOUBLE;

    public static final int NR_INT = ParserMinimalBase.NR_INT;

    public static final int NR_LONG = ParserMinimalBase.NR_LONG;

    public static final int NR_BIGINT = ParserMinimalBase.NR_BIGINT;

    private XMLStreamReader xmlReaderMock;

    @BeforeEach
    void setUp() throws Exception {
        xmlReaderMock = Mockito.mock(XMLStreamReader.class);
        // Initialize other required fields here
    }

    @Test
    void testGetDoubleValueWithUnknownType() throws IOException {
        this._numTypesValid = NR_UNKNOWN;
        assertThrows(IOException.class, this::getDoubleValue);
    }

    @Test
    void testGetDoubleValueWithDoubleType() throws IOException {
        this._numTypesValid = NR_DOUBLE;
        this._numberLong = 1234567890L;
        assertEquals(1234567890.0, getDoubleValue());
    }

    @Test
    void testGetDoubleValueWithIntType() throws IOException {
        this._numTypesValid = NR_INT;
        this._numberInt = 42;
        assertEquals(42.0, getDoubleValue());
    }

    @Test
    void testGetDoubleValueWithLongType() throws IOException {
        this._numTypesValid = NR_LONG;
        this._numberLong = 1234567890L;
        assertEquals(1234567890.0, getDoubleValue());
    }

    @Test
    void testGetDoubleValueWithBigIntType() throws IOException {
        this._numTypesValid = NR_BIGINT;
        this._numberBigInt = BigInteger.valueOf(1234567890L);
        assertEquals(1234567890.0, getDoubleValue());
    }
}

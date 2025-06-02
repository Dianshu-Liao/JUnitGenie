package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
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
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.PackageVersion;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class FromXmlParser_getFloatValue_47_1_Test {

    private FromXmlParser parser;

    private IOContext ioContext;

    private XMLStreamReader xmlReader;

    private ObjectCodec objectCodec;

    @BeforeEach
    public void setUp() throws Exception {
        ioContext = mock(IOContext.class);
        xmlReader = mock(XMLStreamReader.class);
        objectCodec = mock(ObjectCodec.class);
        parser = new FromXmlParser(ioContext, 0, 0, objectCodec, xmlReader, null);
    }

    @Test
    public void testGetFloatValue_ValidFloat() throws IOException {
        // NR_FLOAT
        parser._numTypesValid = 1;
        parser._numberInt = 3;
        float result = parser.getFloatValue();
        assertEquals(3.0f, result);
    }

    @Test
    public void testGetFloatValue_UnknownType_ShouldCallCheckNumericValue() throws IOException {
        // NR_UNKNOWN
        parser._numTypesValid = 0;
        // NR_FLOAT
        parser._checkNumericValue(1);
        // NR_FLOAT
        parser._numTypesValid = 1;
        parser._numberInt = 5;
        float result = parser.getFloatValue();
        assertEquals(5.0f, result);
    }

    @Test
    public void testGetFloatValue_InvalidType_ShouldThrowIOException() {
        parser._numTypesValid = 0;
        assertThrows(IOException.class, () -> {
            parser.getFloatValue();
        });
    }

    @Test
    public void testGetFloatValue_ValidLong() throws IOException {
        // NR_LONG
        parser._numTypesValid = 2;
        parser._numberLong = 10L;
        float result = parser.getFloatValue();
        assertEquals(10.0f, result);
    }

    @Test
    public void testGetFloatValue_ValidBigInteger() throws IOException {
        // NR_BIGINT
        parser._numTypesValid = 3;
        parser._numberBigInt = BigInteger.valueOf(15);
        float result = parser.getFloatValue();
        assertEquals(15.0f, result);
    }
}

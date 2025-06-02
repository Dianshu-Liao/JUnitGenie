package com.fasterxml.jackson.dataformat.xml.deser;

import java.io.IOException;
import javax.xml.stream.XMLStreamReader;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import javax.xml.stream.XMLStreamException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.util.Set;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamWriter;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.PackageVersion;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class FromXmlParser_getDecimalValue_49_1_Test {

    private FromXmlParser parser;

    private XMLStreamReader xmlStreamReader;

    private static final int NR_BIGINT = 1;

    private static final int NR_LONG = 2;

    private static final int NR_INT = 4;

    private static final int NR_UNKNOWN = 0;

    private static final int NR_BIGDECIMAL = 8;

    @BeforeEach
    public void setUp() throws Exception {
        xmlStreamReader = createMockXMLStreamReader();
        IOContext ioContext = new IOContext(null, null, false);
        parser = new FromXmlParser(ioContext, 0, 0, null, xmlStreamReader, null);
    }

    @Test
    public void testGetDecimalValueWithValidBigInteger() throws IOException {
        parser._numTypesValid = NR_BIGINT;
        parser._numberBigInt = BigInteger.valueOf(123456789);
        BigDecimal result = parser.getDecimalValue();
        assertEquals(new BigDecimal("123456789"), result);
    }

    @Test
    public void testGetDecimalValueWithValidLong() throws IOException {
        parser._numTypesValid = NR_LONG;
        parser._numberLong = 123456789L;
        BigDecimal result = parser.getDecimalValue();
        assertEquals(new BigDecimal("123456789"), result);
    }

    @Test
    public void testGetDecimalValueWithValidInt() throws IOException {
        parser._numTypesValid = NR_INT;
        parser._numberInt = 123456;
        BigDecimal result = parser.getDecimalValue();
        assertEquals(new BigDecimal("123456"), result);
    }

    @Test
    public void testGetDecimalValueWithUnknownType() {
        parser._numTypesValid = NR_UNKNOWN;
        assertThrows(IOException.class, () -> {
            parser.getDecimalValue();
        });
    }

    @Test
    public void testGetDecimalValueWithInvalidState() {
        parser._numTypesValid = 0;
        assertThrows(IOException.class, () -> {
            parser.getDecimalValue();
        });
    }

    private XMLStreamReader createMockXMLStreamReader() {
        return Mockito.mock(XMLStreamReader.class);
    }
}

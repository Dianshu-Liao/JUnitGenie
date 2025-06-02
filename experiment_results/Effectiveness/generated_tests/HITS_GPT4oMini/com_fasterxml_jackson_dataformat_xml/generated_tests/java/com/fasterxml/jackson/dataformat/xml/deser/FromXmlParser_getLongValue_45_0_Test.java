package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.StringReader;
import java.math.BigInteger;
import javax.xml.stream.XMLInputFactory;
import java.math.BigDecimal;
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

public class FromXmlParser_getLongValue_45_0_Test {

    private FromXmlParser parser;

    private static final int NR_LONG = 1;

    private static final int NR_UNKNOWN = 0;

    private static final int NR_BIGINT = 2;

    @BeforeEach
    public void setUp() throws Exception {
        String xml = "<root><number>123456789</number></root>";
        XMLStreamReader xmlReader = createXmlStreamReader(xml);
        parser = new FromXmlParser(new IOContext(null, null, false), 0, 0, null, xmlReader, null);
    }

    private XMLStreamReader createXmlStreamReader(String xml) throws XMLStreamException {
        return XMLInputFactory.newInstance().createXMLStreamReader(new StringReader(xml));
    }

    @Test
    public void testGetLongValue_WhenValidLongValue_ReturnsCorrectValue() throws IOException {
        parser._numberLong = 123456789L;
        parser._numTypesValid = NR_LONG;
        long result = parser.getLongValue();
        assertEquals(123456789L, result);
    }

    @Test
    public void testGetLongValue_WhenNumberNotParsed_CallsConvertNumberToLong() throws IOException {
        parser._numTypesValid = NR_UNKNOWN;
        parser._numberBigInt = BigInteger.valueOf(987654321);
        parser._numTypesValid |= NR_BIGINT;
        long result = parser.getLongValue();
        assertEquals(987654321L, result);
    }

    @Test
    public void testGetLongValue_WhenNumberIsBigInteger_ReturnsLongValue() throws IOException {
        parser._numberBigInt = BigInteger.valueOf(1234567890123456789L);
        parser._numTypesValid = NR_BIGINT;
        long result = parser.getLongValue();
        assertEquals(1234567890123456789L, result);
    }

    @Test
    public void testGetLongValue_WhenNumberIsInvalid_ThrowsIOException() {
        parser._numTypesValid = 0;
        assertThrows(IOException.class, () -> {
            parser.getLongValue();
        });
    }
}

package com.fasterxml.jackson.dataformat.xml.deser;

import java.io.IOException;
import java.math.BigInteger;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.util.Set;
import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
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

public class FromXmlParser__convertNumberToDouble_56_1_Test {

    private TestableFromXmlParser parser;

    private static class TestableFromXmlParser extends FromXmlParser {

        public TestableFromXmlParser() throws IOException {
            super(null, 0, 0, null, null, null);
        }

        // Assuming these values for testing
        public static final int NR_BIGINT = 1;

        public static final int NR_LONG = 2;

        public static final int NR_INT = 4;
    }

    @BeforeEach
    public void setUp() throws IOException {
        parser = new TestableFromXmlParser();
    }

    @Test
    public void testConvertNumberToDouble_NoValidType() {
        parser._numTypesValid = 0;
        assertThrows(IOException.class, () -> {
            parser._convertNumberToDouble();
        });
    }

    @Test
    public void testConvertNumberToDouble_WithBigInteger() throws IOException {
        parser._numberBigInt = BigInteger.valueOf(123456789);
        parser._numTypesValid = TestableFromXmlParser.NR_BIGINT;
        double result = parser._convertNumberToDouble();
        assertEquals(123456789.0, result);
    }

    @Test
    public void testConvertNumberToDouble_WithLong() throws IOException {
        parser._numberLong = 123456789L;
        parser._numTypesValid = TestableFromXmlParser.NR_LONG;
        double result = parser._convertNumberToDouble();
        assertEquals(123456789.0, result);
    }

    @Test
    public void testConvertNumberToDouble_WithInt() throws IOException {
        parser._numberInt = 123456789;
        parser._numTypesValid = TestableFromXmlParser.NR_INT;
        double result = parser._convertNumberToDouble();
        assertEquals(123456789.0, result);
    }
}

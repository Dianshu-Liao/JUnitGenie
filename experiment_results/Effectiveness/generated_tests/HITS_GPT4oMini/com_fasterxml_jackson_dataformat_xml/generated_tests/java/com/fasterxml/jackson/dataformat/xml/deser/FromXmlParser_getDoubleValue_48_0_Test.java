package com.fasterxml.jackson.dataformat.xml.deser;

import java.io.IOException;
import javax.xml.stream.XMLStreamReader;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.ContentReference;
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

public class FromXmlParser_getDoubleValue_48_0_Test {

    private FromXmlParser parser;

    private static class TestFromXmlParser extends FromXmlParser {

        public TestFromXmlParser(IOContext ctxt, int genericParserFeatures, int xmlFeatures, ObjectCodec codec, XMLStreamReader xmlReader, XmlNameProcessor tagProcessor) throws IOException {
            super(ctxt, genericParserFeatures, xmlFeatures, codec, xmlReader, tagProcessor);
        }

        public static final int NR_DOUBLE = FromXmlParser.NR_DOUBLE;

        public static final int NR_UNKNOWN = FromXmlParser.NR_UNKNOWN;

        public static final int NR_INT = FromXmlParser.NR_INT;

        public static final int NR_LONG = FromXmlParser.NR_LONG;

        public static final int NR_BIGINT = FromXmlParser.NR_BIGINT;
    }

    @BeforeEach
    public void setUp() throws Exception {
        // Mocking the XMLStreamReader and other dependencies
        XMLStreamReader mockReader = Mockito.mock(XMLStreamReader.class);
        ContentReference mockContentReference = Mockito.mock(ContentReference.class);
        IOContext mockContext = new IOContext(null, mockContentReference, false);
        parser = new TestFromXmlParser(mockContext, 0, 0, null, mockReader, null);
    }

    @Test
    public void testGetDoubleValue_WhenNumTypesValidIsNRDouble_ShouldReturnDoubleValue() throws IOException {
        // Arrange
        parser._numTypesValid = TestFromXmlParser.NR_DOUBLE;
        parser._numberLong = 42;
        parser._numberInt = 0;
        parser._numberBigInt = BigInteger.ZERO;
        // Act
        double result = parser.getDoubleValue();
        // Assert
        assertEquals(42.0, result);
    }

    @Test
    public void testGetDoubleValue_WhenNumTypesValidIsNRUnknown_ShouldCheckNumericValue() throws IOException {
        // Arrange
        parser._numTypesValid = TestFromXmlParser.NR_UNKNOWN;
        // Act & Assert
        assertThrows(IOException.class, () -> {
            parser.getDoubleValue();
        });
    }

    @Test
    public void testGetDoubleValue_WhenNumTypesValidIsNotNRDoubleOrNRUnknown_ShouldReturnDoubleValue() throws IOException {
        // Arrange
        parser._numTypesValid = TestFromXmlParser.NR_INT;
        parser._numberInt = 10;
        // Act
        double result = parser.getDoubleValue();
        // Assert
        assertEquals(10.0, result);
    }

    @Test
    public void testGetDoubleValue_WhenNumTypesValidIsNRLong_ShouldReturnDoubleValue() throws IOException {
        // Arrange
        parser._numTypesValid = TestFromXmlParser.NR_LONG;
        parser._numberLong = 20L;
        // Act
        double result = parser.getDoubleValue();
        // Assert
        assertEquals(20.0, result);
    }

    @Test
    public void testGetDoubleValue_WhenNumTypesValidIsNRBigInteger_ShouldReturnDoubleValue() throws IOException {
        // Arrange
        parser._numTypesValid = TestFromXmlParser.NR_BIGINT;
        parser._numberBigInt = BigInteger.valueOf(30);
        // Act
        double result = parser.getDoubleValue();
        // Assert
        assertEquals(30.0, result);
    }
}

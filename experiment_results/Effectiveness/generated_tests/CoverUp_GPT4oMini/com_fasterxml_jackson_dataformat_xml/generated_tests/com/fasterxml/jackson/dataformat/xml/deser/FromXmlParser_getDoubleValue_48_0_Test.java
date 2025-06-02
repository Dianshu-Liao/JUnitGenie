package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.math.BigInteger;
import java.lang.reflect.Field;
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

    private IOContext ioContext;

    private ObjectCodec objectCodec;

    private XMLStreamReader xmlReader;

    @BeforeEach
    public void setUp() throws Exception {
        ioContext = mock(IOContext.class);
        objectCodec = mock(ObjectCodec.class);
        xmlReader = mock(XMLStreamReader.class);
        parser = new FromXmlParser(ioContext, 0, 0, objectCodec, xmlReader, null);
    }

    private void setFieldValue(String fieldName, Object value) throws Exception {
        Field field = FromXmlParser.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(parser, value);
    }

    @Test
    public void testGetDoubleValueWithUnknownType() throws Exception {
        // NR_UNKNOWN
        setFieldValue("_numTypesValid", 0);
        setFieldValue("_numberInt", 10);
        double result = parser.getDoubleValue();
        assertEquals(10.0, result);
    }

    @Test
    public void testGetDoubleValueWithInt() throws Exception {
        // NR_INT
        setFieldValue("_numTypesValid", 1);
        setFieldValue("_numberInt", 5);
        double result = parser.getDoubleValue();
        assertEquals(5.0, result);
    }

    @Test
    public void testGetDoubleValueWithLong() throws Exception {
        // NR_LONG
        setFieldValue("_numTypesValid", 2);
        setFieldValue("_numberLong", 100L);
        double result = parser.getDoubleValue();
        assertEquals(100.0, result);
    }

    @Test
    public void testGetDoubleValueWithBigInteger() throws Exception {
        // NR_BIGINT
        setFieldValue("_numTypesValid", 4);
        setFieldValue("_numberBigInt", BigInteger.valueOf(123456789));
        double result = parser.getDoubleValue();
        assertEquals(123456789.0, result);
    }

    @Test
    public void testGetDoubleValueThrowsIOException() throws Exception {
        // NR_UNKNOWN
        setFieldValue("_numTypesValid", 0);
        assertThrows(IOException.class, () -> parser.getDoubleValue());
    }

    @Test
    public void testGetDoubleValueWithNoNumericValue() throws Exception {
        // No numeric type set
        setFieldValue("_numTypesValid", 0);
        assertThrows(IOException.class, () -> parser.getDoubleValue());
    }
}

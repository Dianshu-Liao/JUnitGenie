package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamReader;
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

class FromXmlParser_getFloatValue_47_1_Test {

    private FromXmlParser parser;

    private IOContext ioContext;

    private XMLStreamReader xmlStreamReader;

    private ObjectCodec objectCodec;

    private static final int NR_UNKNOWN = 0;

    private static final int NR_FLOAT = 1;

    private static final int NR_BIGINT = 2;

    private static final int NR_LONG = 4;

    private static final int NR_INT = 8;

    @BeforeEach
    void setUp() throws Exception {
        ioContext = Mockito.mock(IOContext.class);
        xmlStreamReader = Mockito.mock(XMLStreamReader.class);
        objectCodec = Mockito.mock(ObjectCodec.class);
        parser = new FromXmlParser(ioContext, 0, 0, objectCodec, xmlStreamReader, null);
    }

    @Test
    void testGetFloatValueWhenNumTypesValidIsUnknown() throws Exception {
        // Setup
        setField(parser, "_numTypesValid", NR_UNKNOWN);
        // Expect exception
        assertThrows(IOException.class, parser::getFloatValue);
    }

    @Test
    void testGetFloatValueWhenNumTypesValidIsFloat() throws Exception {
        // Setup
        setField(parser, "_numTypesValid", NR_FLOAT);
        setField(parser, "_numberLong", 123456789L);
        // Execute
        float result = parser.getFloatValue();
        // Verify
        assertEquals(123456789.0f, result);
    }

    @Test
    void testGetFloatValueWhenNumTypesValidIsBigInt() throws Exception {
        // Setup
        setField(parser, "_numTypesValid", NR_BIGINT);
        setField(parser, "_numberBigInt", BigInteger.valueOf(123456789));
        // Execute
        float result = parser.getFloatValue();
        // Verify
        assertEquals(123456789.0f, result);
    }

    @Test
    void testGetFloatValueWhenNumTypesValidIsLong() throws Exception {
        // Setup
        setField(parser, "_numTypesValid", NR_LONG);
        setField(parser, "_numberLong", 123456789L);
        // Execute
        float result = parser.getFloatValue();
        // Verify
        assertEquals(123456789.0f, result);
    }

    @Test
    void testGetFloatValueWhenNumTypesValidIsInt() throws Exception {
        // Setup
        setField(parser, "_numTypesValid", NR_INT);
        setField(parser, "_numberInt", 123456);
        // Execute
        float result = parser.getFloatValue();
        // Verify
        assertEquals(123456.0f, result);
    }

    private void setField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}

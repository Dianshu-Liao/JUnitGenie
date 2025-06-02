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

class FromXmlParser__convertNumberToLong_53_1_Test {

    private FromXmlParser parser;

    private IOContext ioContext;

    private ObjectCodec objectCodec;

    private XMLStreamReader xmlReader;

    private XmlNameProcessor tagProcessor;

    private static final int NR_INT = 1;

    private static final int NR_BIGINT = 2;

    private static final int NR_LONG = 4;

    private static final BigInteger BI_MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);

    private static final BigInteger BI_MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);

    @BeforeEach
    void setUp() throws Exception {
        ioContext = mock(IOContext.class);
        objectCodec = mock(ObjectCodec.class);
        xmlReader = mock(XMLStreamReader.class);
        tagProcessor = mock(XmlNameProcessor.class);
        parser = new FromXmlParser(ioContext, 0, 0, objectCodec, xmlReader, tagProcessor);
    }

    @Test
    void testConvertNumberToLongWithValidInt() throws Exception {
        // Set up the internal state
        setInternalState(parser, "_numTypesValid", NR_INT);
        setInternalState(parser, "_numberInt", 42);
        // Invoke the method
        invokePrivateMethod(parser, "_convertNumberToLong");
        // Verify the result
        assertEquals(42L, getInternalState(parser, "_numberLong"));
        assertEquals(NR_LONG, getInternalState(parser, "_numTypesValid"));
    }

    @Test
    void testConvertNumberToLongWithValidBigInt() throws Exception {
        // Set up the internal state
        setInternalState(parser, "_numTypesValid", NR_BIGINT);
        setInternalState(parser, "_numberBigInt", BigInteger.valueOf(123456789));
        // Invoke the method
        invokePrivateMethod(parser, "_convertNumberToLong");
        // Verify the result
        assertEquals(123456789L, getInternalState(parser, "_numberLong"));
        assertEquals(NR_LONG, getInternalState(parser, "_numTypesValid"));
    }

    @Test
    void testConvertNumberToLongWithOverflow() throws Exception {
        // Set up the internal state
        setInternalState(parser, "_numTypesValid", NR_BIGINT);
        setInternalState(parser, "_numberBigInt", BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE));
        // Expect an overflow report
        assertThrows(IOException.class, () -> {
            invokePrivateMethod(parser, "_convertNumberToLong");
        });
    }

    @Test
    void testConvertNumberToLongWithInvalidType() throws Exception {
        // Set up the internal state
        // No valid number type
        setInternalState(parser, "_numTypesValid", 0);
        // Expect an internal error
        assertThrows(IOException.class, () -> {
            invokePrivateMethod(parser, "_convertNumberToLong");
        });
    }

    // Helper methods for reflection
    private void setInternalState(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private Object getInternalState(Object obj, String fieldName) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }

    private void invokePrivateMethod(Object obj, String methodName) throws Exception {
        java.lang.reflect.Method method = obj.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(obj);
    }
}

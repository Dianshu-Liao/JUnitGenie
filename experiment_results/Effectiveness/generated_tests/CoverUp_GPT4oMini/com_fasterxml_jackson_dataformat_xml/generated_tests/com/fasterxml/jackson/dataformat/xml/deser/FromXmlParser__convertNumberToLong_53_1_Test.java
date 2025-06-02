package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.math.BigInteger;
import java.lang.reflect.Method;
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

public class FromXmlParser__convertNumberToLong_53_1_Test {

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

    @Test
    public void testConvertNumberToLongWithInt() throws Exception {
        parser._numberInt = 42;
        // NR_INT
        parser._numTypesValid = 1;
        invokePrivateMethod("_convertNumberToLong");
        assertEquals(42L, parser._numberLong);
        // NR_LONG
        assertEquals(2, parser._numTypesValid);
    }

    @Test
    public void testConvertNumberToLongWithBigIntegerInRange() throws Exception {
        parser._numberBigInt = BigInteger.valueOf(123456789);
        // NR_BIGINT
        parser._numTypesValid = 4;
        invokePrivateMethod("_convertNumberToLong");
        assertEquals(123456789L, parser._numberLong);
        // NR_LONG
        assertEquals(2, parser._numTypesValid);
    }

    @Test
    public void testConvertNumberToLongWithBigIntegerOutOfRange() {
        parser._numberBigInt = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE);
        // NR_BIGINT
        parser._numTypesValid = 4;
        assertThrows(IOException.class, () -> invokePrivateMethod("_convertNumberToLong"));
    }

    @Test
    public void testConvertNumberToLongWithInvalidType() {
        // No valid number type
        parser._numTypesValid = 0;
        assertThrows(IOException.class, () -> invokePrivateMethod("_convertNumberToLong"));
    }

    private void invokePrivateMethod(String methodName) throws Exception {
        Method method = FromXmlParser.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(parser);
    }
}

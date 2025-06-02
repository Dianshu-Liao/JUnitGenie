package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.core.io.IOContext;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.math.BigInteger;
import java.lang.reflect.Method;
import javax.xml.stream.XMLStreamReader;
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

class FromXmlParser__convertNumberToInt_52_2_Test {

    private FromXmlParser parser;

    @BeforeEach
    void setUp() throws Exception {
        // Mock dependencies
        IOContext ioContext = new IOContext(null, null, false);
        ObjectCodec codec = null;
        XMLStreamReader xmlReader = null;
        parser = new FromXmlParser(ioContext, 0, 0, codec, xmlReader, null);
    }

    @Test
    void testConvertNumberToIntWithLong() throws Exception {
        parser._numberLong = 123456789L;
        // Assuming NR_LONG is 1
        parser._numTypesValid = 1;
        invokeConvertNumberToInt();
        assertEquals(123456789, parser._numberInt);
        // Assuming NR_INT is 2
        assertEquals(1, parser._numTypesValid & 2);
    }

    @Test
    void testConvertNumberToIntWithBigInteger() throws Exception {
        parser._numberBigInt = BigInteger.valueOf(123456789);
        // Assuming NR_BIGINT is 2
        parser._numTypesValid = 2;
        invokeConvertNumberToInt();
        assertEquals(123456789, parser._numberInt);
        // Assuming NR_INT is 2
        assertEquals(1, parser._numTypesValid & 2);
    }

    @Test
    void testConvertNumberToIntWithBigIntegerOverflow() {
        parser._numberBigInt = BigInteger.valueOf(Long.MAX_VALUE);
        // Assuming NR_BIGINT is 2
        parser._numTypesValid = 2;
        Exception exception = assertThrows(IOException.class, () -> {
            invokeConvertNumberToInt();
        });
        assertTrue(exception.getMessage().contains("Numeric value"));
    }

    @Test
    void testConvertNumberToIntWithInvalidState() {
        // Assuming NR_UNKNOWN is 0
        parser._numTypesValid = 0;
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            invokeConvertNumberToInt();
        });
        assertEquals("Internal error: invalid state", exception.getMessage());
    }

    private void invokeConvertNumberToInt() throws Exception {
        Method method = FromXmlParser.class.getDeclaredMethod("_convertNumberToInt");
        method.setAccessible(true);
        method.invoke(parser);
    }
}

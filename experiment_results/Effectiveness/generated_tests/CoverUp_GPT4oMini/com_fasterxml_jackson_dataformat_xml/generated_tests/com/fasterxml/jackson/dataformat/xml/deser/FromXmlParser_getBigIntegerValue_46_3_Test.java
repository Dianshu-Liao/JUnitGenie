package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.BigInteger;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

public class FromXmlParser_getBigIntegerValue_46_3_Test {

    private FromXmlParser parser;

    private XMLStreamReader xmlReader;

    private ObjectCodec codec;

    @BeforeEach
    public void setUp() throws IOException {
        xmlReader = Mockito.mock(XMLStreamReader.class);
        codec = Mockito.mock(ObjectCodec.class);
        IOContext ioContext = new IOContext(null, null, false);
        parser = new FromXmlParser(ioContext, 0, 0, codec, xmlReader, null);
    }

    @Test
    public void testGetBigIntegerValueWhenNotParsed() throws IOException {
        setField(parser, "_numTypesValid", 0);
        assertEquals(BigInteger.ZERO, parser.getBigIntegerValue());
    }

    @Test
    public void testGetBigIntegerValueWhenIntParsed() throws IOException {
        // NR_INT
        setField(parser, "_numTypesValid", 1);
        setField(parser, "_numberInt", 42);
        BigInteger result = parser.getBigIntegerValue();
        assertEquals(BigInteger.valueOf(42), result);
    }

    @Test
    public void testGetBigIntegerValueWhenLongParsed() throws IOException {
        // NR_LONG
        setField(parser, "_numTypesValid", 2);
        setField(parser, "_numberLong", 123456789L);
        BigInteger result = parser.getBigIntegerValue();
        assertEquals(BigInteger.valueOf(123456789L), result);
    }

    @Test
    public void testGetBigIntegerValueWhenConversionNeeded() throws IOException {
        // NR_LONG
        setField(parser, "_numTypesValid", 2);
        setField(parser, "_numberLong", 987654321L);
        BigInteger result = parser.getBigIntegerValue();
        assertEquals(BigInteger.valueOf(987654321L), result);
    }

    @Test
    public void testGetBigIntegerValueThrowsExceptionOnInvalidState() {
        setField(parser, "_numTypesValid", 0);
        assertThrows(IOException.class, () -> {
            parser.getBigIntegerValue();
        });
    }

    private void setField(Object obj, String fieldName, Object value) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

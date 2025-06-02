package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.deser.FromXmlParser;
import javax.xml.stream.XMLStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
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

public class FromXmlParser_getNumberValue_43_0_Test {

    private FromXmlParser parser;

    @BeforeEach
    public void setUp() throws Exception {
        IOContext ioContext = Mockito.mock(IOContext.class);
        ObjectCodec codec = Mockito.mock(ObjectCodec.class);
        XMLStreamReader xmlReader = Mockito.mock(XMLStreamReader.class);
        parser = new FromXmlParser(ioContext, 0, 0, codec, xmlReader, null);
    }

    @Test
    public void testGetNumberValueWithInt() throws Exception {
        setFieldValue("numberInt", 42);
        setFieldValue("numTypesValid", getFieldValue("NR_INT"));
        Number result = parser.getNumberValue();
        assertEquals(42, result);
    }

    @Test
    public void testGetNumberValueWithLong() throws Exception {
        setFieldValue("numberLong", 42L);
        setFieldValue("numTypesValid", getFieldValue("NR_LONG"));
        Number result = parser.getNumberValue();
        assertEquals(42L, result);
    }

    @Test
    public void testGetNumberValueWithBigInteger() throws Exception {
        setFieldValue("numberBigInt", BigInteger.valueOf(42));
        setFieldValue("numTypesValid", getFieldValue("NR_BIGINT"));
        Number result = parser.getNumberValue();
        assertEquals(BigInteger.valueOf(42), result);
    }

    @Test
    public void testGetNumberValueWithUnknown() throws Exception {
        setFieldValue("numTypesValid", getFieldValue("NR_UNKNOWN"));
        assertThrows(IOException.class, () -> parser.getNumberValue());
    }

    private void setFieldValue(String fieldName, Object value) throws Exception {
        Field field = FromXmlParser.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(parser, value);
    }

    private int getFieldValue(String fieldName) throws Exception {
        Field field = FromXmlParser.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.getInt(null);
    }
}

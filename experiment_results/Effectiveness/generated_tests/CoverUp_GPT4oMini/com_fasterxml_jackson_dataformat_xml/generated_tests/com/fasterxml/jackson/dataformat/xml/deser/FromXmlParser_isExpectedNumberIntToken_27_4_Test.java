package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
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
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.PackageVersion;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;

public class FromXmlParser_isExpectedNumberIntToken_27_4_Test {

    private FromXmlParser parser;

    private XMLStreamReader xmlStreamReader;

    private ObjectCodec codec;

    @BeforeEach
    public void setUp() throws Exception {
        xmlStreamReader = mock(XMLStreamReader.class);
        codec = mock(ObjectCodec.class);
        parser = new FromXmlParser(mock(IOContext.class), 0, 0, codec, xmlStreamReader, null);
    }

    @Test
    public void testIsExpectedNumberIntToken_ValueString_ValidInt() throws Exception {
        setCurrToken(JsonToken.VALUE_STRING);
        setCurrText("123");
        boolean result = parser.isExpectedNumberIntToken();
        assertTrue(result);
        assertEquals(123, parser.getIntValue());
    }

    @Test
    public void testIsExpectedNumberIntToken_ValueString_ValidLong() throws Exception {
        setCurrToken(JsonToken.VALUE_STRING);
        setCurrText("123456789012345678");
        boolean result = parser.isExpectedNumberIntToken();
        assertTrue(result);
        assertEquals(123456789012345678L, parser.getLongValue());
    }

    @Test
    public void testIsExpectedNumberIntToken_ValueString_ValidBigInteger() throws Exception {
        setCurrToken(JsonToken.VALUE_STRING);
        setCurrText("123456789012345678901234567890");
        boolean result = parser.isExpectedNumberIntToken();
        assertTrue(result);
        assertEquals(new BigInteger("123456789012345678901234567890"), parser.getBigIntegerValue());
    }

    @Test
    public void testIsExpectedNumberIntToken_ValueString_Invalid() throws Exception {
        setCurrToken(JsonToken.VALUE_STRING);
        setCurrText("abc");
        boolean result = parser.isExpectedNumberIntToken();
        assertFalse(result);
    }

    @Test
    public void testIsExpectedNumberIntToken_ValueNumberInt() throws Exception {
        setCurrToken(JsonToken.VALUE_NUMBER_INT);
        boolean result = parser.isExpectedNumberIntToken();
        assertTrue(result);
    }

    @Test
    public void testIsExpectedNumberIntToken_ValueNumberStringLeadingWhitespace() throws Exception {
        setCurrToken(JsonToken.VALUE_STRING);
        setCurrText("   456   ");
        boolean result = parser.isExpectedNumberIntToken();
        assertTrue(result);
        assertEquals(456, parser.getIntValue());
    }

    @Test
    public void testIsExpectedNumberIntToken_ValueString_Negative() throws Exception {
        setCurrToken(JsonToken.VALUE_STRING);
        setCurrText("-123");
        boolean result = parser.isExpectedNumberIntToken();
        assertTrue(result);
        assertEquals(-123, parser.getIntValue());
    }

    @Test
    public void testIsExpectedNumberIntToken_ValueString_TooLong() throws Exception {
        setCurrToken(JsonToken.VALUE_STRING);
        // More than 19 digits
        parser._currText = "12345678901234567890";
        boolean result = parser.isExpectedNumberIntToken();
        assertTrue(result);
        assertEquals(new BigInteger("12345678901234567890"), parser.getBigIntegerValue());
    }

    @Test
    public void testIsExpectedNumberIntToken_ValueString_Empty() throws Exception {
        setCurrToken(JsonToken.VALUE_STRING);
        setCurrText("");
        boolean result = parser.isExpectedNumberIntToken();
        assertFalse(result);
    }

    private void setCurrToken(JsonToken token) throws Exception {
        setField("_currToken", token);
    }

    private void setCurrText(String text) throws Exception {
        setField("_currText", text);
    }

    private void setField(String fieldName, Object value) throws Exception {
        Field field = FromXmlParser.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(parser, value);
    }
}

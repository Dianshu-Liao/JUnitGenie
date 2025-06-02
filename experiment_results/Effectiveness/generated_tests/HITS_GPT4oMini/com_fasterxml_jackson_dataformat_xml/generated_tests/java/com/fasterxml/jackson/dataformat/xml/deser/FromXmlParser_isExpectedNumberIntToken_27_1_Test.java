package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import java.io.IOException;
import javax.xml.stream.XMLStreamReader;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.BufferRecycler;
import javax.xml.stream.XMLStreamException;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.math.BigInteger;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.util.Set;
import javax.xml.XMLConstants;
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

public class FromXmlParser_isExpectedNumberIntToken_27_1_Test {

    private FromXmlParser parser;

    @BeforeEach
    public void setUp() throws Exception {
        XMLStreamReader xmlReader = createMockXmlStreamReader();
        BufferRecycler bufferRecycler = new BufferRecycler();
        parser = new FromXmlParser(new IOContext(bufferRecycler, null, false), 0, 0, null, xmlReader, Mockito.mock(XmlNameProcessor.class));
    }

    private XMLStreamReader createMockXmlStreamReader() {
        return Mockito.mock(XMLStreamReader.class);
    }

    @Test
    public void testIsExpectedNumberIntToken_WithValidIntString() {
        parser._currText = "123";
        parser._nextToken = JsonToken.VALUE_STRING;
        boolean result = parser.isExpectedNumberIntToken();
        assertTrue(result);
        try {
            assertEquals(123, parser.getIntValue());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    public void testIsExpectedNumberIntToken_WithValidLongString() {
        parser._currText = "123456789012345678";
        parser._nextToken = JsonToken.VALUE_STRING;
        boolean result = parser.isExpectedNumberIntToken();
        assertTrue(result);
        try {
            assertEquals(123456789012345678L, parser.getLongValue());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    public void testIsExpectedNumberIntToken_WithNegativeIntString() {
        parser._currText = "-123";
        parser._nextToken = JsonToken.VALUE_STRING;
        boolean result = parser.isExpectedNumberIntToken();
        assertTrue(result);
        try {
            assertEquals(-123, parser.getIntValue());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    public void testIsExpectedNumberIntToken_WithInvalidIntString() {
        parser._currText = "abc";
        parser._nextToken = JsonToken.VALUE_STRING;
        boolean result = parser.isExpectedNumberIntToken();
        assertFalse(result);
    }

    @Test
    public void testIsExpectedNumberIntToken_WithEmptyString() {
        parser._currText = "";
        parser._nextToken = JsonToken.VALUE_STRING;
        boolean result = parser.isExpectedNumberIntToken();
        assertFalse(result);
    }
}

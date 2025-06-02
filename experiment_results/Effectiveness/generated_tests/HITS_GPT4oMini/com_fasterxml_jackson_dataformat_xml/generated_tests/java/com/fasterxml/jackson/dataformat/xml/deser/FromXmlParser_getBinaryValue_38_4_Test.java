package com.fasterxml.jackson.dataformat.xml.deser;

import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import com.fasterxml.jackson.core.io.IOContext;
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

public class FromXmlParser_getBinaryValue_38_4_Test {

    private FromXmlParser parser;

    private XMLStreamReader xmlStreamReader;

    private Base64Variant base64Variant;

    @BeforeEach
    public void setUp() throws Exception {
        xmlStreamReader = mock(XMLStreamReader.class);
        base64Variant = Base64Variants.MIME;
        parser = new FromXmlParser(new IOContext(null, null, false), 0, 0, null, xmlStreamReader, null);
    }

    private void setCurrToken(FromXmlParser parser, JsonToken token) {
        parser._nextToken = token;
    }

    @Test
    public void testGetBinaryValueWithValidBase64String() throws IOException {
        setCurrToken(parser, JsonToken.VALUE_STRING);
        // "Hello World" in Base64
        parser._currText = "SGVsbG8gV29ybGQ=";
        parser._binaryValue = null;
        byte[] result = parser.getBinaryValue(base64Variant);
        assertNotNull(result);
        assertArrayEquals("Hello World".getBytes(), result);
    }

    @Test
    public void testGetBinaryValueWithEmbeddedObject() throws IOException {
        setCurrToken(parser, JsonToken.VALUE_EMBEDDED_OBJECT);
        parser._binaryValue = new byte[] { 1, 2, 3 };
        byte[] result = parser.getBinaryValue(base64Variant);
        assertNotNull(result);
        assertArrayEquals(new byte[] { 1, 2, 3 }, result);
    }

    @Test
    public void testGetBinaryValueThrowsExceptionWhenTokenIsNotStringOrEmbedded() {
        setCurrToken(parser, JsonToken.VALUE_NUMBER_INT);
        parser._binaryValue = null;
        Exception exception = assertThrows(IOException.class, () -> {
            parser.getBinaryValue(base64Variant);
        });
        assertTrue(exception.getMessage().contains("Current token"));
    }
}

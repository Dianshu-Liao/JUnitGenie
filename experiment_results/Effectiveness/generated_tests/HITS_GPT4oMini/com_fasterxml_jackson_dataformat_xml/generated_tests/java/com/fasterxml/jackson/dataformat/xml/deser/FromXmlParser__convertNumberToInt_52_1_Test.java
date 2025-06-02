package com.fasterxml.jackson.dataformat.xml.deser;

import java.io.IOException;
import javax.xml.stream.XMLStreamReader;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
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
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

class FromXmlParser__convertNumberToInt_52_1_Test {

    private FromXmlParser parser;

    private XMLStreamReader xmlStreamReader;

    @BeforeEach
    void setUp() throws Exception {
        xmlStreamReader = mock(XMLStreamReader.class);
        IOContext ioContext = new IOContext(null, null, false);
        ObjectCodec codec = new XmlMapper().getFactory().getCodec();
        parser = new FromXmlParser(ioContext, 0, 0, codec, xmlStreamReader, null);
    }

    @Test
    void testConvertNumberToIntWithLong() throws IOException {
        parser._numberLong = 123456789L;
        // NR_LONG
        parser._numTypesValid = 2;
        parser._convertNumberToInt();
        assertEquals(123456789, parser._numberInt);
    }

    @Test
    void testConvertNumberToIntWithBigInteger() throws IOException {
        parser._numberBigInt = BigInteger.valueOf(123456789);
        // NR_BIGINT
        parser._numTypesValid = 4;
        parser._convertNumberToInt();
        assertEquals(123456789, parser._numberInt);
    }

    @Test
    void testConvertNumberToIntOutOfRange() throws IOException {
        parser._numberLong = Long.MAX_VALUE;
        // NR_LONG
        parser._numTypesValid = 2;
        Exception exception = assertThrows(IOException.class, () -> {
            parser._convertNumberToInt();
        });
        assertEquals("Numeric value (" + parser.getText() + ") out of range of int", exception.getMessage());
    }
}

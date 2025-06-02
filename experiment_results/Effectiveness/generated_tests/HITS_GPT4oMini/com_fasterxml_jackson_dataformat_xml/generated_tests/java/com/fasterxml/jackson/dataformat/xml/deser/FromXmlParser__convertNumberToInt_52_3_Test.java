package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
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
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

class FromXmlParser__convertNumberToInt_52_3_Test {

    private FromXmlParser parser;

    private IOContext ioContext;

    private ObjectCodec codec;

    private XMLStreamReader xmlReader;

    private XmlNameProcessor nameProcessor;

    @BeforeEach
    void setUp() throws Exception {
        ioContext = mock(IOContext.class);
        codec = mock(ObjectCodec.class);
        xmlReader = mock(XMLStreamReader.class);
        nameProcessor = mock(XmlNameProcessor.class);
        // Create an instance of FromXmlParser with mocked dependencies
        parser = new FromXmlParser(ioContext, 0, 0, codec, xmlReader, nameProcessor);
    }

    @Test
    void testConvertNumberToIntWithLong() throws IOException {
        // Set up the necessary state for the parser
        // A valid long value
        parser._numberLong = 123456789L;
        // Set the type as long
        parser._numTypesValid = 0b10;
        // Call the method under test
        parser._convertNumberToInt();
        // Verify the expected outcome
        assertEquals(123456789, parser._numberInt);
    }

    @Test
    void testConvertNumberToIntWithBigInteger() throws IOException {
        // Set up the necessary state for the parser
        // Max int value
        parser._numberBigInt = BigInteger.valueOf(2147483647);
        // Set the type as BigInteger
        parser._numTypesValid = 0b100;
        // Call the method under test
        parser._convertNumberToInt();
        // Verify the expected outcome
        assertEquals(2147483647, parser._numberInt);
    }

    @Test
    void testConvertNumberToIntWithOverflow() {
        // Set up the necessary state for the parser
        // Overflow value
        parser._numberBigInt = BigInteger.valueOf(2147483648L);
        // Set the type as BigInteger
        parser._numTypesValid = 0b100;
        // Expect an overflow exception
        assertThrows(IOException.class, () -> {
            parser._convertNumberToInt();
        });
    }
}

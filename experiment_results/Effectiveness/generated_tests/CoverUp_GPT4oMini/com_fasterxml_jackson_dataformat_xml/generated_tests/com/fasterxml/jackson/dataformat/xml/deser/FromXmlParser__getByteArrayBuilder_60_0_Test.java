package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.lang.reflect.Method;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
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
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.PackageVersion;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;

class FromXmlParser__getByteArrayBuilder_60_0_Test {

    private FromXmlParser parser;

    @BeforeEach
    void setUp() throws IOException {
        IOContext ioContext = mock(IOContext.class);
        ObjectCodec codec = mock(ObjectCodec.class);
        XMLStreamReader xmlReader = mock(XMLStreamReader.class);
        XmlTokenStream xmlTokenStream = mock(XmlTokenStream.class);
        XmlReadContext parsingContext = XmlReadContext.createRootContext(1, 1);
        parser = new FromXmlParser(ioContext, 0, 0, codec, xmlReader, null);
        // No need to set _xmlTokens as it is final and cannot be modified
        parser._parsingContext = parsingContext;
    }

    @Test
    void testGetByteArrayBuilder_NullBuilder() throws Exception {
        // Test when _byteArrayBuilder is null
        invokeGetByteArrayBuilder();
        assertNotNull(parser._byteArrayBuilder);
    }

    @Test
    void testGetByteArrayBuilder_ExistingBuilder() throws Exception {
        // Test when _byteArrayBuilder already exists
        parser._byteArrayBuilder = new ByteArrayBuilder();
        ByteArrayBuilder builder = invokeGetByteArrayBuilder();
        assertSame(builder, parser._byteArrayBuilder);
    }

    @Test
    void testGetByteArrayBuilder_ResetBuilder() throws Exception {
        // Test that the existing ByteArrayBuilder is reset
        parser._byteArrayBuilder = new ByteArrayBuilder();
        ByteArrayBuilder builderBeforeReset = parser._byteArrayBuilder;
        invokeGetByteArrayBuilder();
        assertNotSame(builderBeforeReset, parser._byteArrayBuilder);
    }

    private ByteArrayBuilder invokeGetByteArrayBuilder() throws Exception {
        Method method = FromXmlParser.class.getDeclaredMethod("_getByteArrayBuilder");
        method.setAccessible(true);
        return (ByteArrayBuilder) method.invoke(parser);
    }
}

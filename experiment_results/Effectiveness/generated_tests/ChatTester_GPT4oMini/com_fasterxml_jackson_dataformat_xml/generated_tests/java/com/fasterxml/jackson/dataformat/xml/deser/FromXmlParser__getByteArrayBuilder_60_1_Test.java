package com.fasterxml.jackson.dataformat.xml.deser;

import java.io.IOException;
import javax.xml.stream.XMLStreamReader;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
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
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.dataformat.xml.PackageVersion;
import com.fasterxml.jackson.dataformat.xml.XmlNameProcessor;
import com.fasterxml.jackson.dataformat.xml.util.CaseInsensitiveNameSet;
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class FromXmlParser__getByteArrayBuilder_60_1_Test {

    private FromXmlParser parser;

    @BeforeEach
    public void setUp() throws IOException {
        IOContext ioContext = mock(IOContext.class);
        int genericParserFeatures = 0;
        int xmlFeatures = 0;
        ObjectCodec codec = mock(ObjectCodec.class);
        XMLStreamReader xmlReader = mock(XMLStreamReader.class);
        XmlNameProcessor tagProcessor = mock(XmlNameProcessor.class);
        parser = new FromXmlParser(ioContext, genericParserFeatures, xmlFeatures, codec, xmlReader, tagProcessor);
    }

    @Test
    public void testGetByteArrayBuilder_WhenBuilderIsNull_ShouldInitializeBuilder() {
        ByteArrayBuilder builder = invokeGetByteArrayBuilder();
        assertNotNull(builder);
    }

    @Test
    public void testGetByteArrayBuilder_WhenBuilderIsNotNull_ShouldResetBuilder() {
        ByteArrayBuilder firstCall = invokeGetByteArrayBuilder();
        ByteArrayBuilder secondCall = invokeGetByteArrayBuilder();
        assertSame(firstCall, secondCall);
    }

    private ByteArrayBuilder invokeGetByteArrayBuilder() {
        try {
            java.lang.reflect.Method method = FromXmlParser.class.getDeclaredMethod("_getByteArrayBuilder");
            method.setAccessible(true);
            return (ByteArrayBuilder) method.invoke(parser);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

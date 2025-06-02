package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import javax.xml.stream.XMLStreamReader;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;

public class FromXmlParser__getByteArrayBuilder_60_0_Test {

    private FromXmlParser parser;

    @BeforeEach
    public void setUp() throws IOException {
        // Mocking the required parameters for the constructor
        IOContext ioContext = mock(IOContext.class);
        ObjectCodec objectCodec = mock(ObjectCodec.class);
        XMLStreamReader xmlStreamReader = mock(XMLStreamReader.class);
        parser = new FromXmlParser(ioContext, 0, 0, objectCodec, xmlStreamReader, null);
    }

    @Test
    public void testGetByteArrayBuilder_WhenByteArrayBuilderIsNull_ShouldInitialize() {
        ByteArrayBuilder builder = parser._getByteArrayBuilder();
        assertNotNull(builder, "ByteArrayBuilder should be initialized and not null");
    }

    @Test
    public void testGetByteArrayBuilder_WhenByteArrayBuilderIsNotNull_ShouldReset() {
        // First call to initialize the ByteArrayBuilder
        ByteArrayBuilder firstBuilder = parser._getByteArrayBuilder();
        // Call again to test reset functionality
        ByteArrayBuilder secondBuilder = parser._getByteArrayBuilder();
        // Assert that both calls return the same instance after reset
        assertSame(firstBuilder, secondBuilder, "ByteArrayBuilder should be the same instance after reset");
    }
}

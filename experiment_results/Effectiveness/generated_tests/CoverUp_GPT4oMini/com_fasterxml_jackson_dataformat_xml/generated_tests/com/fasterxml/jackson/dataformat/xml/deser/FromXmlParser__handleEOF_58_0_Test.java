package com.fasterxml.jackson.dataformat.xml.deser;

import com.fasterxml.jackson.core.io.IOContext;
import javax.xml.stream.XMLStreamReader;
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

class FromXmlParser__handleEOF_58_0_Test {

    private FromXmlParser parser;

    private IOContext ioContext;

    private ObjectCodec objectCodec;

    private XMLStreamReader xmlReader;

    private XmlReadContext parsingContext;

    @BeforeEach
    void setUp() throws Exception {
        ioContext = mock(IOContext.class);
        objectCodec = mock(ObjectCodec.class);
        xmlReader = mock(XMLStreamReader.class);
        parsingContext = mock(XmlReadContext.class);
        parser = new FromXmlParser(ioContext, 0, 0, objectCodec, xmlReader, null);
        parser._parsingContext = parsingContext;
    }

    @Test
    void testHandleEOF_InRoot() throws Exception {
        when(parsingContext.inRoot()).thenReturn(true);
        // Invoke the private method _handleEOF using reflection
        Method method = FromXmlParser.class.getDeclaredMethod("_handleEOF");
        method.setAccessible(true);
        method.invoke(parser);
        // No exception should be thrown
    }

    @Test
    void testHandleEOF_NotInRoot_InArray() throws Exception {
        when(parsingContext.inRoot()).thenReturn(false);
        when(parsingContext.inArray()).thenReturn(true);
        when(parsingContext.startLocation(ioContext.contentReference())).thenReturn(mock(JsonLocation.class));
        // Expecting JsonParseException to be thrown
        assertThrows(JsonParseException.class, () -> {
            Method method = FromXmlParser.class.getDeclaredMethod("_handleEOF");
            method.setAccessible(true);
            method.invoke(parser);
        });
    }

    @Test
    void testHandleEOF_NotInRoot_NotInArray() throws Exception {
        when(parsingContext.inRoot()).thenReturn(false);
        when(parsingContext.inArray()).thenReturn(false);
        when(parsingContext.startLocation(ioContext.contentReference())).thenReturn(mock(JsonLocation.class));
        // Expecting JsonParseException to be thrown
        assertThrows(JsonParseException.class, () -> {
            Method method = FromXmlParser.class.getDeclaredMethod("_handleEOF");
            method.setAccessible(true);
            method.invoke(parser);
        });
    }
}

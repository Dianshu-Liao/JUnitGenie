package com.fasterxml.jackson.dataformat.xml.deser;

import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
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
import com.fasterxml.jackson.dataformat.xml.util.StaxUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

public class FromXmlParser_overrideCurrentName_18_2_Test {

    private FromXmlParser parser;

    private IOContext mockIoContext;

    private ObjectCodec mockCodec;

    private XMLStreamReader mockXmlReader;

    private XmlNameProcessor mockTagProcessor;

    private XmlReadContext mockParsingContext;

    @BeforeEach
    public void setUp() throws IOException {
        mockIoContext = mock(IOContext.class);
        mockCodec = mock(ObjectCodec.class);
        mockXmlReader = mock(XMLStreamReader.class);
        mockTagProcessor = mock(XmlNameProcessor.class);
        mockParsingContext = mock(XmlReadContext.class);
        parser = new FromXmlParser(mockIoContext, 0, 0, mockCodec, mockXmlReader, mockTagProcessor);
        // Initialize the private fields for testing
        setPrivateField(parser, "_parsingContext", mockParsingContext);
    }

    @Test
    public void testOverrideCurrentName_AtStartObject() {
        setPrivateField(parser, "_currToken", JsonToken.START_OBJECT);
        when(mockParsingContext.getParent()).thenReturn(mockParsingContext);
        String name = "testName";
        parser.overrideCurrentName(name);
        verify(mockParsingContext).setCurrentName(name);
    }

    @Test
    public void testOverrideCurrentName_AtStartArray() {
        setPrivateField(parser, "_currToken", JsonToken.START_ARRAY);
        when(mockParsingContext.getParent()).thenReturn(mockParsingContext);
        String name = "testName";
        parser.overrideCurrentName(name);
        verify(mockParsingContext).setCurrentName(name);
    }

    @Test
    public void testOverrideCurrentName_AtOtherToken() {
        setPrivateField(parser, "_currToken", JsonToken.VALUE_STRING);
        String name = "testName";
        parser.overrideCurrentName(name);
        verify(mockParsingContext, never()).setCurrentName(anyString());
    }

    @Test
    public void testOverrideCurrentName_AtNullToken() {
        setPrivateField(parser, "_currToken", null);
        String name = "testName";
        parser.overrideCurrentName(name);
        verify(mockParsingContext, never()).setCurrentName(anyString());
    }

    private void setPrivateField(Object target, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(target, value);
        } catch (Exception e) {
            fail("Failed to set private field: " + fieldName);
        }
    }
}

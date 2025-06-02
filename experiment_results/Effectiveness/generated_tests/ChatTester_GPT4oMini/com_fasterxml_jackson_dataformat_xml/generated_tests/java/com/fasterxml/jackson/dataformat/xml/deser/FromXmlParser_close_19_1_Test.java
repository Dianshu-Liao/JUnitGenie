// Test method
package com.fasterxml.jackson.dataformat.xml.deser;

import javax.xml.stream.XMLStreamException;
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

public class FromXmlParser_close_19_1_Test {

    @Mock
    private IOContext mockIoContext;

    @Mock
    private XMLStreamReader mockXmlReader;

    @Mock
    private XmlTokenStream mockXmlTokens;

    @Mock
    private ObjectCodec mockCodec;

    private FromXmlParser parser;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        parser = new FromXmlParser(mockIoContext, 0, 0, mockCodec, mockXmlReader, null);
        // Fixed Buggy Line: Use reflection to set the private final field _xmlTokens
        java.lang.reflect.Field field = FromXmlParser.class.getDeclaredField("_xmlTokens");
        field.setAccessible(true);
        field.set(parser, mockXmlTokens);
    }

    @Test
    public void testClose_WhenNotClosedAndResourceManaged() throws Exception {
        when(mockIoContext.isResourceManaged()).thenReturn(true);
        parser.close();
        assertTrue(parser._closed);
        verify(mockXmlTokens).closeCompletely();
        verify(mockIoContext).close();
    }

    @Test
    public void testClose_WhenNotClosedAndAutoCloseSourceEnabled() throws Exception {
        when(mockIoContext.isResourceManaged()).thenReturn(false);
        when(parser.isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE)).thenReturn(true);
        parser.close();
        assertTrue(parser._closed);
        verify(mockXmlTokens).closeCompletely();
        verify(mockIoContext).close();
    }

    @Test
    public void testClose_WhenNotClosedAndNeitherCondition() throws Exception {
        when(mockIoContext.isResourceManaged()).thenReturn(false);
        when(parser.isEnabled(JsonParser.Feature.AUTO_CLOSE_SOURCE)).thenReturn(false);
        parser.close();
        assertTrue(parser._closed);
        verify(mockXmlTokens).close();
        verify(mockIoContext).close();
    }

    @Test
    public void testClose_WhenAlreadyClosed() throws Exception {
        parser._closed = true;
        parser.close();
        assertTrue(parser._closed);
        verify(mockXmlTokens, never()).close();
        verify(mockXmlTokens, never()).closeCompletely();
        verify(mockIoContext, never()).close();
    }

    @Test
    public void testClose_WhenXmlStreamExceptionThrown() throws Exception {
        when(mockIoContext.isResourceManaged()).thenReturn(true);
        doThrow(new XMLStreamException("Test Exception")).when(mockXmlTokens).closeCompletely();
        assertThrows(IOException.class, () -> {
            parser.close();
        });
        assertTrue(parser._closed);
        verify(mockIoContext).close();
    }
}

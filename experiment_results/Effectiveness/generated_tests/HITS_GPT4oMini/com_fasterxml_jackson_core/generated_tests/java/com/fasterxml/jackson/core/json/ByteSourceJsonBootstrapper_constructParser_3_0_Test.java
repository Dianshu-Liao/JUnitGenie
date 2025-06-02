package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.util.VersionUtil;

public class ByteSourceJsonBootstrapper_constructParser_3_0_Test {

    private ByteSourceJsonBootstrapper bootstrapper;

    private IOContext ioContext;

    private ByteQuadsCanonicalizer byteQuadsCanonicalizer;

    private CharsToNameCanonicalizer charsToNameCanonicalizer;

    private ObjectCodec objectCodec;

    @BeforeEach
    public void setUp() {
        ioContext = mock(IOContext.class);
        byteQuadsCanonicalizer = mock(ByteQuadsCanonicalizer.class);
        charsToNameCanonicalizer = mock(CharsToNameCanonicalizer.class);
        objectCodec = mock(ObjectCodec.class);
        // Example buffer
        byte[] inputBuffer = new byte[1024];
        bootstrapper = new ByteSourceJsonBootstrapper(ioContext, new ByteArrayInputStream(inputBuffer));
    }

    @Test
    public void testConstructParserWithCharsetDetectionEnabled() throws IOException {
        int parserFeatures = 0;
        int factoryFeatures = JsonFactory.Feature.CHARSET_DETECTION.getMask();
        when(ioContext.getEncoding()).thenReturn(JsonEncoding.UTF8);
        JsonParser parser = bootstrapper.constructParser(parserFeatures, objectCodec, byteQuadsCanonicalizer, charsToNameCanonicalizer, factoryFeatures);
        assertNotNull(parser);
        assertTrue(parser instanceof UTF8StreamJsonParser);
    }

    @Test
    public void testConstructParserWithCharsetDetectionDisabled() throws IOException {
        int parserFeatures = 0;
        // No charset detection
        int factoryFeatures = 0;
        when(ioContext.getEncoding()).thenReturn(JsonEncoding.UTF8);
        JsonParser parser = bootstrapper.constructParser(parserFeatures, objectCodec, byteQuadsCanonicalizer, charsToNameCanonicalizer, factoryFeatures);
        assertNotNull(parser);
        assertTrue(parser instanceof ReaderBasedJsonParser);
    }

    @Test
    public void testDetectEncodingCalledWhenCharsetDetectionEnabled() throws IOException {
        int parserFeatures = 0;
        int factoryFeatures = JsonFactory.Feature.CHARSET_DETECTION.getMask();
        when(ioContext.getEncoding()).thenReturn(JsonEncoding.UTF8);
        doNothing().when(bootstrapper).detectEncoding();
        bootstrapper.constructParser(parserFeatures, objectCodec, byteQuadsCanonicalizer, charsToNameCanonicalizer, factoryFeatures);
        verify(bootstrapper, times(1)).detectEncoding();
    }

    @Test
    public void testDetectEncodingNotCalledWhenCharsetDetectionDisabled() throws IOException {
        int parserFeatures = 0;
        // No charset detection
        int factoryFeatures = 0;
        when(ioContext.getEncoding()).thenReturn(JsonEncoding.UTF8);
        doNothing().when(bootstrapper).detectEncoding();
        bootstrapper.constructParser(parserFeatures, objectCodec, byteQuadsCanonicalizer, charsToNameCanonicalizer, factoryFeatures);
        verify(bootstrapper, never()).detectEncoding();
    }
}

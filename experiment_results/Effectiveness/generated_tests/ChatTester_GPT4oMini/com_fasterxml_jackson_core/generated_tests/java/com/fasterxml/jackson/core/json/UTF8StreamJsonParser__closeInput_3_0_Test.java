package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8StreamJsonParser__closeInput_3_0_Test {

    @Mock
    private IOContext mockIOContext;

    @Mock
    private ObjectCodec mockObjectCodec;

    @Mock
    private ByteQuadsCanonicalizer mockByteQuadsCanonicalizer;

    @Mock
    private InputStream mockInputStream;

    private UTF8StreamJsonParser parser;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        parser = new UTF8StreamJsonParser(mockIOContext, 0, mockInputStream, mockObjectCodec, mockByteQuadsCanonicalizer, null, 0, 0, false);
    }

    @Test
    public void testCloseInput_WhenInputStreamIsNotNullAndResourceManaged() throws IOException {
        when(mockIOContext.isResourceManaged()).thenReturn(true);
        parser._closeInput();
        verify(mockInputStream, times(1)).close();
        assertNull(parser._inputStream);
    }

    @Test
    public void testCloseInput_WhenInputStreamIsNotNullAndAutoCloseSourceEnabled() throws IOException {
        when(mockIOContext.isResourceManaged()).thenReturn(false);
        parser.enable(UTF8StreamJsonParser.Feature.AUTO_CLOSE_SOURCE);
        parser._closeInput();
        verify(mockInputStream, times(1)).close();
        assertNull(parser._inputStream);
    }

    @Test
    public void testCloseInput_WhenInputStreamIsNotNullAndNeitherResourceManagedNorAutoCloseEnabled() throws IOException {
        when(mockIOContext.isResourceManaged()).thenReturn(false);
        parser.disable(UTF8StreamJsonParser.Feature.AUTO_CLOSE_SOURCE);
        parser._closeInput();
        verify(mockInputStream, times(0)).close();
        assertNull(parser._inputStream);
    }

    @Test
    public void testCloseInput_WhenInputStreamIsNull() throws IOException {
        parser._inputStream = null;
        parser._closeInput();
        verify(mockInputStream, times(0)).close();
    }
}

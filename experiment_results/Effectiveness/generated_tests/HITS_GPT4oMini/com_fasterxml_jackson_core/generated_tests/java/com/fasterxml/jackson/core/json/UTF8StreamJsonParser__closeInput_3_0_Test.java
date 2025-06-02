package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.util.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class UTF8StreamJsonParser__closeInput_3_0_Test {

    private UTF8StreamJsonParser parser;

    private IOContext mockIOContext;

    private ByteQuadsCanonicalizer mockByteQuadsCanonicalizer;

    private ObjectCodec mockObjectCodec;

    @BeforeEach
    public void setUp() {
        mockIOContext = mock(IOContext.class);
        mockByteQuadsCanonicalizer = mock(ByteQuadsCanonicalizer.class);
        mockObjectCodec = mock(ObjectCodec.class);
        parser = new UTF8StreamJsonParser(mockIOContext, 0, null, mockObjectCodec, mockByteQuadsCanonicalizer, new byte[0], 0, 0, false);
    }

    @Test
    public void testCloseInput_WhenInputStreamIsNull() throws IOException {
        parser._closeInput();
        assertNull(parser._inputStream, "InputStream should be null after close.");
    }

    @Test
    public void testCloseInput_WhenResourceManagedAndInputStreamIsNotNull() throws IOException {
        InputStream inputStream = new ByteArrayInputStream(new byte[] {});
        parser._inputStream = inputStream;
        when(mockIOContext.isResourceManaged()).thenReturn(true);
        parser._closeInput();
        assertNull(parser._inputStream, "InputStream should be null after close when resource is managed.");
        verify(inputStream).close();
    }

    @Test
    public void testCloseInput_WhenAutoCloseSourceIsEnabled() throws IOException {
        InputStream inputStream = new ByteArrayInputStream(new byte[] {});
        parser._inputStream = inputStream;
        when(mockIOContext.isResourceManaged()).thenReturn(false);
        parser.enable(Feature.AUTO_CLOSE_SOURCE);
        parser._closeInput();
        assertNull(parser._inputStream, "InputStream should be null after close when auto close source is enabled.");
        verify(inputStream).close();
    }

    @Test
    public void testCloseInput_WhenResourceNotManagedAndAutoCloseSourceIsNotEnabled() throws IOException {
        InputStream inputStream = new ByteArrayInputStream(new byte[] {});
        parser._inputStream = inputStream;
        when(mockIOContext.isResourceManaged()).thenReturn(false);
        parser.disable(Feature.AUTO_CLOSE_SOURCE);
        parser._closeInput();
        assertNotNull(parser._inputStream, "InputStream should not be null after close when neither resource is managed nor auto close source is enabled.");
    }

    @Test
    public void testCloseInput_WhenInputStreamIsAlreadyClosed() throws IOException {
        InputStream inputStream = mock(InputStream.class);
        parser._inputStream = inputStream;
        when(mockIOContext.isResourceManaged()).thenReturn(true);
        doThrow(new IOException("Stream already closed")).when(inputStream).close();
        assertThrows(IOException.class, () -> parser._closeInput(), "Expected IOException when closing an already closed InputStream.");
    }
}

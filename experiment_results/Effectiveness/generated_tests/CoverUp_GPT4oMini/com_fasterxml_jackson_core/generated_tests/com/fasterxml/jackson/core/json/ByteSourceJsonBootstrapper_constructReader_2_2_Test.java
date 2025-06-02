package com.fasterxml.jackson.core.json;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.VersionUtil;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.*;

class ByteSourceJsonBootstrapper_constructReader_2_2_Test {

    private IOContext mockContext;

    private ByteSourceJsonBootstrapper bootstrapper;

    private InputStream mockInputStream;

    private byte[] inputBuffer;

    @BeforeEach
    void setUp() {
        mockContext = mock(IOContext.class);
        mockInputStream = mock(InputStream.class);
        inputBuffer = new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF, 't', 'e', 's', 't' };
    }

    @Test
    void testConstructReaderWithNullInputStreamAndShortBuffer() throws IOException {
        when(mockContext.getEncoding()).thenReturn(JsonEncoding.UTF8);
        bootstrapper = new ByteSourceJsonBootstrapper(mockContext, inputBuffer, 0, inputBuffer.length);
        Reader reader = bootstrapper.constructReader();
        assertNotNull(reader);
        assertTrue(reader instanceof StringReader);
        assertEquals("test", readAll(reader));
    }

    @Test
    void testConstructReaderWithNullInputStreamAndLongBuffer() throws IOException {
        when(mockContext.getEncoding()).thenReturn(JsonEncoding.UTF8);
        bootstrapper = new ByteSourceJsonBootstrapper(mockContext, inputBuffer, 0, 10);
        Reader reader = bootstrapper.constructReader();
        assertNotNull(reader);
        assertTrue(reader instanceof InputStreamReader);
        assertEquals("test", readAll(reader));
    }

    @Test
    void testConstructReaderWithExistingInputStream() throws IOException {
        when(mockContext.getEncoding()).thenReturn(JsonEncoding.UTF8);
        bootstrapper = new ByteSourceJsonBootstrapper(mockContext, mockInputStream);
        when(mockInputStream.read(any(byte[].class), anyInt(), anyInt())).thenReturn(4);
        when(mockInputStream.read()).thenReturn((int) 't', (int) 'e', (int) 's', (int) 't', -1);
        Reader reader = bootstrapper.constructReader();
        assertNotNull(reader);
        assertTrue(reader instanceof InputStreamReader);
        assertEquals("test", readAll(reader));
    }

    @Test
    void testConstructReaderWithUTF32Encoding() throws IOException {
        when(mockContext.getEncoding()).thenReturn(JsonEncoding.UTF32_BE);
        bootstrapper = new ByteSourceJsonBootstrapper(mockContext, mockInputStream);
        Reader reader = bootstrapper.constructReader();
        assertNotNull(reader);
        assertTrue(reader instanceof UTF32Reader);
    }

    @Test
    void testConstructReaderThrowsExceptionOnInvalidEncoding() {
        when(mockContext.getEncoding()).thenReturn(null);
        bootstrapper = new ByteSourceJsonBootstrapper(mockContext, mockInputStream);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            bootstrapper.constructReader();
        });
        assertEquals("Internal error: this code path should never get executed", exception.getMessage());
    }

    private String readAll(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        char[] buffer = new char[1024];
        int numRead;
        while ((numRead = reader.read(buffer)) != -1) {
            sb.append(buffer, 0, numRead);
        }
        return sb.toString();
    }
}

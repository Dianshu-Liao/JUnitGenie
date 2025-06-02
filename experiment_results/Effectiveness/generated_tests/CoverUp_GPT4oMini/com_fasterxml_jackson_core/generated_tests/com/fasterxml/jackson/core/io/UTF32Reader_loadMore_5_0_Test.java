package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.io.IOContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;

class UTF32Reader_loadMore_5_0_Test {

    private IOContext context;

    private ByteArrayInputStream inputStream;

    private byte[] buffer;

    private UTF32Reader reader;

    @BeforeEach
    void setUp() {
        context = new IOContext(null, null, null, null, null, false);
        // Buffer size of 8 bytes
        buffer = new byte[8];
        // Input stream with 4 bytes
        inputStream = new ByteArrayInputStream(new byte[] { 0, 0, 0, 0 });
        reader = new UTF32Reader(context, inputStream, buffer, 0, 0, true);
    }

    @Test
    void testLoadMoreWithAvailableBytes() throws IOException {
        // Simulate that there are 4 bytes available to read
        assertTrue(invokeLoadMore(4));
        assertEquals(4, reader._length);
        assertEquals(0, reader._ptr);
    }

    @Test
    void testLoadMoreWithNoInputStream() throws IOException {
        // Simulate no input stream
        reader._in = null;
        assertFalse(invokeLoadMore(0));
    }

    @Test
    void testLoadMoreWithEOF() throws IOException {
        inputStream = new ByteArrayInputStream(new byte[] {});
        // Input stream with no bytes
        reader._in = inputStream;
        assertFalse(invokeLoadMore(0));
    }

    @Test
    void testLoadMoreWithInsufficientBytes() {
        // Input stream with 2 bytes
        inputStream = new ByteArrayInputStream(new byte[] { 0, 0 });
        reader._in = inputStream;
        assertThrows(CharConversionException.class, () -> invokeLoadMore(0));
    }

    @Test
    void testLoadMoreWithZeroCount() {
        inputStream = new ByteArrayInputStream(new byte[] { 0, 0, 0, 0 });
        reader._in = inputStream;
        assertThrows(IOException.class, () -> invokeLoadMore(0));
    }

    private boolean invokeLoadMore(int available) throws IOException {
        try {
            java.lang.reflect.Method method = UTF32Reader.class.getDeclaredMethod("loadMore", int.class);
            method.setAccessible(true);
            return (boolean) method.invoke(reader, available);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

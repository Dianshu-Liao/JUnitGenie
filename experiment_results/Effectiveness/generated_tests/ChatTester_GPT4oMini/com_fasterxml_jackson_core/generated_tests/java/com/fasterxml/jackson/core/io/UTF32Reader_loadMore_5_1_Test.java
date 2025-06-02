package com.fasterxml.jackson.core.io;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;

class UTF32Reader_loadMore_5_1_Test {

    private UTF32Reader utf32Reader;

    private IOContext mockContext;

    private InputStream mockInputStream;

    private byte[] buffer;

    @BeforeEach
    void setUp() {
        mockContext = Mockito.mock(IOContext.class);
        buffer = new byte[1024];
        // Example input
        mockInputStream = new ByteArrayInputStream(new byte[] { 0, 0, 0, 0 });
        utf32Reader = new UTF32Reader(mockContext, mockInputStream, buffer, 0, 0, true);
    }

    @Test
    void testLoadMore_WithNullInputStream() throws IOException {
        utf32Reader = new UTF32Reader(mockContext, null, buffer, 0, 0, true);
        boolean result = invokeLoadMore(0);
        assertFalse(result);
    }

    @Test
    void testLoadMore_WithNullBuffer() throws IOException {
        utf32Reader = new UTF32Reader(mockContext, mockInputStream, null, 0, 0, true);
        boolean result = invokeLoadMore(0);
        assertFalse(result);
    }

    @Test
    void testLoadMore_WithAvailableBytes() throws IOException {
        boolean result = invokeLoadMore(4);
        assertTrue(result);
        assertEquals(0, utf32Reader._ptr);
        assertEquals(4, utf32Reader._length);
    }

    @Test
    void testLoadMore_WithEOF() throws IOException {
        utf32Reader = new UTF32Reader(mockContext, new ByteArrayInputStream(new byte[0]), buffer, 0, 0, true);
        boolean result = invokeLoadMore(0);
        assertFalse(result);
    }

    @Test
    void testLoadMore_WithInsufficientBytes() throws IOException {
        utf32Reader = new UTF32Reader(mockContext, new ByteArrayInputStream(new byte[2]), buffer, 0, 0, true);
        Exception exception = assertThrows(IOException.class, () -> {
            invokeLoadMore(0);
        });
        assertTrue(exception.getMessage().contains("Unexpected EOF"));
    }

    @Test
    void testLoadMore_WithZeroAvailableBytes() throws IOException {
        // Test with 0 available bytes
        boolean result = invokeLoadMore(0);
        assertTrue(result);
        assertEquals(0, utf32Reader._ptr);
        // Ensure we read at least 4 bytes
        assertTrue(utf32Reader._length >= 4);
    }

    private boolean invokeLoadMore(int available) throws IOException {
        try {
            java.lang.reflect.Method method = UTF32Reader.class.getDeclaredMethod("loadMore", int.class);
            method.setAccessible(true);
            return (boolean) method.invoke(utf32Reader, available);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

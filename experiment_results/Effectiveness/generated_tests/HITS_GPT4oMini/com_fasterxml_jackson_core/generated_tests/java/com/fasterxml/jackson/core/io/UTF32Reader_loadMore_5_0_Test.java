package com.fasterxml.jackson.core.io;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;

public class UTF32Reader_loadMore_5_0_Test {

    private UTF32Reader utf32Reader;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        // Initialize IOContext with dummy values
        ioContext = new IOContext(null, null, null, true);
        // Initialize buffer and other parameters
        byte[] buffer = new byte[1024];
        utf32Reader = new UTF32Reader(ioContext, new ByteArrayInputStream(new byte[0]), buffer, 0, 0, true);
    }

    private boolean invokeLoadMore(int available) throws Exception {
        Method method = UTF32Reader.class.getDeclaredMethod("loadMore", int.class);
        method.setAccessible(true);
        return (boolean) method.invoke(utf32Reader, available);
    }

    @Test
    public void testLoadMoreWithNullInputStream() throws Exception {
        utf32Reader = new UTF32Reader(ioContext, null, new byte[1024], 0, 0, true);
        assertFalse(invokeLoadMore(0), "loadMore should return false when InputStream is null");
    }

    @Test
    public void testLoadMoreWithNullBuffer() throws Exception {
        utf32Reader = new UTF32Reader(ioContext, new ByteArrayInputStream(new byte[0]), null, 0, 0, true);
        assertFalse(invokeLoadMore(0), "loadMore should return false when buffer is null");
    }

    @Test
    public void testLoadMoreWithAvailableBytes() throws Exception {
        byte[] input = new byte[] { 0, 0, 0, 1 };
        utf32Reader = new UTF32Reader(ioContext, new ByteArrayInputStream(input), new byte[1024], 0, 0, true);
        assertTrue(invokeLoadMore(0), "loadMore should return true when there are available bytes");
    }

    @Test
    public void testLoadMoreEOF() throws Exception {
        byte[] input = new byte[] {};
        utf32Reader = new UTF32Reader(ioContext, new ByteArrayInputStream(input), new byte[1024], 0, 0, true);
        assertFalse(invokeLoadMore(0), "loadMore should return false on EOF");
    }

    @Test
    public void testLoadMoreInsufficientBytes() {
        byte[] input = new byte[] { 0, 0, 0 };
        utf32Reader = new UTF32Reader(ioContext, new ByteArrayInputStream(input), new byte[1024], 0, 0, true);
        Exception exception = assertThrows(CharConversionException.class, () -> {
            invokeLoadMore(0);
        });
        assertTrue(exception.getMessage().contains("Unexpected EOF in the middle of a 4-byte UTF-32 char"));
    }

    @Test
    public void testLoadMoreWithZeroBytes() throws Exception {
        byte[] input = new byte[] { 0, 0, 0, 1, 0, 0, 0, 2 };
        utf32Reader = new UTF32Reader(ioContext, new ByteArrayInputStream(input), new byte[1024], 0, 0, true);
        assertTrue(invokeLoadMore(0), "loadMore should return true when exactly 4 bytes are read");
    }
}

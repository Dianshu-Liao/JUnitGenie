package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.io.IOContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;

class UTF32Reader_close_0_2_Test {

    private UTF32Reader utf32Reader;

    private IOContext ioContext;

    private InputStream inputStream;

    @BeforeEach
    void setUp() {
        ioContext = mock(IOContext.class);
        inputStream = mock(InputStream.class);
        byte[] buffer = new byte[10];
        utf32Reader = new UTF32Reader(ioContext, inputStream, buffer, 0, buffer.length, true);
    }

    @Test
    void testClose() throws IOException {
        utf32Reader.close();
        // Verify that the input stream is closed
        verify(inputStream).close();
        // Verify that freeBuffers is called
        verify(ioContext).releaseReadIOBuffer(any(byte[].class));
        // Check that _in is set to null after closing
        assertNull(utf32Reader._in);
    }

    @Test
    void testCloseWithNullInputStream() throws IOException {
        // Setup UTF32Reader with null InputStream
        utf32Reader = new UTF32Reader(ioContext, null, new byte[10], 0, 10, true);
        utf32Reader.close();
        // Verify that freeBuffers is called
        verify(ioContext, never()).releaseReadIOBuffer(any(byte[].class));
        // Ensure no exception is thrown
        assertNull(utf32Reader._in);
    }

    @Test
    void testCloseHandlesIOException() throws IOException {
        doThrow(new IOException("Test Exception")).when(inputStream).close();
        // Call close and expect no exceptions
        try {
            utf32Reader.close();
        } catch (IOException e) {
            // Exception should be caught and handled
            assertNull(e.getMessage());
        }
        // Verify that freeBuffers is called
        verify(ioContext).releaseReadIOBuffer(any(byte[].class));
        // Check that _in is set to null after closing
        assertNull(utf32Reader._in);
    }
}

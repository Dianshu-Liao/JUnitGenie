package com.fasterxml.jackson.core.io;

import com.fasterxml.jackson.core.io.IOContext;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

class MergedStream_skip_8_0_Test {

    private IOContext ioContext;

    private InputStream inputStream;

    private byte[] buffer;

    private MergedStream mergedStream;

    @BeforeEach
    void setUp() {
        ioContext = mock(IOContext.class);
        inputStream = new ByteArrayInputStream("Hello World".getBytes());
        buffer = new byte[5];
        mergedStream = new MergedStream(ioContext, inputStream, buffer, 0, buffer.length);
    }

    @Test
    void testSkipAllInBuffer() throws IOException {
        mergedStream.skip(5);
        long skipped = mergedStream.skip(3);
        assertEquals(3, skipped);
    }

    @Test
    void testSkipPartialBuffer() throws IOException {
        mergedStream.skip(5);
        long skipped = mergedStream.skip(7);
        assertEquals(7, skipped);
    }

    @Test
    void testSkipMoreThanAvailable() throws IOException {
        mergedStream.skip(5);
        long skipped = mergedStream.skip(10);
        assertEquals(10, skipped);
    }

    @Test
    void testSkipZero() throws IOException {
        long skipped = mergedStream.skip(0);
        assertEquals(0, skipped);
    }

    @Test
    void testSkipNegative() throws IOException {
        long skipped = mergedStream.skip(-1);
        assertEquals(0, skipped);
    }

    @Test
    void testSkipWithEmptyBuffer() throws IOException {
        mergedStream = new MergedStream(ioContext, inputStream, null, 0, 0);
        long skipped = mergedStream.skip(5);
        assertEquals(0, skipped);
    }

    @Test
    void testSkipWithNullInputStream() {
        mergedStream = new MergedStream(ioContext, null, buffer, 0, buffer.length);
        assertThrows(IOException.class, () -> mergedStream.skip(5));
    }

    // Reflection to test private method _free
    @Test
    void testFreeBuffer() throws Exception {
        // Use reflection to access the private _free method
        java.lang.reflect.Method freeMethod = MergedStream.class.getDeclaredMethod("_free");
        freeMethod.setAccessible(true);
        // Call the _free method
        freeMethod.invoke(mergedStream);
        // Verify that the buffer is freed
        java.lang.reflect.Field bufferField = MergedStream.class.getDeclaredField("_b");
        bufferField.setAccessible(true);
        assertNull(bufferField.get(mergedStream));
        verify(ioContext).releaseReadIOBuffer(buffer);
    }
}

package com.fasterxml.jackson.core.io;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

public class MergedStream_skip_8_0_Test {

    private IOContext ioContext;

    private InputStream inputStream;

    private byte[] buffer;

    private MergedStream mergedStream;

    @BeforeEach
    public void setUp() {
        ioContext = mock(IOContext.class);
        buffer = new byte[] { 1, 2, 3, 4, 5 };
        inputStream = new ByteArrayInputStream(new byte[] { 6, 7, 8, 9, 10 });
        mergedStream = new MergedStream(ioContext, inputStream, buffer, 0, buffer.length);
    }

    @Test
    public void testSkipWithinBufferedData() throws IOException {
        long skipped = mergedStream.skip(3);
        assertEquals(3, skipped);
    }

    @Test
    public void testSkipExceedingBufferedData() throws IOException {
        long skipped = mergedStream.skip(10);
        assertEquals(10, skipped);
    }

    @Test
    public void testSkipExactBufferedData() throws IOException {
        long skipped = mergedStream.skip(5);
        assertEquals(5, skipped);
    }

    @Test
    public void testSkipZeroBytes() throws IOException {
        long skipped = mergedStream.skip(0);
        assertEquals(0, skipped);
    }

    @Test
    public void testSkipWithNegativeValue() throws IOException {
        long skipped = mergedStream.skip(-1);
        assertEquals(0, skipped);
    }

    @Test
    public void testSkipWithNullBuffer() throws IOException {
        mergedStream = new MergedStream(ioContext, inputStream, null, 0, 0);
        long skipped = mergedStream.skip(5);
        assertEquals(0, skipped);
    }

    @Test
    public void testSkipWithEmptyInputStream() throws IOException {
        mergedStream = new MergedStream(ioContext, new ByteArrayInputStream(new byte[0]), buffer, 0, buffer.length);
        long skipped = mergedStream.skip(5);
        assertEquals(0, skipped);
    }
}

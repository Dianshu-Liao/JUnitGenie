package org.apache.commons.compress.compressors.lzma;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.compress.MemoryLimitException;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;
import org.tukaani.xz.LZMAInputStream;

public class LZMACompressorInputStream_read_5_3_Test {

    private LZMACompressorInputStream compressorInputStream;

    private InputStream mockInputStream;

    @BeforeEach
    public void setUp() throws IOException {
        mockInputStream = mock(InputStream.class);
        compressorInputStream = new LZMACompressorInputStream(mockInputStream);
    }

    @Test
    public void testReadReturnsCorrectBytes() throws IOException {
        byte[] buffer = new byte[10];
        byte[] data = new byte[] { 1, 2, 3, 4, 5 };
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        doReturn(5).when(mockInputStream).read(buffer, 0, 10);
        int bytesRead = compressorInputStream.read(buffer, 0, 10);
        assertEquals(5, bytesRead);
        assertEquals(1, buffer[0]);
        assertEquals(2, buffer[1]);
        assertEquals(3, buffer[2]);
        assertEquals(4, buffer[3]);
        assertEquals(5, buffer[4]);
    }

    @Test
    public void testReadHandlesEndOfStream() throws IOException {
        byte[] buffer = new byte[10];
        doReturn(-1).when(mockInputStream).read(buffer, 0, 10);
        int bytesRead = compressorInputStream.read(buffer, 0, 10);
        assertEquals(-1, bytesRead);
    }

    @Test
    public void testReadThrowsIOException() throws IOException {
        byte[] buffer = new byte[10];
        doThrow(new IOException("Mocked IO Exception")).when(mockInputStream).read(buffer, 0, 10);
        assertThrows(IOException.class, () -> {
            compressorInputStream.read(buffer, 0, 10);
        });
    }

    @Test
    public void testReadPartialBytes() throws IOException {
        byte[] buffer = new byte[10];
        byte[] data = new byte[] { 1, 2, 3 };
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        doReturn(3).when(mockInputStream).read(buffer, 0, 10);
        int bytesRead = compressorInputStream.read(buffer, 0, 10);
        assertEquals(3, bytesRead);
        assertEquals(1, buffer[0]);
        assertEquals(2, buffer[1]);
        assertEquals(3, buffer[2]);
    }
}

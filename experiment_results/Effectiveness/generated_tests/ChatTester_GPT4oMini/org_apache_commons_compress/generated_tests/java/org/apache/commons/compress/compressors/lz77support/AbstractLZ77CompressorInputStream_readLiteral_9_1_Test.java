package org.apache.commons.compress.compressors.lz77support;

import java.io.IOException;
import java.io.InputStream;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AbstractLZ77CompressorInputStream_readLiteral_9_1_Test {

    private TestLZ77CompressorInputStream compressorInputStream;

    private BoundedInputStream mockInputStream;

    @BeforeEach
    public void setUp() {
        mockInputStream = mock(BoundedInputStream.class);
        compressorInputStream = new TestLZ77CompressorInputStream(mockInputStream, 1024);
    }

    @Test
    public void testReadLiteral_WithAvailableBytes() throws IOException {
        byte[] buffer = new byte[10];
        when(compressorInputStream.available()).thenReturn(10);
        when(compressorInputStream.readFromBuffer(buffer, 0, 10)).thenReturn(10);
        int bytesRead = compressorInputStream.readLiteral(buffer, 0, 10);
        assertEquals(10, bytesRead);
    }

    @Test
    public void testReadLiteral_NeedsToReadMoreBytes() throws IOException {
        byte[] buffer = new byte[10];
        when(compressorInputStream.available()).thenReturn(5);
        when(compressorInputStream.readFromBuffer(buffer, 0, 10)).thenReturn(10);
        doNothing().when(compressorInputStream).tryToReadLiteral(5);
        int bytesRead = compressorInputStream.readLiteral(buffer, 0, 10);
        assertEquals(10, bytesRead);
        verify(compressorInputStream).tryToReadLiteral(5);
    }

    @Test
    public void testReadLiteral_ThrowsIOException() throws IOException {
        byte[] buffer = new byte[10];
        when(compressorInputStream.available()).thenReturn(5);
        doThrow(new IOException()).when(compressorInputStream).readFromBuffer(buffer, 0, 10);
        assertThrows(IOException.class, () -> {
            compressorInputStream.readLiteral(buffer, 0, 10);
        });
    }

    @Test
    public void testReadLiteral_ZeroLengthRead() throws IOException {
        byte[] buffer = new byte[10];
        int bytesRead = compressorInputStream.readLiteral(buffer, 0, 0);
        assertEquals(0, bytesRead);
    }

    @Test
    public void testReadLiteral_NegativeLengthRead() {
        byte[] buffer = new byte[10];
        assertThrows(IllegalArgumentException.class, () -> {
            compressorInputStream.readLiteral(buffer, 0, -1);
        });
    }

    private static class TestLZ77CompressorInputStream extends AbstractLZ77CompressorInputStream {

        public TestLZ77CompressorInputStream(InputStream is, int windowSize) {
            super(is, windowSize);
        }

        public int available() {
            // Mocked in tests
            return 0;
        }

        protected int readFromBuffer(byte[] b, int off, int len) throws IOException {
            // Mocked in tests
            return 0;
        }

        protected void tryToReadLiteral(int len) {
            // Mocked in tests
        }
    }
}

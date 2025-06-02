package org.apache.commons.compress.compressors.snappy;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Arrays;
import org.apache.commons.codec.digest.PureJavaCrc32C;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;

public class FramedSnappyCompressorInputStream_read_5_0_Test {

    private FramedSnappyCompressorInputStream compressorInputStream;

    @BeforeEach
    public void setUp() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(new byte[] { 0, 1, 2, 3, 4 });
        compressorInputStream = new FramedSnappyCompressorInputStream(byteArrayInputStream);
    }

    @Test
    public void testReadReturnsCorrectByte() throws IOException {
        assertEquals(0, compressorInputStream.read());
        assertEquals(1, compressorInputStream.read());
        assertEquals(2, compressorInputStream.read());
        assertEquals(3, compressorInputStream.read());
        assertEquals(4, compressorInputStream.read());
    }

    @Test
    public void testReadReturnsMinusOneAtEndOfStream() throws IOException {
        while (compressorInputStream.read() != -1) {
            // Read until the end of stream
        }
        assertEquals(-1, compressorInputStream.read());
    }

    @Test
    public void testReadThrowsIOExceptionWhenStreamIsClosed() throws IOException {
        compressorInputStream.close();
        assertThrows(IOException.class, () -> compressorInputStream.read());
    }

    @Test
    public void testReadHandlesEmptyStream() throws IOException {
        ByteArrayInputStream emptyStream = new ByteArrayInputStream(new byte[] {});
        FramedSnappyCompressorInputStream emptyCompressorInputStream = new FramedSnappyCompressorInputStream(emptyStream);
        assertEquals(-1, emptyCompressorInputStream.read());
    }

    @Test
    public void testReadHandlesSingleByteStream() throws IOException {
        ByteArrayInputStream singleByteStream = new ByteArrayInputStream(new byte[] { 42 });
        FramedSnappyCompressorInputStream singleByteCompressorInputStream = new FramedSnappyCompressorInputStream(singleByteStream);
        assertEquals(42, singleByteCompressorInputStream.read());
        assertEquals(-1, singleByteCompressorInputStream.read());
    }
}

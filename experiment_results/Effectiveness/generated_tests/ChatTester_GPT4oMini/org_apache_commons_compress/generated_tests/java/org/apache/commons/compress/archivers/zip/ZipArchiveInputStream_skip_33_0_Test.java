package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.apache.commons.compress.archivers.zip.ZipConstants.DWORD;
import static org.apache.commons.compress.archivers.zip.ZipConstants.SHORT;
import static org.apache.commons.compress.archivers.zip.ZipConstants.WORD;
import static org.apache.commons.compress.archivers.zip.ZipConstants.ZIP64_MAGIC;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.PushbackInputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Function;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.deflate64.Deflate64CompressorInputStream;
import org.apache.commons.compress.compressors.zstandard.ZstdCompressorInputStream;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;

public class ZipArchiveInputStream_skip_33_0_Test {

    private ZipArchiveInputStream zipArchiveInputStream;

    private InputStream mockInputStream;

    @BeforeEach
    public void setUp() {
        // Mocking an input stream with 1024 bytes
        mockInputStream = new ByteArrayInputStream(new byte[1024]);
        zipArchiveInputStream = new ZipArchiveInputStream(mockInputStream);
    }

    @Test
    public void testSkipPositiveValue() throws IOException {
        long bytesSkipped = zipArchiveInputStream.skip(100);
        assertEquals(100, bytesSkipped);
    }

    @Test
    public void testSkipLessThanBuffer() throws IOException {
        long bytesSkipped = zipArchiveInputStream.skip(50);
        assertEquals(50, bytesSkipped);
    }

    @Test
    public void testSkipMoreThanBuffer() throws IOException {
        long bytesSkipped = zipArchiveInputStream.skip(1500);
        // Should skip only available bytes
        assertEquals(1024, bytesSkipped);
    }

    @Test
    public void testSkipZero() throws IOException {
        long bytesSkipped = zipArchiveInputStream.skip(0);
        assertEquals(0, bytesSkipped);
    }

    @Test
    public void testSkipNegativeValue() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            zipArchiveInputStream.skip(-1);
        });
        assertEquals("Negative skip value", exception.getMessage());
    }

    @Test
    public void testSkipUntilEndOfStream() throws IOException {
        // Create an InputStream with fewer bytes than the skip request
        InputStream shortInputStream = new ByteArrayInputStream(new byte[500]);
        ZipArchiveInputStream shortZipArchiveInputStream = new ZipArchiveInputStream(shortInputStream);
        long bytesSkipped = shortZipArchiveInputStream.skip(1000);
        // Should skip only available bytes
        assertEquals(500, bytesSkipped);
    }

    @Test
    public void testSkipHandlesReadReturnMinus1() throws IOException {
        // Mocking read method to return -1, simulating end of stream
        zipArchiveInputStream = mock(ZipArchiveInputStream.class);
        when(zipArchiveInputStream.skip(anyLong())).thenCallRealMethod();
        when(zipArchiveInputStream.read(any(byte[].class), anyInt(), anyInt())).thenReturn(-1);
        long bytesSkipped = zipArchiveInputStream.skip(100);
        // No bytes should be skipped
        assertEquals(0, bytesSkipped);
    }

    @Test
    public void testSkipHandlesPartialRead() throws IOException {
        // Mocking read method to simulate partial read
        zipArchiveInputStream = mock(ZipArchiveInputStream.class);
        when(zipArchiveInputStream.skip(anyLong())).thenCallRealMethod();
        when(zipArchiveInputStream.read(any(byte[].class), anyInt(), anyInt())).thenReturn(200).thenReturn(100).thenReturn(-1);
        long bytesSkipped = zipArchiveInputStream.skip(500);
        // Should skip the total of bytes read
        assertEquals(300, bytesSkipped);
    }
}

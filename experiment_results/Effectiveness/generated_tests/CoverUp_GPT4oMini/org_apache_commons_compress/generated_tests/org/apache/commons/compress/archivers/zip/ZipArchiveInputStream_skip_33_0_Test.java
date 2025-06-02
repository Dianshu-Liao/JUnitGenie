package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.compress.archivers.zip.ZipArchiveInputStream;
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

class ZipArchiveInputStream_skip_33_0_Test {

    private ZipArchiveInputStream zipArchiveInputStream;

    private InputStream inputStream;

    @BeforeEach
    void setUp() {
        // Prepare a simple byte array input stream for testing
        byte[] data = "Hello, World! This is a test for the ZipArchiveInputStream.".getBytes();
        inputStream = new ByteArrayInputStream(data);
        zipArchiveInputStream = new ZipArchiveInputStream(inputStream);
    }

    @Test
    void testSkipPositiveValue() throws IOException {
        long skipped = zipArchiveInputStream.skip(5);
        assertEquals(5, skipped);
        // Verify that the next read reads the expected data
        byte[] buffer = new byte[10];
        int read = zipArchiveInputStream.read(buffer);
        String result = new String(buffer, 0, read);
        assertEquals("World! Thi", result);
    }

    @Test
    void testSkipNegativeValue() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            zipArchiveInputStream.skip(-1);
        });
        assertEquals("Negative skip value", exception.getMessage());
    }

    @Test
    void testSkipMoreThanAvailable() throws IOException {
        long skipped = zipArchiveInputStream.skip(100);
        // Total length of the input stream
        assertEquals(63, skipped);
    }

    @Test
    void testSkipExactlyAvailable() throws IOException {
        long skipped = zipArchiveInputStream.skip(63);
        assertEquals(63, skipped);
        // Verify that no more data is available
        byte[] buffer = new byte[10];
        int read = zipArchiveInputStream.read(buffer);
        // End of stream
        assertEquals(-1, read);
    }

    @Test
    void testSkipZero() throws IOException {
        long skipped = zipArchiveInputStream.skip(0);
        assertEquals(0, skipped);
        // Verify that the first read still returns data
        byte[] buffer = new byte[10];
        int read = zipArchiveInputStream.read(buffer);
        String result = new String(buffer, 0, read);
        assertEquals("Hello, Wor", result);
    }
}

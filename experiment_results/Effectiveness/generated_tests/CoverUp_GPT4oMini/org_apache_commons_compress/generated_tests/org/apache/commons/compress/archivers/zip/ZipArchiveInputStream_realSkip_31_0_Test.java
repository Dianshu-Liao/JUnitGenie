package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
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

class ZipArchiveInputStream_realSkip_31_0_Test {

    private ZipArchiveInputStream zipArchiveInputStream;

    private InputStream inputStream;

    @BeforeEach
    void setUp() {
        // Create a ByteArrayInputStream with some test data
        byte[] data = "This is a test data for ZipArchiveInputStream".getBytes();
        inputStream = new ByteArrayInputStream(data);
        zipArchiveInputStream = new ZipArchiveInputStream(inputStream);
    }

    @Test
    void testRealSkipPositiveValue() throws Exception {
        // Skip a positive number of bytes
        long bytesToSkip = 10;
        long skipped = invokeRealSkip(bytesToSkip);
        // Verify that the input stream has skipped the correct number of bytes
        assertEquals(bytesToSkip, skipped);
        // 43 - 10 = 33
        assertEquals(33, inputStream.available());
    }

    @Test
    void testRealSkipExactLength() throws Exception {
        // Skip the exact length of the data
        long bytesToSkip = 43;
        long skipped = invokeRealSkip(bytesToSkip);
        // Verify that the input stream is now empty
        assertEquals(bytesToSkip, skipped);
        assertEquals(0, inputStream.available());
    }

    @Test
    void testRealSkipMoreThanAvailable() throws Exception {
        // Skip more bytes than available
        long bytesToSkip = 100;
        long skipped = invokeRealSkip(bytesToSkip);
        // Verify that the input stream has been fully read
        assertEquals(43, skipped);
        assertEquals(0, inputStream.available());
    }

    @Test
    void testRealSkipNegativeValue() {
        // Attempt to skip a negative number of bytes
        assertThrows(IllegalArgumentException.class, () -> {
            invokeRealSkip(-1);
        });
    }

    @Test
    void testRealSkipEOF() throws Exception {
        // Skip to the end of the stream
        invokeRealSkip(43);
        // Now try to skip again, expecting to reach EOF
        long skipped = invokeRealSkip(10);
        // Should return 0 since we are at EOF
        assertEquals(0, skipped);
    }

    private long invokeRealSkip(long bytesToSkip) throws Exception {
        Method method = ZipArchiveInputStream.class.getDeclaredMethod("realSkip", long.class);
        method.setAccessible(true);
        return (long) method.invoke(zipArchiveInputStream, bytesToSkip);
    }
}

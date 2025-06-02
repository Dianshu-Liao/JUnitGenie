package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.EOFException;
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

class ZipArchiveInputStream_readFully_25_0_Test {

    private ZipArchiveInputStream zipArchiveInputStream;

    @BeforeEach
    void setUp() {
        InputStream inputStream = new ByteArrayInputStream(new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        zipArchiveInputStream = new ZipArchiveInputStream(inputStream);
    }

    @Test
    void testReadFully_withValidData() throws Exception {
        byte[] buffer = new byte[10];
        invokeReadFully(zipArchiveInputStream, buffer);
        assertArrayEquals(new byte[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, buffer);
    }

    @Test
    void testReadFully_withEOFException() throws Exception {
        byte[] buffer = new byte[10];
        InputStream inputStream = new ByteArrayInputStream(new byte[5]);
        zipArchiveInputStream = new ZipArchiveInputStream(inputStream);
        assertThrows(EOFException.class, () -> {
            invokeReadFully(zipArchiveInputStream, buffer);
        });
    }

    @Test
    void testReadFully_withNullBuffer() {
        assertThrows(NullPointerException.class, () -> {
            invokeReadFully(zipArchiveInputStream, null);
        });
    }

    @Test
    void testReadFully_withEmptyBuffer() throws Exception {
        byte[] buffer = new byte[0];
        invokeReadFully(zipArchiveInputStream, buffer);
        // No exception should be thrown for an empty buffer
    }

    private void invokeReadFully(ZipArchiveInputStream zipArchiveInputStream, byte[] buffer) throws Exception {
        Method method = ZipArchiveInputStream.class.getDeclaredMethod("readFully", byte[].class, int.class);
        method.setAccessible(true);
        method.invoke(zipArchiveInputStream, buffer, 0);
    }
}

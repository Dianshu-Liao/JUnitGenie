package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.commons.compress.utils.IOUtils;
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
import java.io.InputStream;
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
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;

class ZipArchiveInputStream_readRange_28_0_Test {

    private ZipArchiveInputStream zipArchiveInputStream;

    private ByteArrayInputStream inputStream;

    @BeforeEach
    void setUp() {
        // Setup a sample input stream for testing
        byte[] data = new byte[] { 0, 1, 2, 3, 4, 5 };
        inputStream = new ByteArrayInputStream(data);
        zipArchiveInputStream = new ZipArchiveInputStream(inputStream);
    }

    @Test
    void testReadRange_ValidLength() throws Exception {
        // Using reflection to access the private method
        Method readRangeMethod = ZipArchiveInputStream.class.getDeclaredMethod("readRange", int.class);
        readRangeMethod.setAccessible(true);
        byte[] result = (byte[]) readRangeMethod.invoke(zipArchiveInputStream, 5);
        assertArrayEquals(new byte[] { 0, 1, 2, 3, 4 }, result);
    }

    @Test
    void testReadRange_LengthGreaterThanAvailable() throws Exception {
        // Using reflection to access the private method
        Method readRangeMethod = ZipArchiveInputStream.class.getDeclaredMethod("readRange", int.class);
        readRangeMethod.setAccessible(true);
        assertThrows(IOException.class, () -> {
            readRangeMethod.invoke(zipArchiveInputStream, 10);
        });
    }

    @Test
    void testReadRange_ExactLength() throws Exception {
        // Using reflection to access the private method
        Method readRangeMethod = ZipArchiveInputStream.class.getDeclaredMethod("readRange", int.class);
        readRangeMethod.setAccessible(true);
        byte[] result = (byte[]) readRangeMethod.invoke(zipArchiveInputStream, 6);
        assertArrayEquals(new byte[] { 0, 1, 2, 3, 4, 5 }, result);
    }

    @Test
    void testReadRange_ZeroLength() throws Exception {
        // Using reflection to access the private method
        Method readRangeMethod = ZipArchiveInputStream.class.getDeclaredMethod("readRange", int.class);
        readRangeMethod.setAccessible(true);
        byte[] result = (byte[]) readRangeMethod.invoke(zipArchiveInputStream, 0);
        assertArrayEquals(new byte[] {}, result);
    }

    @Test
    void testReadRange_NegativeLength() throws Exception {
        // Using reflection to access the private method
        Method readRangeMethod = ZipArchiveInputStream.class.getDeclaredMethod("readRange", int.class);
        readRangeMethod.setAccessible(true);
        assertThrows(IllegalArgumentException.class, () -> {
            readRangeMethod.invoke(zipArchiveInputStream, -1);
        });
    }
}

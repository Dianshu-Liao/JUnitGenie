package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
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
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.InputStreamStatistics;
import org.apache.commons.io.input.BoundedInputStream;

class ZipArchiveInputStream_readRange_28_0_Test {

    private ZipArchiveInputStream zipArchiveInputStream;

    @BeforeEach
    void setUp() {
        byte[] data = "Hello, World!".getBytes();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        zipArchiveInputStream = new ZipArchiveInputStream(byteArrayInputStream);
    }

    private byte[] invokeReadRange(int length) throws Exception {
        Method method = ZipArchiveInputStream.class.getDeclaredMethod("readRange", int.class);
        method.setAccessible(true);
        return (byte[]) method.invoke(zipArchiveInputStream, length);
    }

    @Test
    void testReadRange_ValidLength() throws Exception {
        byte[] result = invokeReadRange(5);
        assertArrayEquals("Hello".getBytes(), result);
    }

    @Test
    void testReadRange_ExactLength() throws Exception {
        byte[] result = invokeReadRange(13);
        assertArrayEquals("Hello, World!".getBytes(), result);
    }

    @Test
    void testReadRange_LengthGreaterThanAvailable() {
        assertThrows(EOFException.class, () -> {
            invokeReadRange(20);
        });
    }

    @Test
    void testReadRange_ZeroLength() throws Exception {
        byte[] result = invokeReadRange(0);
        assertArrayEquals(new byte[0], result);
    }

    @Test
    void testReadRange_NegativeLength() {
        assertThrows(IllegalArgumentException.class, () -> {
            invokeReadRange(-1);
        });
    }

    @Test
    void testReadRange_AfterClose() throws Exception {
        zipArchiveInputStream.close();
        assertThrows(IOException.class, () -> {
            invokeReadRange(5);
        });
    }
}

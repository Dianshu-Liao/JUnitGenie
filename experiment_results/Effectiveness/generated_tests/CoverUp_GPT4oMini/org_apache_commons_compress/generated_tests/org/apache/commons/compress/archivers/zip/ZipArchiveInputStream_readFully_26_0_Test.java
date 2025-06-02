package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.apache.commons.compress.archivers.zip.ZipConstants.DWORD;
import static org.apache.commons.compress.archivers.zip.ZipConstants.SHORT;
import static org.apache.commons.compress.archivers.zip.ZipConstants.WORD;
import static org.apache.commons.compress.archivers.zip.ZipConstants.ZIP64_MAGIC;

class ZipArchiveInputStream_readFully_26_0_Test {

    private ZipArchiveInputStream zipArchiveInputStream;

    private InputStream mockInputStream;

    @BeforeEach
    void setUp() {
        mockInputStream = mock(InputStream.class);
        zipArchiveInputStream = new ZipArchiveInputStream(mockInputStream);
    }

    @Test
    void testReadFully_WithSufficientData() throws Exception {
        byte[] buffer = new byte[10];
        when(mockInputStream.read(any(byte[].class), anyInt(), anyInt())).thenReturn(10);
        invokeReadFully(buffer, 0);
        assertEquals(10, buffer.length);
        verify(mockInputStream, times(1)).read(any(byte[].class), eq(0), eq(10));
    }

    @Test
    void testReadFully_WithInsufficientData() throws Exception {
        byte[] buffer = new byte[10];
        when(mockInputStream.read(any(byte[].class), anyInt(), anyInt())).thenReturn(5);
        assertThrows(EOFException.class, () -> {
            invokeReadFully(buffer, 0);
        });
        verify(mockInputStream, times(1)).read(any(byte[].class), eq(0), eq(10));
    }

    @Test
    void testReadFully_WithNegativeOffset() {
        byte[] buffer = new byte[10];
        assertThrows(IndexOutOfBoundsException.class, () -> {
            invokeReadFully(buffer, -1);
        });
    }

//    @Test
//    void testReadFully_WithNegativeLength() {
//        byte[] buffer = new byte[10];
//        assertThrows(IndexOutOfBoundsException.class, () -> {
//            invokeReadFully(buffer, 0);
//        });
//    }

    @Test
    void testReadFully_WithOffsetExceedingBufferLength() {
        byte[] buffer = new byte[10];
        assertThrows(IndexOutOfBoundsException.class, () -> {
            invokeReadFully(buffer, 11);
        });
    }

//    @Test
//    void testReadFully_WithZeroLength() throws Exception {
//        byte[] buffer = new byte[10];
//        invokeReadFully(buffer, 0);
//        assertArrayEquals(new byte[10], buffer);
//    }

    private void invokeReadFully(byte[] buffer, int offset) throws Exception {
        Method method = ZipArchiveInputStream.class.getDeclaredMethod("readFully", byte[].class, int.class);
        method.setAccessible(true);
        method.invoke(zipArchiveInputStream, buffer, offset);
    }
}

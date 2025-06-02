package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
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

class ZipArchiveInputStream_readFully_26_1_Test {

    private ZipArchiveInputStream zipArchiveInputStream;

    private InputStream mockInputStream;

    @BeforeEach
    void setUp() {
        mockInputStream = mock(InputStream.class);
        zipArchiveInputStream = new ZipArchiveInputStream(mockInputStream);
    }

//    @Test
//    void testReadFully_Success() throws Exception {
//        // Arrange
//        byte[] buffer = new byte[10];
//        when(IOUtils.readFully(mockInputStream, buffer, 0, 10)).thenReturn(10);
//        // Act
//        invokeReadFully(buffer, 0);
//        // Assert
//        // No exception should be thrown
//    }

//    @Test
//    void testReadFully_EOFException() throws Exception {
//        // Arrange
//        byte[] buffer = new byte[10];
//        when(IOUtils.readFully(mockInputStream, buffer, 0, 10)).thenReturn(5);
//        // Act & Assert
//        assertThrows(EOFException.class, () -> invokeReadFully(buffer, 0));
//    }

    @Test
    void testReadFully_NullBuffer() throws Exception {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> invokeReadFully(null, 0));
    }

//    @Test
//    void testReadFully_BufferTooSmall() throws Exception {
//        // Arrange
//        byte[] buffer = new byte[5];
//        when(IOUtils.readFully(mockInputStream, buffer, 0, 5)).thenReturn(5);
//        // Act & Assert
//        assertThrows(ArrayIndexOutOfBoundsException.class, () -> invokeReadFully(buffer, 1));
//    }

    @Test
    void testReadFully_ZeroLengthBuffer() throws Exception {
        // Arrange
        byte[] buffer = new byte[0];
        when(IOUtils.readFully(mockInputStream, buffer, 0, 0)).thenReturn(0);
        // Act
        invokeReadFully(buffer, 0);
        // Assert
        // No exception should be thrown
    }

    private void invokeReadFully(byte[] b, int off) throws Exception {
        Method method = ZipArchiveInputStream.class.getDeclaredMethod("readFully", byte[].class, int.class);
        method.setAccessible(true);
        method.invoke(zipArchiveInputStream, b, off);
    }
}

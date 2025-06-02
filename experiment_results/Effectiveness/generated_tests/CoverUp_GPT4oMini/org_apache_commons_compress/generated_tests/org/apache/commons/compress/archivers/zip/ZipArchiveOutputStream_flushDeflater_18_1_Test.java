package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.archivers.zip.ZipMethod;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.zip.Deflater;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.io.Charsets;

@ExtendWith(MockitoExtension.class)
public class ZipArchiveOutputStream_flushDeflater_18_1_Test {

    private ZipArchiveOutputStream zipOutputStream;

    private ByteArrayOutputStream byteArrayOutputStream;

    private ZipArchiveEntry zipEntry;

    @BeforeEach
    public void setUp() throws IOException {
        byteArrayOutputStream = new ByteArrayOutputStream();
        zipOutputStream = new ZipArchiveOutputStream(byteArrayOutputStream);
        zipEntry = new ZipArchiveEntry("test.txt");
    }

    @Test
    public void testFlushDeflater_WhenEntryMethodIsDeflated() throws Exception {
        // Arrange
        zipEntry.setMethod(ZipArchiveOutputStream.DEFLATED);
        invokeSetEntry(zipOutputStream, zipEntry);
        Method flushDeflaterMethod = ZipArchiveOutputStream.class.getDeclaredMethod("flushDeflater");
        flushDeflaterMethod.setAccessible(true);
        // Act
        assertDoesNotThrow(() -> flushDeflaterMethod.invoke(zipOutputStream));
        // Verify that the streamCompressor's flushDeflater method was called
    }

    @Test
    public void testFlushDeflater_WhenEntryMethodIsNotDeflated() throws Exception {
        // Arrange
        zipEntry.setMethod(ZipArchiveOutputStream.STORED);
        invokeSetEntry(zipOutputStream, zipEntry);
        Method flushDeflaterMethod = ZipArchiveOutputStream.class.getDeclaredMethod("flushDeflater");
        flushDeflaterMethod.setAccessible(true);
        // Act
        assertDoesNotThrow(() -> flushDeflaterMethod.invoke(zipOutputStream));
        // No exception should be thrown, and flushDeflater should not be called
    }

    @Test
    public void testFlushDeflater_ThrowsIOException() throws Exception {
        // Arrange
        zipEntry.setMethod(ZipArchiveOutputStream.DEFLATED);
        invokeSetEntry(zipOutputStream, zipEntry);
        StreamCompressor mockCompressor = mock(StreamCompressor.class);
        setStreamCompressor(zipOutputStream, mockCompressor);
        doThrow(new IOException("Test Exception")).when(mockCompressor).flushDeflater();
        Method flushDeflaterMethod = ZipArchiveOutputStream.class.getDeclaredMethod("flushDeflater");
        flushDeflaterMethod.setAccessible(true);
        // Act & Assert
        IOException exception = assertThrows(IOException.class, () -> flushDeflaterMethod.invoke(zipOutputStream));
        assertEquals("Test Exception", exception.getMessage());
    }

    private void invokeSetEntry(ZipArchiveOutputStream zipOutputStream, ZipArchiveEntry zipEntry) throws Exception {
        Method setEntryMethod = ZipArchiveOutputStream.class.getDeclaredMethod("setDefaults", ZipArchiveEntry.class);
        setEntryMethod.setAccessible(true);
        setEntryMethod.invoke(zipOutputStream, zipEntry);
    }

    private void setStreamCompressor(ZipArchiveOutputStream zipOutputStream, StreamCompressor compressor) throws Exception {
        Field streamCompressorField = ZipArchiveOutputStream.class.getDeclaredField("streamCompressor");
        streamCompressorField.setAccessible(true);
        streamCompressorField.set(zipOutputStream, compressor);
    }
}

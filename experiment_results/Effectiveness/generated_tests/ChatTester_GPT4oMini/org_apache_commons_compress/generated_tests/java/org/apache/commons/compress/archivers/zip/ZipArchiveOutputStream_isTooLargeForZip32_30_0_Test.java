package org.apache.commons.compress.archivers.zip;

import java.io.File;
import java.io.IOException;
import java.util.zip.ZipEntry;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
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
import java.util.zip.Deflater;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.io.Charsets;

public class ZipArchiveOutputStream_isTooLargeForZip32_30_0_Test {

    private ZipArchiveOutputStream zipArchiveOutputStream;

    private ZipArchiveEntry zipArchiveEntry;

    @BeforeEach
    public void setUp() throws IOException {
        // Initialize the ZipArchiveOutputStream with a mock File
        zipArchiveOutputStream = new ZipArchiveOutputStream(new File("dummy.zip"));
        zipArchiveEntry = Mockito.mock(ZipArchiveEntry.class);
    }

    @Test
    public void testIsTooLargeForZip32_WhenSizeIsLessThanZip64Magic_ReturnsFalse() {
        // Arrange
        Mockito.when(zipArchiveEntry.getSize()).thenReturn(ZipConstants.ZIP64_MAGIC - 1);
        Mockito.when(zipArchiveEntry.getCompressedSize()).thenReturn(ZipConstants.ZIP64_MAGIC - 1);
        // Act
        boolean result = invokeIsTooLargeForZip32(zipArchiveOutputStream, zipArchiveEntry);
        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsTooLargeForZip32_WhenSizeIsEqualToZip64Magic_ReturnsTrue() {
        // Arrange
        Mockito.when(zipArchiveEntry.getSize()).thenReturn(ZipConstants.ZIP64_MAGIC);
        Mockito.when(zipArchiveEntry.getCompressedSize()).thenReturn(ZipConstants.ZIP64_MAGIC - 1);
        // Act
        boolean result = invokeIsTooLargeForZip32(zipArchiveOutputStream, zipArchiveEntry);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsTooLargeForZip32_WhenCompressedSizeIsEqualToZip64Magic_ReturnsTrue() {
        // Arrange
        Mockito.when(zipArchiveEntry.getSize()).thenReturn(ZipConstants.ZIP64_MAGIC - 1);
        Mockito.when(zipArchiveEntry.getCompressedSize()).thenReturn(ZipConstants.ZIP64_MAGIC);
        // Act
        boolean result = invokeIsTooLargeForZip32(zipArchiveOutputStream, zipArchiveEntry);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsTooLargeForZip32_WhenBothSizesAreGreaterThanZip64Magic_ReturnsTrue() {
        // Arrange
        Mockito.when(zipArchiveEntry.getSize()).thenReturn(ZipConstants.ZIP64_MAGIC + 1);
        Mockito.when(zipArchiveEntry.getCompressedSize()).thenReturn(ZipConstants.ZIP64_MAGIC + 1);
        // Act
        boolean result = invokeIsTooLargeForZip32(zipArchiveOutputStream, zipArchiveEntry);
        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsTooLargeForZip32_WhenBothSizesAreLessThanZip64Magic_ReturnsFalse() {
        // Arrange
        Mockito.when(zipArchiveEntry.getSize()).thenReturn(ZipConstants.ZIP64_MAGIC - 1);
        Mockito.when(zipArchiveEntry.getCompressedSize()).thenReturn(ZipConstants.ZIP64_MAGIC - 1);
        // Act
        boolean result = invokeIsTooLargeForZip32(zipArchiveOutputStream, zipArchiveEntry);
        // Assert
        assertFalse(result);
    }

    // Reflection method to invoke the private method
    private boolean invokeIsTooLargeForZip32(ZipArchiveOutputStream zipArchiveOutputStream, ZipArchiveEntry zipArchiveEntry) {
        try {
            java.lang.reflect.Method method = ZipArchiveOutputStream.class.getDeclaredMethod("isTooLargeForZip32", ZipArchiveEntry.class);
            method.setAccessible(true);
            return (boolean) method.invoke(zipArchiveOutputStream, zipArchiveEntry);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

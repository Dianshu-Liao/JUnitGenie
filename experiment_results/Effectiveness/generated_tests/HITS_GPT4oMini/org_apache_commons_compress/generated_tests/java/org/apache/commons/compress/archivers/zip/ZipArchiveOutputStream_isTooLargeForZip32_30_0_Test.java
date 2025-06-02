package org.apache.commons.compress.archivers.zip;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
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

    private ZipArchiveOutputStream zipOutputStream;

    @BeforeEach
    public void setUp() throws IOException {
        // Create a temporary file for testing
        File tempFile = File.createTempFile("testZip", ".zip");
        // Ensure the file is deleted after the test
        tempFile.deleteOnExit();
        zipOutputStream = new ZipArchiveOutputStream(tempFile);
    }

    private boolean invokeIsTooLargeForZip32(ZipArchiveEntry entry) throws Exception {
        Method method = ZipArchiveOutputStream.class.getDeclaredMethod("isTooLargeForZip32", ZipArchiveEntry.class);
        // Allow access to the private method
        method.setAccessible(true);
        return (boolean) method.invoke(zipOutputStream, entry);
    }

    @Test
    public void testIsTooLargeForZip32_WithSizeLessThanZip64Magic() throws Exception {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        entry.setSize(ZipConstants.ZIP64_MAGIC - 1);
        entry.setCompressedSize(ZipConstants.ZIP64_MAGIC - 1);
        boolean result = invokeIsTooLargeForZip32(entry);
        assertFalse(result, "Entry size less than ZIP64 magic should return false.");
    }

    @Test
    public void testIsTooLargeForZip32_WithSizeEqualToZip64Magic() throws Exception {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        entry.setSize(ZipConstants.ZIP64_MAGIC);
        entry.setCompressedSize(ZipConstants.ZIP64_MAGIC - 1);
        boolean result = invokeIsTooLargeForZip32(entry);
        assertTrue(result, "Entry size equal to ZIP64 magic should return true.");
    }

    @Test
    public void testIsTooLargeForZip32_WithCompressedSizeEqualToZip64Magic() throws Exception {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        entry.setSize(ZipConstants.ZIP64_MAGIC - 1);
        entry.setCompressedSize(ZipConstants.ZIP64_MAGIC);
        boolean result = invokeIsTooLargeForZip32(entry);
        assertTrue(result, "Compressed size equal to ZIP64 magic should return true.");
    }

    @Test
    public void testIsTooLargeForZip32_WithSizeGreaterThanZip64Magic() throws Exception {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        entry.setSize(ZipConstants.ZIP64_MAGIC + 1);
        entry.setCompressedSize(ZipConstants.ZIP64_MAGIC - 1);
        boolean result = invokeIsTooLargeForZip32(entry);
        assertTrue(result, "Entry size greater than ZIP64 magic should return true.");
    }

    @Test
    public void testIsTooLargeForZip32_WithCompressedSizeGreaterThanZip64Magic() throws Exception {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        entry.setSize(ZipConstants.ZIP64_MAGIC - 1);
        entry.setCompressedSize(ZipConstants.ZIP64_MAGIC + 1);
        boolean result = invokeIsTooLargeForZip32(entry);
        assertTrue(result, "Compressed size greater than ZIP64 magic should return true.");
    }
}

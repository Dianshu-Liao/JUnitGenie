package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
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

class ZipArchiveOutputStream_isTooLargeForZip32_30_0_Test {

    private ZipArchiveOutputStream zipArchiveOutputStream;

    @BeforeEach
    void setUp() {
        zipArchiveOutputStream = new ZipArchiveOutputStream(new ByteArrayOutputStream());
    }

    @Test
    void testIsTooLargeForZip32_withSizeLessThanZip64Magic() throws Exception {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        entry.setSize(ZipConstants.ZIP64_MAGIC - 1);
        entry.setCompressedSize(ZipConstants.ZIP64_MAGIC - 1);
        Method method = ZipArchiveOutputStream.class.getDeclaredMethod("isTooLargeForZip32", ZipArchiveEntry.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(zipArchiveOutputStream, entry);
        assertFalse(result, "Entry should not be too large for Zip32");
    }

    @Test
    void testIsTooLargeForZip32_withSizeEqualToZip64Magic() throws Exception {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        entry.setSize(ZipConstants.ZIP64_MAGIC);
        entry.setCompressedSize(ZipConstants.ZIP64_MAGIC - 1);
        Method method = ZipArchiveOutputStream.class.getDeclaredMethod("isTooLargeForZip32", ZipArchiveEntry.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(zipArchiveOutputStream, entry);
        assertTrue(result, "Entry should be too large for Zip32");
    }

    @Test
    void testIsTooLargeForZip32_withCompressedSizeEqualToZip64Magic() throws Exception {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        entry.setSize(ZipConstants.ZIP64_MAGIC - 1);
        entry.setCompressedSize(ZipConstants.ZIP64_MAGIC);
        Method method = ZipArchiveOutputStream.class.getDeclaredMethod("isTooLargeForZip32", ZipArchiveEntry.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(zipArchiveOutputStream, entry);
        assertTrue(result, "Entry should be too large for Zip32");
    }

    @Test
    void testIsTooLargeForZip32_withSizeAndCompressedSizeGreaterThanZip64Magic() throws Exception {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        entry.setSize(ZipConstants.ZIP64_MAGIC + 1);
        entry.setCompressedSize(ZipConstants.ZIP64_MAGIC + 1);
        Method method = ZipArchiveOutputStream.class.getDeclaredMethod("isTooLargeForZip32", ZipArchiveEntry.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(zipArchiveOutputStream, entry);
        assertTrue(result, "Entry should be too large for Zip32");
    }
}

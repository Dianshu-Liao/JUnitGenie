package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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
import java.util.zip.Deflater;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.utils.ByteUtils;
import org.apache.commons.io.Charsets;

class ZipArchiveOutputStream_writeLocalFileHeader_60_0_Test {

    private ZipArchiveOutputStream zipOutputStream;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        zipOutputStream = new ZipArchiveOutputStream(outputStream);
    }

    @Test
    void testWriteLocalFileHeader_WhenEntryIsValid() throws Exception {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        entry.setMethod(ZipArchiveOutputStream.DEFLATED);
        entry.setSize(1234);
        entry.setTime(System.currentTimeMillis());
        entry.setCrc(4321);
        invokeWriteLocalFileHeader(entry, false);
        byte[] result = outputStream.toByteArray();
        // Check the header signature
        assertEquals(0x04034b50, ((result[0] & 0xFF) | (result[1] & 0xFF) << 8 | (result[2] & 0xFF) << 16 | (result[3] & 0xFF) << 24));
    }

    @Test
    void testWriteLocalFileHeader_WhenEntryIsNull() {
        assertThrows(NullPointerException.class, () -> {
            invokeWriteLocalFileHeader(null, false);
        });
    }

    @Test
    void testWriteLocalFileHeader_WithPhasedTrue() throws Exception {
        ZipArchiveEntry entry = new ZipArchiveEntry("testPhased.txt");
        entry.setMethod(ZipArchiveOutputStream.DEFLATED);
        entry.setSize(5678);
        entry.setTime(System.currentTimeMillis());
        entry.setCrc(8765);
        invokeWriteLocalFileHeader(entry, true);
        byte[] result = outputStream.toByteArray();
        // Check the header signature
        assertEquals(0x04034b50, ((result[0] & 0xFF) | (result[1] & 0xFF) << 8 | (result[2] & 0xFF) << 16 | (result[3] & 0xFF) << 24));
    }

    @Test
    void testWriteLocalFileHeader_WhenEntryHasInvalidMethod() {
        ZipArchiveEntry entry = new ZipArchiveEntry("testInvalidMethod.txt");
        // Invalid method
        entry.setMethod(-1);
        entry.setSize(1234);
        entry.setTime(System.currentTimeMillis());
        entry.setCrc(4321);
        assertThrows(IllegalArgumentException.class, () -> {
            invokeWriteLocalFileHeader(entry, false);
        });
    }

    private void invokeWriteLocalFileHeader(ZipArchiveEntry entry, boolean phased) throws Exception {
        Method method = ZipArchiveOutputStream.class.getDeclaredMethod("writeLocalFileHeader", ZipArchiveEntry.class, boolean.class);
        method.setAccessible(true);
        method.invoke(zipOutputStream, entry, phased);
    }
}

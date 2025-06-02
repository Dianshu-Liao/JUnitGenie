package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
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

class ZipArchiveOutputStream_writeLocalFileHeader_59_0_Test {

    private ZipArchiveOutputStream zipOutputStream;

    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        zipOutputStream = new ZipArchiveOutputStream(byteArrayOutputStream);
    }

    @Test
    void testWriteLocalFileHeader_WithValidEntry() throws IOException {
        // Arrange
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        entry.setSize(100);
        entry.setTime(System.currentTimeMillis());
        // Act
        zipOutputStream.writeLocalFileHeader(entry);
        // Assert
        assertNotNull(byteArrayOutputStream.toByteArray());
        assertTrue(byteArrayOutputStream.size() > 0, "The output stream should not be empty after writing a header.");
    }

    @Test
    void testWriteLocalFileHeader_WithEmptyEntryName() {
        // Arrange
        ZipArchiveEntry entry = new ZipArchiveEntry("");
        // Act & Assert
        assertThrows(IOException.class, () -> {
            zipOutputStream.writeLocalFileHeader(entry);
        }, "Expected IOException for empty entry name");
    }

    @Test
    void testWriteLocalFileHeader_WithNullEntry() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            zipOutputStream.writeLocalFileHeader(null);
        }, "Expected NullPointerException for null entry");
    }

    @Test
    void testWriteLocalFileHeader_WithSpecialCharacters() throws IOException {
        // Arrange
        ZipArchiveEntry entry = new ZipArchiveEntry("test/with special@chars.txt");
        entry.setSize(150);
        entry.setTime(System.currentTimeMillis());
        // Act
        zipOutputStream.writeLocalFileHeader(entry);
        // Assert
        assertNotNull(byteArrayOutputStream.toByteArray());
        assertTrue(byteArrayOutputStream.size() > 0, "The output stream should not be empty after writing a header with special characters.");
    }

    @Test
    void testWriteLocalFileHeader_WithLargeSize() throws IOException {
        // Arrange
        ZipArchiveEntry entry = new ZipArchiveEntry("largefile.txt");
        entry.setSize(Long.MAX_VALUE);
        entry.setTime(System.currentTimeMillis());
        // Act
        zipOutputStream.writeLocalFileHeader(entry);
        // Assert
        assertNotNull(byteArrayOutputStream.toByteArray());
        assertTrue(byteArrayOutputStream.size() > 0, "The output stream should not be empty after writing a header for a large size.");
    }

    @Test
    void testWriteLocalFileHeader_WithDifferentCompressionMethods() throws IOException {
        // Arrange
        ZipArchiveEntry entry = new ZipArchiveEntry("compressedfile.txt");
        entry.setMethod(ZipArchiveOutputStream.DEFLATED);
        entry.setSize(200);
        entry.setTime(System.currentTimeMillis());
        // Act
        zipOutputStream.writeLocalFileHeader(entry);
        // Assert
        assertNotNull(byteArrayOutputStream.toByteArray());
        assertTrue(byteArrayOutputStream.size() > 0, "The output stream should not be empty after writing a header with deflated method.");
    }

    @Test
    void testWriteLocalFileHeader_WhenFinished() throws IOException {
        // Arrange
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        entry.setSize(100);
        entry.setTime(System.currentTimeMillis());
        zipOutputStream.finish();
        // Act & Assert
        assertThrows(IOException.class, () -> {
            zipOutputStream.writeLocalFileHeader(entry);
        }, "Expected IOException when trying to write after finishing the stream");
    }
}

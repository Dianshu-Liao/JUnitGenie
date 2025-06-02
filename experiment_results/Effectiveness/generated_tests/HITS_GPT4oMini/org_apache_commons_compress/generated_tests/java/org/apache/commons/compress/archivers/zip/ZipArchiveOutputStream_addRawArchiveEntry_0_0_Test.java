package org.apache.commons.compress.archivers.zip;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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

public class ZipArchiveOutputStream_addRawArchiveEntry_0_0_Test {

    private ZipArchiveOutputStream zipOutputStream;

    @BeforeEach
    public void setUp() throws IOException {
        // Using ByteArrayOutputStream for testing purposes.
        zipOutputStream = new ZipArchiveOutputStream(new ByteArrayOutputStream());
    }

    @Test
    public void testAddRawArchiveEntry_WithValidEntry() throws IOException {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        entry.setSize(11);
        entry.setCompressedSize(11);
        entry.setCrc(12345678);
        byte[] data = "Hello World".getBytes();
        InputStream inputStream = new ByteArrayInputStream(data);
        zipOutputStream.addRawArchiveEntry(entry, inputStream);
        // Since we can't directly check the output stream, we can check if no exceptions were thrown.
        assertDoesNotThrow(() -> zipOutputStream.close());
    }

    @Test
    public void testAddRawArchiveEntry_WithNullEntry() {
        assertThrows(NullPointerException.class, () -> {
            zipOutputStream.addRawArchiveEntry(null, new ByteArrayInputStream(new byte[0]));
        });
    }

    @Test
    public void testAddRawArchiveEntry_WithNullInputStream() {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        assertThrows(NullPointerException.class, () -> {
            zipOutputStream.addRawArchiveEntry(entry, null);
        });
    }

    @Test
    public void testAddRawArchiveEntry_WithEntryHavingUnknownSize() throws IOException {
        ZipArchiveEntry entry = new ZipArchiveEntry("unknown_size.txt");
        // CRC is known, size is unknown
        entry.setCrc(12345678);
        byte[] data = "Test Data".getBytes();
        InputStream inputStream = new ByteArrayInputStream(data);
        assertDoesNotThrow(() -> zipOutputStream.addRawArchiveEntry(entry, inputStream));
        assertDoesNotThrow(() -> zipOutputStream.close());
    }

    @Test
    public void testAddRawArchiveEntry_WithFinishedStream() throws IOException {
        // Mark the stream as finished
        zipOutputStream.finish();
        ZipArchiveEntry entry = new ZipArchiveEntry("finished.txt");
        byte[] data = "This should fail".getBytes();
        InputStream inputStream = new ByteArrayInputStream(data);
        IOException thrown = assertThrows(IOException.class, () -> {
            zipOutputStream.addRawArchiveEntry(entry, inputStream);
        });
        assertEquals("Stream has already been finished", thrown.getMessage());
    }

    @Test
    public void testAddRawArchiveEntry_WithEntryHavingNoCrcButKnownSize() throws IOException {
        ZipArchiveEntry entry = new ZipArchiveEntry("no_crc.txt");
        // Size is known, CRC is unknown
        entry.setSize(9);
        byte[] data = "Test Data".getBytes();
        InputStream inputStream = new ByteArrayInputStream(data);
        assertDoesNotThrow(() -> zipOutputStream.addRawArchiveEntry(entry, inputStream));
        assertDoesNotThrow(() -> zipOutputStream.close());
    }
}

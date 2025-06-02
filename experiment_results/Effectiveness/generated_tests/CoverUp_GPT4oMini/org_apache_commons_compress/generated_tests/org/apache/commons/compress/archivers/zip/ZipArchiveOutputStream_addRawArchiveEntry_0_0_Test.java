package org.apache.commons.compress.archivers.zip;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
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
        zipOutputStream = new ZipArchiveOutputStream(new ByteArrayOutputStream());
    }

    @Test
    public void testAddRawArchiveEntry_withValidEntry() throws IOException, NoSuchFieldException, IllegalAccessException {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        byte[] data = "Hello, World!".getBytes();
        InputStream inputStream = new ByteArrayInputStream(data);
        zipOutputStream.addRawArchiveEntry(entry, inputStream);
        // Check that the entry has been added correctly
        List<ZipArchiveEntry> entries = getEntries(zipOutputStream);
        assertEquals(1, entries.size());
        assertEquals("test.txt", entries.get(0).getName());
        assertEquals(data.length, entries.get(0).getSize());
    }

    @Test
    public void testAddRawArchiveEntry_withNullEntry() {
        assertThrows(NullPointerException.class, () -> {
            zipOutputStream.addRawArchiveEntry(null, new ByteArrayInputStream(new byte[0]));
        });
    }

    @Test
    public void testAddRawArchiveEntry_withNullInputStream() {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        assertThrows(NullPointerException.class, () -> {
            zipOutputStream.addRawArchiveEntry(entry, null);
        });
    }

    @Test
    public void testAddRawArchiveEntry_withFinishedStream() throws IOException {
        zipOutputStream.finish();
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        InputStream inputStream = new ByteArrayInputStream(new byte[0]);
        assertThrows(IOException.class, () -> {
            zipOutputStream.addRawArchiveEntry(entry, inputStream);
        });
    }

    @Test
    public void testAddRawArchiveEntry_withInvalidEntry() throws IOException {
        ZipArchiveEntry entry = new ZipArchiveEntry("test.txt");
        // Invalid size
        entry.setSize(-1);
        byte[] data = "Hello, World!".getBytes();
        InputStream inputStream = new ByteArrayInputStream(data);
        assertThrows(IllegalArgumentException.class, () -> {
            zipOutputStream.addRawArchiveEntry(entry, inputStream);
        });
    }

    @SuppressWarnings("unchecked")
    private List<ZipArchiveEntry> getEntries(ZipArchiveOutputStream zipOutputStream) throws NoSuchFieldException, IllegalAccessException {
        Field entriesField = ZipArchiveOutputStream.class.getDeclaredField("entries");
        entriesField.setAccessible(true);
        return (List<ZipArchiveEntry>) entriesField.get(zipOutputStream);
    }
}

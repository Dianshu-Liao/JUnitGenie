package org.apache.commons.compress.archivers.sevenz;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Date;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static java.nio.charset.StandardCharsets.UTF_16LE;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.LinkOption;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import java.util.zip.CRC32;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.io.output.CountingOutputStream;

public class SevenZOutputFile_createArchiveEntry_3_0_Test {

    private SevenZOutputFile sevenZOutputFile;

    private File tempFile;

    @BeforeEach
    public void setUp() throws IOException {
        // Create a temporary file for testing
        tempFile = Files.createTempFile("testFile", ".txt").toFile();
        sevenZOutputFile = new SevenZOutputFile(tempFile);
    }

    @Test
    public void testCreateArchiveEntryWithFile() {
        String entryName = "testEntry";
        SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(tempFile, entryName);
        assertNotNull(entry);
        assertEquals(entryName, entry.getName());
        assertFalse(entry.getHasCreationDate());
        assertFalse(entry.getHasLastModifiedDate());
        assertFalse(entry.getHasAccessDate());
        assertFalse(entry.isDirectory());
    }

    @Test
    public void testCreateArchiveEntryWithDirectory() throws IOException {
        // Create a temporary directory
        File tempDir = Files.createTempDirectory("testDir").toFile();
        SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(tempDir, "testDirEntry");
        assertNotNull(entry);
        assertEquals("testDirEntry", entry.getName());
        assertTrue(entry.isDirectory());
    }

    @Test
    public void testCreateArchiveEntrySetsLastModifiedDate() throws IOException {
        // Set last modified date
        long lastModifiedTime = System.currentTimeMillis();
        tempFile.setLastModified(lastModifiedTime);
        SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(tempFile, "testEntry");
        // Verify last modified date is set
        assertTrue(entry.getHasLastModifiedDate());
        assertEquals(new Date(lastModifiedTime), entry.getLastModifiedDate());
    }

    @Test
    public void testCreateArchiveEntryHandlesIOException() throws IOException {
        // Mock a scenario where fillDates throws IOException
        Path mockPath = tempFile.toPath();
        BasicFileAttributes attributes = Files.readAttributes(mockPath, BasicFileAttributes.class);
        // This will cause an IOException
        Files.setAttribute(mockPath, "basic:lastModifiedTime", null);
        SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(tempFile, "testEntry");
        // Check that last modified date is set to the file's last modified time
        assertEquals(new Date(tempFile.lastModified()), entry.getLastModifiedDate());
    }

    @Test
    public void testCreateArchiveEntryWithNullEntryName() {
        SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(tempFile, null);
        assertNotNull(entry);
        assertNull(entry.getName());
    }

    @Test
    public void testCreateArchiveEntryWithEmptyEntryName() {
        SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(tempFile, "");
        assertNotNull(entry);
        assertEquals("", entry.getName());
    }

    @Test
    public void testCreateArchiveEntryWithNonExistentFile() {
        File nonExistentFile = new File("non_existent_file.txt");
        SevenZArchiveEntry entry = sevenZOutputFile.createArchiveEntry(nonExistentFile, "testEntry");
        assertNotNull(entry);
        assertEquals("testEntry", entry.getName());
        assertFalse(entry.getHasCreationDate());
        assertFalse(entry.getHasLastModifiedDate());
        assertFalse(entry.getHasAccessDate());
        assertFalse(entry.isDirectory());
    }
}

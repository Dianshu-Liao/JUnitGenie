package org.apache.commons.compress.archivers.tar;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.nio.file.DirectoryStream;
import java.nio.file.LinkOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;
import java.time.DateTimeException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.EntryStreamOffsets;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.lang3.SystemProperties;

class TarArchiveEntry_TarArchiveEntry_110_0_Test {

    private File tempFile;

    private String fileName;

    @BeforeEach
    void setUp() throws IOException {
        // Create a temporary file for testing
        tempFile = Files.createTempFile("testFile", ".txt").toFile();
        fileName = tempFile.getName();
    }

    @Test
    void testConstructorWithValidFileAndFileName() {
        TarArchiveEntry entry = new TarArchiveEntry(tempFile, fileName);
        assertNotNull(entry);
        assertEquals(fileName, entry.getName());
        assertEquals(tempFile.length(), entry.getSize());
    }

    @Test
    void testConstructorWithDirectory() throws IOException {
        // Create a temporary directory
        File tempDir = Files.createTempDirectory("testDir").toFile();
        TarArchiveEntry entry = new TarArchiveEntry(tempDir, tempDir.getName());
        assertNotNull(entry);
        assertEquals(tempDir.getName() + "/", entry.getName());
        assertEquals(TarArchiveEntry.DEFAULT_DIR_MODE, entry.getMode());
    }

    @Test
    void testConstructorHandlesIOException() throws IOException {
        // Make the file read-only
        tempFile.setWritable(false);
        TarArchiveEntry entry = new TarArchiveEntry(tempFile, fileName);
        assertNotNull(entry);
        assertEquals(tempFile.length(), entry.getSize());
        assertNotNull(entry.getLastModifiedTime());
    }

    @Test
    void testConstructorWithInvalidFile() {
        File invalidFile = new File("invalid/path/to/file.txt");
        TarArchiveEntry entry = new TarArchiveEntry(invalidFile, "file.txt");
        assertNotNull(entry);
        assertEquals(0, entry.getSize());
    }

    @Test
    void testConstructorWithNullFile() {
        assertThrows(NullPointerException.class, () -> {
            new TarArchiveEntry(null, fileName);
        });
    }

    @Test
    void testConstructorWithNullFileName() {
        assertThrows(NullPointerException.class, () -> {
            new TarArchiveEntry(tempFile, null);
        });
    }

    @Test
    void testSetCreationTime() {
        TarArchiveEntry entry = new TarArchiveEntry(tempFile, fileName);
        FileTime creationTime = FileTime.fromMillis(System.currentTimeMillis());
        entry.setCreationTime(creationTime);
        assertEquals(creationTime, entry.getCreationTime());
    }

    @Test
    void testSetUserName() {
        TarArchiveEntry entry = new TarArchiveEntry(tempFile, fileName);
        entry.setUserName("testUser");
        assertEquals("testUser", entry.getUserName());
    }

    @Test
    void testSetGroupName() {
        TarArchiveEntry entry = new TarArchiveEntry(tempFile, fileName);
        entry.setGroupName("testGroup");
        assertEquals("testGroup", entry.getGroupName());
    }

    @Test
    void testSetSize() {
        TarArchiveEntry entry = new TarArchiveEntry(tempFile, fileName);
        entry.setSize(1024);
        assertEquals(1024, entry.getSize());
    }

    @Test
    void testSetInvalidSize() {
        TarArchiveEntry entry = new TarArchiveEntry(tempFile, fileName);
        assertThrows(IllegalArgumentException.class, () -> {
            entry.setSize(-1);
        });
    }

    @Test
    void testSetDevMajor() {
        TarArchiveEntry entry = new TarArchiveEntry(tempFile, fileName);
        entry.setDevMajor(123);
        assertEquals(123, entry.getDevMajor());
    }

    @Test
    void testSetDevMinor() {
        TarArchiveEntry entry = new TarArchiveEntry(tempFile, fileName);
        entry.setDevMinor(456);
        assertEquals(456, entry.getDevMinor());
    }

    @Test
    void testCleanup() {
        // Delete temporary file after tests
        if (tempFile != null && tempFile.exists()) {
            tempFile.delete();
        }
    }
}

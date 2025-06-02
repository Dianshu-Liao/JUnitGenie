package org.apache.commons.compress.archivers.cpio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.LinkOption;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.utils.ExactMath;
import org.apache.commons.compress.utils.TimeUtils;

class CpioArchiveEntry_CpioArchiveEntry_52_0_Test {

    private Path tempFile;

    private Path tempDir;

    @BeforeEach
    void setUp() throws IOException {
        // Create a temporary file and directory for testing
        tempFile = Files.createTempFile("testFile", ".tmp");
        tempDir = Files.createTempDirectory("testDir");
    }

    @Test
    void testCpioArchiveEntryWithFile() throws IOException {
        CpioArchiveEntry entry = new CpioArchiveEntry(tempFile, "testFileEntry");
        assertEquals("testFileEntry", entry.getName());
        assertTrue(entry.getSize() > 0);
        assertTrue(entry.getMode() != 0);
    }

    @Test
    void testCpioArchiveEntryWithDirectory() throws IOException {
        CpioArchiveEntry entry = new CpioArchiveEntry(tempDir, "testDirEntry", LinkOption.NOFOLLOW_LINKS);
        assertEquals("testDirEntry", entry.getName());
        assertEquals(0, entry.getSize());
        assertTrue(entry.getMode() != 0);
    }

    @Test
    void testCpioArchiveEntryFileNotFound() {
        Path nonExistentPath = Paths.get("nonExistentFile.tmp");
        assertThrows(IOException.class, () -> {
            new CpioArchiveEntry(nonExistentPath, "nonExistentEntry");
        });
    }

    @Test
    void testCpioArchiveEntryInvalidPath() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveEntry(Paths.get(""), "invalidEntry");
        });
    }

    @Test
    void testCpioArchiveEntryWithLinkOption() throws IOException {
        CpioArchiveEntry entry = new CpioArchiveEntry(tempFile, "testFileEntry", LinkOption.NOFOLLOW_LINKS);
        assertEquals("testFileEntry", entry.getName());
        assertTrue(entry.getSize() > 0);
    }

    @Test
    void testCpioArchiveEntryWithNullEntryName() {
        assertThrows(NullPointerException.class, () -> {
            new CpioArchiveEntry(tempFile, null);
        });
    }

    @Test
    void testCpioArchiveEntryWithEmptyEntryName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveEntry(tempFile, "");
        });
    }

    @Test
    void testCpioArchiveEntryWithInvalidLinkOption() {
        assertThrows(IOException.class, () -> {
            new CpioArchiveEntry(tempDir, "testDirEntry", (LinkOption[]) null);
        });
    }

    @Test
    void cleanup() throws IOException {
        // Cleanup temporary files and directories
        Files.deleteIfExists(tempFile);
        Files.deleteIfExists(tempDir);
    }
}

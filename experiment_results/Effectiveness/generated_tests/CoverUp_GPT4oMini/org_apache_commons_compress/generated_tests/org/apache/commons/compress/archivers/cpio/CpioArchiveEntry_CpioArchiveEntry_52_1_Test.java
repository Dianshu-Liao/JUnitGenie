package org.apache.commons.compress.archivers.cpio;

import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.LinkOption;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.utils.ExactMath;
import org.apache.commons.compress.utils.TimeUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.nio.charset.Charset;

class CpioArchiveEntry_CpioArchiveEntry_52_1_Test {

    private Path tempFilePath;

    private CpioArchiveEntry entry;

    @BeforeEach
    void setUp() throws IOException {
        // Create a temporary file for testing
        tempFilePath = Files.createTempFile("testFile", ".txt");
        Files.write(tempFilePath, "Test content".getBytes(StandardCharsets.UTF_8));
    }

    @Test
    void testCpioArchiveEntryWithValidPathAndName() throws IOException {
        entry = new CpioArchiveEntry(tempFilePath, "testEntry", LinkOption.NOFOLLOW_LINKS);
        assertEquals("testEntry", entry.getName());
        assertEquals(Files.size(tempFilePath), entry.getSize());
        assertTrue(Files.isRegularFile(tempFilePath));
    }

    @Test
    void testCpioArchiveEntryWithDirectory() throws IOException {
        Path tempDirPath = Files.createTempDirectory("testDir");
        entry = new CpioArchiveEntry(tempDirPath, "testDirEntry", LinkOption.NOFOLLOW_LINKS);
        assertEquals("testDirEntry", entry.getName());
        assertTrue(Files.isDirectory(tempDirPath));
        assertEquals(0, entry.getSize());
    }

    @Test
    void testCpioArchiveEntryWithInvalidPath() {
        Path invalidPath = Paths.get("invalid/path/to/file.txt");
        assertThrows(IOException.class, () -> {
            new CpioArchiveEntry(invalidPath, "invalidEntry", LinkOption.NOFOLLOW_LINKS);
        });
    }

    @Test
    void testCpioArchiveEntryWithNullPath() {
        assertThrows(NullPointerException.class, () -> {
            new CpioArchiveEntry(null, "nullEntry", LinkOption.NOFOLLOW_LINKS);
        });
    }

    @Test
    void testCpioArchiveEntryWithNullName() {
        assertThrows(NullPointerException.class, () -> {
            entry = new CpioArchiveEntry(tempFilePath, null, LinkOption.NOFOLLOW_LINKS);
        });
    }

    @Test
    void testFileFormat() throws IOException {
        entry = new CpioArchiveEntry(tempFilePath, "testEntry", LinkOption.NOFOLLOW_LINKS);
        assertEquals(CpioArchiveEntry.FORMAT_NEW, entry.getFormat());
    }

    @Test
    void testHeaderSize() throws IOException {
        entry = new CpioArchiveEntry(tempFilePath, "testEntry", LinkOption.NOFOLLOW_LINKS);
        assertEquals(110, entry.getHeaderSize());
    }

    @Test
    void testAlignmentBoundary() throws IOException {
        entry = new CpioArchiveEntry(tempFilePath, "testEntry", LinkOption.NOFOLLOW_LINKS);
        assertEquals(4, entry.getAlignmentBoundary());
    }

    @AfterEach
    void tearDown() throws IOException {
        Files.deleteIfExists(tempFilePath);
    }
}

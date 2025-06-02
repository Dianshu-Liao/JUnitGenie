package org.apache.commons.compress.archivers.cpio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.utils.ExactMath;
import org.apache.commons.compress.utils.TimeUtils;

class CpioArchiveEntry_CpioArchiveEntry_55_0_Test {

    private static final short FORMAT_NEW = 1;

    private static final long VALID_FILE_SIZE = 1024L;

    private static final String VALID_ENTRY_NAME = "testEntry";

    private Path tempFile;

    @BeforeEach
    void setUp() throws IOException {
        // Create a temporary file for testing
        tempFile = Files.createTempFile("testFile", ".tmp");
        // Writing 1KB of data
        Files.write(tempFile, new byte[(int) VALID_FILE_SIZE]);
    }

    @Test
    void testCpioArchiveEntry_RegularFile() throws IOException {
        CpioArchiveEntry entry = new CpioArchiveEntry(FORMAT_NEW, tempFile, VALID_ENTRY_NAME, LinkOption.NOFOLLOW_LINKS);
        assertEquals(VALID_FILE_SIZE, entry.getSize());
        assertEquals(VALID_ENTRY_NAME, entry.getName());
        assertTrue(Files.isRegularFile(tempFile));
    }

    @Test
    void testCpioArchiveEntry_Directory() throws IOException {
        Path tempDir = Files.createTempDirectory("testDir");
        CpioArchiveEntry entry = new CpioArchiveEntry(FORMAT_NEW, tempDir, VALID_ENTRY_NAME, LinkOption.NOFOLLOW_LINKS);
        assertEquals(0, entry.getSize());
        assertEquals(VALID_ENTRY_NAME, entry.getName());
        assertTrue(Files.isDirectory(tempDir));
    }

    @Test
    void testCpioArchiveEntry_InvalidPath() {
        Path invalidPath = Paths.get("invalid/path");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveEntry(FORMAT_NEW, invalidPath, VALID_ENTRY_NAME, LinkOption.NOFOLLOW_LINKS);
        });
        String expectedMessage = "Cannot determine type of file " + invalidPath;
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testCpioArchiveEntry_SetTime() throws IOException {
        CpioArchiveEntry entry = new CpioArchiveEntry(FORMAT_NEW, tempFile, VALID_ENTRY_NAME, LinkOption.NOFOLLOW_LINKS);
        FileTime fileTime = Files.getLastModifiedTime(tempFile);
        entry.setTime(fileTime);
        assertEquals(fileTime.toMillis() / 1000, entry.getTime());
    }

    @Test
    void testCpioArchiveEntry_SetMode() throws IOException {
        CpioArchiveEntry entry = new CpioArchiveEntry(FORMAT_NEW, tempFile, VALID_ENTRY_NAME, LinkOption.NOFOLLOW_LINKS);
        // Assuming C_ISDIR is defined
        entry.setMode(CpioArchiveEntry.C_ISDIR);
        assertEquals(CpioArchiveEntry.C_ISDIR, entry.getMode());
    }

    @AfterEach
    void tearDown() throws IOException {
        // Clean up the temporary file
        Files.deleteIfExists(tempFile);
    }
}

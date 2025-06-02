package org.apache.commons.compress.archivers.cpio;

import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.Charset;
import java.nio.file.LinkOption;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.utils.ExactMath;
import org.apache.commons.compress.utils.TimeUtils;

class // Additional tests can be added here to cover other constructors and methods
CpioArchiveEntry_CpioArchiveEntry_51_0_Test {

    private static final short FORMAT_NEW = 0;

    private static final String TEST_ENTRY_NAME = "testEntry";

    private File testFile;

    @BeforeEach
    void setUp() throws IOException {
        // Create a temporary file for testing
        testFile = Files.createTempFile("testFile", ".txt").toFile();
        testFile.deleteOnExit();
    }

    @Test
    void testCpioArchiveEntryWithFile() {
        CpioArchiveEntry entry = new CpioArchiveEntry(testFile, TEST_ENTRY_NAME);
        assertEquals(TEST_ENTRY_NAME, entry.getName());
        assertEquals(testFile.length(), entry.getSize());
        assertTrue(entry.getMode() == CpioArchiveEntry.C_ISREG);
    }

    @Test
    void testCpioArchiveEntryWithDirectory() {
        // Create a temporary directory
        File testDir = new File(System.getProperty("java.io.tmpdir"), "testDir");
        assertTrue(testDir.mkdir());
        testDir.deleteOnExit();
        CpioArchiveEntry entry = new CpioArchiveEntry(testDir, TEST_ENTRY_NAME);
        assertEquals(TEST_ENTRY_NAME, entry.getName());
        assertEquals(0, entry.getSize());
        assertTrue(entry.getMode() == CpioArchiveEntry.C_ISDIR);
    }

    @Test
    void testCpioArchiveEntryWithInvalidFile() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveEntry(new File("invalidFilePath"), TEST_ENTRY_NAME);
        });
        assertTrue(exception.getMessage().contains("Cannot determine type of file"));
    }
}

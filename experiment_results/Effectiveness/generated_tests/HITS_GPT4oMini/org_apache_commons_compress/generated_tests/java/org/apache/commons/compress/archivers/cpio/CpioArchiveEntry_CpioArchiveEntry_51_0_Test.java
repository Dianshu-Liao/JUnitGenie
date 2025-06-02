package org.apache.commons.compress.archivers.cpio;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.LinkOption;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.utils.ExactMath;
import org.apache.commons.compress.utils.TimeUtils;

public class CpioArchiveEntry_CpioArchiveEntry_51_0_Test {

    private static final String TEST_DIRECTORY = "testDir";

    private static final String TEST_FILE = "testFile.txt";

    private static final String TEST_FILE_PATH = TEST_DIRECTORY + File.separator + TEST_FILE;

    @BeforeEach
    public void setUp() throws Exception {
        // Create a test directory and a test file
        Files.createDirectories(Paths.get(TEST_DIRECTORY));
        Files.createFile(Paths.get(TEST_FILE_PATH));
    }

    @Test
    public void testCpioArchiveEntryWithFile() {
        File inputFile = new File(TEST_FILE_PATH);
        CpioArchiveEntry entry = new CpioArchiveEntry(inputFile, TEST_FILE);
        assertNotNull(entry);
        assertEquals(TEST_FILE, entry.getName());
        assertEquals(inputFile.length(), entry.getSize());
        assertEquals(CpioArchiveEntry.C_ISREG, entry.getMode());
    }

    @Test
    public void testCpioArchiveEntryWithDirectory() {
        File dir = new File(TEST_DIRECTORY);
        CpioArchiveEntry entry = new CpioArchiveEntry(dir, TEST_DIRECTORY);
        assertNotNull(entry);
        assertEquals(TEST_DIRECTORY, entry.getName());
        assertEquals(0, entry.getSize());
        assertEquals(CpioArchiveEntry.C_ISDIR, entry.getMode());
    }

    @Test
    public void testCpioArchiveEntryInvalidFile() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveEntry(new File("nonexistent.txt"), "nonexistent");
        });
        assertTrue(exception.getMessage().contains("Cannot determine type of file"));
    }

    @Test
    public void testCpioArchiveEntryWithNullFile() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new CpioArchiveEntry(null, TEST_FILE);
        });
        assertNotNull(exception);
    }

    @Test
    public void testCpioArchiveEntryWithEmptyName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveEntry(new File(TEST_FILE_PATH), "");
        });
        assertTrue(exception.getMessage().contains("Cannot determine type of file"));
    }

    @Test
    public void testCpioArchiveEntryFileFormat() {
        File inputFile = new File(TEST_FILE_PATH);
        CpioArchiveEntry entry = new CpioArchiveEntry(inputFile, TEST_FILE);
        assertEquals(CpioArchiveEntry.FORMAT_NEW, entry.getFormat());
    }

    @Test
    public void testCpioArchiveEntryHeaderSize() {
        File inputFile = new File(TEST_FILE_PATH);
        CpioArchiveEntry entry = new CpioArchiveEntry(inputFile, TEST_FILE);
        assertEquals(110, entry.getHeaderSize());
    }

    @Test
    public void testCpioArchiveEntryAlignmentBoundary() {
        File inputFile = new File(TEST_FILE_PATH);
        CpioArchiveEntry entry = new CpioArchiveEntry(inputFile, TEST_FILE);
        assertEquals(4, entry.getAlignmentBoundary());
    }

    @Test
    public void testCpioArchiveEntryFileSize() {
        File inputFile = new File(TEST_FILE_PATH);
        CpioArchiveEntry entry = new CpioArchiveEntry(inputFile, TEST_FILE);
        assertEquals(inputFile.length(), entry.getSize());
    }

    @Test
    public void testCpioArchiveEntryLastModifiedDate() {
        File inputFile = new File(TEST_FILE_PATH);
        CpioArchiveEntry entry = new CpioArchiveEntry(inputFile, TEST_FILE);
        assertNotNull(entry.getLastModifiedDate());
    }

    @Test
    public void tearDown() throws Exception {
        // Clean up test directory and file
        Files.deleteIfExists(Paths.get(TEST_FILE_PATH));
        Files.deleteIfExists(Paths.get(TEST_DIRECTORY));
    }
}

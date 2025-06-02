package org.apache.commons.compress.archivers.ar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;

class ArArchiveEntry_ArArchiveEntry_12_0_Test {

    private Path validFilePath;

    private Path invalidFilePath;

    private String entryName;

    @BeforeEach
    void setUp() throws IOException {
        // Create a temporary file for testing
        validFilePath = Files.createTempFile("testFile", ".tmp");
        Files.write(validFilePath, "Sample content".getBytes());
        entryName = "testFile";
        // Create an invalid file path
        invalidFilePath = Paths.get("invalid/path/to/file");
    }

    @Test
    void testArArchiveEntryWithValidFile() throws IOException {
        ArArchiveEntry entry = new ArArchiveEntry(validFilePath, entryName, LinkOption.NOFOLLOW_LINKS);
        Assertions.assertNotNull(entry);
        Assertions.assertEquals(entryName, entry.getName());
        Assertions.assertTrue(entry.getLength() > 0);
    }

    @Test
    void testArArchiveEntryWithNonRegularFile() throws IOException {
        ArArchiveEntry entry = new ArArchiveEntry(invalidFilePath, entryName, LinkOption.NOFOLLOW_LINKS);
        Assertions.assertNotNull(entry);
        Assertions.assertEquals(entryName, entry.getName());
        Assertions.assertEquals(0, entry.getLength());
    }

    @Test
    void testArArchiveEntryWithDirectory() throws IOException {
        Path dirPath = Files.createTempDirectory("testDir");
        ArArchiveEntry entry = new ArArchiveEntry(dirPath, entryName, LinkOption.NOFOLLOW_LINKS);
        Assertions.assertNotNull(entry);
        Assertions.assertEquals(entryName, entry.getName());
        Assertions.assertEquals(0, entry.getLength());
        // Clean up
        Files.delete(dirPath);
    }

    @Test
    void testArArchiveEntryWithEmptyFile() throws IOException {
        Path emptyFilePath = Files.createTempFile("emptyFile", ".tmp");
        // Create an empty file
        Files.delete(emptyFilePath);
        ArArchiveEntry entry = new ArArchiveEntry(emptyFilePath, entryName, LinkOption.NOFOLLOW_LINKS);
        Assertions.assertNotNull(entry);
        Assertions.assertEquals(entryName, entry.getName());
        Assertions.assertEquals(0, entry.getLength());
    }

    @Test
    void testArArchiveEntryWithIOException() {
        Assertions.assertThrows(IOException.class, () -> {
            new ArArchiveEntry(invalidFilePath, entryName, LinkOption.NOFOLLOW_LINKS);
        });
    }
}

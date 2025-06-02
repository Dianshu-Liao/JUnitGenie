package org.apache.commons.compress.archivers.ar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;

public class ArArchiveEntry_ArArchiveEntry_12_0_Test {

    @Test
    public void testArArchiveEntryWithRegularFile() throws IOException {
        // Arrange
        Path tempFile = Files.createTempFile("testFile", ".txt");
        Files.write(tempFile, "Hello World".getBytes());
        String entryName = "testFile.txt";
        LinkOption[] options = new LinkOption[] {};
        // Act
        ArArchiveEntry entry = new ArArchiveEntry(tempFile, entryName, options);
        // Assert
        assertNotNull(entry);
        assertEquals(entryName, entry.getName());
        assertEquals(Files.size(tempFile), entry.getLength());
        assertTrue(Files.isRegularFile(tempFile));
        assertTrue(new Date(entry.getLastModified()).getTime() > 0);
        Files.delete(tempFile);
    }

    @Test
    public void testArArchiveEntryWithNonRegularFile() throws IOException {
        // Arrange
        Path tempDir = Files.createTempDirectory("testDir");
        String entryName = "testDir";
        LinkOption[] options = new LinkOption[] {};
        // Act
        ArArchiveEntry entry = new ArArchiveEntry(tempDir, entryName, options);
        // Assert
        assertNotNull(entry);
        assertEquals(entryName, entry.getName());
        assertEquals(0, entry.getLength());
        assertTrue(Files.isDirectory(tempDir));
        Files.delete(tempDir);
    }

    @Test
    public void testArArchiveEntryWithInvalidPath() {
        // Arrange
        Path invalidPath = Paths.get("invalid/path/to/file");
        String entryName = "invalidFile";
        LinkOption[] options = new LinkOption[] {};
        // Act & Assert
        assertThrows(IOException.class, () -> {
            new ArArchiveEntry(invalidPath, entryName, options);
        });
    }

    @Test
    public void testArArchiveEntryWithEmptyFile() throws IOException {
        // Arrange
        Path tempFile = Files.createTempFile("emptyFile", ".txt");
        // Write an empty file
        Files.write(tempFile, new byte[0]);
        String entryName = "emptyFile.txt";
        LinkOption[] options = new LinkOption[] {};
        // Act
        ArArchiveEntry entry = new ArArchiveEntry(tempFile, entryName, options);
        // Assert
        assertNotNull(entry);
        assertEquals(entryName, entry.getName());
        assertEquals(0, entry.getLength());
        assertTrue(new Date(entry.getLastModified()).getTime() > 0);
        Files.delete(tempFile);
    }

    @Test
    public void testArArchiveEntryWithSymbolicLink() throws IOException {
        // Arrange
        Path tempFile = Files.createTempFile("testFile", ".txt");
        Path symlink = Files.createSymbolicLink(Paths.get("symlinkToTestFile"), tempFile);
        String entryName = "symlinkToTestFile";
        LinkOption[] options = new LinkOption[] { LinkOption.NOFOLLOW_LINKS };
        // Act
        ArArchiveEntry entry = new ArArchiveEntry(symlink, entryName, options);
        // Assert
        assertNotNull(entry);
        assertEquals(entryName, entry.getName());
        assertEquals(Files.size(tempFile), entry.getLength());
        assertTrue(new Date(entry.getLastModified()).getTime() > 0);
        Files.delete(symlink);
        Files.delete(tempFile);
    }
}

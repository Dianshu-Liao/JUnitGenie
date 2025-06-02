package org.apache.commons.compress.archivers.ar;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;

public class ArArchiveEntry_ArArchiveEntry_11_0_Test {

    private File testFile;

    @BeforeEach
    public void setUp() throws IOException {
        // Create a temporary file for testing
        testFile = Files.createTempFile("testFile", ".txt").toFile();
        // Write some content to the file
        Files.write(testFile.toPath(), "Hello, World!".getBytes());
    }

    @AfterEach
    public void tearDown() throws IOException {
        // Clean up the temporary file after each test
        if (testFile != null && testFile.exists()) {
            Files.delete(testFile.toPath());
        }
    }

    @Test
    public void testArArchiveEntryWithFile() {
        // Arrange
        String entryName = "testFile.txt";
        // Act
        ArArchiveEntry entry = new ArArchiveEntry(testFile, entryName);
        // Assert
        assertEquals(entryName, entry.getName());
        assertEquals(testFile.length(), entry.getLength());
        assertEquals(0, entry.getUserId());
        assertEquals(0, entry.getGroupId());
        // Use hardcoded value for DEFAULT_MODE
        assertEquals(33188, entry.getMode());
        assertTrue(entry.getLastModified() <= System.currentTimeMillis() / 1000);
    }

    @Test
    public void testArArchiveEntryWithNonExistentFile() {
        // Arrange
        File nonExistentFile = new File("nonExistentFile.txt");
        String entryName = "nonExistentFile.txt";
        // Act
        ArArchiveEntry entry = new ArArchiveEntry(nonExistentFile, entryName);
        // Assert
        assertEquals(entryName, entry.getName());
        assertEquals(0, entry.getLength());
        assertEquals(0, entry.getUserId());
        assertEquals(0, entry.getGroupId());
        // Use hardcoded value for DEFAULT_MODE
        assertEquals(33188, entry.getMode());
        assertTrue(entry.getLastModified() <= System.currentTimeMillis() / 1000);
    }
}

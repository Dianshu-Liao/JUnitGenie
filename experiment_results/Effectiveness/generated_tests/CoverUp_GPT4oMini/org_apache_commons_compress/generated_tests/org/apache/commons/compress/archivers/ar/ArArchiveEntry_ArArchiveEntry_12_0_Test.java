package org.apache.commons.compress.archivers.ar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ArArchiveEntry_ArArchiveEntry_12_0_Test {

    private Path inputPath;

    private String entryName;

    private LinkOption[] options;

    @BeforeEach
    public void setUp() {
        inputPath = Paths.get("testFile.txt");
        entryName = "entry.txt";
        options = new LinkOption[] {};
    }

    @Test
    public void testConstructorRegularFile() throws IOException, Exception {
        // Setup
        Files.createFile(inputPath);
        Files.write(inputPath, "Test content".getBytes());
        // Act
        ArArchiveEntry entry = new ArArchiveEntry(inputPath, entryName, options);
        // Assert
        assertEquals(entryName, entry.getName());
        assertEquals(Files.size(inputPath), entry.getLength());
        assertEquals(0, entry.getUserId());
        assertEquals(0, entry.getGroupId());
        // Use reflection to get default mode
        assertEquals(getDefaultMode(), entry.getMode());
        assertTrue(entry.getLastModified() > 0);
        // Cleanup
        Files.delete(inputPath);
    }

    @Test
    public void testConstructorNotRegularFile() throws IOException, Exception {
        // Setup
        Path directoryPath = Files.createDirectory(inputPath.resolve("testDir"));
        // Act
        ArArchiveEntry entry = new ArArchiveEntry(directoryPath, entryName, options);
        // Assert
        assertEquals(entryName, entry.getName());
        assertEquals(0, entry.getLength());
        assertEquals(0, entry.getUserId());
        assertEquals(0, entry.getGroupId());
        // Use reflection to get default mode
        assertEquals(getDefaultMode(), entry.getMode());
        assertTrue(entry.getLastModified() > 0);
        // Cleanup
        Files.delete(directoryPath);
    }

    @Test
    public void testConstructorIOException() {
        // Setup
        Path invalidPath = Paths.get("invalidPath.txt");
        // Act & Assert
        assertThrows(IOException.class, () -> {
            new ArArchiveEntry(invalidPath, entryName, options);
        });
    }

    private int getDefaultMode() throws Exception {
        Field defaultModeField = ArArchiveEntry.class.getDeclaredField("DEFAULT_MODE");
        defaultModeField.setAccessible(true);
        return (int) defaultModeField.get(null);
    }
}

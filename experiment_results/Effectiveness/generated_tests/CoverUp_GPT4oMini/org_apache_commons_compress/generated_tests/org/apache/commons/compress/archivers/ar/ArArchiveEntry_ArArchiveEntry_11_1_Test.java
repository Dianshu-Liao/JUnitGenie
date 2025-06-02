package org.apache.commons.compress.archivers.ar;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
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

class ArArchiveEntry_ArArchiveEntry_11_1_Test {

    private static final String ENTRY_NAME = "testEntry";

    private File testFile;

    @BeforeEach
    void setUp() throws IOException {
        // Create a temporary file for testing
        testFile = Files.createTempFile("testFile", ".tmp").toFile();
        testFile.deleteOnExit();
    }

    @Test
    void testArArchiveEntryWithFile() {
        // Test when inputFile is a regular file
        // Ensure the file does not exist
        testFile.delete();
        assertFalse(testFile.exists());
        // Create the file and set its last modified time
        try {
            Files.write(testFile.toPath(), "Test content".getBytes());
            long lastModified = System.currentTimeMillis();
            testFile.setLastModified(lastModified);
            // Create ArArchiveEntry instance
            ArArchiveEntry entry = new ArArchiveEntry(testFile, ENTRY_NAME);
            // Validate the properties
            assertEquals(testFile.length(), entry.getLength());
            assertEquals(0, entry.getUserId());
            assertEquals(0, entry.getGroupId());
            assertEquals(getDefaultMode(), entry.getMode());
            assertEquals(lastModified / 1000, entry.getLastModified());
            assertEquals(ENTRY_NAME, entry.getName());
        } catch (IOException e) {
            fail("Failed to create test file: " + e.getMessage());
        }
    }

    @Test
    void testArArchiveEntryWithNonExistentFile() {
        // Test when inputFile is a non-existent file
        assertFalse(testFile.exists());
        // Create ArArchiveEntry instance
        ArArchiveEntry entry = new ArArchiveEntry(testFile, ENTRY_NAME);
        // Validate the properties
        assertEquals(0, entry.getLength());
        assertEquals(0, entry.getUserId());
        assertEquals(0, entry.getGroupId());
        assertEquals(getDefaultMode(), entry.getMode());
        assertEquals(0, entry.getLastModified());
        assertEquals(ENTRY_NAME, entry.getName());
    }

    @Test
    void testArArchiveEntryWithNullFile() {
        // Test when inputFile is null
        assertThrows(NullPointerException.class, () -> new ArArchiveEntry(null, ENTRY_NAME));
    }

    @Test
    void testArArchiveEntryWithNullEntryName() {
        // Test when entryName is null
        assertThrows(NullPointerException.class, () -> new ArArchiveEntry(testFile, null));
    }

    private int getDefaultMode() {
        try {
            Field field = ArArchiveEntry.class.getDeclaredField("DEFAULT_MODE");
            field.setAccessible(true);
            return (int) field.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Failed to access DEFAULT_MODE: " + e.getMessage());
            // Unreachable, added to satisfy compiler
            return -1;
        }
    }
}

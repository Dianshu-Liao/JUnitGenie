package org.apache.commons.compress.archivers.ar;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;

public class ArArchiveEntry_ArArchiveEntry_11_0_Test {

    private File validFile;

    private File emptyFile;

    private String entryName;

    @BeforeEach
    public void setUp() {
        entryName = "testEntry";
        validFile = new File("src/test/resources/validFile.txt");
        emptyFile = new File("src/test/resources/emptyFile.txt");
        // Create test files
        try {
            if (!validFile.exists()) {
                validFile.createNewFile();
                // Write some content to validFile
                try (java.io.FileWriter writer = new java.io.FileWriter(validFile)) {
                    writer.write("This is a test file.");
                }
            }
            if (!emptyFile.exists()) {
                emptyFile.createNewFile();
            }
        } catch (IOException e) {
            fail("Setup failed: " + e.getMessage());
        }
    }

    @Test
    public void testArArchiveEntryWithValidFile() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Constructor<ArArchiveEntry> constructor = ArArchiveEntry.class.getDeclaredConstructor(File.class, String.class);
        constructor.setAccessible(true);
        ArArchiveEntry entry = constructor.newInstance(validFile, entryName);
        assertNotNull(entry);
        assertEquals(entryName, entry.getName());
        assertEquals(validFile.length(), entry.getLength());
        assertEquals(0, entry.getUserId());
        assertEquals(0, entry.getGroupId());
        Field modeField = ArArchiveEntry.class.getDeclaredField("DEFAULT_MODE");
        modeField.setAccessible(true);
        int defaultMode = (int) modeField.get(null);
        assertEquals(defaultMode, entry.getMode());
        assertEquals(validFile.lastModified() / 1000, entry.getLastModified());
    }

    @Test
    public void testArArchiveEntryWithEmptyFile() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Constructor<ArArchiveEntry> constructor = ArArchiveEntry.class.getDeclaredConstructor(File.class, String.class);
        constructor.setAccessible(true);
        ArArchiveEntry entry = constructor.newInstance(emptyFile, entryName);
        assertNotNull(entry);
        assertEquals(entryName, entry.getName());
        assertEquals(0, entry.getLength());
        assertEquals(0, entry.getUserId());
        assertEquals(0, entry.getGroupId());
        Field modeField = ArArchiveEntry.class.getDeclaredField("DEFAULT_MODE");
        modeField.setAccessible(true);
        int defaultMode = (int) modeField.get(null);
        assertEquals(defaultMode, entry.getMode());
        assertEquals(emptyFile.lastModified() / 1000, entry.getLastModified());
    }

    @Test
    public void testArArchiveEntryWithNonExistentFile() {
        File nonExistentFile = new File("src/test/resources/nonExistentFile.txt");
        assertThrows(InvocationTargetException.class, () -> {
            Constructor<ArArchiveEntry> constructor = ArArchiveEntry.class.getDeclaredConstructor(File.class, String.class);
            constructor.setAccessible(true);
            constructor.newInstance(nonExistentFile, entryName);
        });
    }
}

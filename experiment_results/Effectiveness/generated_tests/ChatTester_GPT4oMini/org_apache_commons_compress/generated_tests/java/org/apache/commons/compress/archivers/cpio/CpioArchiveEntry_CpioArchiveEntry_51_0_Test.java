package org.apache.commons.compress.archivers.cpio;

import java.io.File;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.utils.ExactMath;
import org.apache.commons.compress.utils.TimeUtils;

public class CpioArchiveEntry_CpioArchiveEntry_51_0_Test {

    // Assuming some constant for format
    private static final short FORMAT_NEW = 1;

    private CpioArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        // Setup for tests if needed
    }

    @Test
    public void testCpioArchiveEntry_WithFileAndEntryName() {
        // Arrange
        File inputFile = new File("test.cpio");
        String entryName = "testEntry";
        // Act
        entry = new CpioArchiveEntry(inputFile, entryName);
        // Assert
        assertNotNull(entry);
        assertEquals(entryName, entry.getName());
        // Additional assertions can be added here to verify the state of the entry object
    }

    @Test
    public void testCpioArchiveEntry_WithFileAndEntryName_NullEntryName() {
        // Arrange
        File inputFile = new File("test.cpio");
        String entryName = null;
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            entry = new CpioArchiveEntry(inputFile, entryName);
        });
    }

    @Test
    public void testCpioArchiveEntry_WithNonExistentFile() {
        // Arrange
        File inputFile = new File("non_existent.cpio");
        String entryName = "testEntry";
        // Act & Assert
        assertThrows(IOException.class, () -> {
            entry = new CpioArchiveEntry(inputFile, entryName);
        });
    }
}

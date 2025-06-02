package org.apache.commons.compress.archivers.dump;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DumpArchiveEntry_getSize_19_0_Test {

    private DumpArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        entry = new DumpArchiveEntry();
    }

    @Test
    public void testGetSizeWhenNotDirectory() {
        // Arrange
        long expectedSize = 1024L;
        entry.setSize(expectedSize);
        entry.setType(DumpArchiveEntry.TYPE.FILE);
        // Act
        long actualSize = entry.getSize();
        // Assert
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testGetSizeWhenIsDirectory() {
        // Arrange
        entry.setType(DumpArchiveEntry.TYPE.DIRECTORY);
        // Act
        long actualSize = entry.getSize();
        // Assert
        assertEquals(DumpArchiveEntry.SIZE_UNKNOWN, actualSize);
    }

    @Test
    public void testGetSizeWhenSizeIsZero() {
        // Arrange
        entry.setSize(0L);
        entry.setType(DumpArchiveEntry.TYPE.FILE);
        // Act
        long actualSize = entry.getSize();
        // Assert
        assertEquals(0L, actualSize);
    }

    @Test
    public void testGetSizeWhenNegativeSize() {
        // Arrange
        entry.setSize(-1L);
        entry.setType(DumpArchiveEntry.TYPE.FILE);
        // Act
        long actualSize = entry.getSize();
        // Assert
        assertEquals(-1L, actualSize);
    }
}

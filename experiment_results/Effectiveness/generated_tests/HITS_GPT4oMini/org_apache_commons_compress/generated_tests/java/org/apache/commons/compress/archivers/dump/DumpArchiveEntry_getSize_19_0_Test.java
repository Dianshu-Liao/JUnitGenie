package org.apache.commons.compress.archivers.dump;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.Date;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.compress.archivers.ArchiveEntry;

public class DumpArchiveEntry_getSize_19_0_Test {

    private DumpArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        entry = new DumpArchiveEntry();
    }

    @Test
    public void testGetSize_WhenIsDirectory_ReturnsSizeUnknown() {
        entry.setType(DumpArchiveEntry.TYPE.DIRECTORY);
        long expectedSize = DumpArchiveEntry.SIZE_UNKNOWN;
        long actualSize = entry.getSize();
        assertEquals(expectedSize, actualSize, "Expected size should be SIZE_UNKNOWN for directory entries.");
    }

    @Test
    public void testGetSize_WhenIsNotDirectory_ReturnsSetSize() {
        entry.setType(DumpArchiveEntry.TYPE.FILE);
        // Example size
        long testSize = 1024L;
        entry.setSize(testSize);
        long actualSize = entry.getSize();
        assertEquals(testSize, actualSize, "Expected size should match the set size for non-directory entries.");
    }

    @Test
    public void testGetSize_WhenSizeIsZero_ReturnsZero() {
        entry.setType(DumpArchiveEntry.TYPE.FILE);
        entry.setSize(0L);
        long actualSize = entry.getSize();
        assertEquals(0L, actualSize, "Expected size should be zero when the size is set to zero.");
    }

    @Test
    public void testGetSize_WhenSizeIsNegative_ReturnsNegativeSize() {
        entry.setType(DumpArchiveEntry.TYPE.FILE);
        entry.setSize(-500L);
        long actualSize = entry.getSize();
        assertEquals(-500L, actualSize, "Expected size should match the negative size set.");
    }

    @Test
    public void testGetSize_WhenSizeIsLarge_ReturnsLargeSize() {
        entry.setType(DumpArchiveEntry.TYPE.FILE);
        // Example of a large size
        long largeSize = Long.MAX_VALUE;
        entry.setSize(largeSize);
        long actualSize = entry.getSize();
        assertEquals(largeSize, actualSize, "Expected size should match the large size set.");
    }
}

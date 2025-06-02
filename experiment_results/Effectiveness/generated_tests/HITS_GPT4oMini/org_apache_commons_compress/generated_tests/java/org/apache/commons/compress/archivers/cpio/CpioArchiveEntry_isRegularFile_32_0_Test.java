package org.apache.commons.compress.archivers.cpio;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.IOException;
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

public class CpioArchiveEntry_isRegularFile_32_0_Test {

    private CpioArchiveEntry regularFileEntry;

    private CpioArchiveEntry directoryEntry;

    private CpioArchiveEntry otherEntry;

    // Example mode for regular file
    private static final long C_ISREG = 0x8000;

    // Example mode for directory
    private static final long C_ISDIR = 0x4000;

    @BeforeEach
    public void setUp() {
        // Create a CpioArchiveEntry representing a regular file
        regularFileEntry = new CpioArchiveEntry((short) 0, "regularFile");
        regularFileEntry.setMode(C_ISREG);
        // Create a CpioArchiveEntry representing a directory
        directoryEntry = new CpioArchiveEntry((short) 0, "directory");
        directoryEntry.setMode(C_ISDIR);
        // Create a CpioArchiveEntry representing some other type (not regular file)
        otherEntry = new CpioArchiveEntry((short) 0, "other");
        // Example mode for symbolic link
        otherEntry.setMode(0x2000);
    }

    @Test
    public void testIsRegularFile_WhenEntryIsRegularFile_ShouldReturnTrue() {
        assertTrue(regularFileEntry.isRegularFile(), "Expected isRegularFile to return true for regular file entry.");
    }

    @Test
    public void testIsRegularFile_WhenEntryIsDirectory_ShouldReturnFalse() {
        assertFalse(directoryEntry.isRegularFile(), "Expected isRegularFile to return false for directory entry.");
    }

    @Test
    public void testIsRegularFile_WhenEntryIsNotRegularFile_ShouldReturnFalse() {
        assertFalse(otherEntry.isRegularFile(), "Expected isRegularFile to return false for non-regular file entry.");
    }
}

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

public class CpioArchiveEntry_isBlockDevice_27_0_Test {

    private CpioArchiveEntry entryBlockDevice;

    private CpioArchiveEntry entryRegularFile;

    private CpioArchiveEntry entryDirectory;

    // Block device
    private static final long C_ISBLK = 0x6000;

    // Regular file
    private static final long C_ISREG = 0x8000;

    // Directory
    private static final long C_ISDIR = 0x4000;

    @BeforeEach
    public void setUp() {
        entryBlockDevice = new CpioArchiveEntry((short) 0, "blockDevice");
        // Set mode to block device
        entryBlockDevice.setMode(C_ISBLK);
        entryRegularFile = new CpioArchiveEntry((short) 0, "regularFile");
        // Set mode to regular file
        entryRegularFile.setMode(C_ISREG);
        entryDirectory = new CpioArchiveEntry((short) 0, "directory");
        // Set mode to directory
        entryDirectory.setMode(C_ISDIR);
    }

    @Test
    public void testIsBlockDevice_WhenModeIsBlockDevice_ShouldReturnTrue() {
        assertTrue(entryBlockDevice.isBlockDevice(), "Expected isBlockDevice() to return true for block device");
    }

    @Test
    public void testIsBlockDevice_WhenModeIsRegularFile_ShouldReturnFalse() {
        assertFalse(entryRegularFile.isBlockDevice(), "Expected isBlockDevice() to return false for regular file");
    }

    @Test
    public void testIsBlockDevice_WhenModeIsDirectory_ShouldReturnFalse() {
        assertFalse(entryDirectory.isBlockDevice(), "Expected isBlockDevice() to return false for directory");
    }

    @Test
    public void testIsBlockDevice_WhenModeIsSetToZero_ShouldReturnFalse() {
        CpioArchiveEntry entryZeroMode = new CpioArchiveEntry((short) 0, "zeroModeEntry");
        // Set mode to zero
        entryZeroMode.setMode(0);
        assertFalse(entryZeroMode.isBlockDevice(), "Expected isBlockDevice() to return false for zero mode");
    }
}

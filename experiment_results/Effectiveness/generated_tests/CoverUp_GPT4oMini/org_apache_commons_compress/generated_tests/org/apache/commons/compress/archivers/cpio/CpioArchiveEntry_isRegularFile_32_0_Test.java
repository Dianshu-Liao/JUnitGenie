package org.apache.commons.compress.archivers.cpio;

import java.lang.reflect.Method;
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

class CpioArchiveEntry_isRegularFile_32_0_Test {

    // Example value for regular file
    private static final long C_ISREG = 0x8000;

    // Example value for directory
    private static final long C_ISDIR = 0x4000;

    private CpioArchiveEntry entry;

    @BeforeEach
    void setUp() {
        // Initialize CpioArchiveEntry before each test
        // Using default constructor
        entry = new CpioArchiveEntry((short) 0);
    }

    @Test
    void testIsRegularFileWhenModeIsRegularFile() throws Exception {
        // Set mode to indicate a regular file
        invokeSetMode(entry, C_ISREG);
        // Assert that isRegularFile() returns true
        assertTrue(entry.isRegularFile());
    }

    @Test
    void testIsRegularFileWhenModeIsDirectory() throws Exception {
        // Set mode to indicate a directory
        invokeSetMode(entry, C_ISDIR);
        // Assert that isRegularFile() returns false
        assertFalse(entry.isRegularFile());
    }

    @Test
    void testIsRegularFileWhenModeIsZero() throws Exception {
        // Set mode to zero
        invokeSetMode(entry, 0);
        // Assert that isRegularFile() returns false
        assertFalse(entry.isRegularFile());
    }

    private void invokeSetMode(CpioArchiveEntry entry, long mode) throws Exception {
        // Use reflection to access the private setMode method
        Method setModeMethod = CpioArchiveEntry.class.getDeclaredMethod("setMode", long.class);
        setModeMethod.setAccessible(true);
        setModeMethod.invoke(entry, mode);
    }
}

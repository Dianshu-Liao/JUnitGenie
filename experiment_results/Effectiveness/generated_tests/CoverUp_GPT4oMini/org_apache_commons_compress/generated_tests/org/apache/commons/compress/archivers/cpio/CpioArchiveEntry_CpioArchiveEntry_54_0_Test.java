package org.apache.commons.compress.archivers.cpio;

import java.io.File;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
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

public class CpioArchiveEntry_CpioArchiveEntry_54_0_Test {

    // Assuming a constant for test
    private static final short FORMAT_NEW = 1;

    private CpioArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        // Set up a temporary file for testing
        File tempFile = new File("tempFile.txt");
        try {
            if (tempFile.createNewFile()) {
                entry = new CpioArchiveEntry(FORMAT_NEW, tempFile, "tempFile.txt");
            }
        } catch (Exception e) {
            fail("Failed to create a temporary file for testing: " + e.getMessage());
        }
    }

    @Test
    public void testConstructorWithFileAsDirectory() {
        File dir = new File("testDir");
        assertTrue(dir.mkdir(), "Failed to create test directory");
        try {
            CpioArchiveEntry dirEntry = new CpioArchiveEntry(FORMAT_NEW, dir, "testDir");
            assertEquals(CpioArchiveEntry.C_ISDIR, dirEntry.getMode(), "Mode should be directory");
        } finally {
            // Clean up
            dir.delete();
        }
    }

    @Test
    public void testConstructorWithFileAsRegularFile() {
        assertEquals(0, entry.getSize(), "Size should be 0 for a newly created file");
        assertEquals(CpioArchiveEntry.C_ISREG, entry.getMode(), "Mode should be regular file");
    }

    @Test
    public void testConstructorWithInvalidFile() {
        File invalidFile = new File("invalidFile.txt");
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveEntry(FORMAT_NEW, invalidFile, "invalidFile.txt");
        });
        assertEquals("Cannot determine type of file invalidFile.txt", thrown.getMessage());
    }

    @Test
    public void testSetModeWithInvalidValue() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            // Invalid mode
            invokePrivateSetMode(entry, -1);
        });
        assertTrue(thrown.getMessage().contains("Unknown mode"), "Expected an exception for invalid mode");
    }

    private void invokePrivateSetMode(CpioArchiveEntry entry, long mode) throws Exception {
        Method method = CpioArchiveEntry.class.getDeclaredMethod("setMode", long.class);
        method.setAccessible(true);
        method.invoke(entry, mode);
    }
}

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

public class CpioArchiveEntry_CpioArchiveEntry_54_0_Test {

    // Assuming a constant for the new format
    private static final short FORMAT_NEW = 0x0001;

    // Directory file type
    private static final long C_ISDIR = 0x4000;

    // Regular file type
    private static final long C_ISREG = 0x8000;

    @Test
    public void testCpioArchiveEntryWithDirectory() {
        File dir = new File("testDir");
        // Create a test directory
        dir.mkdir();
        try {
            CpioArchiveEntry entry = new CpioArchiveEntry(FORMAT_NEW, dir, "testDir");
            assertEquals(C_ISDIR, entry.getMode());
            assertEquals("testDir", entry.getName());
            // Directory size should be 0
            assertTrue(entry.getSize() == 0);
        } finally {
            // Clean up
            dir.delete();
        }
    }

    @Test
    public void testCpioArchiveEntryWithFile() {
        File file = new File("testFile.txt");
        try {
            // Create a test file
            file.createNewFile();
            CpioArchiveEntry entry = new CpioArchiveEntry(FORMAT_NEW, file, "testFile.txt");
            assertEquals(C_ISREG, entry.getMode());
            assertEquals("testFile.txt", entry.getName());
            // Size should match the newly created file size
            assertEquals(0, entry.getSize());
        } catch (IOException e) {
            fail("IOException occurred while creating test file: " + e.getMessage());
        } finally {
            // Clean up
            file.delete();
        }
    }

    @Test
    public void testCpioArchiveEntryWithInvalidFile() {
        File invalidFile = new File("invalidFile.xyz");
        assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveEntry(FORMAT_NEW, invalidFile, "invalidFile.xyz");
        });
    }

    @Test
    public void testCpioArchiveEntryWithNullFile() {
        assertThrows(NullPointerException.class, () -> {
            new CpioArchiveEntry(FORMAT_NEW, null, "nullFile");
        });
    }

    @Test
    public void testCpioArchiveEntryWithEmptyName() {
        File file = new File("testFile.txt");
        try {
            // Create a test file
            file.createNewFile();
            CpioArchiveEntry entry = new CpioArchiveEntry(FORMAT_NEW, file, "");
            assertEquals(C_ISREG, entry.getMode());
            assertEquals("", entry.getName());
            assertEquals(0, entry.getSize());
        } catch (IOException e) {
            fail("IOException occurred while creating test file: " + e.getMessage());
        } finally {
            // Clean up
            file.delete();
        }
    }

    @Test
    public void testCpioArchiveEntryWithNonExistentFile() {
        File nonExistentFile = new File("nonExistentFile.txt");
        assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveEntry(FORMAT_NEW, nonExistentFile, "nonExistentFile.txt");
        });
    }
}

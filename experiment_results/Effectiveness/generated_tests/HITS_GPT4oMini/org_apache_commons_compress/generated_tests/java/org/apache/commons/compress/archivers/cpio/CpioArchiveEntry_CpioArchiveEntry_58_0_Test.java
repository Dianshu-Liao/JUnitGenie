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

public class CpioArchiveEntry_CpioArchiveEntry_58_0_Test {

    @Test
    public void testCpioArchiveEntryWithValidName() {
        String entryName = "testFile.txt";
        CpioArchiveEntry entry = new CpioArchiveEntry(entryName);
        assertNotNull(entry);
        assertEquals(entryName, entry.getName());
        assertEquals(110, entry.getHeaderSize());
        assertEquals(4, entry.getAlignmentBoundary());
    }

    @Test
    public void testCpioArchiveEntryWithNullName() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveEntry(null);
        });
        assertEquals("Name cannot be null", exception.getMessage());
    }

    @Test
    public void testCpioArchiveEntryWithEmptyName() {
        CpioArchiveEntry entry = new CpioArchiveEntry("");
        assertNotNull(entry);
        assertEquals("", entry.getName());
    }

    @Test
    public void testSetSizeWithValidSize() {
        String entryName = "testFile.txt";
        CpioArchiveEntry entry = new CpioArchiveEntry(entryName);
        entry.setSize(1024);
        assertEquals(1024, entry.getSize());
    }

    @Test
    public void testSetSizeWithNegativeSize() {
        String entryName = "testFile.txt";
        CpioArchiveEntry entry = new CpioArchiveEntry(entryName);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            entry.setSize(-1);
        });
        assertEquals("Invalid entry size <-1>", exception.getMessage());
    }

    @Test
    public void testSetSizeWithTooLargeSize() {
        String entryName = "testFile.txt";
        CpioArchiveEntry entry = new CpioArchiveEntry(entryName);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            entry.setSize(0xFFFFFFFFL + 1);
        });
        assertEquals("Invalid entry size <4294967296>", exception.getMessage());
    }

    @Test
    public void testSetModeWithValidMode() {
        String entryName = "testFile.txt";
        CpioArchiveEntry entry = new CpioArchiveEntry(entryName);
        // Regular file
        entry.setMode(0x8000);
        assertEquals(0x8000, entry.getMode());
    }

    @Test
    public void testSetModeWithInvalidMode() {
        String entryName = "testFile.txt";
        CpioArchiveEntry entry = new CpioArchiveEntry(entryName);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // Invalid mode
            entry.setMode(0xFFFF);
        });
        assertTrue(exception.getMessage().contains("Unknown mode"));
    }

    @Test
    public void testGetChksum() {
        String entryName = "testFile.txt";
        CpioArchiveEntry entry = new CpioArchiveEntry(entryName);
        entry.setChksum(123456789);
        assertEquals(123456789 & 0xFFFFFFFFL, entry.getChksum());
    }

    @Test
    public void testGetAlignmentBoundary() {
        String entryName = "testFile.txt";
        CpioArchiveEntry entry = new CpioArchiveEntry(entryName);
        assertEquals(4, entry.getAlignmentBoundary());
    }

    @Test
    public void testGetHeaderSize() {
        String entryName = "testFile.txt";
        CpioArchiveEntry entry = new CpioArchiveEntry(entryName);
        assertEquals(110, entry.getHeaderSize());
    }
}

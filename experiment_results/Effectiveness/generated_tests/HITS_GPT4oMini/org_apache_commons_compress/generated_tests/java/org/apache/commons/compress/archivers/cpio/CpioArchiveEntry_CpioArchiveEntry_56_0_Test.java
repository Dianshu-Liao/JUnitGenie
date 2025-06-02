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

public class CpioArchiveEntry_CpioArchiveEntry_56_0_Test {

    @Test
    public void testConstructorWithValidShortAndName() {
        // Example format
        short format = 1;
        String name = "testEntry";
        CpioArchiveEntry entry = new CpioArchiveEntry(format, name);
        assertEquals(format, entry.getFormat());
        assertEquals(name, entry.getName());
        // Assuming FORMAT_NEW corresponds to headerSize 110
        assertEquals(110, entry.getHeaderSize());
    }

    @Test
    public void testConstructorWithInvalidFormat() {
        // Invalid format
        short invalidFormat = 999;
        String name = "invalidEntry";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveEntry(invalidFormat, name);
        });
        assertEquals("Unknown header type " + invalidFormat, exception.getMessage());
    }

    @Test
    public void testSetName() {
        short format = 1;
        String name = "testEntry";
        CpioArchiveEntry entry = new CpioArchiveEntry(format, name);
        String newName = "newEntry";
        entry.setName(newName);
        assertEquals(newName, entry.getName());
    }

    @Test
    public void testSetSize() {
        short format = 1;
        String name = "testEntry";
        CpioArchiveEntry entry = new CpioArchiveEntry(format, name);
        long size = 12345L;
        entry.setSize(size);
        assertEquals(size, entry.getSize());
    }

    @Test
    public void testSetSizeWithInvalidValue() {
        short format = 1;
        String name = "testEntry";
        CpioArchiveEntry entry = new CpioArchiveEntry(format, name);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // Invalid size
            entry.setSize(-1L);
        });
        assertEquals("Invalid entry size <-1>", exception.getMessage());
    }

    @Test
    public void testGetAlignmentBoundary() {
        // Example format
        short format = 1;
        CpioArchiveEntry entry = new CpioArchiveEntry(format, "testEntry");
        // Assuming FORMAT_NEW corresponds to alignmentBoundary 4
        assertEquals(4, entry.getAlignmentBoundary());
    }

    @Test
    public void testGetHeaderSize() {
        // Example format
        short format = 1;
        CpioArchiveEntry entry = new CpioArchiveEntry(format, "testEntry");
        // Assuming FORMAT_NEW corresponds to headerSize 110
        assertEquals(110, entry.getHeaderSize());
    }

    @Test
    public void testCheckNewFormat() {
        // Example format
        short format = 1;
        CpioArchiveEntry entry = new CpioArchiveEntry(format, "testEntry");
        entry.setChksum(123456789L);
        assertEquals(123456789L, entry.getChksum());
    }

    @Test
    public void testGetLastModifiedDate() {
        // Example format
        short format = 1;
        CpioArchiveEntry entry = new CpioArchiveEntry(format, "testEntry");
        long time = System.currentTimeMillis() / 1000;
        entry.setTime(time);
        assertNotNull(entry.getLastModifiedDate());
    }

    @Test
    public void testSetModeWithValidValue() {
        // Example format
        short format = 1;
        CpioArchiveEntry entry = new CpioArchiveEntry(format, "testEntry");
        // Example mode for regular file
        long mode = 0x8000;
        entry.setMode(mode);
        assertEquals(mode, entry.getMode());
    }

    @Test
    public void testSetModeWithInvalidValue() {
        // Example format
        short format = 1;
        CpioArchiveEntry entry = new CpioArchiveEntry(format, "testEntry");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // Invalid mode
            entry.setMode(0x0000);
        });
        assertTrue(exception.getMessage().contains("Unknown mode."));
    }
}

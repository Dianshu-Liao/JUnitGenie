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

public class CpioArchiveEntry_CpioArchiveEntry_59_0_Test {

    @Test
    public void testConstructorWithNameAndSize() {
        String name = "testFile";
        long size = 1024;
        CpioArchiveEntry entry = new CpioArchiveEntry(name, size);
        assertEquals(name, entry.getName());
        assertEquals(size, entry.getSize());
    }

    @Test
    public void testSetSizeWithValidValue() {
        String name = "testFile";
        CpioArchiveEntry entry = new CpioArchiveEntry(name, 0);
        long newSize = 2048;
        entry.setSize(newSize);
        assertEquals(newSize, entry.getSize());
    }

    @Test
    public void testSetSizeWithNegativeValue() {
        String name = "testFile";
        CpioArchiveEntry entry = new CpioArchiveEntry(name, 0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            entry.setSize(-1);
        });
        assertEquals("Invalid entry size <-1>", exception.getMessage());
    }

    @Test
    public void testSetSizeWithExceedingValue() {
        String name = "testFile";
        CpioArchiveEntry entry = new CpioArchiveEntry(name, 0);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            entry.setSize(0xFFFFFFFFL + 1);
        });
        assertEquals("Invalid entry size <4294967296>", exception.getMessage());
    }

    @Test
    public void testGetAlignmentBoundary() {
        String name = "testFile";
        CpioArchiveEntry entry = new CpioArchiveEntry(name, 1024);
        assertEquals(4, entry.getAlignmentBoundary());
    }

    @Test
    public void testGetHeaderSize() {
        String name = "testFile";
        CpioArchiveEntry entry = new CpioArchiveEntry(name, 1024);
        assertEquals(110, entry.getHeaderSize());
    }

    @Test
    public void testGetLastModifiedDate() {
        String name = "testFile";
        long time = System.currentTimeMillis() / 1000;
        CpioArchiveEntry entry = new CpioArchiveEntry(name, 1024);
        entry.setTime(time);
        assertNotNull(entry.getLastModifiedDate());
        assertEquals(time * 1000, entry.getLastModifiedDate().getTime());
    }

    @Test
    public void testSetName() {
        String name = "testFile";
        CpioArchiveEntry entry = new CpioArchiveEntry(name, 1024);
        String newName = "newTestFile";
        entry.setName(newName);
        assertEquals(newName, entry.getName());
    }

    @Test
    public void testSetMode() {
        String name = "testFile";
        CpioArchiveEntry entry = new CpioArchiveEntry(name, 1024);
        // example mode
        long mode = 0x1FF;
        entry.setMode(mode);
        assertEquals(mode, entry.getMode());
    }

    @Test
    public void testSetModeWithInvalidValue() {
        String name = "testFile";
        CpioArchiveEntry entry = new CpioArchiveEntry(name, 1024);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // invalid mode
            entry.setMode(0xFFFFFFFFFFFFFFF0L);
        });
        assertTrue(exception.getMessage().contains("Unknown mode."));
    }
}

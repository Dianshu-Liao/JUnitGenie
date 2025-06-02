package org.apache.commons.compress.archivers.cpio;

import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
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

class CpioArchiveEntry_CpioArchiveEntry_58_0_Test {

    @Test
    void testCpioArchiveEntryWithValidName() {
        String name = "testEntry";
        CpioArchiveEntry entry = new CpioArchiveEntry(name);
        assertNotNull(entry);
        assertEquals(name, entry.getName());
        assertEquals(0, entry.getSize());
        assertEquals(0, entry.getChksum());
    }

    @Test
    void testCpioArchiveEntryWithNullName() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new CpioArchiveEntry(null);
        });
        assertEquals("name cannot be null", exception.getMessage());
    }

    @Test
    void testSetName() {
        String name = "newEntry";
        CpioArchiveEntry entry = new CpioArchiveEntry("oldEntry");
        entry.setName(name);
        assertEquals(name, entry.getName());
    }

    @Test
    void testSetSize() {
        CpioArchiveEntry entry = new CpioArchiveEntry("testEntry");
        entry.setSize(1024);
        assertEquals(1024, entry.getSize());
    }

    @Test
    void testSetSizeWithInvalidValue() {
        CpioArchiveEntry entry = new CpioArchiveEntry("testEntry");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            entry.setSize(-1);
        });
        assertEquals("Invalid entry size <-1>", exception.getMessage());
    }

    @Test
    void testGetChksum() {
        CpioArchiveEntry entry = new CpioArchiveEntry("testEntry");
        entry.setChksum(123456789);
        assertEquals(123456789 & 0xFFFFFFFFL, entry.getChksum());
    }

    @Test
    void testGetAlignmentBoundary() {
        CpioArchiveEntry entry = new CpioArchiveEntry("testEntry");
        assertEquals(4, entry.getAlignmentBoundary());
    }

    @Test
    void testGetFormat() {
        CpioArchiveEntry entry = new CpioArchiveEntry("testEntry");
        assertEquals(CpioArchiveEntry.FORMAT_NEW, entry.getFormat());
    }

    @Test
    void testGetLastModifiedDate() {
        CpioArchiveEntry entry = new CpioArchiveEntry("testEntry");
        // Jan 1, 2021
        entry.setTime(1609459200);
        assertNotNull(entry.getLastModifiedDate());
    }
}

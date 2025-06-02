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

    private CpioArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        // Initialize a CpioArchiveEntry with a valid format and name
        entry = new CpioArchiveEntry((short) 1, "testEntry");
    }

    @Test
    public void testConstructorWithValidParameters() {
        assertNotNull(entry);
        assertEquals("testEntry", entry.getName());
        assertEquals(1, entry.getFormat());
    }

    @Test
    public void testSetName() {
        entry.setName("newName");
        assertEquals("newName", entry.getName());
    }

    @Test
    public void testSetSize() {
        entry.setSize(1000);
        assertEquals(1000, entry.getSize());
    }

    @Test
    public void testSetSizeInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            entry.setSize(-1);
        });
        assertEquals("Invalid entry size <-1>", exception.getMessage());
    }

    @Test
    public void testSetChksum() {
        entry.setChksum(123456);
        assertEquals(123456, entry.getChksum());
    }

    @Test
    public void testGetAlignmentBoundary() {
        assertEquals(4, entry.getAlignmentBoundary());
    }

    @Test
    public void testGetHeaderSize() {
        assertEquals(110, entry.getHeaderSize());
    }

    @Test
    public void testGetLastModifiedDate() {
        // This will depend on the implementation of getTime()
        long currentTime = System.currentTimeMillis() / 1000;
        entry.setTime(currentTime);
        assertNotNull(entry.getLastModifiedDate());
    }

    @Test
    public void testSetModeValid() {
        entry.setMode(CpioArchiveEntry.C_ISREG);
        assertEquals(CpioArchiveEntry.C_ISREG, entry.getMode());
    }

    @Test
    public void testSetModeInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            entry.setMode(9999);
        });
        assertTrue(exception.getMessage().contains("Unknown mode"));
    }
}

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

public class CpioArchiveEntry_CpioArchiveEntry_57_0_Test {

    @Test
    public void testCpioArchiveEntry_ValidParameters() {
        // Assuming FORMAT_NEW is represented by 1
        short format = 1;
        String name = "testFile";
        long size = 1024;
        CpioArchiveEntry entry = new CpioArchiveEntry(format, name, size);
        assertEquals(format, entry.getFormat());
        assertEquals(name, entry.getName());
        assertEquals(size, entry.getSize());
    }

    @Test
    public void testCpioArchiveEntry_NegativeSize() {
        // Assuming FORMAT_NEW is represented by 1
        short format = 1;
        String name = "testFile";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveEntry(format, name, -1);
        });
        assertEquals("Invalid entry size <-1>", exception.getMessage());
    }

    @Test
    public void testCpioArchiveEntry_TooLargeSize() {
        // Assuming FORMAT_NEW is represented by 1
        short format = 1;
        String name = "testFile";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveEntry(format, name, 0xFFFFFFFFL + 1);
        });
        assertEquals("Invalid entry size <4294967296>", exception.getMessage());
    }

    @Test
    public void testCpioArchiveEntry_ValidFormat() {
        // Assuming FORMAT_NEW is represented by 1
        short format = 1;
        String name = "testFile";
        long size = 2048;
        CpioArchiveEntry entry = new CpioArchiveEntry(format, name, size);
        assertEquals(110, entry.getHeaderSize());
        assertEquals(4, entry.getAlignmentBoundary());
    }

    @Test
    public void testCpioArchiveEntry_InvalidFormat() {
        // An unknown format
        short invalidFormat = 99;
        String name = "testFile";
        long size = 512;
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveEntry(invalidFormat, name, size);
        });
        assertEquals("Unknown header type 99", exception.getMessage());
    }
}

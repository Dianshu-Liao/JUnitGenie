package org.apache.commons.compress.archivers.cpio;

import java.lang.reflect.Field;
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

public class CpioArchiveEntry_CpioArchiveEntry_53_0_Test {

    private static final short FORMAT_NEW = 0x0001;

    private static final short FORMAT_NEW_CRC = 0x0002;

    private static final short FORMAT_OLD_ASCII = 0x0003;

    private static final short FORMAT_OLD_BINARY = 0x0004;

    @Test
    public void testCpioArchiveEntryNewFormat() {
        CpioArchiveEntry entry = new CpioArchiveEntry(FORMAT_NEW);
        assertNotNull(entry);
        assertEquals(110, getHeaderSize(entry));
        assertEquals(4, getAlignmentBoundary(entry));
    }

    @Test
    public void testCpioArchiveEntryNewCrcFormat() {
        CpioArchiveEntry entry = new CpioArchiveEntry(FORMAT_NEW_CRC);
        assertNotNull(entry);
        assertEquals(110, getHeaderSize(entry));
        assertEquals(4, getAlignmentBoundary(entry));
    }

    @Test
    public void testCpioArchiveEntryOldAsciiFormat() {
        CpioArchiveEntry entry = new CpioArchiveEntry(FORMAT_OLD_ASCII);
        assertNotNull(entry);
        assertEquals(76, getHeaderSize(entry));
        assertEquals(0, getAlignmentBoundary(entry));
    }

    @Test
    public void testCpioArchiveEntryOldBinaryFormat() {
        CpioArchiveEntry entry = new CpioArchiveEntry(FORMAT_OLD_BINARY);
        assertNotNull(entry);
        assertEquals(26, getHeaderSize(entry));
        assertEquals(2, getAlignmentBoundary(entry));
    }

    @Test
    public void testCpioArchiveEntryInvalidFormat() {
        assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveEntry((short) 0x0005);
        });
    }

    private int getHeaderSize(CpioArchiveEntry entry) {
        short format = getFileFormat(entry);
        switch(format) {
            case FORMAT_NEW:
            case FORMAT_NEW_CRC:
                return 110;
            case FORMAT_OLD_ASCII:
                return 76;
            case FORMAT_OLD_BINARY:
                return 26;
            default:
                throw new IllegalArgumentException("Unknown format");
        }
    }

    private int getAlignmentBoundary(CpioArchiveEntry entry) {
        short format = getFileFormat(entry);
        switch(format) {
            case FORMAT_NEW:
            case FORMAT_NEW_CRC:
                return 4;
            case FORMAT_OLD_ASCII:
                return 0;
            case FORMAT_OLD_BINARY:
                return 2;
            default:
                throw new IllegalArgumentException("Unknown format");
        }
    }

    private short getFileFormat(CpioArchiveEntry entry) {
        try {
            Field field = CpioArchiveEntry.class.getDeclaredField("fileFormat");
            field.setAccessible(true);
            return (short) field.get(entry);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Unable to access fileFormat field", e);
        }
    }
}

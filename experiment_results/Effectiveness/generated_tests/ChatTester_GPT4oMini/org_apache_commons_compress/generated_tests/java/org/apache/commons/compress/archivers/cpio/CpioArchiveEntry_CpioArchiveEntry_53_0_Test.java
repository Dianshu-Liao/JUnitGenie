package org.apache.commons.compress.archivers.cpio;

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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CpioArchiveEntry_CpioArchiveEntry_53_0_Test {

    private static final short FORMAT_NEW = 1;

    private static final short FORMAT_NEW_CRC = 2;

    private static final short FORMAT_OLD_ASCII = 3;

    private static final short FORMAT_OLD_BINARY = 4;

    private CpioArchiveEntry entry;

    @BeforeEach
    public void setUp() {
        // Optional setup before each test if needed
    }

    @Test
    public void testCpioArchiveEntryFormatNew() {
        entry = new CpioArchiveEntry(FORMAT_NEW);
        assertEquals(110, invokePrivateField("headerSize", entry));
        assertEquals(4, invokePrivateField("alignmentBoundary", entry));
    }

    @Test
    public void testCpioArchiveEntryFormatNewCrc() {
        entry = new CpioArchiveEntry(FORMAT_NEW_CRC);
        assertEquals(110, invokePrivateField("headerSize", entry));
        assertEquals(4, invokePrivateField("alignmentBoundary", entry));
    }

    @Test
    public void testCpioArchiveEntryFormatOldAscii() {
        entry = new CpioArchiveEntry(FORMAT_OLD_ASCII);
        assertEquals(76, invokePrivateField("headerSize", entry));
        assertEquals(0, invokePrivateField("alignmentBoundary", entry));
    }

    @Test
    public void testCpioArchiveEntryFormatOldBinary() {
        entry = new CpioArchiveEntry(FORMAT_OLD_BINARY);
        assertEquals(26, invokePrivateField("headerSize", entry));
        assertEquals(2, invokePrivateField("alignmentBoundary", entry));
    }

    @Test
    public void testCpioArchiveEntryUnknownFormat() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // Unknown format
            new CpioArchiveEntry((short) 5);
        });
        assertEquals("Unknown header type 5", exception.getMessage());
    }

    private Object invokePrivateField(String fieldName, CpioArchiveEntry entry) {
        try {
            // Fixed line: use Field instead of var
            java.lang.reflect.Field field = CpioArchiveEntry.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(entry);
        } catch (Exception e) {
            fail("Reflection failed: " + e.getMessage());
            // Unreachable, but required for compilation
            return null;
        }
    }
}

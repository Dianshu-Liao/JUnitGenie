package org.apache.commons.compress.archivers.cpio;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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

class CpioArchiveEntry_CpioArchiveEntry_53_0_Test {

    @Test
    void testCpioArchiveEntryNewFormat() throws Exception {
        CpioArchiveEntry entry = createCpioArchiveEntry((short) CpioArchiveEntry.FORMAT_NEW);
        assertEquals(110, entry.getHeaderSize());
        assertEquals(4, entry.getAlignmentBoundary());
    }

    @Test
    void testCpioArchiveEntryNewCrcFormat() throws Exception {
        CpioArchiveEntry entry = createCpioArchiveEntry((short) CpioArchiveEntry.FORMAT_NEW_CRC);
        assertEquals(110, entry.getHeaderSize());
        assertEquals(4, entry.getAlignmentBoundary());
    }

    @Test
    void testCpioArchiveEntryOldAsciiFormat() throws Exception {
        CpioArchiveEntry entry = createCpioArchiveEntry((short) CpioArchiveEntry.FORMAT_OLD_ASCII);
        assertEquals(76, entry.getHeaderSize());
        assertEquals(0, entry.getAlignmentBoundary());
    }

    @Test
    void testCpioArchiveEntryOldBinaryFormat() throws Exception {
        CpioArchiveEntry entry = createCpioArchiveEntry((short) CpioArchiveEntry.FORMAT_OLD_BINARY);
        assertEquals(26, entry.getHeaderSize());
        assertEquals(2, entry.getAlignmentBoundary());
    }

    @Test
    void testCpioArchiveEntryInvalidFormat() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            createCpioArchiveEntry((short) -1);
        });
        assertEquals("Unknown header type -1", exception.getMessage());
    }

    private CpioArchiveEntry createCpioArchiveEntry(short format) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<CpioArchiveEntry> constructor = CpioArchiveEntry.class.getDeclaredConstructor(short.class);
        constructor.setAccessible(true);
        return constructor.newInstance(format);
    }
}

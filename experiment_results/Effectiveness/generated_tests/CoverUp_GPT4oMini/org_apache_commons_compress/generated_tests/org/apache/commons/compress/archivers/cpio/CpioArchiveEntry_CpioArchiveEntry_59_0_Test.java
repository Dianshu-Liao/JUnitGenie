package org.apache.commons.compress.archivers.cpio;

import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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

class CpioArchiveEntry_CpioArchiveEntry_59_0_Test {

    private CpioArchiveEntry entry;

    @BeforeEach
    void setUp() {
        entry = new CpioArchiveEntry("testFile", 1000);
    }

    @Test
    void testConstructorWithValidParameters() {
        assertNotNull(entry);
        assertEquals("testFile", entry.getName());
        assertEquals(1000, entry.getSize());
    }

    @Test
    void testConstructorWithNegativeSize() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveEntry("testFile", -1);
        });
        assertEquals("Invalid entry size <-1>", exception.getMessage());
    }

    @Test
    void testConstructorWithExcessiveSize() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new CpioArchiveEntry("testFile", 0xFFFFFFFFL + 1);
        });
        assertEquals("Invalid entry size <4294967296>", exception.getMessage());
    }

    @Test
    void testSetSizeWithValidValue() {
        entry.setSize(2000);
        assertEquals(2000, entry.getSize());
    }

    @Test
    void testSetSizeWithNegativeValue() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            entry.setSize(-1);
        });
        assertEquals("Invalid entry size <-1>", exception.getMessage());
    }

    @Test
    void testSetSizeWithExcessiveValue() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            entry.setSize(0xFFFFFFFFL + 1);
        });
        assertEquals("Invalid entry size <4294967296>", exception.getMessage());
    }

    @Test
    void testSetName() {
        entry.setName("newFileName");
        assertEquals("newFileName", entry.getName());
    }

    @Test
    void testGetAlignmentBoundary() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Constructor<CpioArchiveEntry> constructor = CpioArchiveEntry.class.getDeclaredConstructor(short.class, String.class, long.class);
        constructor.setAccessible(true);
        CpioArchiveEntry newEntry = constructor.newInstance((short) 1, "testFile", 1000);
        assertEquals(4, newEntry.getAlignmentBoundary());
    }
}

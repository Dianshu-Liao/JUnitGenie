package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
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
import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFileAttributes;
import java.time.DateTimeException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.compress.archivers.ArchiveEntry;
import org.apache.commons.compress.archivers.EntryStreamOffsets;
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.lang3.SystemProperties;

class TarArchiveEntry_TarArchiveEntry_117_0_Test {

    private TarArchiveEntry entry;

    @BeforeEach
    void setUp() {
        // Setup a TarArchiveEntry instance with a default name and linkFlag
        entry = new TarArchiveEntry("testEntry", (byte) 0);
    }

    @Test
    void testConstructorWithNameAndLinkFlag() {
        assertEquals("testEntry", entry.getName());
        assertEquals(0, entry.getLinkFlag());
    }

    @Test
    void testConstructorWithName() {
        TarArchiveEntry entryWithName = new TarArchiveEntry("anotherTestEntry");
        assertEquals("anotherTestEntry", entryWithName.getName());
        assertEquals(TarArchiveEntry.DEFAULT_FILE_MODE, entryWithName.getMode());
    }

    @Test
    void testSetName() {
        entry.setName("newEntryName");
        assertEquals("newEntryName", entry.getName());
    }

    @Test
    void testSetSize() {
        entry.setSize(1024);
        assertEquals(1024, entry.getSize());
    }

    @Test
    void testSetGroupId() {
        entry.setGroupId(1001);
        assertEquals(1001, entry.getLongGroupId());
    }

    @Test
    void testSetUserId() {
        entry.setUserId(1001);
        assertEquals(1001, entry.getLongUserId());
    }

    @Test
    void testSetLinkName() {
        entry.setLinkName("linkToAnotherEntry");
        assertEquals("linkToAnotherEntry", entry.getLinkName());
    }

    @Test
    void testSetCreationTime() {
        entry.setCreationTime(FileTime.fromMillis(System.currentTimeMillis()));
        assertNotNull(entry.getCreationTime());
    }

    @Test
    void testSetDataOffset() {
        entry.setDataOffset(2048);
        assertEquals(2048, entry.getDataOffset());
    }

    @Test
    void testSetDevMajorAndMinor() {
        entry.setDevMajor(1);
        entry.setDevMinor(2);
        assertEquals(1, entry.getDevMajor());
        assertEquals(2, entry.getDevMinor());
    }

    @Test
    void testInvalidSize() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            entry.setSize(-1);
        });
        assertEquals("Size is out of range: -1", exception.getMessage());
    }

    @Test
    void testInvalidDataOffset() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            entry.setDataOffset(-1);
        });
        assertEquals("The offset cannot be smaller than 0", exception.getMessage());
    }

    @Test
    void testPrivateConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<TarArchiveEntry> constructor = TarArchiveEntry.class.getDeclaredConstructor(boolean.class);
        constructor.setAccessible(true);
        TarArchiveEntry privateEntry = constructor.newInstance(true);
        assertNotNull(privateEntry);
    }
}

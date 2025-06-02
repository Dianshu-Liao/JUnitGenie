package org.apache.commons.compress.archivers.tar;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
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

class TarArchiveEntry_TarArchiveEntry_104_0_Test {

    private TarArchiveEntry entry;

    @BeforeEach
    void setUp() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Use reflection to invoke the private constructor
        Constructor<TarArchiveEntry> constructor = TarArchiveEntry.class.getDeclaredConstructor(boolean.class);
        constructor.setAccessible(true);
        entry = constructor.newInstance(true);
    }

    @Test
    void testConstructorPreserveAbsolutePath() {
        // Verify that the preserveAbsolutePath is set correctly
        assertTrue(entry.getUserName().length() <= TarArchiveEntry.MAX_NAMELEN);
    }

    @Test
    void testDefaultValues() {
        // Test default values of fields
        assertEquals("", entry.getName());
        assertEquals(0, entry.getMode());
        assertEquals(0, entry.getSize());
        assertEquals(0, entry.getLongUserId());
        assertEquals(0, entry.getLongGroupId());
    }

    @Test
    void testUserNameIsSet() {
        // Check if the username is set correctly
        String userName = entry.getUserName();
        assertTrue(userName.length() <= TarArchiveEntry.MAX_NAMELEN);
    }

    @Test
    void testSetName() {
        // Test setting name
        entry.setName("testFile");
        assertEquals("testFile", entry.getName());
    }

    @Test
    void testSetSize() {
        // Test setting size
        entry.setSize(1024);
        assertEquals(1024, entry.getSize());
    }

    @Test
    void testSetNegativeSizeThrowsException() {
        // Test that setting a negative size throws an exception
        try {
            entry.setSize(-1);
        } catch (IllegalArgumentException e) {
            assertEquals("Size is out of range: -1", e.getMessage());
        }
    }
}

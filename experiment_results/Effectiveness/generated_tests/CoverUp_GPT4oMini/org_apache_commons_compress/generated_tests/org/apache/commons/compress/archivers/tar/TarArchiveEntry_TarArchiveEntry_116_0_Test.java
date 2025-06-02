package org.apache.commons.compress.archivers.tar;

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

public class TarArchiveEntry_TarArchiveEntry_116_0_Test {

    @Test
    public void testConstructorWithNameAndPreserveAbsolutePath() throws Exception {
        // Test with a normal file name and preserveAbsolutePath as false
        TarArchiveEntry entry = createTarArchiveEntry("testFile.txt", false);
        assertEquals("testFile.txt", entry.getName());
        assertEquals(TarArchiveEntry.DEFAULT_FILE_MODE, entry.getMode());
        // Test with a directory name
        TarArchiveEntry dirEntry = createTarArchiveEntry("testDir/", false);
        assertEquals("testDir/", dirEntry.getName());
        assertEquals(TarArchiveEntry.DEFAULT_DIR_MODE, dirEntry.getMode());
        // Test with preserveAbsolutePath as true
        TarArchiveEntry entryWithAbsolutePath = createTarArchiveEntry("/absolute/path/to/file.txt", true);
        assertEquals("absolute/path/to/file.txt", entryWithAbsolutePath.getName());
        assertEquals(TarArchiveEntry.DEFAULT_FILE_MODE, entryWithAbsolutePath.getMode());
    }

    private TarArchiveEntry createTarArchiveEntry(String name, boolean preserveAbsolutePath) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<TarArchiveEntry> constructor = TarArchiveEntry.class.getDeclaredConstructor(String.class, boolean.class);
        constructor.setAccessible(true);
        return constructor.newInstance(name, preserveAbsolutePath);
    }

    @Test
    public void testConstructorWithInvalidName() throws Exception {
        // Test with a name exceeding MAX_NAMELEN
        String longName = String.format("%0" + (TarArchiveEntry.MAX_NAMELEN + 1) + "d", 0).replace("0", "a");
        TarArchiveEntry entry = createTarArchiveEntry(longName, false);
        assertEquals(TarArchiveEntry.MAX_NAMELEN, entry.getName().length());
    }

    @Test
    public void testConstructorWithEmptyName() throws Exception {
        // Test with an empty name
        TarArchiveEntry entry = createTarArchiveEntry("", false);
        assertEquals("", entry.getName());
        assertEquals(TarArchiveEntry.DEFAULT_FILE_MODE, entry.getMode());
    }

    @Test
    public void testConstructorWithNameEndingWithSlash() throws Exception {
        // Test with a name that ends with a slash
        TarArchiveEntry entry = createTarArchiveEntry("folder/", false);
        assertEquals("folder/", entry.getName());
        assertEquals(TarArchiveEntry.DEFAULT_DIR_MODE, entry.getMode());
    }
}

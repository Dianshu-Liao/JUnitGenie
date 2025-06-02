// Test method
package org.apache.commons.compress.archivers.tar;

import java.lang.reflect.Constructor;
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

public class TarArchiveEntry_TarArchiveEntry_115_0_Test {

    private TarArchiveEntry tarArchiveEntry;

    @BeforeEach
    public void setUp() {
        tarArchiveEntry = new TarArchiveEntry("testEntry");
    }

    @Test
    public void testConstructorWithName() {
        assertNotNull(tarArchiveEntry, "TarArchiveEntry should not be null");
        assertEquals("testEntry", tarArchiveEntry.getName(), "TarArchiveEntry name should match the provided name");
    }

    @Test
    public void testConstructorWithNamePreserveAbsolutePath() throws Exception {
        // Use reflection to invoke the private constructor with preserveAbsolutePath
        Constructor<TarArchiveEntry> constructor = TarArchiveEntry.class.getDeclaredConstructor(String.class, boolean.class);
        constructor.setAccessible(true);
        TarArchiveEntry entry = constructor.newInstance("testEntry", true);
        assertNotNull(entry, "TarArchiveEntry with preserveAbsolutePath should not be null");
        assertEquals("testEntry", entry.getName(), "TarArchiveEntry name should match the provided name");
    }

    @Test
    public void testConstructorWithEmptyName() {
        TarArchiveEntry entry = new TarArchiveEntry("");
        assertNotNull(entry, "TarArchiveEntry with empty name should not be null");
        assertEquals("", entry.getName(), "TarArchiveEntry name should be empty");
    }

    @Test
    public void testConstructorWithNullName() {
        assertThrows(NullPointerException.class, () -> {
            // Fixed Buggy Line
            new TarArchiveEntry((String) null);
        }, "TarArchiveEntry should throw NullPointerException for null name");
    }

    @Test
    public void testConstructorWithWhitespaceName() {
        TarArchiveEntry entry = new TarArchiveEntry("   ");
        assertNotNull(entry, "TarArchiveEntry with whitespace name should not be null");
        assertEquals("   ", entry.getName(), "TarArchiveEntry name should match the provided whitespace name");
    }
}

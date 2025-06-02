package org.apache.commons.compress.archivers.tar;

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

public class TarArchiveEntry_equals_6_0_Test {

    private TarArchiveEntry entry1;

    private TarArchiveEntry entry2;

    private TarArchiveEntry entry3;

    @BeforeEach
    public void setUp() {
        entry1 = new TarArchiveEntry("testFile");
        entry2 = new TarArchiveEntry("testFile");
        entry3 = new TarArchiveEntry("anotherFile");
    }

    @Test
    public void testEquals_SameName() {
        assertTrue(entry1.equals(entry2), "Entries with the same name should be equal");
    }

    @Test
    public void testEquals_DifferentName() {
        assertFalse(entry1.equals(entry3), "Entries with different names should not be equal");
    }

    @Test
    public void testEquals_NullEntry() {
        assertFalse(entry1.equals(null), "Entry should not be equal to null");
    }

    @Test
    public void testEquals_SameInstance() {
        assertTrue(entry1.equals(entry1), "An entry should be equal to itself");
    }

    @Test
    public void testEquals_EmptyNames() {
        TarArchiveEntry emptyEntry1 = new TarArchiveEntry("");
        TarArchiveEntry emptyEntry2 = new TarArchiveEntry("");
        assertTrue(emptyEntry1.equals(emptyEntry2), "Empty name entries should be equal");
    }

    @Test
    public void testEquals_DifferentEmptyName() {
        TarArchiveEntry emptyEntry = new TarArchiveEntry("");
        TarArchiveEntry anotherEntry = new TarArchiveEntry("nonEmpty");
        assertFalse(emptyEntry.equals(anotherEntry), "An empty name entry should not be equal to a non-empty name entry");
    }
}

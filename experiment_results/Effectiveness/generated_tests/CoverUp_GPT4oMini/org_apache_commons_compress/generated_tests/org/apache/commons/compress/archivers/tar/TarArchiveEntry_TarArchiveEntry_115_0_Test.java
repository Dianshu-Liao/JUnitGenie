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

class TarArchiveEntry_TarArchiveEntry_115_0_Test {

    @Test
    void testTarArchiveEntryWithName() {
        String entryName = "testEntry";
        TarArchiveEntry entry = new TarArchiveEntry(entryName);
        assertEquals(entryName, entry.getName());
        assertFalse(entry.getPath().toString().isEmpty());
        assertEquals(TarArchiveEntry.DEFAULT_FILE_MODE, entry.getMode());
    }

    @Test
    void testTarArchiveEntryWithPreserveAbsolutePath() {
        String entryName = "testEntry";
        TarArchiveEntry entry = new TarArchiveEntry(entryName, true);
        assertEquals(entryName, entry.getName());
        assertFalse(entry.getPath().toString().isEmpty());
        assertEquals(TarArchiveEntry.DEFAULT_FILE_MODE, entry.getMode());
    }

    @Test
    void testTarArchiveEntryWithLinkFlag() {
        String entryName = "testEntry";
        byte linkFlag = TarArchiveEntry.LF_NORMAL;
        TarArchiveEntry entry = new TarArchiveEntry(entryName, linkFlag);
        assertEquals(entryName, entry.getName());
        assertEquals(linkFlag, entry.getLinkFlag());
    }

    @Test
    void testTarArchiveEntryWithLinkFlagAndPreservePath() {
        String entryName = "testEntry";
        byte linkFlag = TarArchiveEntry.LF_GNUTYPE_LONGNAME;
        TarArchiveEntry entry = new TarArchiveEntry(entryName, linkFlag, true);
        assertEquals(entryName, entry.getName());
        assertEquals(linkFlag, entry.getLinkFlag());
    }

    @Test
    void testTarArchiveEntryWithInvalidName() {
        String entryName = "";
        TarArchiveEntry entry = new TarArchiveEntry(entryName);
        assertEquals(entryName, entry.getName());
        assertThrows(IllegalArgumentException.class, () -> entry.setSize(-1));
    }

    @Test
    void testSetName() {
        String entryName = "newEntryName";
        TarArchiveEntry entry = new TarArchiveEntry("oldEntryName");
        entry.setName(entryName);
        assertEquals(entryName, entry.getName());
    }

    @Test
    void testSetSize() {
        long size = 1024;
        TarArchiveEntry entry = new TarArchiveEntry("testEntry");
        entry.setSize(size);
        assertEquals(size, entry.getSize());
    }

    @Test
    void testSetSizeNegative() {
        TarArchiveEntry entry = new TarArchiveEntry("testEntry");
        assertThrows(IllegalArgumentException.class, () -> entry.setSize(-1));
    }

    @Test
    void testGetLastModifiedTime() {
        TarArchiveEntry entry = new TarArchiveEntry("testEntry");
        assertNotNull(entry.getLastModifiedTime());
    }
}

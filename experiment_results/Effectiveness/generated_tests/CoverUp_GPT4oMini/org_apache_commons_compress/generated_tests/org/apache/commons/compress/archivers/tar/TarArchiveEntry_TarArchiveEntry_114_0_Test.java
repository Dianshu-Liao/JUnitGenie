package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.LinkOption;
import java.nio.file.attribute.FileTime;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.nio.file.DirectoryStream;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TarArchiveEntry_TarArchiveEntry_114_0_Test {

    @Test
    void testTarArchiveEntryWithValidPathAndFileName() throws IOException {
        Path tempFile = Files.createTempFile("testFile", ".txt");
        TarArchiveEntry entry = new TarArchiveEntry(tempFile, "testFile.txt", LinkOption.NOFOLLOW_LINKS);
        assertEquals("testFile.txt", entry.getName());
        assertEquals(tempFile, entry.getPath());
        assertTrue(entry.getSize() >= 0);
        assertNotNull(entry.getLastModifiedTime());
        assertNotNull(entry.getCreationTime());
        Files.deleteIfExists(tempFile);
    }

    @Test
    void testTarArchiveEntryWithDirectory() throws IOException {
        Path tempDir = Files.createTempDirectory("testDir");
        TarArchiveEntry entry = new TarArchiveEntry(tempDir, "testDir", LinkOption.NOFOLLOW_LINKS);
        assertEquals("testDir", entry.getName());
        assertEquals(tempDir, entry.getPath());
        assertTrue(entry.getSize() >= 0);
        assertNotNull(entry.getLastModifiedTime());
        assertNotNull(entry.getCreationTime());
        Files.deleteIfExists(tempDir);
    }

    @Test
    void testTarArchiveEntryWithNullLinkOptions() throws IOException {
        Path tempFile = Files.createTempFile("testFile", ".txt");
        TarArchiveEntry entry = new TarArchiveEntry(tempFile, "testFile.txt", (LinkOption[]) null);
        assertEquals("testFile.txt", entry.getName());
        assertEquals(tempFile, entry.getPath());
        assertTrue(entry.getSize() >= 0);
        Files.deleteIfExists(tempFile);
    }

    @Test
    void testTarArchiveEntryWithInvalidPath() {
        assertThrows(IOException.class, () -> {
            Path invalidPath = Paths.get("invalid/path/to/file.txt");
            new TarArchiveEntry(invalidPath, "file.txt", LinkOption.NOFOLLOW_LINKS);
        });
    }

    @Test
    void testTarArchiveEntryWithEmptyFileName() throws IOException {
        Path tempFile = Files.createTempFile("testFile", ".txt");
        TarArchiveEntry entry = new TarArchiveEntry(tempFile, "", LinkOption.NOFOLLOW_LINKS);
        assertEquals("", entry.getName());
        assertEquals(tempFile, entry.getPath());
        assertTrue(entry.getSize() >= 0);
        Files.deleteIfExists(tempFile);
    }

    @Test
    void testTarArchiveEntryWithFileNameLongerThanMaxLength() throws IOException {
        Path tempFile = Files.createTempFile("testFile", ".txt");
        // Exceeding MAX_NAMELEN
        String longFileName = String.format("%" + (TarArchiveEntry.MAX_NAMELEN + 1) + "s", "").replace(' ', 'a');
        TarArchiveEntry entry = new TarArchiveEntry(tempFile, longFileName, LinkOption.NOFOLLOW_LINKS);
        assertEquals(longFileName.substring(0, TarArchiveEntry.MAX_NAMELEN), entry.getName());
        assertEquals(tempFile, entry.getPath());
        assertTrue(entry.getSize() >= 0);
        Files.deleteIfExists(tempFile);
    }
}

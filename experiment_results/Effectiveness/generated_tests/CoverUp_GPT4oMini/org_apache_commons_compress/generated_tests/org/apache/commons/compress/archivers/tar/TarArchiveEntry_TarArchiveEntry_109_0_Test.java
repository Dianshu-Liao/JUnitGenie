package org.apache.commons.compress.archivers.tar;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.nio.file.DirectoryStream;
import java.nio.file.LinkOption;
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

class TarArchiveEntry_TarArchiveEntry_109_0_Test {

    private File tempFile;

    @BeforeEach
    void setUp() throws IOException {
        // Create a temporary file for testing
        tempFile = Files.createTempFile("testFile", ".txt").toFile();
    }

    @AfterEach
    void tearDown() {
        // Delete the temporary file after each test
        if (tempFile.exists()) {
            tempFile.delete();
        }
    }

    @Test
    void testTarArchiveEntryWithFile() {
        TarArchiveEntry entry = new TarArchiveEntry(tempFile);
        // Validate the properties of the TarArchiveEntry
        assertEquals(tempFile.getName(), entry.getName());
        assertEquals(tempFile.length(), entry.getSize());
        assertNotNull(entry.getLastModifiedTime());
        assertEquals(FileTime.fromMillis(tempFile.lastModified()), entry.getLastModifiedTime());
        assertEquals(TarArchiveEntry.DEFAULT_FILE_MODE, entry.getMode());
    }

    @Test
    void testTarArchiveEntryWithDirectory() throws IOException {
        // Create a temporary directory
        File tempDir = Files.createTempDirectory("testDir").toFile();
        TarArchiveEntry entry = new TarArchiveEntry(tempDir);
        // Validate the properties of the TarArchiveEntry for directory
        assertEquals(tempDir.getName(), entry.getName());
        // Directories generally have size 0 in tar
        assertEquals(0, entry.getSize());
        assertNotNull(entry.getLastModifiedTime());
        assertEquals(FileTime.fromMillis(tempDir.lastModified()), entry.getLastModifiedTime());
        assertEquals(TarArchiveEntry.DEFAULT_DIR_MODE, entry.getMode());
    }

    @Test
    void testTarArchiveEntryInvalidFile() {
        // Test with a non-existent file
        File invalidFile = new File("invalidFile.txt");
        assertThrows(IOException.class, () -> {
            new TarArchiveEntry(invalidFile);
        });
    }
}

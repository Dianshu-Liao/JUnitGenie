package org.apache.commons.compress.archivers.tar;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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

public class TarArchiveEntry_getFile_20_0_Test {

    @Test
    public void testGetFileWhenFileIsNull() {
        // Create a TarArchiveEntry using a constructor that does not set a file
        // Using a name, but file is not set
        TarArchiveEntry entry = new TarArchiveEntry("");
        assertNull(entry.getFile(), "Expected getFile() to return null when file is null");
    }

    @Test
    public void testGetFileWhenFileIsNotNull() throws IOException {
        // Create a temporary file
        Path tempFile = Files.createTempFile("testFile", ".txt");
        TarArchiveEntry entry = new TarArchiveEntry(tempFile.toFile());
        // Assert that the getFile() method returns the correct File object
        assertEquals(tempFile.toFile(), entry.getFile(), "Expected getFile() to return the correct File object");
        // Clean up the temporary file
        Files.deleteIfExists(tempFile);
    }

    @Test
    public void testGetFileWithDirectory() throws IOException {
        // Create a temporary directory
        Path tempDir = Files.createTempDirectory("testDir");
        TarArchiveEntry entry = new TarArchiveEntry(tempDir.toFile());
        // Assert that the getFile() method returns the correct File object for a directory
        assertEquals(tempDir.toFile(), entry.getFile(), "Expected getFile() to return the correct File object for a directory");
        // Clean up the temporary directory
        Files.deleteIfExists(tempDir);
    }
}

package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
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

class TarArchiveEntry_TarArchiveEntry_113_0_Test {

    @Test
    void testConstructorWithValidPath() throws IOException {
        // Arrange
        Path tempFile = Files.createTempFile("testFile", ".txt");
        try {
            // Act
            TarArchiveEntry entry = new TarArchiveEntry(tempFile);
            // Assert
            assertNotNull(entry);
            assertEquals(tempFile.toString(), entry.getName());
            assertEquals(tempFile, entry.getPath());
        } finally {
            Files.deleteIfExists(tempFile);
        }
    }

    @Test
    void testConstructorWithDirectoryPath() throws IOException {
        // Arrange
        Path tempDir = Files.createTempDirectory("testDir");
        try {
            // Act
            TarArchiveEntry entry = new TarArchiveEntry(tempDir);
            // Assert
            assertNotNull(entry);
            assertEquals(tempDir.toString(), entry.getName());
            assertEquals(tempDir, entry.getPath());
        } finally {
            Files.deleteIfExists(tempDir);
        }
    }

    @Test
    void testConstructorWithNonExistentPath() {
        // Arrange
        Path nonExistentPath = Paths.get("nonExistentFile.txt");
        // Act & Assert
        assertThrows(IOException.class, () -> {
            new TarArchiveEntry(nonExistentPath);
        });
    }

    @Test
    void testConstructorWithSpecialCharacterPath() throws IOException {
        // Arrange
        Path tempFile = Files.createTempFile("testFile_!@#$%^&*()", ".txt");
        try {
            // Act
            TarArchiveEntry entry = new TarArchiveEntry(tempFile);
            // Assert
            assertNotNull(entry);
            assertEquals(tempFile.toString(), entry.getName());
            assertEquals(tempFile, entry.getPath());
        } finally {
            Files.deleteIfExists(tempFile);
        }
    }
}

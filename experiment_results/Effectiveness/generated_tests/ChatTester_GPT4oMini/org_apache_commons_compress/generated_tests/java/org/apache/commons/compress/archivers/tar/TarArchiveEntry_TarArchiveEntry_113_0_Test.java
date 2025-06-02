package org.apache.commons.compress.archivers.tar;

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

public class TarArchiveEntry_TarArchiveEntry_113_0_Test {

    @Test
    public void testConstructorWithPath() throws IOException {
        // Arrange
        Path validPath = Files.createTempFile("example", ".tar");
        try {
            // Act
            TarArchiveEntry entry = new TarArchiveEntry(validPath);
            // Assert
            assertNotNull(entry);
            assertEquals(validPath.toString(), entry.getName());
            assertEquals(validPath, entry.getPath());
        } finally {
            // Clean up
            Files.deleteIfExists(validPath);
        }
    }

    @Test
    public void testConstructorWithInvalidPath() {
        // Arrange
        Path invalidPath = Paths.get("invalid_path.tar");
        // Act & Assert
        assertThrows(IOException.class, () -> {
            new TarArchiveEntry(invalidPath);
        });
    }
}

package org.apache.commons.compress.archivers.tar;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Constructor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

class TarArchiveEntry_getFile_20_0_Test {

    private TarArchiveEntry entryWithFile;

    private TarArchiveEntry entryWithoutFile;

    private Path tempFile;

    @BeforeEach
    void setUp() throws IOException {
        // Creating a temporary file for testing
        tempFile = Files.createTempFile("testFile", ".txt");
        entryWithFile = new TarArchiveEntry(tempFile.toFile());
        // Entry with no file using reflection to create an instance
        entryWithoutFile = createEntryWithoutFile();
    }

    @AfterEach
    void tearDown() throws IOException {
        // Clean up the temporary file after tests
        Files.deleteIfExists(tempFile);
    }

    private TarArchiveEntry createEntryWithoutFile() throws IOException {
        try {
            Constructor<TarArchiveEntry> constructor = TarArchiveEntry.class.getDeclaredConstructor(boolean.class);
            constructor.setAccessible(true);
            return constructor.newInstance(false);
        } catch (Exception e) {
            throw new IOException("Failed to create TarArchiveEntry without file", e);
        }
    }

    @Test
    void testGetFileWithValidFile() {
        File file = entryWithFile.getFile();
        assertEquals(tempFile.toFile(), file, "The retrieved file should match the temporary file created.");
    }

    @Test
    void testGetFileWithNullFile() {
        File file = entryWithoutFile.getFile();
        assertNull(file, "The retrieved file should be null when no file is associated with the entry.");
    }
}

// Test method
package org.apache.commons.compress.archivers.tar;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
import java.nio.file.Files;
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

class TarArchiveEntry_TarArchiveEntry_109_0_Test {

    private File testFile;

    @BeforeEach
    void setUp() {
        testFile = new File("testFile.txt");
        try {
            // Create a test file for the purpose of the test
            if (!testFile.exists()) {
                testFile.createNewFile();
            }
        } catch (IOException e) {
            fail("Could not create test file: " + e.getMessage());
        }
    }

    @Test
    void testTarArchiveEntryWithFile() {
        // Given
        File file = testFile;
        // When
        TarArchiveEntry entry = new TarArchiveEntry(file);
        // Then
        assertNotNull(entry, "TarArchiveEntry should not be null");
        assertEquals(file.getPath(), entry.getPath().toString(), "The file path should match the input file path");
        // Clean up after test
        file.delete();
    }

    @Test
    void testTarArchiveEntryWithNonExistentFile() {
        // Given
        File nonExistentFile = new File("nonExistentFile.txt");
        // When & Then
        assertThrows(IOException.class, () -> {
            new TarArchiveEntry(nonExistentFile);
        }, "Expected to throw IOException for non-existent file");
    }

    @Test
    void testTarArchiveEntryWithNullFile() {
        // When & Then
        assertThrows(NullPointerException.class, () -> {
            // Fixed line to use Path instead of File
            new TarArchiveEntry((Path) null);
        }, "Expected to throw NullPointerException for null file");
    }

    @Test
    void testTarArchiveEntryPrivateConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Given
        Constructor<TarArchiveEntry> constructor = TarArchiveEntry.class.getDeclaredConstructor(File.class);
        constructor.setAccessible(true);
        // When
        TarArchiveEntry entry = constructor.newInstance(testFile);
        // Then
        assertNotNull(entry, "TarArchiveEntry should not be null");
    }
}

// Test method
package org.apache.commons.compress.archivers.tar;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TarArchiveEntry_TarArchiveEntry_110_0_Test {

    private TarArchiveEntry tarArchiveEntry;

    private File testFile;

    private String testFileName;

    @BeforeEach
    void setUp() {
        testFile = new File("testFile.txt");
        testFileName = "testFile.txt";
        // Create a test file for the purpose of testing
        try {
            if (testFile.createNewFile()) {
                // Optionally set the last modified time
                long currentTime = System.currentTimeMillis();
                testFile.setLastModified(currentTime);
            }
        } catch (IOException e) {
            fail("Failed to create test file: " + e.getMessage());
        }
    }

    @Test
    void testConstructorWithFileAndFileName() {
        // Simulate the file existing and having a specific length
        assertDoesNotThrow(() -> {
            tarArchiveEntry = new TarArchiveEntry(testFile, testFileName);
        });
        // Use reflection to access private fields
        assertNotNull(tarArchiveEntry);
        // Check if the file path is set correctly
        assertEquals(testFile.toPath(), getFieldValue(tarArchiveEntry, "file"));
        assertEquals(testFileName, getFieldValue(tarArchiveEntry, "name"));
        // Check if the size is set correctly
        assertEquals(testFile.length(), getFieldValue(tarArchiveEntry, "size"));
        // Check if the last modified time is set correctly
        FileTime expectedLastModifiedTime = FileTime.fromMillis(testFile.lastModified());
        assertEquals(expectedLastModifiedTime, getFieldValue(tarArchiveEntry, "mTime"));
    }

    @Test
    void testConstructorWithDirectory() {
        // Create a directory for testing
        File testDir = new File("testDir");
        testDir.mkdir();
        assertDoesNotThrow(() -> {
            tarArchiveEntry = new TarArchiveEntry(testDir, testDir.getName());
        });
        // Verify that the entry was created without throwing exceptions
        assertNotNull(tarArchiveEntry);
        // Ensure the size is set to 0 for directories
        assertEquals(0, getFieldValue(tarArchiveEntry, "size"));
    }

    @Test
    void testConstructorHandlesIOException() {
        // Simulate a file that causes IOException
        File invalidFile = new File("invalidFile.txt");
        assertDoesNotThrow(() -> {
            tarArchiveEntry = new TarArchiveEntry(invalidFile, testFileName);
        });
        // Verify that the instance was created even if the file was invalid
        assertNotNull(tarArchiveEntry);
    }

    private Object getFieldValue(Object obj, String fieldName) {
        try {
            // Fixed line: Use 'Field' instead of 'var'
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception e) {
            fail("Failed to access field: " + fieldName);
            return null;
        }
    }
}

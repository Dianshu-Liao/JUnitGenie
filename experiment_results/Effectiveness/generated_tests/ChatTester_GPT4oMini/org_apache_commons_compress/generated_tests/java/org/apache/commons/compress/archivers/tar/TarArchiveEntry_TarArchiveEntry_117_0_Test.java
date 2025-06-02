package org.apache.commons.compress.archivers.tar;

import java.lang.reflect.Field;
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

class TarArchiveEntry_TarArchiveEntry_117_0_Test {

    private TarArchiveEntry entry;

    @BeforeEach
    void setUp() {
        // Initialize the TarArchiveEntry with test values
        entry = new TarArchiveEntry("testFile.txt", (byte) 0);
    }

    @Test
    void testConstructorWithValidParameters() {
        assertNotNull(entry);
    }

    @Test
    void testConstructorWithName() {
        // Using reflection to access the private field 'name'
        String name = getFieldValue(entry, "name");
        assertEquals("testFile.txt", name);
    }

    @Test
    void testConstructorWithLinkFlag() {
        // Using reflection to access the private field 'linkFlag'
        byte linkFlag = getFieldValue(entry, "linkFlag");
        assertEquals((byte) 0, linkFlag);
    }

    @Test
    void testConstructorPreserveAbsolutePath() {
        // Using reflection to access the private field 'preserveAbsolutePath'
        boolean preserveAbsolutePath = getFieldValue(entry, "preserveAbsolutePath");
        assertFalse(preserveAbsolutePath);
    }

    @Test
    void testConstructorWithNullName() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            new TarArchiveEntry(null, (byte) 0);
        });
        assertEquals("name cannot be null", exception.getMessage());
    }

    @Test
    void testConstructorWithEmptyName() {
        TarArchiveEntry emptyNameEntry = new TarArchiveEntry("", (byte) 0);
        String name = getFieldValue(emptyNameEntry, "name");
        assertEquals("", name);
    }

    @Test
    void testConstructorWithNegativeLinkFlag() {
        TarArchiveEntry negativeLinkFlagEntry = new TarArchiveEntry("testFile.txt", (byte) -1);
        byte linkFlag = getFieldValue(negativeLinkFlagEntry, "linkFlag");
        assertEquals((byte) -1, linkFlag);
    }

    @SuppressWarnings("unchecked")
    private <T> T getFieldValue(Object obj, String fieldName) {
        try {
            // Repaired line
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return (T) field.get(obj);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Field not found or inaccessible: " + fieldName);
            return null;
        }
    }
}

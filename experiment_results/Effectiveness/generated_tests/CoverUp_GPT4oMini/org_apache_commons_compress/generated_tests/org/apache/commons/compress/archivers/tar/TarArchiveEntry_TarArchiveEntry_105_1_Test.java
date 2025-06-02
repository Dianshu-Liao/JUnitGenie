package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import java.lang.reflect.Constructor;
import java.nio.charset.StandardCharsets;
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

class TarArchiveEntry_TarArchiveEntry_105_1_Test {

    @Test
    void testTarArchiveEntryWithValidHeader() {
        // Prepare a valid TAR header (this is a simplified example, actual headers are more complex)
        // Adjust size according to the TAR header specification
        byte[] validHeader = new byte[100];
        // Populate the header with valid data as needed, e.g., name, size, etc.
        // Create TarArchiveEntry using the valid header
        TarArchiveEntry entry = new TarArchiveEntry(validHeader);
        // Assertions to verify the behavior
        assertNotNull(entry);
        // Replace with actual expected name if set
        assertEquals("", entry.getName());
        // Replace with actual expected size if set
        assertEquals(0, entry.getSize());
    }

    @Test
    void testTarArchiveEntryWithNullHeader() {
        assertThrows(NullPointerException.class, () -> {
            // Attempt to create TarArchiveEntry with null header
            new TarArchiveEntry((byte[]) null);
        });
    }

    @Test
    void testTarArchiveEntryWithEmptyHeader() {
        byte[] emptyHeader = new byte[0];
        TarArchiveEntry entry = new TarArchiveEntry(emptyHeader);
        // Assertions to verify the behavior
        assertNotNull(entry);
        // Expect default name for empty header
        assertEquals("", entry.getName());
        // Expect default size for empty header
        assertEquals(0, entry.getSize());
    }

    // Additional tests for edge cases can be added here
    @Test
    void testConstructorWithInvalidHeaderFormat() {
        // Populate with invalid data
        byte[] invalidHeader = new byte[100];
        assertThrows(RuntimeException.class, () -> {
            // Expecting an exception due to invalid header
            new TarArchiveEntry(invalidHeader);
        });
    }
}

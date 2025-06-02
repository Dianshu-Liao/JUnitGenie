package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TarArchiveEntry_TarArchiveEntry_106_0_Test {

    // Sample header buffer
    private static final byte[] HEADER_BUF = new byte[] { 0, 1, 2 };

    // Assume ZipEncoding is a valid class
    private ZipEncoding encoding;

    @BeforeEach
    void setUp() {
        // Initialize the ZipEncoding instance here
        // Fixed the buggy line to use a mock
        encoding = mock(ZipEncoding.class);
    }

    @Test
    void testTarArchiveEntryWithValidParameters() {
        Assertions.assertDoesNotThrow(() -> {
            TarArchiveEntry entry = new TarArchiveEntry(HEADER_BUF, encoding);
            Assertions.assertNotNull(entry);
        });
    }

    @Test
    void testTarArchiveEntryWithNullHeaderBuf() {
        Assertions.assertThrows(IOException.class, () -> {
            new TarArchiveEntry(null, encoding);
        });
    }

    @Test
    void testTarArchiveEntryWithNullEncoding() {
        Assertions.assertThrows(IOException.class, () -> {
            new TarArchiveEntry(HEADER_BUF, null);
        });
    }

    @Test
    void testTarArchiveEntryWithEmptyHeaderBuf() {
        Assertions.assertThrows(IOException.class, () -> {
            new TarArchiveEntry(new byte[] {}, encoding);
        });
    }

    @Test
    void testTarArchiveEntryWithInvalidHeaderBuf() {
        // Assuming some specific condition that makes the header invalid
        // Example of invalid header
        byte[] invalidHeaderBuf = new byte[] { -1, -1, -1 };
        Assertions.assertThrows(IOException.class, () -> {
            new TarArchiveEntry(invalidHeaderBuf, encoding);
        });
    }
}

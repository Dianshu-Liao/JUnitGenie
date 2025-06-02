package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import java.io.IOException;
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
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.lang3.SystemProperties;

public class TarArchiveEntry_TarArchiveEntry_106_0_Test {

    private byte[] headerBuf;

    private ZipEncoding encoding;

    @BeforeEach
    public void setUp() {
        // Initialize the byte array to simulate a tar header
        headerBuf = new byte[100];
        // Get encoding directly from ZipEncodingHelper
        encoding = ZipEncodingHelper.getZipEncoding("UTF-8");
    }

    @Test
    public void testTarArchiveEntryInitialization() {
        try {
            TarArchiveEntry entry = new TarArchiveEntry(headerBuf, encoding);
            assertNotNull(entry, "TarArchiveEntry should be initialized successfully");
        } catch (IOException e) {
            fail("IOException should not be thrown during initialization: " + e.getMessage());
        }
    }

    @Test
    public void testTarArchiveEntryWithNullHeader() {
        assertThrows(IOException.class, () -> {
            new TarArchiveEntry(null, encoding);
        }, "Should throw IOException when header buffer is null");
    }

    @Test
    public void testTarArchiveEntryWithNullEncoding() {
        assertThrows(IOException.class, () -> {
            new TarArchiveEntry(headerBuf, null);
        }, "Should throw IOException when encoding is null");
    }

    @Test
    public void testTarArchiveEntryWithEmptyHeader() {
        byte[] emptyHeader = new byte[0];
        assertThrows(IOException.class, () -> {
            new TarArchiveEntry(emptyHeader, encoding);
        }, "Should throw IOException when header buffer is empty");
    }

    @Test
    public void testTarArchiveEntryWithInvalidHeader() {
        byte[] invalidHeader = new byte[100];
        // Fill with invalid data if necessary
        assertThrows(IOException.class, () -> {
            new TarArchiveEntry(invalidHeader, encoding);
        }, "Should throw IOException with invalid header data");
    }
}

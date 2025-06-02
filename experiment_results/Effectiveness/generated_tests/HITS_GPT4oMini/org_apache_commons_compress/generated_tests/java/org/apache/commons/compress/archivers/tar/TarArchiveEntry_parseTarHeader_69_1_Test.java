package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.archivers.zip.ZipEncodingHelper;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
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

class TarArchiveEntry_parseTarHeader_69_1_Test {

    private TarArchiveEntry tarArchiveEntry;

    @BeforeEach
    void setUp() {
        // Initialize a TarArchiveEntry object before each test with a valid header
        tarArchiveEntry = new TarArchiveEntry(new byte[0]);
    }

    @Test
    void testParseTarHeaderValidInput() throws IOException {
        // Valid TAR header byte array (example)
        byte[] header = new byte[] {/* Populate with valid TAR header bytes */
        };
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding(StandardCharsets.UTF_8.name());
        // Execute the method to test using the constructor
        TarArchiveEntry entry = new TarArchiveEntry(header, encoding);
        // Assert expected outcomes (you may need to adjust based on what the method modifies)
        assertNotNull(entry.getName());
        assertTrue(entry.getSize() >= 0);
    }

    @Test
    void testParseTarHeaderWithInvalidHeader() {
        // Example of an invalid header
        byte[] invalidHeader = new byte[] { 0, 1, 2, 3 };
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding(StandardCharsets.UTF_8.name());
        // Expect an IOException when parsing an invalid header
        assertThrows(IOException.class, () -> {
            new TarArchiveEntry(invalidHeader, encoding);
        });
    }

    @Test
    void testParseTarHeaderWithNullHeader() {
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding(StandardCharsets.UTF_8.name());
        // Expect an IOException when passing a null header
        assertThrows(NullPointerException.class, () -> {
            new TarArchiveEntry(null, encoding);
        });
    }

    @Test
    void testParseTarHeaderWithEmptyHeader() {
        byte[] emptyHeader = new byte[0];
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding(StandardCharsets.UTF_8.name());
        // Execute the method with an empty header
        assertThrows(IOException.class, () -> {
            new TarArchiveEntry(emptyHeader, encoding);
        });
    }
}

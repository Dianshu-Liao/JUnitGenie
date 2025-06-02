package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
import org.apache.commons.compress.archivers.zip.ZipEncoding;
import org.apache.commons.compress.utils.ArchiveUtils;
import org.apache.commons.compress.utils.IOUtils;
import org.apache.commons.compress.utils.ParsingUtils;
import org.apache.commons.compress.utils.TimeUtils;
import org.apache.commons.io.file.attribute.FileTimes;
import org.apache.commons.lang3.SystemProperties;

public class TarArchiveEntry_parseTarHeader_67_0_Test {

    private TarArchiveEntry tarArchiveEntry;

    @BeforeEach
    public void setUp() {
        // Initialize the TarArchiveEntry object with a dummy header for testing
        byte[] dummyHeader = new byte[512];
        tarArchiveEntry = new TarArchiveEntry(dummyHeader);
    }

    @Test
    public void testParseTarHeader_ValidHeader() {
        // Valid TAR header example (dummy data)
        byte[] validHeader = new byte[512];
        String validHeaderString = "valid-header-data";
        System.arraycopy(validHeaderString.getBytes(StandardCharsets.UTF_8), 0, validHeader, 0, validHeaderString.length());
        // Expect no exception to be thrown for a valid header
        assertDoesNotThrow(() -> tarArchiveEntry.parseTarHeader(validHeader));
    }

    @Test
    public void testParseTarHeader_InvalidHeader() {
        // Invalid TAR header example (dummy data)
        byte[] invalidHeader = new byte[512];
        String invalidHeaderString = "invalid-header-data";
        System.arraycopy(invalidHeaderString.getBytes(StandardCharsets.UTF_8), 0, invalidHeader, 0, invalidHeaderString.length());
        // Expect an IOException to be thrown for an invalid header
        assertThrows(IOException.class, () -> tarArchiveEntry.parseTarHeader(invalidHeader));
    }

    @Test
    public void testParseTarHeader_NullHeader() {
        // Expect an UncheckedIOException to be thrown for a null header
        assertThrows(UncheckedIOException.class, () -> tarArchiveEntry.parseTarHeader(null));
    }

    @Test
    public void testParseTarHeader_EmptyHeader() {
        // Empty header
        byte[] emptyHeader = new byte[512];
        // Expect no exception to be thrown for an empty header
        assertDoesNotThrow(() -> tarArchiveEntry.parseTarHeader(emptyHeader));
    }

    @Test
    public void testParseTarHeader_HeaderWithIncorrectSize() {
        // Header with incorrect size (not 512 bytes)
        // Less than 512 bytes
        byte[] incorrectSizeHeader = new byte[400];
        // Expect an IOException to be thrown for a header with incorrect size
        assertThrows(IOException.class, () -> tarArchiveEntry.parseTarHeader(incorrectSizeHeader));
    }
}

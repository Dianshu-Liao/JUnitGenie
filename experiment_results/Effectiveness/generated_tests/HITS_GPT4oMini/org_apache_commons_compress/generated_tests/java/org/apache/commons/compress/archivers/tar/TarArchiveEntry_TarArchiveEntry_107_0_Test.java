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

public class TarArchiveEntry_TarArchiveEntry_107_0_Test {

    @Test
    public void testTarArchiveEntryWithValidParameters() throws IOException {
        // Arrange
        byte[] headerBuf = new byte[100];
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding("UTF-8");
        boolean lenient = false;
        // Act
        TarArchiveEntry entry = new TarArchiveEntry(headerBuf, encoding, lenient);
        // Assert
        assertNotNull(entry, "TarArchiveEntry should not be null");
    }

    @Test
    public void testTarArchiveEntryWithEmptyHeaderBuffer() {
        // Arrange
        byte[] headerBuf = new byte[0];
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding("UTF-8");
        boolean lenient = false;
        // Act & Assert
        assertThrows(IOException.class, () -> {
            new TarArchiveEntry(headerBuf, encoding, lenient);
        }, "Expected IOException for empty header buffer");
    }

    @Test
    public void testTarArchiveEntryWithNullEncoding() throws IOException {
        // Arrange
        byte[] headerBuf = new byte[100];
        ZipEncoding encoding = null;
        boolean lenient = false;
        // Act & Assert
        assertThrows(NullPointerException.class, () -> {
            new TarArchiveEntry(headerBuf, encoding, lenient);
        }, "Expected NullPointerException for null ZipEncoding");
    }

    @Test
    public void testTarArchiveEntryWithLenientTrue() throws IOException {
        // Arrange
        byte[] headerBuf = new byte[100];
        ZipEncoding encoding = ZipEncodingHelper.getZipEncoding("UTF-8");
        boolean lenient = true;
        // Act
        TarArchiveEntry entry = new TarArchiveEntry(headerBuf, encoding, lenient);
        // Assert
        assertNotNull(entry, "TarArchiveEntry should not be null");
    }
}

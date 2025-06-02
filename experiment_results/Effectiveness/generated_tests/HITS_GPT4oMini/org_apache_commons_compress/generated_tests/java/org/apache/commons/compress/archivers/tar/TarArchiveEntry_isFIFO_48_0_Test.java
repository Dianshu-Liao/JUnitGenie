package org.apache.commons.compress.archivers.tar;

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

public class TarArchiveEntry_isFIFO_48_0_Test {

    private TarArchiveEntry fifoEntry;

    private TarArchiveEntry nonFifoEntry;

    @BeforeEach
    public void setUp() {
        // Create a FIFO entry
        fifoEntry = new TarArchiveEntry("fifoEntry", (byte) 0x01);
        // Create a non-FIFO entry
        nonFifoEntry = new TarArchiveEntry("fileEntry", (byte) 0x00);
    }

    @Test
    public void testIsFIFO_WhenLinkFlagIsFIFO_ShouldReturnTrue() {
        // Arrange
        // Simulate FIFO link flag
        fifoEntry = new TarArchiveEntry("fifoEntry", TarArchiveEntry.LF_FIFO);
        // Act
        boolean result = fifoEntry.isFIFO();
        // Assert
        assertTrue(result, "Expected isFIFO() to return true for FIFO entry.");
    }

    @Test
    public void testIsFIFO_WhenLinkFlagIsNotFIFO_ShouldReturnFalse() {
        // Arrange
        // Simulate non-FIFO link flag
        // Regular file
        nonFifoEntry = new TarArchiveEntry("fileEntry", (byte) 0x00);
        // Act
        boolean result = nonFifoEntry.isFIFO();
        // Assert
        assertFalse(result, "Expected isFIFO() to return false for non-FIFO entry.");
    }
}

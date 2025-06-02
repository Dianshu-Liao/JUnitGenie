package org.apache.commons.compress.archivers.tar;

import java.io.File;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.nio.file.DirectoryStream;
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

public class TarArchiveEntry_TarArchiveEntry_114_0_Test {

    private TarArchiveEntry tarArchiveEntry;

    private Path mockPath;

    @BeforeEach
    public void setUp() {
        mockPath = mock(Path.class);
    }

    @Test
    public void testConstructorWithValidInputs() throws IOException {
        String fileName = "testFile.txt";
        LinkOption[] linkOptions = new LinkOption[] { LinkOption.NOFOLLOW_LINKS };
        tarArchiveEntry = new TarArchiveEntry(mockPath, fileName, linkOptions);
        // Assuming the internal state can be checked via reflection or public methods
        assertNotNull(tarArchiveEntry);
    }

    @Test
    public void testConstructorWithNullLinkOptions() throws IOException {
        String fileName = "testFile.txt";
        tarArchiveEntry = new TarArchiveEntry(mockPath, fileName, null);
        // Assuming the internal state can be checked via reflection or public methods
        assertNotNull(tarArchiveEntry);
    }

    @Test
    public void testConstructorWithEmptyFileName() {
        String fileName = "";
        assertThrows(IOException.class, () -> {
            tarArchiveEntry = new TarArchiveEntry(mockPath, fileName);
        });
    }

    @Test
    public void testConstructorWithInvalidPath() throws IOException {
        String fileName = "invalidFile.txt";
        // Simulating an invalid path scenario
        when(mockPath.toString()).thenReturn("invalidPath");
        when(Files.exists(mockPath)).thenReturn(false);
        assertThrows(IOException.class, () -> {
            tarArchiveEntry = new TarArchiveEntry(mockPath, fileName);
        });
    }

    @Test
    public void testConstructorWithValidPathAndFileName() throws IOException {
        String fileName = "validFile.txt";
        when(mockPath.toString()).thenReturn("validPath");
        when(Files.exists(mockPath)).thenReturn(true);
        when(Files.isRegularFile(mockPath)).thenReturn(true);
        tarArchiveEntry = new TarArchiveEntry(mockPath, fileName, LinkOption.NOFOLLOW_LINKS);
        assertNotNull(tarArchiveEntry);
        assertEquals("validFile.txt", tarArchiveEntry.getName());
    }

    @Test
    public void testConstructorWithDirectoryPath() throws IOException {
        String fileName = "directory";
        when(mockPath.toString()).thenReturn("directoryPath");
        when(Files.exists(mockPath)).thenReturn(true);
        when(Files.isDirectory(mockPath)).thenReturn(true);
        tarArchiveEntry = new TarArchiveEntry(mockPath, fileName, LinkOption.NOFOLLOW_LINKS);
        assertNotNull(tarArchiveEntry);
        assertEquals("directory", tarArchiveEntry.getName());
    }
}

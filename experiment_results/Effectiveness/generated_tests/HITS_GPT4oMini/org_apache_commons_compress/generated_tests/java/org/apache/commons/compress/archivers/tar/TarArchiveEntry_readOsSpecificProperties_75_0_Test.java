package org.apache.commons.compress.archivers.tar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import java.io.UncheckedIOException;
import java.math.BigDecimal;
import java.nio.file.DirectoryStream;
import java.time.DateTimeException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
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

public class TarArchiveEntry_readOsSpecificProperties_75_0_Test {

    private TarArchiveEntry tarArchiveEntry;

    private Path mockPath;

    @BeforeEach
    public void setUp() throws IOException {
        mockPath = Mockito.mock(Path.class);
        // Use appropriate constructor
        tarArchiveEntry = new TarArchiveEntry(mockPath);
    }

    @Test
    public void testReadOsSpecificProperties_PosixAttributes() throws IOException {
        // Arrange
        PosixFileAttributes posixAttributes = mock(PosixFileAttributes.class);
        when(posixAttributes.lastModifiedTime()).thenReturn(FileTime.fromMillis(1000));
        when(posixAttributes.creationTime()).thenReturn(FileTime.fromMillis(2000));
        when(posixAttributes.lastAccessTime()).thenReturn(FileTime.fromMillis(3000));
        when(posixAttributes.owner()).thenReturn(() -> "owner");
        when(posixAttributes.group()).thenReturn(() -> "group");
        when(Files.readAttributes(mockPath, PosixFileAttributes.class, (LinkOption[]) any())).thenReturn(posixAttributes);
        // Act
        // Re-instantiate to trigger attribute reading
        tarArchiveEntry = new TarArchiveEntry(mockPath);
        // Assert
        assertEquals("owner", tarArchiveEntry.getUserName());
        assertEquals("group", tarArchiveEntry.getGroupName());
        assertEquals(FileTime.fromMillis(1000), tarArchiveEntry.getLastModifiedTime());
        assertEquals(FileTime.fromMillis(2000), tarArchiveEntry.getCreationTime());
        assertEquals(FileTime.fromMillis(3000), tarArchiveEntry.getLastAccessTime());
    }

    @Test
    public void testReadOsSpecificProperties_DosAttributes() throws IOException {
        // Arrange
        DosFileAttributes dosAttributes = mock(DosFileAttributes.class);
        when(dosAttributes.lastModifiedTime()).thenReturn(FileTime.fromMillis(4000));
        when(dosAttributes.creationTime()).thenReturn(FileTime.fromMillis(5000));
        when(dosAttributes.lastAccessTime()).thenReturn(FileTime.fromMillis(6000));
        when(Files.readAttributes(mockPath, DosFileAttributes.class, (LinkOption[]) any())).thenReturn(dosAttributes);
        // Act
        // Re-instantiate to trigger attribute reading
        tarArchiveEntry = new TarArchiveEntry(mockPath);
        // Assert
        assertEquals(FileTime.fromMillis(4000), tarArchiveEntry.getLastModifiedTime());
        assertEquals(FileTime.fromMillis(5000), tarArchiveEntry.getCreationTime());
        assertEquals(FileTime.fromMillis(6000), tarArchiveEntry.getLastAccessTime());
    }

    @Test
    public void testReadOsSpecificProperties_BasicAttributes() throws IOException {
        // Arrange
        BasicFileAttributes basicAttributes = mock(BasicFileAttributes.class);
        when(basicAttributes.lastModifiedTime()).thenReturn(FileTime.fromMillis(7000));
        when(basicAttributes.creationTime()).thenReturn(FileTime.fromMillis(8000));
    }
}

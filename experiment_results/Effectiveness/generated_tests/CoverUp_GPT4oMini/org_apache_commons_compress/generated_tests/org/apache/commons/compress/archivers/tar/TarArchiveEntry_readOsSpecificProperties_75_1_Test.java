package org.apache.commons.compress.archivers.tar;

import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
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
import java.lang.reflect.Method;
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

@ExtendWith(MockitoExtension.class)
class TarArchiveEntry_readOsSpecificProperties_75_1_Test {

    private TarArchiveEntry tarArchiveEntry;

    private Path mockPath;

    @BeforeEach
    void setUp() throws IOException {
        // Create a mock Path
        mockPath = mock(Path.class);
        tarArchiveEntry = new TarArchiveEntry(mockPath);
    }

    private void invokePrivateMethod(String methodName, Object... args) throws Exception {
        Method method = TarArchiveEntry.class.getDeclaredMethod(methodName, Path.class, LinkOption[].class);
        method.setAccessible(true);
        method.invoke(tarArchiveEntry, args);
    }

    @Test
    void testReadOsSpecificProperties_PosixAttributes() throws Exception {
        // Setup mock behavior for POSIX attributes
        PosixFileAttributes posixAttributes = mock(PosixFileAttributes.class);
        when(Files.readAttributes(mockPath, PosixFileAttributes.class, (LinkOption[]) any())).thenReturn(posixAttributes);
        when(posixAttributes.lastModifiedTime()).thenReturn(FileTime.fromMillis(1000));
        when(posixAttributes.creationTime()).thenReturn(FileTime.fromMillis(2000));
        when(posixAttributes.lastAccessTime()).thenReturn(FileTime.fromMillis(3000));
        when(posixAttributes.owner()).thenReturn(mock(java.nio.file.attribute.UserPrincipal.class));
        when(posixAttributes.group()).thenReturn(mock(java.nio.file.attribute.GroupPrincipal.class));
        // Mock owner and group
        when(posixAttributes.owner().getName()).thenReturn("user");
        when(posixAttributes.group().getName()).thenReturn("group");
        // Invoke the method using reflection
        invokePrivateMethod("readOsSpecificProperties", mockPath, new LinkOption[0]);
        // Verify the results
        assertEquals(FileTime.fromMillis(1000), tarArchiveEntry.getLastModifiedTime());
        assertEquals(FileTime.fromMillis(2000), tarArchiveEntry.getCreationTime());
        assertEquals(FileTime.fromMillis(3000), tarArchiveEntry.getLastAccessTime());
        assertEquals("user", tarArchiveEntry.getUserName());
        assertEquals("group", tarArchiveEntry.getGroupName());
    }

    @Test
    void testReadOsSpecificProperties_DosAttributes() throws Exception {
        // Setup mock behavior for DOS attributes
        DosFileAttributes dosAttributes = mock(DosFileAttributes.class);
        when(Files.readAttributes(mockPath, DosFileAttributes.class, (LinkOption[]) any())).thenReturn(dosAttributes);
        when(dosAttributes.lastModifiedTime()).thenReturn(FileTime.fromMillis(4000));
        when(dosAttributes.creationTime()).thenReturn(FileTime.fromMillis(5000));
        when(dosAttributes.lastAccessTime()).thenReturn(FileTime.fromMillis(6000));
        // Invoke the method using reflection
        invokePrivateMethod("readOsSpecificProperties", mockPath, new LinkOption[0]);
        // Verify the results
        assertEquals(FileTime.fromMillis(4000), tarArchiveEntry.getLastModifiedTime());
        assertEquals(FileTime.fromMillis(5000), tarArchiveEntry.getCreationTime());
        assertEquals(FileTime.fromMillis(6000), tarArchiveEntry.getLastAccessTime());
    }

    @Test
    void testReadOsSpecificProperties_BasicAttributes() throws Exception {
        // Setup mock behavior for basic attributes
        BasicFileAttributes basicAttributes = mock(BasicFileAttributes.class);
        when(Files.readAttributes(mockPath, BasicFileAttributes.class, (LinkOption[]) any())).thenReturn(basicAttributes);
        when(basicAttributes.lastModifiedTime()).thenReturn(FileTime.fromMillis(7000));
        when(basicAttributes.creationTime()).thenReturn(FileTime.fromMillis(8000));
        when(basicAttributes.lastAccessTime()).thenReturn(FileTime.fromMillis(9000));
        // Mock owner
        when(Files.getOwner(mockPath, (LinkOption[]) any())).thenReturn(mock(java.nio.file.attribute.UserPrincipal.class));
        when(Files.getOwner(mockPath, (LinkOption[]) any()).getName()).thenReturn("user");
        // Invoke the method using reflection
        invokePrivateMethod("readOsSpecificProperties", mockPath, new LinkOption[0]);
        // Verify the results
    }
}
